package com.youquiz.backend.repository;

import com.youquiz.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByEmail(String email);

    @Query(
        """
        SELECT COUNT(s) FROM Student s
        WHERE s.email = :email AND s.id <> :id
        """
    )
    Long checkEmailForUpdate(
            @Param("id") Long id,
            @Param("email") String email
    );
}
