package com.youquiz.backend.components.level.service;

import com.youquiz.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.youquiz.backend.components.level.dto.request.CreateLevelDTO;
import com.youquiz.backend.components.level.dto.request.UpdateLevelDTO;
import com.youquiz.backend.components.level.dto.response.LevelResponseDTO;
import com.youquiz.backend.components.level.mapper.LevelMapper;
import com.youquiz.backend.components.level.repository.LevelRepository;
import com.youquiz.backend.entities.Level;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional
public class LevelService extends EntityServiceImpl<Level, Long, CreateLevelDTO, UpdateLevelDTO, LevelResponseDTO> {
    private final LevelRepository levelRepository;
    private final LevelMapper levelMapper;

    public LevelService(
            LevelRepository levelRepository,
            LevelMapper levelMapper,
            ApplicationContext applicationContext) {
        super(levelRepository, levelMapper, applicationContext);
        this.levelRepository = levelRepository;
        this.levelMapper = levelMapper;
    }

    @Override
    public LevelResponseDTO create(CreateLevelDTO createLevelDTO) {
        log.info("create method started...");
        log.info("*Name: {}", createLevelDTO.getName());
        log.info("*MinPoints: {}", createLevelDTO.getMinPoints());
        log.info("*MaxPoints: {}", createLevelDTO.getMaxPoints());
        return super.create(createLevelDTO);
    }
}
