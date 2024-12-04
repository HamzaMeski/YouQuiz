package com.youquiz.backend.components.quizAssignment.mapper;

import com.youquiz.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.youquiz.backend.components.quizAssignment.dto.request.CreateAssignmenentDTO;
import com.youquiz.backend.components.quizAssignment.dto.request.UpdateAssignmenentDTO;
import com.youquiz.backend.components.quizAssignment.dto.response.AssignmentResponseDTO;
import com.youquiz.backend.entities.QuizAssignment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface QuizAssingmentMapper extends EntityMapper<QuizAssignment, Long, CreateAssignmenentDTO, UpdateAssignmenentDTO, AssignmentResponseDTO>  {
    @Override
    @Mapping(target ="student", ignore = true)
    @Mapping(target = "quiz", ignore = true)
    QuizAssignment toEntity(CreateAssignmenentDTO createAssignmenentDTO);

    @Override
    @Mapping(target ="student", ignore = true)
    @Mapping(target = "quiz", ignore = true)
    void updateEntity(UpdateAssignmenentDTO updateAssignmenentDTO, @MappingTarget QuizAssignment quizAssignment);

    @Override
    AssignmentResponseDTO toResponseDTO(QuizAssignment quizAssignment);
}
