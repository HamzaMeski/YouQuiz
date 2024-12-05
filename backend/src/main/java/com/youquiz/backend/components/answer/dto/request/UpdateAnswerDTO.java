package com.youquiz.backend.components.answer.dto.request;

import com.youquiz.backend.EntityComponentsProvider.dto.request.UpdateDTO;
import com.youquiz.backend.entities.Answer;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateAnswerDTO extends UpdateDTO<Answer> {

    @NotBlank(message = "answer shouldn't be blank")
    private String answer;
}
