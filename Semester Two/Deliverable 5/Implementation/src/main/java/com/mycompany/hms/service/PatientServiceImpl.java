package com.mycompany.hms.service;

import com.mycompany.hms.dto.PatientDTO;
import com.mycompany.hms.dto.PatientRequest;
import com.mycompany.hms.exception.DuplicateEmailException;
import com.mycompany.hms.exception.ResourceNotFoundException;
import com.mycompany.hms.model.Patient;
import com.mycompany.hms.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Contributed by: Adham Sobhy
 * Task: A3 - Patient Service Implementation
 * Date: May 2026
 */
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<PatientDTO> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Patient not found with id: " + id));
        return toDTO(patient);
    }

    @Override
    public PatientDTO createPatient(PatientRequest request) {
        if (patientRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException(
                    "Email already exists: " + request.getEmail());
        }
        Patient saved = patientRepository.save(toEntity(request));
        return toDTO(saved);
    }

    @Override
    public PatientDTO updatePatient(Long id, PatientRequest request) {
        Patient existing = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Patient not found with id: " + id));

        if (!existing.getEmail().equalsIgnoreCase(request.getEmail())
                && patientRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException(
                    "Email already in use: " + request.getEmail());
        }

        existing.setName(request.getName());
        existing.setEmail(request.getEmail());
        existing.setPhone(request.getPhone());
        existing.setBirthDate(request.getBirthDate());
        existing.setGender(request.getGender());

        return toDTO(patientRepository.save(existing));
    }

    @Override
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Patient not found with id: " + id);
        }
        patientRepository.deleteById(id);
    }

    private PatientDTO toDTO(Patient patient) {
        return PatientDTO.builder()
                .id(patient.getId())
                .name(patient.getName())
                .email(patient.getEmail())
                .phone(patient.getPhone())
                .birthDate(patient.getBirthDate())
                .gender(patient.getGender())
                .build();
    }

    private Patient toEntity(PatientRequest request) {
        return Patient.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .birthDate(request.getBirthDate())
                .gender(request.getGender())
                .build();
    }
}
