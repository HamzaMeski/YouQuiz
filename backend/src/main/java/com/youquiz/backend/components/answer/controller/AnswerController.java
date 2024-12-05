package com.youquiz.backend.components.answer.controller;

import com.youquiz.backend.EntityComponentsProvider.controller.Controller;
import com.youquiz.backend.components.answer.dto.request.CreateAnswerDTO;
import com.youquiz.backend.components.answer.dto.request.UpdateAnswerDTO;
import com.youquiz.backend.components.answer.dto.response.AnswerResponseDTO;
import com.youquiz.backend.components.answer.service.AnswerService;
import com.youquiz.backend.entities.Answer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answers")
public class AnswerController extends Controller<Answer, Long, CreateAnswerDTO, UpdateAnswerDTO, AnswerResponseDTO> {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        super(answerService);
        this.answerService = answerService;
    }
}