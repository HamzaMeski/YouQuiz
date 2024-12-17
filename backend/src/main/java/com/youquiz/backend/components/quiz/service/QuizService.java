package com.youquiz.backend.components.quiz.service;

import com.youquiz.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.youquiz.backend.components.question.dto.response.QuestionResponseDTO;
import com.youquiz.backend.components.question.mapper.QuestionMapper;
import com.youquiz.backend.components.quiz.dto.request.CreateQuizDTO;
import com.youquiz.backend.components.quiz.dto.request.UpdateQuizDTO;
import com.youquiz.backend.components.quiz.dto.response.QuizDetailResponseDTO;
import com.youquiz.backend.components.quiz.dto.response.QuizResponseDTO;
import com.youquiz.backend.components.quiz.mapper.QuizMapper;
import com.youquiz.backend.components.quiz.repository.QuizRepository;
import com.youquiz.backend.config.exception.ValidationException;
import com.youquiz.backend.entities.Question;
import com.youquiz.backend.entities.Quiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@Transactional
public class QuizService extends EntityServiceImpl<Quiz, Long, CreateQuizDTO, UpdateQuizDTO, QuizResponseDTO> {
    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public QuizService(
            QuizRepository quizRepository, 
            QuizMapper quizMapper,
            ApplicationContext applicationContext) {
        super(quizRepository, quizMapper, applicationContext);
        this.quizRepository = quizRepository;
        this.quizMapper = quizMapper;
    }

    public QuizDetailResponseDTO getQuizDetails(Long quizId) {
        List<Question> questions = quizRepository.findQuestionsByQuizId(quizId);

        List<QuestionResponseDTO> questionResponseDTOS = questions.stream()
                .map(q -> questionMapper.toResponseDTO(q))
                .collect(Collectors.toList());

        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new ValidationException("quiz with ID doesn't exist"));

        QuizDetailResponseDTO quizDetailResponseDTO = quizMapper.toDetailResponseDTO(quiz);
        quizDetailResponseDTO.setQuestions(questionResponseDTOS);

        return quizDetailResponseDTO;
    }
}
