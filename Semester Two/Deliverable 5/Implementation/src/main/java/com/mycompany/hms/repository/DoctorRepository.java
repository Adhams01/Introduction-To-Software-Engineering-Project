package com.mycompany.hms.repository;

import com.mycompany.hms.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * Contributed by: Andrew
 * Task: B2 - Doctor Repository
 * Date: May 2026
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByEmail(String email);

    boolean existsByEmail(String email);
}
