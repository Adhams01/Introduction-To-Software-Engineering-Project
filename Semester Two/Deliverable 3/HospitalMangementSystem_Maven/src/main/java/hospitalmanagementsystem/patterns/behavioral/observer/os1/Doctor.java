package hospitalmanagementsystem.patterns.behavioral.observer.os1;

/**
 * Concrete Observer implementation representing a Doctor.
 * Author: Maged
 */
public class Doctor implements EventListener {
    private final String doctorId;
    private final String name;
    private final String department;
    private final String specialization;

    public Doctor(String doctorId, String name, String department, String specialization) {
        if (doctorId == null || doctorId.trim().isEmpty()) {
            throw new IllegalArgumentException("Doctor ID cannot be null or empty");
        }
        this.doctorId = doctorId;
        this.name = name != null ? name : "Unknown";
        this.department = department != null ? department.toUpperCase() : "GENERAL";
        this.specialization = specialization != null ? specialization : "General Practice";
    }

    @Override
    public void onEvent(HospitalEvent event) {
        System.out.printf("[Doctor] Dr. %s (%s) received: %s - %s%n",
                name, specialization, event.getType().getDisplayName(), event.getMessage());
        switch (event.getType()) {
            case LAB_RESULTS_READY:
                System.out.printf("  -> Reviewing lab results for patient in %s department%n", department);
                break;
            case PATIENT_STATUS_CHANGE:
                System.out.printf("  -> Updating patient care plan in %s%n", department);
                break;
            case EMERGENCY_ALERT:
                System.out.printf("  -> EMERGENCY: Responding immediately in %s%n", department);
                break;
            default:
                break;
        }
    }

    @Override
    public String getListenerId() {
        return "DOCTOR-" + doctorId;
    }

    @Override
    public boolean isInterestedIn(EventType type, String eventDepartment) {
        boolean sameDepartment = department.equals(eventDepartment);
        boolean isEmergency = type == EventType.EMERGENCY_ALERT;
        boolean relevantEventType = type == EventType.PATIENT_STATUS_CHANGE ||
                                   type == EventType.LAB_RESULTS_READY ||
                                   type == EventType.APPOINTMENT_SCHEDULED ||
                                   type == EventType.PATIENT_ADMITTED ||
                                   type == EventType.PATIENT_DISCHARGED;
        return (sameDepartment && relevantEventType) || isEmergency;
    }
}
