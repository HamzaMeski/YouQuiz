package com.youquiz.backend.entity;

import jakarta.persistence.Entity;

@Entity
public class Trainer extends User {
    private String specialty;
}
