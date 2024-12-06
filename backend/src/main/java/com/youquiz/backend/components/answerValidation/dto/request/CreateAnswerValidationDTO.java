package com.youquiz.backend.components.answerValidation.dto.request;

import com.youquiz.backend.EntityComponentsProvider.dto.request.CreateDTO;
import com.youquiz.backend.EntityComponentsProvider.dto.request.RelationshipField;
import com.youquiz.backend.entities.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateAnswerValidationDTO extends CreateDTO<AnswerValidation> {

    @RelationshipField(
            entity = Answer.class,
            repository = "com.youquiz.backend.components.answer.repository.AnswerRepository"
    )
    @NotNull(message = "answerId is required")
    private Long answerId;

    @RelationshipField(
            entity = Question.class,
            repository = "com.youquiz.backend.components.question.repository.QuestionRepository"
    )
    @NotNull(message = "studentId is required")
    private Long questionId;

    @RelationshipField(
            entity = QuizAssignment.class,
            repository = "com.youquiz.backend.components.quizAssignment.repository.QuizAssignmentRepository"
    )
    private Long quizAssignmentId;

    @NotNull(message = "You must set points value, It's required")
    private Float points;
}