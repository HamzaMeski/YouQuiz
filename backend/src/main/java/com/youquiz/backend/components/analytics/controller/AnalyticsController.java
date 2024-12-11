// AnalyticsController.java
package com.youquiz.backend.components.analytics.controller;

import com.youquiz.backend.components.analytics.dto.response.QuizStatisticsDTO;
import com.youquiz.backend.components.analytics.dto.response.StudentPerformanceDTO;
import com.youquiz.backend.components.analytics.service.AnalyticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/student/{studentId}")
    public ResponseEntity<StudentPerformanceDTO> getStudentPerformance(
            @PathVariable Long studentId) {
        return ResponseEntity.ok(analyticsService.getStudentPerformance(studentId));
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<QuizStatisticsDTO> getQuizStatistics(
            @PathVariable Long quizId) {
        return ResponseEntity.ok(analyticsService.getQuizStatistics(quizId));
    }
}