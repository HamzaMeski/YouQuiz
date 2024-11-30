package com.youquiz.backend.service;

import com.youquiz.backend.dto.trainer.request.CreateTrainerRequest;
import com.youquiz.backend.dto.trainer.request.UpdateTrainerRequest;
import com.youquiz.backend.dto.trainer.response.TrainerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TrainerService {
    TrainerResponse create(CreateTrainerRequest request);
    void update(Long id, UpdateTrainerRequest request);
    Page<TrainerResponse> getAll(Pageable pageable);
    TrainerResponse getById(Long id);
    void delete(Long id);
}
