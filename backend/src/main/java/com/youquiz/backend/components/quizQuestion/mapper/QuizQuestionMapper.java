package com.youquiz.backend.components.quizQuestion.mapper;

import com.youquiz.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.youquiz.backend.components.question.mapper.QuestionMapper;
import com.youquiz.backend.components.quiz.mapper.QuizMapper;
import com.youquiz.backend.components.quizQuestion.dto.request.CreateQuizQuestionDTO;
import com.youquiz.backend.components.quizQuestion.dto.request.UpdateQuizQuestionDTO;
import com.youquiz.backend.components.quizQuestion.dto.response.QuizQuestionResponseDTO;
import com.youquiz.backend.entities.QuizQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {QuizMapper.class, QuestionMapper.class})
public interface QuizQuestionMapper extends EntityMapper<QuizQuestion, Long, CreateQuizQuestionDTO, UpdateQuizQuestionDTO, QuizQuestionResponseDTO>  {
    @Override
    @Mapping(target = "question", ignore = true)
    @Mapping(target = "quiz", ignore = true)
    QuizQuestion toEntity(CreateQuizQuestionDTO createQuizQuestionDTO);

    @Override
    @Mapping(target = "question", ignore = true)
    @Mapping(target = "quiz", ignore = true)
    void updateEntity(UpdateQuizQuestionDTO updateQuizQuestionDTO, @MappingTarget QuizQuestion quizQuestion);

    @Override
    QuizQuestionResponseDTO toResponseDTO(QuizQuestion quizQuestion);
}