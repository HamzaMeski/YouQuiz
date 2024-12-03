package com.youquiz.backend.components.quiz.service;

import com.youquiz.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.youquiz.backend.components.quiz.dto.request.CreateQuizDTO;
import com.youquiz.backend.components.quiz.dto.request.UpdateQuizDTO;
import com.youquiz.backend.components.quiz.dto.response.QuizResponseDTO;
import com.youquiz.backend.components.quiz.mapper.QuizMapper;
import com.youquiz.backend.components.quiz.repository.QuizRepository;
import com.youquiz.backend.entities.Quiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class QuizService extends EntityServiceImpl<Quiz, Long, CreateQuizDTO, UpdateQuizDTO, QuizResponseDTO> {
    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    public QuizService(QuizRepository quizRepository, QuizMapper quizMapper) {
        super(quizRepository, quizMapper);
        this.quizRepository = quizRepository;
        this.quizMapper = quizMapper;
    }

    @Override
    public QuizResponseDTO create(CreateQuizDTO request) {

        super.create(request);
    }
}
