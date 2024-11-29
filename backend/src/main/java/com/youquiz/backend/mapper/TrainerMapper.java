package com.youquiz.backend.mapper;


import com.youquiz.backend.dto.trainer.request.CreateTrainerRequest;
import com.youquiz.backend.dto.trainer.request.UpdateTrainerRequest;
import com.youquiz.backend.dto.trainer.response.TrainerResponse;
import com.youquiz.backend.entity.Trainer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TrainerMapper {

    @Mapping(target = "id", ignore = true)
    Trainer toEntity(CreateTrainerRequest request);

    void updateEntity(UpdateTrainerRequest trainerRequest, @MappingTarget Trainer trainer);

    TrainerResponse toTrainerResponse(Trainer trainer);
}