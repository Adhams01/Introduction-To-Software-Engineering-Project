package com.mycompany.hms.service;

import com.mycompany.hms.dto.DoctorDTO;
import com.mycompany.hms.dto.DoctorRequest;
import com.mycompany.hms.exception.DuplicateEmailException;
import com.mycompany.hms.exception.ResourceNotFoundException;
import com.mycompany.hms.model.Doctor;
import com.mycompany.hms.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Contributed by: Andrew
 * Task: B2, B3 - Doctor Service Implementation
 * Date: May 2026
 */
@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with id: " + id));
        return toDTO(doctor);
    }

    @Override
    public DoctorDTO createDoctor(DoctorRequest request) {
        if (doctorRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException(
                    "Email already exists: " + request.getEmail());
        }
        Doctor doctor = Doctor.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .specialty(request.getSpecialty())
                .available(request.getAvailable() != null ? request.getAvailable() : true)
                .build();
        return toDTO(doctorRepository.save(doctor));
    }

    @Override
    public DoctorDTO updateDoctor(Long id, DoctorRequest request) {
        Doctor existing = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with id: " + id));

        if (!existing.getEmail().equalsIgnoreCase(request.getEmail())
                && doctorRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmailException(
                    "Email already in use: " + request.getEmail());
        }

        existing.setName(request.getName());
        existing.setEmail(request.getEmail());
        existing.setPhone(request.getPhone());
        existing.setSpecialty(request.getSpecialty());
        if (request.getAvailable() != null) {
            existing.setAvailable(request.getAvailable());
        }

        return toDTO(doctorRepository.save(existing));
    }

    @Override
    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Doctor not found with id: " + id);
        }
        doctorRepository.deleteById(id);
    }

    private DoctorDTO toDTO(Doctor doctor) {
        return DoctorDTO.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .email(doctor.getEmail())
                .phone(doctor.getPhone())
                .specialty(doctor.getSpecialty())
                .available(doctor.getAvailable())
                .build();
    }
}
