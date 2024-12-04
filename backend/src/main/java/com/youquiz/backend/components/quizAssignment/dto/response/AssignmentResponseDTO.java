package com.youquiz.backend.components.quizAssignment.dto.response;

import com.youquiz.backend.EntityComponentsProvider.dto.request.CreateDTO;
import com.youquiz.backend.EntityComponentsProvider.dto.response.ResponseDTO;
import com.youquiz.backend.entities.Quiz;
import com.youquiz.backend.entities.QuizAssignment;
import com.youquiz.backend.entities.Student;
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
    private Quiz quiz;
    private Student student;
    private String reason;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer attempt;
    private Double score;
}
