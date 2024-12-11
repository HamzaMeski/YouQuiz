// AnalyticsRepository.java
package com.youquiz.backend.components.analytics.repository;

import com.youquiz.backend.entities.QuizAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AnalyticsRepository extends JpaRepository<QuizAssignment, Long> {

    @Query("SELECT AVG(qa.score) FROM QuizAssignment qa WHERE qa.student.id = :studentId")
    Double getStudentAverageScore(@Param("studentId") Long studentId);

    @Query("SELECT COUNT(qa) FROM QuizAssignment qa WHERE qa.student.id = :studentId")
    Integer getStudentTotalQuizzes(@Param("studentId") Long studentId);

    @Query("SELECT AVG(qa.score) FROM QuizAssignment qa WHERE qa.quiz.id = :quizId")
    Double getQuizAverageScore(@Param("quizId") Long quizId);

    @Query("SELECT COUNT(qa) FROM QuizAssignment qa WHERE qa.quiz.id = :quizId")
    Integer getQuizTotalAttempts(@Param("quizId") Long quizId);
}