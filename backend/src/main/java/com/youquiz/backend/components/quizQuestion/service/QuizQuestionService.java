package com.youquiz.backend.components.quizQuestion.service;

import com.youquiz.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.youquiz.backend.components.quizQuestion.dto.request.CreateQuizQuestionDTO;
import com.youquiz.backend.components.quizQuestion.dto.request.UpdateQuizQuestionDTO;
import com.youquiz.backend.components.quizQuestion.dto.response.QuizQuestionResponseDTO;
import com.youquiz.backend.components.quizQuestion.mapper.QuizQuestionMapper;
import com.youquiz.backend.components.quizQuestion.repository.QuizQuestionRepository;
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
}
