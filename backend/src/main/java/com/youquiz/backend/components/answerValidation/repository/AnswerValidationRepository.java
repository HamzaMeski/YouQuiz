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

    @Query(value = "SELECT is_correct FROM answer_validation " +
            "WHERE question_id = :questionId AND answer_id = :answerId " +
            "ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Boolean isAnswerCorrectForQuestion(@Param("questionId") Long questionId, @Param("answerId") Long answerId);

    @Query("SELECT CASE WHEN COUNT(av) > 0 THEN true ELSE false END FROM AnswerValidation av " +
           "WHERE av.question.id = :questionId AND :quizAssignment MEMBER OF av.quizAssignments")
    boolean hasAnsweredQuestion(@Param("questionId") Long questionId, @Param("quizAssignment") QuizAssignment quizAssignment);
    
    @Query("SELECT SUM(av.points) FROM AnswerValidation av WHERE :quizAssignment MEMBER OF av.quizAssignments AND av.isCorrect = true")
    Float calculateTotalScore(@Param("quizAssignment") QuizAssignment quizAssignment);

    @Query(value = "SELECT * FROM answer_validation av " +
            "WHERE av.question_id = :questionId AND av.answer_id = :answerId " +
            "ORDER BY av.created_date DESC " +
            "LIMIT 1",
            nativeQuery = true)
    Optional<AnswerValidation> findByQuestionAndAnswer(@Param("questionId") Long questionId, @Param("answerId") Long answerId);

}
