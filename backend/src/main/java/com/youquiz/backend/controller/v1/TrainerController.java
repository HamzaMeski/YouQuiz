package com.youquiz.backend.controller.v1;

import com.youquiz.backend.mapper.trainer.request.CreateTrainerRequest;
import com.youquiz.backend.mapper.trainer.response.TrainerResponse;
import com.youquiz.backend.service.TrainerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trainers")
@RequiredArgsConstructor
@Slf4j
public class TrainerController {
    private TrainerService trainerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerResponse create(
            @Valid @RequestBody CreateTrainerRequest request
            ) {
        return trainerService.create(request);
    }
}
