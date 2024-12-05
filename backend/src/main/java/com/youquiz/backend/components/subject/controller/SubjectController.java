package com.youquiz.backend.components.subject.controller;

import com.youquiz.backend.EntityComponentsProvider.controller.Controller;
import com.youquiz.backend.components.subject.dto.request.CreateSubjectDTO;
import com.youquiz.backend.components.subject.dto.request.UpdateSubjectDTO;
import com.youquiz.backend.components.subject.dto.response.SubjectResponseDTO;
import com.youquiz.backend.components.subject.service.SubjectService;
import com.youquiz.backend.entities.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController extends Controller<Subject, Long, CreateSubjectDTO, UpdateSubjectDTO, SubjectResponseDTO> {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        super(subjectService);
        this.subjectService = subjectService;
    }
}