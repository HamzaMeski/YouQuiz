package com.youquiz.backend.components.answerValidation.service;

import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youquiz.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.youquiz.backend.components.answer.repository.AnswerRepository;
import com.youquiz.backend.components.answerValidation.dto.request.CreateAnswerValidationDTO;
import com.youquiz.backend.components.answerValidation.dto.request.SubmitAnswerDTO;
import com.youquiz.backend.components.answerValidation.dto.request.UpdateAnswerValidationDTO;
import com.youquiz.backend.components.answerValidation.dto.response.AnswerValidationResponseDTO;
import com.youquiz.backend.components.answerValidation.mapper.AnswerValidationMapper;
import com.youquiz.backend.components.answerValidation.repository.AnswerValidationRepository;
import com.youquiz.backend.components.question.repository.QuestionRepository;
import com.youquiz.backend.components.quizAssignment.repository.QuizAssignmentRepository;
import com.youquiz.backend.config.exception.ResourceNotFoundException;
import com.youquiz.backend.config.exception.ValidationException;
import com.youquiz.backend.entities.Answer;
import com.youquiz.backend.entities.AnswerValidation;
import com.youquiz.backend.entities.Question;
import com.youquiz.backend.entities.Quiz;
import com.youquiz.backend.entities.QuizAssignment;

@Service
@Transactional
public class AnswerValidationService extends EntityServiceImpl<
        AnswerValidation,
        Long,
        CreateAnswerValidationDTO,
        UpdateAnswerValidationDTO,
        AnswerValidationResponseDTO> {

    private final AnswerValidationRepository answerValidationRepository;
    private final AnswerValidationMapper answerValidationMapper;
    private final QuizAssignmentRepository quizAssignmentRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public AnswerValidationService(
            AnswerValidationRepository answerValidationRepository,
            AnswerValidationMapper answerValidationMapper,
            QuizAssignmentRepository quizAssignmentRepository,
            ApplicationContext applicationContext, QuestionRepository questionRepository, AnswerRepository answerRepository) {
        super(answerValidationRepository, answerValidationMapper, applicationContext);
        this.answerValidationRepository = answerValidationRepository;
        this.answerValidationMapper = answerValidationMapper;
        this.quizAssignmentRepository = quizAssignmentRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public AnswerValidationResponseDTO create(CreateAnswerValidationDTO createAnswerValidationDTO) {
        if(createAnswerValidationDTO.getPoints() > 0 && !createAnswerValidationDTO.getIsCorrect()) {
            throw new ValidationException("You can not set points to wrong answer");
        }else if(createAnswerValidationDTO.getPoints() == 0 && createAnswerValidationDTO.getIsCorrect()) {
            throw new ValidationException("You can not set 0 points to correct answer");
        }

        if(createAnswerValidationDTO.getPoints() > 0) createAnswerValidationDTO.setIsCorrect(true);

        return super.create(createAnswerValidationDTO);
    }

    public AnswerValidationResponseDTO submitAnswer(SubmitAnswerDTO submitAnswerDTO) {
        // Verify the quiz assignment exists and belongs to the student
        QuizAssignment quizAssignment = quizAssignmentRepository.findById(submitAnswerDTO.getQuizAssignmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Quiz Assignment not found"));

        // Validate quiz assignment state
        validateQuizAssignmentState(quizAssignment);

        // Get question and answer
        Question question = questionRepository.findById(submitAnswerDTO.getQuestionId())
                .orElseThrow(() -> new ResourceNotFoundException("Question not found"));
        Answer answer = answerRepository.findById(submitAnswerDTO.getAnswerId())
                .orElseThrow(() -> new ResourceNotFoundException("Answer not found"));

        // Check if question already answered
        if (answerValidationRepository.hasAnsweredQuestion(submitAnswerDTO.getQuestionId(), quizAssignment)) {
            throw new ValidationException("This question has already been answered in this quiz");
        }

        // Validate question belongs to quiz
        validateQuestionBelongsToQuiz(question, quizAssignment.getQuiz());

        // Get answer validation
        AnswerValidation answerValidation = answerValidationRepository
                .findByQuestionAndAnswer(submitAnswerDTO.getQuestionId(), submitAnswerDTO.getAnswerId())
                .orElseThrow(() -> new ResourceNotFoundException("answerId is not assigned to that questionId!"));


        // Associate with quiz assignment
        quizAssignment.getAnswerValidations().add(answerValidation);
        answerValidation.getQuizAssignments().add(quizAssignment);

        // Save answer validation
        answerValidation = answerValidationRepository.save(answerValidation);

        // Update quiz assignment score
        Float totalScore = answerValidationRepository.calculateTotalScore(quizAssignment);
        quizAssignment.updateScore(totalScore);
        quizAssignmentRepository.save(quizAssignment);

        return answerValidationMapper.toResponseDTO(answerValidation);
    }

    private void validateQuizAssignmentState(QuizAssignment quizAssignment) {
        LocalTime now = LocalTime.now();
        
        if (now.isAfter(quizAssignment.getEndTime())) {
            throw new ValidationException("Quiz has expired");
        }
        
        if (now.isBefore(quizAssignment.getStartTime())) {
            throw new ValidationException("Quiz hasn't started yet");
        }
    }

    private void validateQuestionBelongsToQuiz(Question question, Quiz quiz) {
        boolean belongs = quiz.getQuizzesQuestions().stream()
                .anyMatch(qq -> qq.getQuestion().getId().equals(question.getId()));
        
        if (!belongs) {
            throw new ValidationException("Question does not belong to this quiz");
        }
    }
}
