package com.youquiz.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
public class Student extends User {
}