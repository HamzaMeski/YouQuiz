package com.youquiz.backend.service.impl;

import com.youquiz.backend.dto.trainer.request.CreateTrainerRequest;
import com.youquiz.backend.dto.trainer.response.TrainerResponse;
import com.youquiz.backend.entity.Trainer;
import com.youquiz.backend.exception.ValidationException;
import com.youquiz.backend.mapper.TrainerMapper;
import com.youquiz.backend.repository.TrainerRepository;
import com.youquiz.backend.service.TrainerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrainerServiceImpl implements TrainerService {
    private final TrainerRepository trainerRepository;
    private final TrainerMapper trainerMapper;

    @Override
    public TrainerResponse create(CreateTrainerRequest request) {
        validateCreate(request);

        Trainer trainer = trainerMapper.toEntity(request);

        return trainerMapper.toTrainerResponse(trainerRepository.save(trainer));
    }

    // validation methods
    public void validateCreate(CreateTrainerRequest request) {
        if(trainerRepository.existsByEmail(request.getEmail())) {
            throw new ValidationException("Email Already exists");
        }
    }
}
