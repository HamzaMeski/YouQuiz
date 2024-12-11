package com.youquiz.backend.components.quizAssignment.controller;

import com.youquiz.backend.EntityComponentsProvider.controller.Controller;
import com.youquiz.backend.components.quizAssignment.dto.request.CreateAssignmenentDTO;
import com.youquiz.backend.components.quizAssignment.dto.request.UpdateAssignmenentDTO;
import com.youquiz.backend.components.quizAssignment.dto.response.AssignmentResponseDTO;
import com.youquiz.backend.components.quizAssignment.service.QuizAssignmentService;
import com.youquiz.backend.entities.QuizAssignment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/assignments")
public class QuizAssignmentController extends Controller<QuizAssignment, Long, CreateAssignmenentDTO, UpdateAssignmenentDTO, AssignmentResponseDTO> {
   private final QuizAssignmentService quizAssingmentService;

    public QuizAssignmentController(QuizAssignmentService quizAssingmentService) {
        super(quizAssingmentService);
        this.quizAssingmentService = quizAssingmentService;
    }
}
