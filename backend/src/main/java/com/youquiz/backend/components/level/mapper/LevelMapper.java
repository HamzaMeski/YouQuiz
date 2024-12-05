package com.youquiz.backend.components.level.mapper;

import com.youquiz.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.youquiz.backend.components.level.dto.request.CreateLevelDTO;
import com.youquiz.backend.components.level.dto.request.UpdateLevelDTO;
import com.youquiz.backend.components.level.dto.response.LevelResponseDTO;
import com.youquiz.backend.entities.Level;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LevelMapper extends EntityMapper<Level, Long, CreateLevelDTO, UpdateLevelDTO, LevelResponseDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "questions", ignore = true)
    Level toEntity(CreateLevelDTO createLevelDTO);

    @Override
    @Mapping(target = "questions", ignore = true)
    void updateEntity(UpdateLevelDTO updateLevelDTO, @MappingTarget Level level);

    @Override
    LevelResponseDTO toResponseDTO(Level level);
}