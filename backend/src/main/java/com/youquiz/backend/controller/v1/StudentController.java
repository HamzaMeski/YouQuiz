package com.youquiz.backend.controller.v1;

import com.youquiz.backend.dto.student.request.CreateStudentRequest;
import com.youquiz.backend.dto.student.request.UpdateStudentRequest;
import com.youquiz.backend.dto.student.response.StudentResponse;
import com.youquiz.backend.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse create(
            @Valid @RequestBody CreateStudentRequest request
    ) {
        return studentService.create(request);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStudentRequest request
    ) {
        studentService.update(id, request);
    }

    @GetMapping
    public Page<StudentResponse> getAll(Pageable pageable) {
        return studentService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public StudentResponse getById(
            @PathVariable Long id
    ) {
        return studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long id
    ) {
        studentService.delete(id);
    }
}
