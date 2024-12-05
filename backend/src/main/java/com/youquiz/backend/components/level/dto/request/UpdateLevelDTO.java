package com.youquiz.backend.components.level.dto.request;

import com.youquiz.backend.EntityComponentsProvider.dto.request.UpdateDTO;
import com.youquiz.backend.entities.Level;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateLevelDTO extends UpdateDTO<Level> {
    @NotBlank(message = "name shouldn't be blank")
    private String name;

    @NotNull(message = "Set Max Points value")
    private Float maxPoints;

    @NotNull(message = "Set Min Points value")
    private Float minPoints;
}
