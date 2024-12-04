package com.youquiz.backend.components.quizAssignment.service;

import com.youquiz.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.youquiz.backend.components.quizAssignment.dto.request.CreateAssignmenentDTO;
import com.youquiz.backend.components.quizAssignment.dto.request.UpdateAssignmenentDTO;
import com.youquiz.backend.components.quizAssignment.dto.response.AssignmentResponseDTO;
import com.youquiz.backend.components.quizAssignment.mapper.QuizAssingmentMapper;
import com.youquiz.backend.components.quizAssignment.repository.QuizAssingmentRepository;
import com.youquiz.backend.entities.QuizAssignment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class QuizAssingmentService extends EntityServiceImpl<QuizAssignment, Long, CreateAssignmenentDTO, UpdateAssignmenentDTO, AssignmentResponseDTO>  {
    private final QuizAssingmentRepository quizAssingmentRepository;
    private final QuizAssingmentMapper quizAssingmentMapper;

    public QuizAssingmentService(
            QuizAssingmentRepository quizAssingmentRepository,
            QuizAssingmentMapper quizAssingmentMapper,
            ApplicationContext applicationContext) {
        super(quizAssingmentRepository, quizAssingmentMapper, applicationContext);
        this.quizAssingmentRepository = quizAssingmentRepository;
        this.quizAssingmentMapper = quizAssingmentMapper;
    }
}