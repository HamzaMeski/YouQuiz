package com.youquiz.backend.components.quizQuestion.controller;

import com.youquiz.backend.EntityComponentsProvider.controller.Controller;
import com.youquiz.backend.components.quizQuestion.dto.request.CreateQuizQuestionDTO;
import com.youquiz.backend.components.quizQuestion.dto.request.UpdateQuizQuestionDTO;
import com.youquiz.backend.components.quizQuestion.dto.response.QuizQuestionResponseDTO;
import com.youquiz.backend.components.quizQuestion.service.QuizQuestionService;
import com.youquiz.backend.entities.QuizQuestion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quiz-questions")
public class QuizQuestionController extends Controller<QuizQuestion, Long, CreateQuizQuestionDTO, UpdateQuizQuestionDTO, QuizQuestionResponseDTO> {
    private final QuizQuestionService quizQuestionService;

    public QuizQuestionController(QuizQuestionService quizQuestionService) {
        super(quizQuestionService);
        this.quizQuestionService = quizQuestionService;
    }
}
