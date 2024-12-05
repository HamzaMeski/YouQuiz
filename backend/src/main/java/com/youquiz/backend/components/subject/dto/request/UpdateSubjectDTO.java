package com.youquiz.backend.components.subject.dto.request;

import com.youquiz.backend.EntityComponentsProvider.dto.request.RelationshipField;
import com.youquiz.backend.EntityComponentsProvider.dto.request.UpdateDTO;
import com.youquiz.backend.entities.Subject;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateSubjectDTO extends UpdateDTO<Subject> {
    @RelationshipField(
            entity = Subject.class,
            repository = "com.youquiz.backend.components.subject.repository.SubjectRepository"
    )
    private Long parentId;

    @NotBlank(message = "title shouldn't be blank")
    private String title;
}
