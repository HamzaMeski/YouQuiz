package com.youquiz.backend.components.analytics.dto.response;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class QuizStatisticsDTO {
    private Long quizId;
    private String quizName;
    private Double averageScore;
    private Integer totalAttempts;
    private Double highestScore;
    private Double lowestScore;
    private Double passRate;  // percentage of students who passed
}