package com.youquiz.backend.components.quiz.controller;

import com.youquiz.backend.EntityComponentsProvider.controller.Controller;
import com.youquiz.backend.components.quiz.dto.request.CreateQuizDTO;
import com.youquiz.backend.components.quiz.dto.request.UpdateQuizDTO;
import com.youquiz.backend.components.quiz.dto.response.QuizResponseDTO;
import com.youquiz.backend.components.quiz.service.QuizService;
import com.youquiz.backend.entities.Quiz;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController extends Controller<Quiz, Long, CreateQuizDTO, UpdateQuizDTO, QuizResponseDTO> {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        super(quizService);
        this.quizService = quizService;
    }
}
