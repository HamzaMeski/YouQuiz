package com.youquiz.backend.components.answerValidation.dto.response;

import com.youquiz.backend.EntityComponentsProvider.dto.response.ResponseDTO;
import com.youquiz.backend.components.answer.dto.response.AnswerResponseDTO;
import com.youquiz.backend.components.question.dto.response.QuestionResponseDTO;
import com.youquiz.backend.components.quizAssignment.dto.response.AssignmentResponseDTO;
import com.youquiz.backend.entities.AnswerValidation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AnswerValidationResponseDTO extends ResponseDTO<AnswerValidation, Long> {
    private AnswerResponseDTO answer;
    private QuestionResponseDTO question;
    private AssignmentResponseDTO quizAssignment;
    private Float points;
}