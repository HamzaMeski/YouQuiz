package com.youquiz.backend.components.question.dto.request;

import com.youquiz.backend.EntityComponentsProvider.dto.request.CreateDTO;
import com.youquiz.backend.EntityComponentsProvider.dto.request.RelationshipField;
import com.youquiz.backend.entities.Level;
import com.youquiz.backend.entities.Question;
import com.youquiz.backend.entities.Subject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateQuestionDTO extends CreateDTO<Question> {

    @RelationshipField(
            entity = Level.class,
            repository = "com.youquiz.backend.components.level.repository.LevelRepository"
    )
    @NotNull(message = "question is required")
    private Long levelId;

    @RelationshipField(
            entity = Subject.class,
            repository = "com.youquiz.backend.components.subject.repository.SubjectRepository"
    )
    @NotNull(message = "subject is required")
    private Long subjectId;

    @NotBlank(message = "question shouldn't be blank")
    private String question;
}
