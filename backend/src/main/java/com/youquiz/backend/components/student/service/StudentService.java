package com.youquiz.backend.components.student.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.youquiz.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.youquiz.backend.components.student.dto.request.CreateStudentDTO;
import com.youquiz.backend.components.student.dto.request.UpdateStudentDTO;
import com.youquiz.backend.components.student.dto.response.StudentDetailResponseDTO;
import com.youquiz.backend.components.student.dto.response.StudentResponseDTO;
import com.youquiz.backend.components.student.mapper.StudentMapper;
import com.youquiz.backend.components.student.repository.StudentRepository;
import com.youquiz.backend.config.exception.DuplicateResourceException;
import com.youquiz.backend.entities.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class StudentService extends EntityServiceImpl<Student, Long, CreateStudentDTO, UpdateStudentDTO, StudentResponseDTO> {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(
            StudentRepository studentRepository, 
            StudentMapper studentMapper,
            ApplicationContext applicationContext) {
        super(studentRepository, studentMapper, applicationContext);
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentResponseDTO create(CreateStudentDTO request) {
        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }
        return super.create(request);
    }

    @Override
    public void update(Long id, UpdateStudentDTO request) {
        if (studentRepository.existsByEmailAndIdNot(request.getEmail(), id)) {
            throw new DuplicateResourceException("Email already exists");
        }
        super.update(id, request);
    }

    // Additional custom methods
    @Transactional(readOnly = true)
    public StudentDetailResponseDTO getDetailById(Long id) {
        Student student = checkEntityExistence(id);
        return studentMapper.toDetailResponseDTO(student);
    }

    @Transactional(readOnly = true)
    public Page<StudentDetailResponseDTO> getAllWithDetails(Pageable pageable) {
        return studentRepository.findAll(pageable)
                .map(studentMapper::toDetailResponseDTO);
    }

    @Transactional(readOnly = true)
    public List<StudentResponseDTO> findByExperienceYears(int years) {
        LocalDate registrationDate = LocalDate.now().minusYears(years);
        return studentRepository.findByRegistrationDateBefore(registrationDate)
                .stream()
                .map(studentMapper::toResponseDTO)
                .toList();
    }
}
