package com.youquiz.backend.components.answer.service;

import com.youquiz.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.youquiz.backend.components.answer.dto.request.CreateAnswerDTO;
import com.youquiz.backend.components.answer.dto.request.UpdateAnswerDTO;
import com.youquiz.backend.components.answer.dto.response.AnswerResponseDTO;
import com.youquiz.backend.components.answer.mapper.AnswerMapper;
import com.youquiz.backend.components.answer.repository.AnswerRepository;
import com.youquiz.backend.entities.Answer;
import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AnswerService extends EntityServiceImpl<Answer, Long, CreateAnswerDTO, UpdateAnswerDTO, AnswerResponseDTO> {
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    public AnswerService(
            AnswerRepository answerRepository,
            AnswerMapper answerMapper,
            ApplicationContext applicationContext) {
        super(answerRepository, answerMapper, applicationContext);
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
    }
}
