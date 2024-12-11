// AnalyticsService.java
package com.youquiz.backend.components.analytics.service;

import com.youquiz.backend.components.analytics.dto.response.QuizStatisticsDTO;
import com.youquiz.backend.components.analytics.dto.response.StudentPerformanceDTO;
import com.youquiz.backend.components.analytics.repository.AnalyticsRepository;
import com.youquiz.backend.components.quiz.repository.QuizRepository;
import com.youquiz.backend.components.student.repository.StudentRepository;
import com.youquiz.backend.config.exception.ResourceNotFoundException;
import com.youquiz.backend.entities.Quiz;
import com.youquiz.backend.entities.Student;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final AnalyticsRepository analyticsRepository;
    private final StudentRepository studentRepository;
    private final QuizRepository quizRepository;

    public StudentPerformanceDTO getStudentPerformance(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Double avgScore = analyticsRepository.getStudentAverageScore(studentId);
        Integer totalQuizzes = analyticsRepository.getStudentTotalQuizzes(studentId);

        return StudentPerformanceDTO.builder()
                .studentId(studentId)
                .studentName(student.getFirstName() + " " + student.getLastName())
                .averageScore(avgScore)
                .totalQuizzesTaken(totalQuizzes)
                .build();
    }

    public QuizStatisticsDTO getQuizStatistics(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));

        Double avgScore = analyticsRepository.getQuizAverageScore(quizId);
        Integer totalAttempts = analyticsRepository.getQuizTotalAttempts(quizId);

        return QuizStatisticsDTO.builder()
                .quizId(quizId)
                .quizName(quiz.getTitle())
                .averageScore(avgScore)
                .totalAttempts(totalAttempts)
                .build();
    }
}