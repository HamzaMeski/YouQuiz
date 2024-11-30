package com.youquiz.backend.service.impl;

import com.youquiz.backend.dto.trainer.request.CreateTrainerRequest;
import com.youquiz.backend.dto.trainer.request.UpdateTrainerRequest;
import com.youquiz.backend.dto.trainer.response.TrainerResponse;
import com.youquiz.backend.entity.Trainer;
import com.youquiz.backend.exception.ValidationException;
import com.youquiz.backend.mapper.TrainerMapper;
import com.youquiz.backend.repository.TrainerRepository;
import com.youquiz.backend.service.TrainerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
        trainer.setRegistrationDate(LocalDate.now());

        return trainerMapper.toTrainerResponse(trainerRepository.save(trainer));
    }

    @Override
    public void update(Long id, UpdateTrainerRequest request) {
        Trainer trainer = checkUserExistence(id);

        validateUpdate(id, request);
        trainerMapper.updateEntity(request, trainer);

        trainerRepository.save(trainer);
    }

    @Override
    public Page<TrainerResponse> getAll(Pageable pageable) {
         Page<Trainer> trainers = trainerRepository.findAll(pageable);

         return trainers.map(trainerMapper::toTrainerResponse);
    }

    @Override
    public TrainerResponse getById(Long id) {
        return trainerMapper.toTrainerResponse(checkUserExistence(id));
    }

    @Override
    public void delete(Long id) {
        trainerRepository.delete(checkUserExistence(id));
    }

    // validation methods
    public Trainer checkUserExistence(Long id) {
        return trainerRepository.findById(id).
                orElseThrow(() -> new ValidationException("Trainer doesn't exist with id " + id));
    }

    public void validateCreate(CreateTrainerRequest request) {
        if(trainerRepository.existsByEmail(request.getEmail())) {
            throw new ValidationException("Email Already exists");
        }
    }

    public void validateUpdate(Long id, UpdateTrainerRequest request) {
        if(trainerRepository.checkEmailForUpdate(id, request.getEmail()) != 0) {
            throw new ValidationException("Email already exists");
        }
    }
}
