package com.youquiz.backend.dto.trainer.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UpdateTrainerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String specialty;
    private LocalDate registrationDate;
}
