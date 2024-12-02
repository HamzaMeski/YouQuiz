package com.youquiz.backend.components.student.dto.request;

import com.youquiz.backend.EntityComponentsProvider.dto.request.UpdateDTO;
import com.youquiz.backend.entities.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateStudentDTO extends UpdateDTO<Student> {
    @NotBlank(message = "first name shouldn't be blank")
    private String firstName;

    @NotBlank(message = "last name shouldn't be blank")
    private String lastName;

    @NotBlank(message = "email is required")
    @Email(message = "make sure the email you set is valid")
    private String email;

    @NotNull(message = "birth date is required")
    private LocalDate birthDate;
}
