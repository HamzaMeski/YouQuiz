package com.youquiz.backend.components.answerValidation.service;

import com.youquiz.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.youquiz.backend.components.answerValidation.dto.request.CreateAnswerValidationDTO;
import com.youquiz.backend.components.answerValidation.dto.request.UpdateAnswerValidationDTO;
import com.youquiz.backend.components.answerValidation.dto.response.AnswerValidationResponseDTO;
import com.youquiz.backend.components.answerValidation.mapper.AnswerValidationMapper;
import com.youquiz.backend.components.answerValidation.repository.AnswerValidationRepository;
import com.youquiz.backend.entities.AnswerValidation;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnswerValidationService extends EntityServiceImpl<AnswerValidation, Long, CreateAnswerValidationDTO, UpdateAnswerValidationDTO, AnswerValidationResponseDTO> {
    private final AnswerValidationRepository answerValidationRepository;
    private final AnswerValidationMapper answerValidationMapper;

    public AnswerValidationService(
            AnswerValidationRepository answerValidationRepository,
            AnswerValidationMapper answerValidationMapper,
            ApplicationContext applicationContext) {
        super(answerValidationRepository, answerValidationMapper, applicationContext);
        this.answerValidationRepository = answerValidationRepository;
        this.answerValidationMapper = answerValidationMapper;
    }
}
