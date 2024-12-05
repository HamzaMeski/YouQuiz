package com.youquiz.backend.components.subject.dto.response;

import com.youquiz.backend.EntityComponentsProvider.dto.response.ResponseDTO;
import com.youquiz.backend.entities.Subject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SubjectResponseDTO extends ResponseDTO<Subject, Long> {
    private Long id;
    private String title;
    private Subject parentSubject;
}