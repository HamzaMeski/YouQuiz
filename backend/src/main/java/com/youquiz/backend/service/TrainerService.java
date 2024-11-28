package com.youquiz.backend.service;

import com.youquiz.backend.mapper.trainer.request.CreateTrainerRequest;
import com.youquiz.backend.mapper.trainer.response.TrainerResponse;

public interface TrainerService {
    TrainerResponse create(CreateTrainerRequest request);
}
