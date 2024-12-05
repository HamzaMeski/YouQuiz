package com.youquiz.backend.components.level.dto.response;

import com.youquiz.backend.EntityComponentsProvider.dto.response.ResponseDTO;
import com.youquiz.backend.entities.Level;

public class LevelResponseDTO extends ResponseDTO<Level, Long> {
    private Long id;
    private String description;
    private Float maxPoints;
    private Float minPoints;
}
