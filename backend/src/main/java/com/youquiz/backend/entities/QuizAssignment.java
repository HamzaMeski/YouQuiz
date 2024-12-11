package com.youquiz.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quiz_assignment")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", nullable = false)
    @JsonManagedReference
    @ToString.Exclude
    private Quiz quiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    @JsonManagedReference
    @ToString.Exclude
    private Student student;

    @ManyToMany
    @JoinTable(
        name = "quiz_assignment_answer_validation",
        joinColumns = @JoinColumn(name = "quiz_assignment_id"),
        inverseJoinColumns = @JoinColumn(name = "answer_validation_id")
    )
    @JsonManagedReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<AnswerValidation> answerValidations = new HashSet<>();

    private String reason;

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime endTime;

    private Integer attempt;

    @Builder.Default
    private Double score = 0.0;

    public void updateScore(Float newScore) {
        this.score = newScore != null ? newScore.doubleValue() : 0.0;
    }
}