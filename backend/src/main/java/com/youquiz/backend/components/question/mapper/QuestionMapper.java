package com.youquiz.backend.components.question.mapper;

import com.youquiz.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.youquiz.backend.components.question.dto.request.CreateQuestionDTO;
import com.youquiz.backend.components.question.dto.request.UpdateQuestionDTO;
import com.youquiz.backend.components.question.dto.response.QuestionResponseDTO;
import com.youquiz.backend.entities.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface QuestionMapper extends EntityMapper<Question, Long, CreateQuestionDTO, UpdateQuestionDTO, QuestionResponseDTO> {

    @Mapping(target = "subject", ignore = true)
    @Mapping(target = "level", ignore = true)
    Question toEntity(CreateQuestionDTO createQuestionDTO);

    @Mapping(target = "subject", ignore = true)
    @Mapping(target = "level", ignore = true)
    void updateEntity(UpdateQuestionDTO updateQuestionDTO, @MappingTarget Question question );

    QuestionResponseDTO toResponseDTO(Question question);
}
