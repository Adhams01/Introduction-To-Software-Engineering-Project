package hospitalmanagementsystem.patterns.behavioral.mediator.md2;

/**
 * FacilitiesComponent — Concrete Colleague in Mediator pattern MD2
 * Represents the facilities management subsystem.
 * It responds to emergency events by preparing rooms and allocating equipment.
 * Author: Yassin
 */
public class FacilitiesComponent extends EmergencyComponent {

    /**
     * Constructs the facilities component registered with the given mediator.
     *
     * @param mediator the shared mediator
     */
    public FacilitiesComponent(EmergencyMediator mediator) {
        super(mediator);
    }

    /**
     * Prepares a room for an emergency incident.
     *
     * @param incidentId the ID of the emergency incident
     * @param roomType   the type of room to prepare
     */
    public void prepareRoom(String incidentId, String roomType) {
        System.out.println("[Facilities] Preparing " + roomType + " for incident " + incidentId);
        System.out.println("  - Room cleaned and sanitized");
        System.out.println("  - Medical equipment installed");
        System.out.println("  - Emergency supplies stocked");
        System.out.println("  ✓ Room ready for patient admission");
    }

    /**
     * Allocates specific equipment for an emergency incident.
     *
     * @param incidentId the ID of the emergency incident
     * @param equipment  the type of equipment to allocate
     */
    public void allocateEquipment(String incidentId, String equipment) {
        System.out.println("[Facilities] Allocating " + equipment + " for incident " + incidentId);
        System.out.println("  - Equipment status verified");
        System.out.println("  - Calibration checked");
        System.out.println("  - Transport arranged to incident location");
        System.out.println("  ✓ Equipment allocated and dispatched");
    }

    /**
     * Releases resources after an emergency is resolved.
     *
     * @param incidentId the ID of the resolved incident
     */
    public void releaseResources(String incidentId) {
        System.out.println("[Facilities] Releasing resources for incident " + incidentId);
        System.out.println("  - Room cleaned and reset");
        System.out.println("  - Equipment returned to inventory");
        System.out.println("  - Supplies restocked");
        System.out.println("  ✓ Resources released and available");
    }
}
