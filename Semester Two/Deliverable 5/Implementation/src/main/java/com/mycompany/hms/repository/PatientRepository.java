package com.mycompany.hms.repository;

import com.mycompany.hms.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
 * Contributed by: Adham
 * Task: A2 - Patient Repository
 * Date: May 2026
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByEmail(String email);

    boolean existsByEmail(String email);
}
