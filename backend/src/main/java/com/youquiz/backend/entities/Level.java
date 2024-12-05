package com.youquiz.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "levels")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name shouldn't be blank")
    private String name;

    @NotNull(message = "max points value is required")
    private Float maxPoints;

    @NotNull(message = "min points value is required")
    private Float minPoints;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;
}
