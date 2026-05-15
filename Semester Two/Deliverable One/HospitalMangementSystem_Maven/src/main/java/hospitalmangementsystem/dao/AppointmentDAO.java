package hospitalmangementsystem.dao;

// [ANDREW] - Data Access Object for Appointments
// Stores appointments in memory using arrays (simulates database)
// Supports: save, find by ID, find by patient, update status

import hospitalmangementsystem.domain.Appointment;

public class AppointmentDAO {
    
    // [ANDREW] - Maximum appointments we can store
    private static final int MAX_APPOINTMENTS = 200;
    
    // [ANDREW] - Arrays to store appointments and their patient IDs
    private final Appointment[] appointments = new Appointment[MAX_APPOINTMENTS];
    private final String[] patientNationalIds = new String[MAX_APPOINTMENTS];
    private int count = 0;  // How many appointments we have
    
    // [ANDREW] - Save a new appointment
    // Checks for valid inputs and space before saving
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
        // Store appointment and patient ID
        appointments[count] = appointment;
        patientNationalIds[count] = patientNationalId.trim();
        count++;
    }
    
    // [ANDREW] - Find appointment by its ID
    // Returns null if not found
    public Appointment findById(String appointmentId) {
        if (appointmentId == null) {
            return null;
        }
        // Search through all appointments
        for (int i = 0; i < count; i++) {
            Appointment a = appointments[i];
            if (a != null && appointmentId.equals(a.getAppointmentId())) {
                return a;
            }
        }
        return null;
    }
    
    // [ANDREW] - Find all upcoming (non-cancelled) appointments for a patient
    // Filters out cancelled appointments
    public Appointment[] findUpcomingByPatientNationalId(String patientNationalId) {
        if (patientNationalId == null) {
            return new Appointment[0];
        }
        String normalized = patientNationalId.trim();
        
        // First pass: count matches
        int matches = 0;
        for (int i = 0; i < count; i++) {
            Appointment a = appointments[i];
            if (a != null && normalized.equals(patientNationalIds[i]) && !"CANCELLED".equalsIgnoreCase(a.getStatus())) {
                matches++;
            }
        }
        // Second pass: collect matches
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
    
    // [ANDREW] - Update status of an appointment (e.g., SCHEDULED -> CANCELLED)
    public boolean updateStatus(String appointmentId, String newStatus) {
        Appointment a = findById(appointmentId);
        if (a == null) {
            return false;
        }
        a.setStatus(newStatus);
        return true;
    }
    
    // [ANDREW] - Get total count of stored appointments
    public int count() {
        return count;
    }
}
