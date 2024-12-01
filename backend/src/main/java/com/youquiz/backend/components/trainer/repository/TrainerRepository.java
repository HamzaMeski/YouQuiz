package com.youquiz.backend.components.trainer.repository;

import com.youquiz.backend.EntityComponentsProvider.repository.EntityRepository;
import com.youquiz.backend.entities.Trainer;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrainerRepository extends EntityRepository<Trainer, Long> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Long id);
    List<Trainer> findByRegistrationDateBefore(LocalDate date);
    List<Trainer> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}