package hospitalmangementsystem.controller;

// [YASSIN] - Controller for managing patient registration
// Uses Singleton pattern (PatientRegistrySingleton) for centralized registry

import hospitalmangementsystem.dao.PatientDAO;
import hospitalmangementsystem.domain.Patient;
import hospitalmangementsystem.patterns.singleton.PatientRegistrySingleton;

public class PatientController {
    
    // [YASSIN] - Singleton registry for patient lookups
    private final PatientRegistrySingleton patientRegistry;
    
    // [YASSIN] - Constructor: gets singleton registry with DAO
    public PatientController(PatientDAO patientDAO) {
        this.patientRegistry = PatientRegistrySingleton.getInstance(patientDAO);
    }
    
    // [YASSIN] - Registers a new patient
    // 1. Validates inputs
    // 2. Creates patient object
    // 3. Saves via singleton registry (updates cache too)
    public String registerPatient(String nationalId, String name) {
        // Validate inputs
        if (nationalId == null || nationalId.trim().isEmpty()) {
            return "ERROR: National ID is required.";
        }
        if (name == null || name.trim().isEmpty()) {
            return "ERROR: Name is required.";
        }
        // Normalize and create patient
        String normalizedNationalId = nationalId.trim();
        Patient patient = new Patient(normalizedNationalId, normalizedNationalId, name.trim());
        // Save via singleton registry
        boolean ok = patientRegistry.saveOrUpdate(patient);
        if (!ok) {
            return "ERROR: Could not save patient.";
        }
        return "SUCCESS: Patient registered (nationalId=" + patient.getNationalId() + ")";
    }
}
