package com.youquiz.backend.components.quizQuestion.dto.response;

import com.youquiz.backend.EntityComponentsProvider.dto.response.ResponseDTO;
import com.youquiz.backend.components.question.dto.response.QuestionResponseDTO;
import com.youquiz.backend.components.quiz.dto.response.QuizResponseDTO;
import com.youquiz.backend.entities.QuizQuestion;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QuizQuestionResponseDTO extends ResponseDTO<QuizQuestion, Long> {
    private Long id;
    private Float timer;
    private QuestionResponseDTO question;
    private QuizResponseDTO quiz;
}