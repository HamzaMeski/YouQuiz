package com.youquiz.backend.dto.trainer.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateTrainerRequest {
    @NotBlank(message = "first name shouldn't be blank")
    private String firstName;

    @NotBlank(message = "last name shouldn't be blank")
    private String lastName;

    @NotBlank(message = "email is required")
    @Email(message = "make sure the email you set is valid")
    private String email;

    @NotNull
    private LocalDate birthDate;

    private String specialty;
}
