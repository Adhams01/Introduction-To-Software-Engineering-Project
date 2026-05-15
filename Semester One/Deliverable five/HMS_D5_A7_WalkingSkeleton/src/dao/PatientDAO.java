package dao;

import domain.Patient;

public class PatientDAO {
    private static final int MAX_PATIENTS = 200;

    private final Patient[] patients = new Patient[MAX_PATIENTS];
    private int count = 0;

    public Patient findByNationalId(String nationalId) {
        if (nationalId == null) {
            return null;
        }
        String id = nationalId.trim();
        for (int i = 0; i < count; i++) {
            Patient p = patients[i];
            if (p != null && id.equals(p.getNationalId())) {
                return p;
            }
        }
        return null;
    }

    public boolean saveOrUpdate(Patient patient) {
        if (patient == null) {
            return false;
        }

        Patient existing = findByNationalId(patient.getNationalId());
        if (existing != null) {
            for (int i = 0; i < count; i++) {
                Patient p = patients[i];
                if (p != null && patient.getNationalId().trim().equals(p.getNationalId())) {
                    patients[i] = patient;
                    return true;
                }
            }
        }

        if (count >= MAX_PATIENTS) {
            throw new IllegalStateException("patients storage is full");
        }

        patients[count++] = patient;
        return true;
    }

    public int count() {
        return count;
    }
}
