package com.youquiz.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@SuperBuilder
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizAssignment> quizAssignments;

    @NotBlank(message = "first name shouldn't be blank")
    private String firstName;

    @NotBlank(message = "last name shouldn't be blank")
    private String lastName;

    @NotBlank(message = "email is required")
    @Email(message = "make sure the email you set is valid")
    private String email;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private LocalDate registrationDate;
}
