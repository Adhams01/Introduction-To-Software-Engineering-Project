package hospitalmanagementsystem.patterns.behavioral.observer.os1;

/**
 * Enumeration of all possible event types in the Hospital Management System.
 * Author: Maged
 */
public enum EventType {
    PATIENT_STATUS_CHANGE("Patient Status Change"),
    BED_FREED("Bed Freed"),
    LAB_RESULTS_READY("Lab Results Ready"),
    APPOINTMENT_SCHEDULED("Appointment Scheduled"),
    EMERGENCY_ALERT("Emergency Alert"),
    PATIENT_ADMITTED("Patient Admitted"),
    PATIENT_DISCHARGED("Patient Discharged");

    private final String displayName;

    EventType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
