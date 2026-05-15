package hospitalmangementsystem.dao;

import hospitalmangementsystem.domain.Appointment;

public class AppointmentDAO {
    private static final int MAX_APPOINTMENTS = 200;

    private final Appointment[] appointments = new Appointment[MAX_APPOINTMENTS];
    private final String[] patientNationalIds = new String[MAX_APPOINTMENTS];
    private int count = 0;

    public void save(String patientNationalId, Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("appointment cannot be null");
        }
        if (patientNationalId == null || patientNationalId.trim().isEmpty()) {
            throw new IllegalArgumentException("patientNationalId cannot be null or empty");
        }
        if (count >= MAX_APPOINTMENTS) {
            throw new IllegalStateException("appointments storage is full");
        }
        appointments[count] = appointment;
        patientNationalIds[count] = patientNationalId.trim();
        count++;
    }

    public Appointment findById(String appointmentId) {
        if (appointmentId == null) {
            return null;
        }
        for (int i = 0; i < count; i++) {
            Appointment a = appointments[i];
            if (a != null && appointmentId.equals(a.getAppointmentId())) {
                return a;
            }
        }
        return null;
    }

    public Appointment[] findUpcomingByPatientNationalId(String patientNationalId) {
        if (patientNationalId == null) {
            return new Appointment[0];
        }

        String normalized = patientNationalId.trim();

        int matches = 0;
        for (int i = 0; i < count; i++) {
            Appointment a = appointments[i];
            if (a != null && normalized.equals(patientNationalIds[i]) && !"CANCELLED".equalsIgnoreCase(a.getStatus())) {
                matches++;
            }
        }

        Appointment[] result = new Appointment[matches];
        int j = 0;
        for (int i = 0; i < count; i++) {
            Appointment a = appointments[i];
            if (a != null && normalized.equals(patientNationalIds[i]) && !"CANCELLED".equalsIgnoreCase(a.getStatus())) {
                result[j++] = a;
            }
        }
        return result;
    }

    public boolean updateStatus(String appointmentId, String newStatus) {
        Appointment a = findById(appointmentId);
        if (a == null) {
            return false;
        }
        a.setStatus(newStatus);
        return true;
    }

    public int count() {
        return count;
    }
}
