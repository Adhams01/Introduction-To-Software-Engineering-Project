package hospitalmangementsystem.controller;

import hospitalmangementsystem.dao.PatientDAO;
import hospitalmangementsystem.domain.Patient;

public class PatientController {
    private final PatientDAO patientDAO;

    public PatientController(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    public String registerPatient(String nationalId, String name) {
        if (nationalId == null || nationalId.trim().isEmpty()) {
            return "ERROR: National ID is required.";
        }
        if (name == null || name.trim().isEmpty()) {
            return "ERROR: Name is required.";
        }

        String normalizedNationalId = nationalId.trim();
        Patient patient = new Patient(normalizedNationalId, normalizedNationalId, name.trim());
        boolean ok = patientDAO.saveOrUpdate(patient);
        if (!ok) {
            return "ERROR: Could not save patient.";
        }

        return "SUCCESS: Patient registered (nationalId=" + patient.getNationalId() + ")";
    }
}
