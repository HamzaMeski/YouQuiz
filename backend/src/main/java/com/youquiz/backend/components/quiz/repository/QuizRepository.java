package com.youquiz.backend.components.quiz.repository;

import com.youquiz.backend.EntityComponentsProvider.repository.EntityRepository;
import com.youquiz.backend.entities.Question;
import com.youquiz.backend.entities.Quiz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepository extends EntityRepository<Quiz, Long> {

    @Query("SELECT q FROM Question q " +
            "JOIN QuizQuestion qq ON q.id = qq.question.id " +
            "JOIN qq.quiz quiz " +
            "WHERE quiz.id = :quizId")
    public List<Question> findQuestionsByQuizId(@Param("quizId") Long quizId);
}
