package com.youquiz.backend.components.quizQuestion.dto.response;

import com.youquiz.backend.EntityComponentsProvider.dto.response.ResponseDTO;
import com.youquiz.backend.entities.Question;
import com.youquiz.backend.entities.Quiz;
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
    private Question question;
    private Quiz quiz;
}