package hospitalmanagementsystem.patterns.behavioral.mediator.md2;

/**
 * EmergencyCoordinator — ConcreteMediator in Mediator pattern MD2
 * Centralizes all coordination logic for emergency response events.
 * Components never call each other directly — all communication
 * passes through this class, eliminating inter-component coupling.
 * Author: Yassin
 */
public class EmergencyCoordinator implements EmergencyMediator {

    private TriageComponent triageComponent;
    private MedicalComponent medicalComponent;
    private FacilitiesComponent facilitiesComponent;
    private CommunicationComponent communicationComponent;

    /**
     * Registers the triage component with this mediator.
     *
     * @param tc the TriageComponent
     */
    public void setTriageComponent(TriageComponent tc) {
        this.triageComponent = tc;
    }

    /**
     * Registers the medical component with this mediator.
     *
     * @param mc the MedicalComponent
     */
    public void setMedicalComponent(MedicalComponent mc) {
        this.medicalComponent = mc;
    }

    /**
     * Registers the facilities component with this mediator.
     *
     * @param fc the FacilitiesComponent
     */
    public void setFacilitiesComponent(FacilitiesComponent fc) {
        this.facilitiesComponent = fc;
    }

    /**
     * Registers the communication component with this mediator.
     *
     * @param cc the CommunicationComponent
     */
    public void setCommunicationComponent(CommunicationComponent cc) {
        this.communicationComponent = cc;
    }

    /**
     * Receives an event from a component and coordinates the reaction
     * of all other registered components.
     *
     * <p>Event handling rules:
     * <ul>
     *   <li>EMERGENCY_DETECTED: assess emergency, dispatch team, prepare room, notify family</li>
     *   <li>SEVERITY_UPDATE: update priority, update patient status, allocate equipment, update display</li>
     *   <li>EMERGENCY_RESOLVED: release resources, notify family, update display</li>
     * </ul>
     *
     * @param sender     the component that triggered the event
     * @param event      the event name
     * @param incidentId the relevant incident ID
     */
    @Override
    public void notify(EmergencyComponent sender, String event, String incidentId) {
        System.out.println("[Coordinator] Received event: " + event
                + " from " + sender.getClass().getSimpleName()
                + " for incident " + incidentId);

        if ("EMERGENCY_DETECTED".equals(event)) {
            // Coordinate initial emergency response
            triageComponent.assessEmergency(incidentId, "INITIAL");
            medicalComponent.dispatchTeam(incidentId, "EMERGENCY_RESPONSE");
            facilitiesComponent.prepareRoom(incidentId, "EMERGENCY_ROOM");
            communicationComponent.notifyFamily(incidentId, "Emergency response initiated");

        } else if ("SEVERITY_UPDATE".equals(event)) {
            // Coordinate severity-based response updates
            triageComponent.updatePriority(incidentId, "HIGH_PRIORITY");
            medicalComponent.updatePatientStatus(incidentId, "CRITICAL");
            facilitiesComponent.allocateEquipment(incidentId, "VENTILATOR");
            communicationComponent.updateDisplay(incidentId, "CRITICAL - High Priority");

        } else if ("EMERGENCY_RESOLVED".equals(event)) {
            // Coordinate emergency resolution
            communicationComponent.notifyFamily(incidentId, "Emergency resolved - patient stable");
            communicationComponent.updateDisplay(incidentId, "RESOLVED");

        } else {
            System.out.println("[Coordinator] Unknown event: " + event + " — no action taken.");
        }
    }
}
