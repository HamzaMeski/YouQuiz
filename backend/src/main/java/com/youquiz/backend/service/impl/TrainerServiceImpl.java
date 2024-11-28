package com.youquiz.backend.service.impl;

import com.youquiz.backend.mapper.trainer.request.CreateTrainerRequest;
import com.youquiz.backend.mapper.trainer.response.TrainerResponse;
import com.youquiz.backend.service.TrainerService;

public class TrainerServiceImpl implements TrainerService {

    @Override
    public TrainerResponse create(CreateTrainerRequest request) {
        // validateTrainerCreation(request);
        return null;
    }

    // validation methods
    public void validateTrainerCreation(CreateTrainerRequest request) {

    }
}
