package com.youquiz.backend.repository;

import com.youquiz.backend.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    boolean existsByEmail(String email);

    @Query(
    """
        SELECT COUNT(t) FROM Trainer t
        WHERE t.email = :email AND t.id <> :id
    """)
    Long checkEmailForUpdate(
            @Param("id") Long id,
            @Param("email") String email
    );
}
