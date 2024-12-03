package com.youquiz.backend.components.quiz.dto.request;

import com.youquiz.backend.EntityComponentsProvider.dto.request.CreateDTO;
import com.youquiz.backend.EntityComponentsProvider.dto.request.RelationshipField;
import com.youquiz.backend.entities.Quiz;
import com.youquiz.backend.entities.Trainer;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateQuizDTO extends CreateDTO<Quiz> {

    @RelationshipField(
            entity = Trainer.class,
            repository = "com.youquiz.backend.components.trainer.repository.TrainerRepository"
    )
    @NotNull(message = "trainerId is required")
    private Long trainerId;

    @NotBlank(message = "Title shouldn't be blank")
    private String title;

    @Min(value = 1, message = "Duration at least must be 1 minute")
    @Max(value = 120, message = "Duration must have at maximum 60 minutes")
    private Integer duration;

    @Positive(message = "Success score can not be negative")
    private Double successScore;

    private Boolean canSeeAnswers = true;
    private Boolean canSeeResult = true;
    private String remark;
}
