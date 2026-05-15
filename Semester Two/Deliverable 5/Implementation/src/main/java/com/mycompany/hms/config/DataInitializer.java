package com.mycompany.hms.config;

import com.mycompany.hms.model.Doctor;
import com.mycompany.hms.model.Patient;
import com.mycompany.hms.repository.DoctorRepository;
import com.mycompany.hms.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Contributed by: Yassin
 * Task: Y1 - Seed H2 database with sample data
 * Adds 3 patients and 3 doctors on startup for testing
 * Date: May 2026
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    @Bean
    CommandLineRunner seedDatabase(PatientRepository patientRepository,
                                   DoctorRepository doctorRepository) {
        return args -> {
            if (patientRepository.count() == 0) {
                patientRepository.save(Patient.builder()
                        .name("Ahmed Hassan")
                        .email("ahmed.hassan@example.com")
                        .phone("+20 100 123 4567")
                        .birthDate("1990-03-15")
                        .gender("MALE")
                        .build());

                patientRepository.save(Patient.builder()
                        .name("Sara Ali")
                        .email("sara.ali@example.com")
                        .phone("+20 111 987 6543")
                        .birthDate("1995-07-22")
                        .gender("FEMALE")
                        .build());

                patientRepository.save(Patient.builder()
                        .name("Mohamed Khaled")
                        .email("mohamed.khaled@example.com")
                        .phone("+20 122 555 0001")
                        .birthDate("1985-11-30")
                        .gender("MALE")
                        .build());

                log.info("Database seeded: 3 patients loaded");
            }

            if (doctorRepository.count() == 0) {
                doctorRepository.save(Doctor.builder()
                        .name("Dr. Fatima Zaki")
                        .email("fatima.zaki@hospital.com")
                        .phone("+20 100 111 2222")
                        .specialty("Cardiology")
                        .available(true)
                        .build());

                doctorRepository.save(Doctor.builder()
                        .name("Dr. Omar Hamed")
                        .email("omar.hamed@hospital.com")
                        .phone("+20 100 333 4444")
                        .specialty("Neurology")
                        .available(true)
                        .build());

                doctorRepository.save(Doctor.builder()
                        .name("Dr. Layla Mostafa")
                        .email("layla.mostafa@hospital.com")
                        .phone("+20 100 555 6666")
                        .specialty("Pediatrics")
                        .available(true)
                        .build());

                log.info("Database seeded: 3 doctors loaded");
            }
        };
    }
}
