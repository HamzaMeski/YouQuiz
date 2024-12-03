package com.youquiz.backend.components.quiz.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class QuizDetailResponseDTO {
    private Long trainerId;
    private String title;
    private Integer duration;
    private Double successScore;
    private Boolean canSeeAnswers;
    private Boolean canSeeResult;
    private Integer chances;
    private String remark;
    // detail
    private String trainerName;
    private Integer totalNumberOsAssignments;
}
