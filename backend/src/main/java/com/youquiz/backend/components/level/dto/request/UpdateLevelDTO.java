package com.youquiz.backend.components.level.dto.request;

import com.youquiz.backend.EntityComponentsProvider.dto.request.UpdateDTO;
import com.youquiz.backend.entities.Level;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class UpdateLevelDTO extends UpdateDTO<Level> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "description shouldn't be blank")
    private String description;

    @NotNull(message = "Set Max Points value")
    private Float maxPoints;

    @NotNull(message = "Set Min Points value")
    private Float minPoints;
}
