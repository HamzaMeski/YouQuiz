package com.youquiz.backend.components.question.service;

import com.youquiz.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.youquiz.backend.components.question.dto.request.CreateQuestionDTO;
import com.youquiz.backend.components.question.dto.request.UpdateQuestionDTO;
import com.youquiz.backend.components.question.dto.response.QuestionResponseDTO;
import com.youquiz.backend.components.question.mapper.QuestionMapper;
import com.youquiz.backend.components.question.repository.QuestionRepository;
import com.youquiz.backend.entities.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class QuestionService extends EntityServiceImpl<Question, Long, CreateQuestionDTO, UpdateQuestionDTO, QuestionResponseDTO> {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    public QuestionService(
            QuestionRepository questionRepository,
            QuestionMapper questionMapper,
            ApplicationContext applicationContext) {
        super(questionRepository, questionMapper, applicationContext);
        this.questionRepository = questionRepository;
        this.questionMapper = questionMapper;
    }
}
