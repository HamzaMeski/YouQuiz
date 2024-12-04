package com.youquiz.backend.components.quizAssignment.dto.response;

import com.youquiz.backend.EntityComponentsProvider.dto.response.ResponseDTO;
import com.youquiz.backend.components.quiz.dto.response.QuizResponseDTO;
import com.youquiz.backend.components.student.dto.response.StudentResponseDTO;
import com.youquiz.backend.entities.QuizAssignment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssignmentResponseDTO extends ResponseDTO<QuizAssignment, Long> {
    private Long id;
    private QuizResponseDTO quiz;
    private StudentResponseDTO student;
    private String reason;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer attempt;
    private Double score;
}
