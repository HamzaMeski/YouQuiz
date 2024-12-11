package com.youquiz.backend.components.answerValidation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.youquiz.backend.EntityComponentsProvider.repository.EntityRepository;
import com.youquiz.backend.entities.AnswerValidation;
import com.youquiz.backend.entities.QuizAssignment;

public interface AnswerValidationRepository extends EntityRepository<AnswerValidation, Long> {
    @Query("SELECT av.points FROM AnswerValidation av WHERE av.question.id = :questionId AND av.answer.id = :answerId")
    Float findPointsByQuestionAndAnswer(@Param("questionId") Long questionId, @Param("answerId") Long answerId);
    
    @Query("SELECT av.isCorrect FROM AnswerValidation av WHERE av.question.id = :questionId AND av.answer.id = :answerId")
    Boolean isAnswerCorrectForQuestion(@Param("questionId") Long questionId, @Param("answerId") Long answerId);
    
    @Query("SELECT CASE WHEN COUNT(av) > 0 THEN true ELSE false END FROM AnswerValidation av " +
           "WHERE av.question.id = :questionId AND :quizAssignment MEMBER OF av.quizAssignments")
    boolean hasAnsweredQuestion(@Param("questionId") Long questionId, @Param("quizAssignment") QuizAssignment quizAssignment);
    
    @Query("SELECT SUM(av.points) FROM AnswerValidation av WHERE :quizAssignment MEMBER OF av.quizAssignments AND av.isCorrect = true")
    Float calculateTotalScore(@Param("quizAssignment") QuizAssignment quizAssignment);
    
    @Query("SELECT av FROM AnswerValidation av WHERE av.question.id = :questionId AND av.answer.id = :answerId")
    Optional<AnswerValidation> findByQuestionAndAnswer(@Param("questionId") Long questionId, @Param("answerId") Long answerId);
}
