package com.youquiz.backend.components.quiz.dto.request;

import com.youquiz.backend.EntityComponentsProvider.dto.request.UpdateDTO;
import com.youquiz.backend.entities.Quiz;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateQuizDTO extends UpdateDTO<Quiz> {

    @NotNull(message = "trainerId is required")
    private Long trainerId;

    @NotBlank(message = "Title shouldn't be blank")
    private String title;

    @Min(value = 1, message = "Duration at least must be 1 minute")
    @Max(value = 120, message = "Duration must have at maximum 60 minutes")
    private Integer duration;

    @Positive(message = "Success score can not be negative")
    private Double successScore;

    private Boolean canSeeAnswers;
    private Boolean canSeeResult;
    private String remark;
}