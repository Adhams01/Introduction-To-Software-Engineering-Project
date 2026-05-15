package com.mycompany.hms.service;

import com.mycompany.hms.dto.PatientDTO;
import com.mycompany.hms.dto.PatientRequest;

import java.util.List;

/*
 * Contributed by: Adham
 * Task: A2 - Patient Service Interface
 * Date: May 2026
 */
public interface PatientService {

    List<PatientDTO> getAllPatients();

    PatientDTO getPatientById(Long id);

    PatientDTO createPatient(PatientRequest request);

    PatientDTO updatePatient(Long id, PatientRequest request);

    void deletePatient(Long id);
}
