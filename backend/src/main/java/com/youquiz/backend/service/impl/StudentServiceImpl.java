package com.youquiz.backend.service.impl;

import com.youquiz.backend.dto.student.request.CreateStudentRequest;
import com.youquiz.backend.dto.student.request.UpdateStudentRequest;
import com.youquiz.backend.dto.student.response.StudentResponse;
import com.youquiz.backend.entity.Student;
import com.youquiz.backend.exception.ValidationException;
import com.youquiz.backend.mapper.StudentMapper;
import com.youquiz.backend.repository.StudentRepository;
import com.youquiz.backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentResponse create(CreateStudentRequest request) {
        validateCreate(request);

        Student student = studentMapper.toEntity(request);
        return studentMapper.toStudentResponse(studentRepository.save(student));
    }

    @Override
    public void update(Long id, UpdateStudentRequest request) {
        Student student = checkUserExistence(id);
        validateUpdate(id, request);

        studentMapper.updateEntity(request, student);
        studentRepository.save(student);
    }

    @Override
    public Page<StudentResponse> getAll(Pageable pageable) {
        return studentRepository.findAll(pageable)
                .map(studentMapper::toStudentResponse);
    }

    @Override
    public StudentResponse getById(Long id) {
        return studentMapper.toStudentResponse(checkUserExistence(id));
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(checkUserExistence(id));
    }

    // Validation
    public Student checkUserExistence(Long id) {
        return studentRepository.findById(id).
                orElseThrow(() -> new ValidationException("Student doesn't exist with id " + id));
    }

    public void validateCreate(CreateStudentRequest request) {
        if(studentRepository.existsByEmail(request.getEmail())) {
            throw new ValidationException("Email already exists");
        }
    }

    public void validateUpdate(Long id, UpdateStudentRequest request) {
        if(studentRepository.checkEmailForUpdate(id, request.getEmail()) != 0) {
            throw new ValidationException("Email already exists");
        }
    }
}
