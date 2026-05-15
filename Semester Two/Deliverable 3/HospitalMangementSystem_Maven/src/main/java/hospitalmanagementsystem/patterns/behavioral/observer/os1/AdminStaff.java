package hospitalmanagementsystem.patterns.behavioral.observer.os1;

/**
 * Concrete Observer implementation representing Administrative Staff.
 * Author: Maged
 */
public class AdminStaff implements EventListener {
    private final String adminId;
    private final String name;
    private final String role;

    public AdminStaff(String adminId, String name, String role) {
        if (adminId == null || adminId.trim().isEmpty()) {
            throw new IllegalArgumentException("Admin ID cannot be null or empty");
        }
        this.adminId = adminId;
        this.name = name != null ? name : "Unknown";
        this.role = role != null ? role.toUpperCase() : "GENERAL";
    }

    @Override
    public void onEvent(HospitalEvent event) {
        System.out.printf("[Admin] %s %s received: %s - %s%n",
                role, name, event.getType().getDisplayName(), event.getMessage());
        switch (event.getType()) {
            case BED_FREED:
                System.out.printf("  -> Updating bed occupancy statistics for %s%n", event.getDepartment());
                break;
            case PATIENT_ADMITTED:
                System.out.printf("  -> Creating patient record and assigning bed in %s%n", event.getDepartment());
                break;
            case PATIENT_DISCHARGED:
                System.out.printf("  -> Processing discharge paperwork and billing in %s%n", event.getDepartment());
                break;
            case APPOINTMENT_SCHEDULED:
                System.out.printf("  -> Updating appointment calendar for %s%n", event.getDepartment());
                break;
            case EMERGENCY_ALERT:
                System.out.printf("  -> EMERGENCY: Notifying hospital administration and families%n");
                break;
            default:
                break;
        }
    }

    @Override
    public String getListenerId() {
        return "ADMIN-" + adminId;
    }

    @Override
    public boolean isInterestedIn(EventType type, String eventDepartment) {
        boolean relevantEventType = type == EventType.BED_FREED ||
                                   type == EventType.PATIENT_ADMITTED ||
                                   type == EventType.PATIENT_DISCHARGED ||
                                   type == EventType.APPOINTMENT_SCHEDULED ||
                                   type == EventType.EMERGENCY_ALERT;
        return relevantEventType;
    }
}
