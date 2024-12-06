package com.youquiz.backend.components.quizQuestion.dto.request;

import com.youquiz.backend.EntityComponentsProvider.dto.request.RelationshipField;
import com.youquiz.backend.EntityComponentsProvider.dto.request.UpdateDTO;
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
public class UpdateQuizQuestionDTO extends UpdateDTO<QuizQuestion> {

    @RelationshipField(
            entity = Quiz.class,
            repository = "com.youquiz.backend.components.quiz.repository.QuizRepository"
    )
    @NotNull(message = "quizId is required")
    private Long quizId;

    @RelationshipField(
            entity = Question.class,
            repository = "com.youquiz.backend.components.question.repository.QuestionRepository"
    )
    @NotNull(message = "questionId is required")
    private Long questionId;

    @NotNull(message = "timer is required")
    private Float timer;
}