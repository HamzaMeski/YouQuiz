package com.youquiz.backend.EntityComponentsProvider.mapper;

import org.mapstruct.MappingTarget;

import com.youquiz.backend.EntityComponentsProvider.dto.request.CreateDTO;
import com.youquiz.backend.EntityComponentsProvider.dto.request.UpdateDTO;
import com.youquiz.backend.EntityComponentsProvider.dto.response.ResponseDTO;

/**
 * Generic mapper interface for entity-DTO conversions
 * @param <T> Entity type
 * @param <ID> Entity ID type
 * @param <C> Create DTO type
 * @param <U> Update DTO type
 * @param <R> Response DTO type
 */
public interface EntityMapper<T, ID, C extends CreateDTO<T>, U extends UpdateDTO<T>, R extends ResponseDTO<T, ID>> {
    T toEntity(C request);
    R toResponseDTO(T entity);
    void updateEntity(U request, @MappingTarget T entity);
}