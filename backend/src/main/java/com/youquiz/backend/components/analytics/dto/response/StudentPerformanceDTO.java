package com.youquiz.backend.components.analytics.dto.response;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class StudentPerformanceDTO {
    private Long studentId;
    private String studentName;
    private Double averageScore;
    private Integer totalQuizzesTaken;
    private Integer totalQuestionAnswered;
    private Double successRate;  // percentage of correct answers
}

