package com.youquiz.backend.components.level.controller;

import com.youquiz.backend.EntityComponentsProvider.controller.Controller;
import com.youquiz.backend.components.level.dto.request.CreateLevelDTO;
import com.youquiz.backend.components.level.dto.request.UpdateLevelDTO;
import com.youquiz.backend.components.level.dto.response.LevelResponseDTO;
import com.youquiz.backend.components.level.service.LevelService;
import com.youquiz.backend.entities.Level;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/levels")
public class LevelController extends Controller<Level, Long, CreateLevelDTO, UpdateLevelDTO, LevelResponseDTO> {
    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        super(levelService);
        this.levelService = levelService;
    }
}
