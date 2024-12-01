package com.youquiz.backend.EntityComponentsProvider.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DetailResponseDTO<T, ID> extends ResponseDTO<T, ID> {
    // Base class for detailed response DTOs
}