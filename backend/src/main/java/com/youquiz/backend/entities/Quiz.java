package com.youquiz.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "quizzes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizAssignment> quizAssignments;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizQuestion> quizzesQuestions;

    @NotBlank(message = "Title shouldn't be blank")
    private String title;

    @Min(value = 1, message = "Duration at least must be 1 minute")
    @Max(value = 120, message = "Duration must have at maximum 60 minutes")
    private Integer duration;

    @Positive(message = "Success score can not be negative")
    private Double successScore;

    private Boolean canSeeAnswers;
    private Boolean canSeeResult;
    private Integer chances;
    private String remark;
}
