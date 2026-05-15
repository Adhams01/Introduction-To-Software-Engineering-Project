package hospitalmanagementsystem.patterns.behavioral.observer.os1;

/**
 * Concrete Observer implementation representing a Lab Technician.
 * Author: Maged
 */
public class LabTechnician implements EventListener {
    private final String technicianId;
    private final String name;
    private final String labSection;

    public LabTechnician(String technicianId, String name, String labSection) {
        if (technicianId == null || technicianId.trim().isEmpty()) {
            throw new IllegalArgumentException("Technician ID cannot be null or empty");
        }
        this.technicianId = technicianId;
        this.name = name != null ? name : "Unknown";
        this.labSection = labSection != null ? labSection.toUpperCase() : "GENERAL";
    }

    @Override
    public void onEvent(HospitalEvent event) {
        System.out.printf("[LabTech] Technician %s (%s) received: %s - %s%n",
                name, labSection, event.getType().getDisplayName(), event.getMessage());
        switch (event.getType()) {
            case LAB_RESULTS_READY:
                System.out.printf("  -> Archiving results and notifying requesting physician in %s%n", labSection);
                break;
            case EMERGENCY_ALERT:
                System.out.printf("  -> EMERGENCY: Prioritizing emergency lab work in %s%n", labSection);
                break;
            default:
                break;
        }
    }

    @Override
    public String getListenerId() {
        return "LABTECH-" + technicianId;
    }

    @Override
    public boolean isInterestedIn(EventType type, String eventDepartment) {
        boolean isLabEvent = type == EventType.LAB_RESULTS_READY;
        boolean isEmergency = type == EventType.EMERGENCY_ALERT;
        return isLabEvent || isEmergency;
    }
}
