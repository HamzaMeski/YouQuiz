package com.youquiz.backend.components.subject.dto.request;

import com.youquiz.backend.EntityComponentsProvider.dto.request.CreateDTO;
import com.youquiz.backend.EntityComponentsProvider.dto.request.RelationshipField;
import com.youquiz.backend.entities.Subject;
import com.youquiz.backend.entities.Trainer;
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
public class CreateSubjectDTO extends CreateDTO<Subject> {

    @RelationshipField(
            entity = Subject.class,
            repository = "com.youquiz.backend.components.subject.repository.SubjectRepository"
    )
    private Long parentId;

    @NotBlank(message = "title shouldn't be blank")
    private String title;
}
