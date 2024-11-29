package com.youquiz.backend.repository;

import com.youquiz.backend.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    boolean existsByEmail(String email);
}
