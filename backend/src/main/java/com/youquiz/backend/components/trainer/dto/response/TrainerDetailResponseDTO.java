package com.youquiz.backend.components.trainer.dto.response;

import com.youquiz.backend.EntityComponentsProvider.dto.response.DetailResponseDTO;
import com.youquiz.backend.entities.Trainer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TrainerDetailResponseDTO extends DetailResponseDTO<Trainer, Long> {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private LocalDate registrationDate;
    private String specialty;
    private Integer age;
    private Integer yearsOfExperience;
}