package com.youquiz.backend.components.level.dto.response;

import com.youquiz.backend.EntityComponentsProvider.dto.response.ResponseDTO;
import com.youquiz.backend.entities.Level;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LevelResponseDTO extends ResponseDTO<Level, Long> {
    private String name;
    private Float maxPoints;
    private Float minPoints;
}
