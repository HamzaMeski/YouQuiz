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

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrainerServiceImpl implements TrainerService {
    private final TrainerRepository trainerRepository;
    private final TrainerMapper trainerMapper;

    @Override
    public TrainerResponse create(CreateTrainerRequest request) {
        log.info("start create method...");
        validateCreate(request);

        Trainer trainer = trainerMapper.toEntity(request);
        trainer.setRegistrationDate(LocalDate.now());
        log.info("before saving...");
        Trainer savedTrainer = trainerRepository.save(trainer);
        log.info("after saving...");
        TrainerResponse trainerResponse = trainerMapper.toTrainerResponse(savedTrainer);
        log.info("after mapping...");
        return trainerResponse;
    }

    // validation methods
    public void validateCreate(CreateTrainerRequest request) {
        if(trainerRepository.existsByEmail(request.getEmail())) {
            throw new ValidationException("Email Already exists");
        }
    }
}
