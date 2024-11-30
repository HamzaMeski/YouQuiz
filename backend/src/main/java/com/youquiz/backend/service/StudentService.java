package com.youquiz.backend.service;

import com.youquiz.backend.dto.student.request.CreateStudentRequest;
import com.youquiz.backend.dto.student.request.UpdateStudentRequest;
import com.youquiz.backend.dto.student.response.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    StudentResponse create(CreateStudentRequest request);
    void update(Long id, UpdateStudentRequest request);
    Page<StudentResponse> getAll(Pageable pageable);
    StudentResponse getById(Long id);
    void delete(Long id);
}
