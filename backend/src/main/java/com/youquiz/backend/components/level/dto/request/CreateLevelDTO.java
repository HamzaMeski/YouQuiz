package com.youquiz.backend.components.level.dto.request;

import com.youquiz.backend.EntityComponentsProvider.dto.request.CreateDTO;
import com.youquiz.backend.entities.Level;
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
public class CreateLevelDTO extends CreateDTO<Level> {

    @NotBlank(message = "name shouldn't be blank")
    private String name;

    @NotNull(message = "Set Max Points value")
    private Float maxPoints;

    @NotNull(message = "Set Min Points value")
    private Float minPoints;
}
