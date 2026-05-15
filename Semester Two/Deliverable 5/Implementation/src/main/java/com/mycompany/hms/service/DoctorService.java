package com.mycompany.hms.service;

import com.mycompany.hms.dto.DoctorDTO;
import com.mycompany.hms.dto.DoctorRequest;

import java.util.List;

/*
 * Contributed by: Andrew
 * Task: B2 - Doctor Service Interface
 * Date: May 2026
 */
public interface DoctorService {

    List<DoctorDTO> getAllDoctors();

    DoctorDTO getDoctorById(Long id);

    DoctorDTO createDoctor(DoctorRequest request);

    DoctorDTO updateDoctor(Long id, DoctorRequest request);

    void deleteDoctor(Long id);
}
