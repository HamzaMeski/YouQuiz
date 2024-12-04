package com.youquiz.backend.components.question.dto.request;

import com.youquiz.backend.entities.AnswerValidation;
import com.youquiz.backend.entities.Level;
import com.youquiz.backend.entities.Subject;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class CreateQuestionDTO {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", nullable = false)
    private Subject subject;

    @NotBlank(message = "question shouldn't be blank")
    private String question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswerValidation> answerValidations;

    private Integer correctAnswers;

}
