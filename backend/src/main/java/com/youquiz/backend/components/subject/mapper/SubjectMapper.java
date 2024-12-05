package com.youquiz.backend.components.subject.mapper;

import com.youquiz.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.youquiz.backend.components.subject.dto.request.CreateSubjectDTO;
import com.youquiz.backend.components.subject.dto.request.UpdateSubjectDTO;
import com.youquiz.backend.components.subject.dto.response.SubjectResponseDTO;
import com.youquiz.backend.entities.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = SubjectMapper.class)
public interface SubjectMapper extends EntityMapper<Subject, Long, CreateSubjectDTO, UpdateSubjectDTO, SubjectResponseDTO> {

    @Override
    @Mapping(target = "subSubjects", ignore = true)
    @Mapping(target = "questions", ignore = true)
    Subject toEntity(CreateSubjectDTO createSubjectDTO);

    @Override
    @Mapping(target = "subSubjects", ignore = true)
    @Mapping(target = "questions", ignore = true)
    void updateEntity(UpdateSubjectDTO updateSubjectDTO, @MappingTarget Subject subject);

    @Override
    SubjectResponseDTO toResponseDTO(Subject subject);
}
