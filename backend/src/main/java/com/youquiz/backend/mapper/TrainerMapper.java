package com.youquiz.backend.mapper;


import com.youquiz.backend.dto.trainer.request.CreateTrainerRequest;
import com.youquiz.backend.dto.trainer.response.TrainerResponse;
import com.youquiz.backend.entity.Trainer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TrainerMapper {

    Trainer toEntity(CreateTrainerRequest request);

    TrainerResponse toTrainerResponse(Trainer trainer);
}