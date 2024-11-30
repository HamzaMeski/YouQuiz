package com.youquiz.backend.mapper;

import com.youquiz.backend.dto.student.request.CreateStudentRequest;
import com.youquiz.backend.dto.student.request.UpdateStudentRequest;
import com.youquiz.backend.dto.student.response.StudentResponse;
import com.youquiz.backend.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "id", ignore = true)
    Student toEntity(CreateStudentRequest request);

    StudentResponse toStudentResponse(Student student);

    void updateEntity(UpdateStudentRequest request, @MappingTarget Student student);
}
