package com.youquiz.backend.components.student.dto.response;

import com.youquiz.backend.EntityComponentsProvider.dto.response.ResponseDTO;
import com.youquiz.backend.entities.Student;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StudentResponseDTO extends ResponseDTO<Student, Long> {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private LocalDate registrationDate;
}
