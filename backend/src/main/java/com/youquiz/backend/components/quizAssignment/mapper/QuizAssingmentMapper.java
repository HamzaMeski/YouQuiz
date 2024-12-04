package com.youquiz.backend.components.quizAssignment.mapper;

import com.youquiz.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.youquiz.backend.components.quiz.mapper.QuizMapper;
import com.youquiz.backend.components.quizAssignment.dto.request.CreateAssignmenentDTO;
import com.youquiz.backend.components.quizAssignment.dto.request.UpdateAssignmenentDTO;
import com.youquiz.backend.components.quizAssignment.dto.response.AssignmentResponseDTO;
import com.youquiz.backend.components.student.mapper.StudentMapper;
import com.youquiz.backend.entities.QuizAssignment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {QuizMapper.class, StudentMapper.class})
public interface QuizAssingmentMapper extends EntityMapper<QuizAssignment, Long, CreateAssignmenentDTO, UpdateAssignmenentDTO, AssignmentResponseDTO>  {
    @Override
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "quiz", ignore = true)
    QuizAssignment toEntity(CreateAssignmenentDTO createAssignmenentDTO);

    @Override
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "quiz", ignore = true)
    void updateEntity(UpdateAssignmenentDTO updateAssignmenentDTO, @MappingTarget QuizAssignment quizAssignment);

    @Override
    @Mapping(target = "quiz", source = "quiz")
    @Mapping(target = "student", source = "student")
    AssignmentResponseDTO toResponseDTO(QuizAssignment quizAssignment);
}