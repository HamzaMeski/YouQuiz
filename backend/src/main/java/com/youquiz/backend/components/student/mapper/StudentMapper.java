package com.youquiz.backend.components.student.mapper;

import com.youquiz.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.youquiz.backend.components.student.dto.request.CreateStudentDTO;
import com.youquiz.backend.components.student.dto.request.UpdateStudentDTO;
import com.youquiz.backend.components.student.dto.response.StudentDetailResponseDTO;
import com.youquiz.backend.components.student.dto.response.StudentResponseDTO;
import com.youquiz.backend.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.Period;

@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<Student, Long, CreateStudentDTO, UpdateStudentDTO, StudentResponseDTO> {

    @Override
    Student toEntity(CreateStudentDTO request);

    @Override
    StudentResponseDTO toResponseDTO(Student entity);

    @Override
    void updateEntity(UpdateStudentDTO request, @MappingTarget Student entity);

    @Mapping(target = "age", source = "birthDate", qualifiedByName = "calculateAge")
    StudentDetailResponseDTO toDetailResponseDTO(Student entity);

    @Named("calculateAge")
    default Integer calculateAge(LocalDate birthDate) {
        return birthDate != null ? Period.between(birthDate, LocalDate.now()).getYears() : null;
    }

    @Named("calculateExperience")
    default Integer calculateExperience(LocalDate registrationDate) {
        return registrationDate != null ? Period.between(registrationDate, LocalDate.now()).getYears() : null;
    }
}
