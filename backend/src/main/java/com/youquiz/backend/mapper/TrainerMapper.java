package com.youquiz.backend.mapper;


import com.youquiz.backend.dto.trainer.request.CreateTrainerRequest;
import com.youquiz.backend.dto.trainer.response.TrainerResponse;
import com.youquiz.backend.entity.Trainer;
import jakarta.security.auth.message.MessagePolicy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.TargetType;

@Mapper(componentModel = "spring")
public interface TrainerMapper {

    @Mapping(target = "id", ignore = true)
    Trainer toEntity(CreateTrainerRequest request);

    TrainerResponse toTrainerResponse(Trainer trainer);
}