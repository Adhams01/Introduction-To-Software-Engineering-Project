package hospitalmangementsystem.domain;

// [MAGED] - Base Appointment class for Factory Method pattern
// This is the Product that all concrete appointments extend
// Each subclass overrides getType() and getDurationMinutes()

public class Appointment {
    
    // [MAGED] - Appointment fields (some are final = cannot change)
    private String status;                    // Can change (SCHEDULED, CANCELLED, etc.)
    private final String appointmentId;       // Fixed when created
    private final String patientId;         // Fixed when created
    private final String startTime;         // Fixed when created
    
    // [MAGED] - Constructor: sets all the fixed fields
    public Appointment(String appointmentId, String patientId, String startTime, String status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.startTime = startTime;
        this.status = status;
    }
    
    // [MAGED] - Get the appointment ID
    public String getAppointmentId() {
        return appointmentId;
    }
    
    // [MAGED] - Get the patient ID
    public String getPatientId() {
        return patientId;
    }
    
    // [MAGED] - Get current status
    public String getStatus() {
        return status;
    }
    
    // [MAGED] - Update status (can change from SCHEDULED to CANCELLED)
    public void setStatus(String status) {
        this.status = status;
    }
    
    // [MAGED] - Get the start time
    public String getStartTime() {
        return startTime;
    }
    
    // [MAGED] - Get appointment type (overridden by subclasses)
    // Default is GENERIC, but Checkup returns "CHECKUP", etc.
    public String getType() {
        return "GENERIC";
    }
    
    // [MAGED] - Get duration in minutes (overridden by subclasses)
    // Default is 30 min, but Surgery returns 120, etc.
    public int getDurationMinutes() {
        return 30; // default duration
    }
}
