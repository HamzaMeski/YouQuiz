package com.youquiz.backend.dto.student.request;

import com.youquiz.backend.dto.trainer.request.RequestDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class UpdateStudentRequest extends RequestDTO {
}
