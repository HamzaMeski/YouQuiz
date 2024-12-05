package com.youquiz.backend.components.answer.mapper;

import com.youquiz.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.youquiz.backend.components.answer.dto.request.CreateAnswerDTO;
import com.youquiz.backend.components.answer.dto.request.UpdateAnswerDTO;
import com.youquiz.backend.components.answer.dto.response.AnswerResponseDTO;
import com.youquiz.backend.entities.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = AnswerMapper.class)
public interface AnswerMapper extends EntityMapper<Answer, Long, CreateAnswerDTO, UpdateAnswerDTO, AnswerResponseDTO> {

    @Override
    @Mapping(target = "answerValidations", ignore = true)
    Answer toEntity(CreateAnswerDTO createAnswerDTO);

    @Override
    @Mapping(target = "answerValidations", ignore = true)
    void updateEntity(UpdateAnswerDTO updateAnswerDTO, @MappingTarget Answer answer);

    @Override
    AnswerResponseDTO toResponseDTO(Answer answer);
}
