package com.youquiz.backend.components.quiz.dto.response;

import com.youquiz.backend.components.question.dto.response.QuestionResponseDTO;
import com.youquiz.backend.components.student.dto.response.StudentResponseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
public class QuizDetailResponseDTO {
    private Long trainerId;
    private String title;
    private Integer duration;
    private Double successScore;
    private Boolean canSeeAnswers;
    private Boolean canSeeResult;
    private Integer chances;
    private String remark;
    // detail
    private String trainerName;
    private Integer totalNumberOsAssignments;

    List<QuestionResponseDTO> questions;
    List<StudentResponseDTO> students;
}
