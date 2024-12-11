package com.youquiz.backend.components.answerValidation.controller;

import com.youquiz.backend.EntityComponentsProvider.controller.Controller;
import com.youquiz.backend.components.answerValidation.dto.request.CreateAnswerValidationDTO;
import com.youquiz.backend.components.answerValidation.dto.request.SubmitAnswerDTO;
import com.youquiz.backend.components.answerValidation.dto.request.UpdateAnswerValidationDTO;
import com.youquiz.backend.components.answerValidation.dto.response.AnswerValidationResponseDTO;
import com.youquiz.backend.components.answerValidation.service.AnswerValidationService;
import com.youquiz.backend.entities.AnswerValidation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answer-validations")
public class AnswerValidationController extends Controller<AnswerValidation, Long, CreateAnswerValidationDTO, UpdateAnswerValidationDTO, AnswerValidationResponseDTO> {
    private final AnswerValidationService answerValidationService;

    public AnswerValidationController(AnswerValidationService answerValidationService) {
        super(answerValidationService);
        this.answerValidationService = answerValidationService;
    }

    @PostMapping("/submit")
    public ResponseEntity<AnswerValidationResponseDTO> submitAnswer(@Valid @RequestBody SubmitAnswerDTO submitAnswerDTO) {
        return ResponseEntity.ok(answerValidationService.submitAnswer(submitAnswerDTO));
    }
}
