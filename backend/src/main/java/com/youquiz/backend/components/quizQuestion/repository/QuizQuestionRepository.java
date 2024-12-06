package com.youquiz.backend.components.quizQuestion.repository;

import com.youquiz.backend.EntityComponentsProvider.repository.EntityRepository;
import com.youquiz.backend.entities.QuizQuestion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuizQuestionRepository extends EntityRepository<QuizQuestion, Long> {
    @Query("""
        SELECT CASE WHEN COUNT(qq) > 0 THEN TRUE ELSE FALSE END
        FROM QuizQuestion qq
        WHERE qq.quiz.id   = :quizId
        AND qq.question.id = :questionId
    """)
    public boolean isRecordAlreadyExists(
            @Param("quizId") Long quizId,
            @Param("questionId") Long questionId
    );

    @Query("""
        SELECT CASE WHEN COUNT(qq) > 0 THEN TRUE ELSE FALSE END
        FROM QuizQuestion qq
        WHERE qq.quiz.id   = :quizId
        AND qq.question.id = :questionId
        AND qq.id != :quizQuestionId
    """)
    public boolean isRecordAlreadyExistsForUpdate(
            @Param("quizId") Long quizId,
            @Param("questionId") Long questionId,
            @Param("quizQuestionId") Long quizQuestionId
    );
}
