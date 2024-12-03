package com.youquiz.backend.components.quiz.mapper;

import com.youquiz.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.youquiz.backend.components.quiz.dto.request.CreateQuizDTO;
import com.youquiz.backend.components.quiz.dto.request.UpdateQuizDTO;
import com.youquiz.backend.components.quiz.dto.response.QuizDetailResponseDTO;
import com.youquiz.backend.components.quiz.dto.response.QuizResponseDTO;
import com.youquiz.backend.entities.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface QuizMapper extends EntityMapper<Quiz, Long, CreateQuizDTO, UpdateQuizDTO, QuizResponseDTO> {
    @Override
    @Mapping(target = "trainer", ignore = true)
    @Mapping(target = "quizAssignments", ignore = true)
    @Mapping(target = "id", ignore = true)
    Quiz toEntity(CreateQuizDTO createQuizDTO);

    @Override
    @Mapping(target = "trainer", ignore = true)
    @Mapping(target = "quizAssignments", ignore = true)
    void updateEntity(UpdateQuizDTO updateQuizDTO, @MappingTarget Quiz quiz);

    @Override
    @Mapping(target = "trainerId", source = "trainer.id")
    QuizResponseDTO toResponseDTO(Quiz quiz);

    @Mapping(target = "trainerName", expression = "java(getTrainerName(quiz))")
    @Mapping(target = "totalNumberOsAssignments", expression = "java(getTotalNumberOsAssignments(quiz))")
    QuizDetailResponseDTO toDetailResponseDTO(Quiz quiz);

    // helpers
    default public String getTrainerName(Quiz quiz) {
        return quiz.getTrainer().getFirstName() + " " + quiz.getTrainer().getLastName();
    }

    default public Integer getTotalNumberOsAssignments(Quiz quiz) {
        return quiz.getQuizAssignments().size();
    }
}