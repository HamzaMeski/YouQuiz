package com.youquiz.backend.components.quiz.mapper;

import com.youquiz.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.youquiz.backend.components.question.dto.response.QuestionResponseDTO;
import com.youquiz.backend.components.quiz.dto.request.CreateQuizDTO;
import com.youquiz.backend.components.quiz.dto.request.UpdateQuizDTO;
import com.youquiz.backend.components.quiz.dto.response.QuizDetailResponseDTO;
import com.youquiz.backend.components.quiz.dto.response.QuizResponseDTO;
import com.youquiz.backend.components.quiz.repository.QuizRepository;
import com.youquiz.backend.components.quizQuestion.repository.QuizQuestionRepository;
import com.youquiz.backend.entities.Question;
import com.youquiz.backend.entities.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class QuizMapper implements EntityMapper<Quiz, Long, CreateQuizDTO, UpdateQuizDTO, QuizResponseDTO> {

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @Override
    @Mapping(target = "trainer", ignore = true)
    @Mapping(target = "quizAssignments", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract Quiz toEntity(CreateQuizDTO createQuizDTO);

    @Override
    @Mapping(target = "trainer", ignore = true)
    @Mapping(target = "quizAssignments", ignore = true)
    public abstract void updateEntity(UpdateQuizDTO updateQuizDTO, @MappingTarget Quiz quiz);

    @Override
    @Mapping(target = "trainerId", source = "trainer.id")
    public abstract QuizResponseDTO toResponseDTO(Quiz quiz);

    @Mapping(target = "trainerName", expression = "java(getTrainerName(quiz))")
    @Mapping(target = "totalNumberOsAssignments", expression = "java(getTotalNumberOsAssignments(quiz))")
    @Mapping(target = "questions", ignore = true)
    public abstract QuizDetailResponseDTO toDetailResponseDTO(Quiz quiz);

    // helpers
    String getTrainerName(Quiz quiz) {
        return quiz.getTrainer().getFirstName() + " " + quiz.getTrainer().getLastName();
    }

    Integer getTotalNumberOsAssignments(Quiz quiz) {
        return quiz.getQuizAssignments().size();
    }
}