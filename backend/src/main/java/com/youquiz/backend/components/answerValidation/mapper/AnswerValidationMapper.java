package com.youquiz.backend.components.answerValidation.mapper;

import com.youquiz.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.youquiz.backend.components.answerValidation.dto.request.CreateAnswerValidationDTO;
import com.youquiz.backend.components.answerValidation.dto.request.UpdateAnswerValidationDTO;
import com.youquiz.backend.components.answerValidation.dto.response.AnswerValidationResponseDTO;
import com.youquiz.backend.entities.Answer;
import com.youquiz.backend.entities.AnswerValidation;
import com.youquiz.backend.entities.Question;
import com.youquiz.backend.entities.QuizAssignment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {QuizAssignment.class, Answer.class, Question.class})
public interface AnswerValidationMapper extends EntityMapper<AnswerValidation, Long, CreateAnswerValidationDTO, UpdateAnswerValidationDTO, AnswerValidationResponseDTO> {

    @Override
    @Mapping(target = "answer", ignore = true)
    @Mapping(target = "question", ignore = true)
    AnswerValidation toEntity(CreateAnswerValidationDTO createAnswerValidationDTO);

    @Override
    @Mapping(target = "answer", ignore = true)
    @Mapping(target = "question", ignore = true)
    void updateEntity(UpdateAnswerValidationDTO updateAnswerValidationDTO, @MappingTarget AnswerValidation answerValidation);

    @Override
    AnswerValidationResponseDTO toResponseDTO(AnswerValidation answerValidation);
}
