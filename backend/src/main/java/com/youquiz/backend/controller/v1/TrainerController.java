package com.youquiz.backend.controller.v1;

import com.youquiz.backend.dto.trainer.request.CreateTrainerRequest;
import com.youquiz.backend.dto.trainer.request.UpdateTrainerRequest;
import com.youquiz.backend.dto.trainer.response.TrainerResponse;
import com.youquiz.backend.service.TrainerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainers")
@RequiredArgsConstructor
@Slf4j
public class TrainerController {
    private final TrainerService trainerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrainerResponse create(
            @Valid @RequestBody CreateTrainerRequest request
            ) {
        return trainerService.create(request);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTrainerRequest request
    ) {
         trainerService.update(id, request);
    }

    @GetMapping
    public Page<TrainerResponse> getAll(Pageable pageable) {
        return trainerService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public TrainerResponse getById(
            @PathVariable Long id
    ) {
        return trainerService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable Long id
    ) {
        trainerService.delete(id);
    }
}
