package com.youquiz.backend.components.quizQuestion.service;

import com.youquiz.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.youquiz.backend.components.quizQuestion.dto.request.CreateQuizQuestionDTO;
import com.youquiz.backend.components.quizQuestion.dto.request.UpdateQuizQuestionDTO;
import com.youquiz.backend.components.quizQuestion.dto.response.QuizQuestionResponseDTO;
import com.youquiz.backend.components.quizQuestion.mapper.QuizQuestionMapper;
import com.youquiz.backend.components.quizQuestion.repository.QuizQuestionRepository;
import com.youquiz.backend.config.exception.ValidationException;
import com.youquiz.backend.entities.QuizQuestion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class QuizQuestionService extends EntityServiceImpl<QuizQuestion, Long, CreateQuizQuestionDTO, UpdateQuizQuestionDTO, QuizQuestionResponseDTO> {
    private final QuizQuestionRepository quizQuestionRepository;
    private final QuizQuestionMapper quizQuestionMapper;

    public QuizQuestionService(
            QuizQuestionRepository quizQuestionRepository,
            QuizQuestionMapper quizQuestionMapper,
            ApplicationContext applicationContext) {
        super(quizQuestionRepository, quizQuestionMapper, applicationContext);
        this.quizQuestionRepository = quizQuestionRepository;
        this.quizQuestionMapper = quizQuestionMapper;
    }

    @Override
    public QuizQuestionResponseDTO create(CreateQuizQuestionDTO createQuizQuestionDTO) {
        if(quizQuestionRepository.isRecordAlreadyExists(createQuizQuestionDTO.getQuizId(), createQuizQuestionDTO.getQuestionId())) {
            throw new ValidationException("Invalid Creation, Question already assigned to that quiz");
        }
        return super.create(createQuizQuestionDTO);
    }

    @Override
    public void update(Long id, UpdateQuizQuestionDTO updateQuizQuestionDTO) {
        if(quizQuestionRepository.isRecordAlreadyExistsForUpdate(updateQuizQuestionDTO.getQuizId(), updateQuizQuestionDTO.getQuestionId(), id)) {
            throw new ValidationException("Invalid Update, Question already assigned to that quiz");
        }
        super.update(id, updateQuizQuestionDTO);
    }
}
