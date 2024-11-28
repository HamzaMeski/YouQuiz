package com.youquiz.backend.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Trainer extends User {
    private String specialty;
}
