package com.youquiz.backend.components.quizAssignment.dto.request;

import com.youquiz.backend.EntityComponentsProvider.dto.request.CreateDTO;
import com.youquiz.backend.EntityComponentsProvider.dto.request.RelationshipField;
import com.youquiz.backend.entities.Quiz;
import com.youquiz.backend.entities.QuizAssignment;
import com.youquiz.backend.entities.Student;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateAssignmenentDTO extends CreateDTO<QuizAssignment> {

    @RelationshipField(
            entity = Quiz.class,
            repository = "com.youquiz.backend.components.quiz.repository.QuizRepository"
    )
    @NotNull(message = "quizId is required")
    private Long quizId;

    @RelationshipField(
            entity = Student.class,
            repository = "com.youquiz.backend.components.student.repository.StudentRepository"
    )
    @NotNull(message = "studentId is required")
    private Long studentId;

    private String reason;

    @NotNull(message = "start time is required")
    private LocalTime startTime;

    @NotNull(message = "end time is required")
    private LocalTime endTime;

    private Integer attempt;

    private Double score = 0.0;
}
