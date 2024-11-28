package com.youquiz.backend.service;


import com.youquiz.backend.dto.trainer.request.CreateTrainerRequest;
import com.youquiz.backend.dto.trainer.response.TrainerResponse;

public interface TrainerService {
    TrainerResponse create(CreateTrainerRequest request);
}
