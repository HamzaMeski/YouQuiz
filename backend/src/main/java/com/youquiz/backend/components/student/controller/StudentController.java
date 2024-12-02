package com.youquiz.backend.components.student.controller;

import com.youquiz.backend.EntityComponentsProvider.controller.Controller;
import com.youquiz.backend.components.student.dto.request.CreateStudentDTO;
import com.youquiz.backend.components.student.dto.request.UpdateStudentDTO;
import com.youquiz.backend.components.student.dto.response.StudentDetailResponseDTO;
import com.youquiz.backend.components.student.dto.response.StudentResponseDTO;
import com.youquiz.backend.components.student.service.StudentService;
import com.youquiz.backend.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController extends Controller<Student, Long, CreateStudentDTO, UpdateStudentDTO, StudentResponseDTO> {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        super(studentService);
        this.studentService = studentService;
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<StudentDetailResponseDTO> getStudentDetails(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getDetailById(id));
    }

    @GetMapping("/details")
    public ResponseEntity<Page<StudentDetailResponseDTO>> getAllStudentsWithDetails(Pageable pageable) {
        return ResponseEntity.ok(studentService.getAllWithDetails(pageable));
    }

    @GetMapping("/experience/{years}")
    public ResponseEntity<List<StudentResponseDTO>> getStudentsByExperience(@PathVariable int years) {
        return ResponseEntity.ok(studentService.findByExperienceYears(years));
    }
}
