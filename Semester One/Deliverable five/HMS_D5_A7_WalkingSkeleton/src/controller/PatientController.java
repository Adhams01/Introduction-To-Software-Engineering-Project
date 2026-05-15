package controller;

import dao.PatientDAO;
import domain.Patient;

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

        Patient patient = new Patient(nationalId.trim(), name.trim());
        boolean ok = patientDAO.saveOrUpdate(patient);
        if (!ok) {
            return "ERROR: Could not save patient.";
        }

        return "SUCCESS: Patient registered (nationalId=" + patient.getNationalId() + ")";
    }
}
