package com.youquiz.backend.components.quiz.dto.response;

import com.youquiz.backend.EntityComponentsProvider.dto.response.ResponseDTO;
import com.youquiz.backend.entities.Quiz;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QuizResponseDTO extends ResponseDTO<Quiz, Long> {
    private Long trainerId;
    private String title;
    private Integer duration;
    private Double successScore;
    private Boolean canSeeAnswers;
    private Boolean canSeeResult;
    private Integer chances;
    private String remark;
}
