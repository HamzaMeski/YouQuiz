package com.youquiz.backend.components.question.controller;

import com.youquiz.backend.EntityComponentsProvider.controller.Controller;
import com.youquiz.backend.components.question.dto.request.CreateQuestionDTO;
import com.youquiz.backend.components.question.dto.request.UpdateQuestionDTO;
import com.youquiz.backend.components.question.dto.response.QuestionResponseDTO;
import com.youquiz.backend.components.question.service.QuestionService;
import com.youquiz.backend.entities.Question;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questions")
public class QuestionController extends Controller<Question, Long, CreateQuestionDTO, UpdateQuestionDTO, QuestionResponseDTO> {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        super(questionService);
        this.questionService = questionService;
    }
}
