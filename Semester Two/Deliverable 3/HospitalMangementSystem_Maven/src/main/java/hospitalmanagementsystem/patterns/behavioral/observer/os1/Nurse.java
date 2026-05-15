package hospitalmanagementsystem.patterns.behavioral.observer.os1;

/**
 * Concrete Observer implementation representing a Nurse.
 * Author: Maged
 */
public class Nurse implements EventListener {
    private final String nurseId;
    private final String name;
    private final String department;
    private final String shift;

    public Nurse(String nurseId, String name, String department, String shift) {
        if (nurseId == null || nurseId.trim().isEmpty()) {
            throw new IllegalArgumentException("Nurse ID cannot be null or empty");
        }
        this.nurseId = nurseId;
        this.name = name != null ? name : "Unknown";
        this.department = department != null ? department.toUpperCase() : "GENERAL";
        this.shift = shift != null ? shift.toUpperCase() : "DAY";
    }

    @Override
    public void onEvent(HospitalEvent event) {
        System.out.printf("[Nurse] Nurse %s (%s shift) received: %s - %s%n",
                name, shift, event.getType().getDisplayName(), event.getMessage());
        switch (event.getType()) {
            case BED_FREED:
                System.out.printf("  -> Updating bed assignment records in %s%n", department);
                break;
            case PATIENT_STATUS_CHANGE:
                System.out.printf("  -> Updating patient monitoring in %s%n", department);
                break;
            case EMERGENCY_ALERT:
                System.out.printf("  -> EMERGENCY: Preparing emergency response in %s%n", department);
                break;
            case APPOINTMENT_SCHEDULED:
                System.out.printf("  -> Preparing patient room for appointment in %s%n", department);
                break;
            default:
                break;
        }
    }

    @Override
    public String getListenerId() {
        return "NURSE-" + nurseId;
    }

    @Override
    public boolean isInterestedIn(EventType type, String eventDepartment) {
        boolean sameDepartment = department.equals(eventDepartment);
        boolean isEmergency = type == EventType.EMERGENCY_ALERT;
        boolean relevantEventType = type == EventType.PATIENT_STATUS_CHANGE ||
                                   type == EventType.BED_FREED ||
                                   type == EventType.APPOINTMENT_SCHEDULED ||
                                   type == EventType.PATIENT_ADMITTED ||
                                   type == EventType.PATIENT_DISCHARGED;
        return (sameDepartment && relevantEventType) || isEmergency;
    }
}
