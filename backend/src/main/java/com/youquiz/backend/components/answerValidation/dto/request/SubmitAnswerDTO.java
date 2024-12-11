package com.youquiz.backend.components.answerValidation.dto.request;

import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
public class SubmitAnswerDTO {
    @NotNull(message = "quizAssignmentId is required")
    private Long quizAssignmentId;

    @NotNull(message = "questionId is required")
    private Long questionId;

    @NotNull(message = "answerId is required")
    private Long answerId;
}