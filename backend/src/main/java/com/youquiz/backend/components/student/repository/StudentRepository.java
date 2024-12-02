package com.youquiz.backend.components.student.repository;

import com.youquiz.backend.EntityComponentsProvider.repository.EntityRepository;
import com.youquiz.backend.entities.Student;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends EntityRepository<Student, Long> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Long id);
    List<Student> findByRegistrationDateBefore(LocalDate date);
    List<Student> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
