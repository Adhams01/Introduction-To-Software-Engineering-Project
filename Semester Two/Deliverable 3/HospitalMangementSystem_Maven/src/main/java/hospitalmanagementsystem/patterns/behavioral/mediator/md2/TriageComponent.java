package hospitalmanagementsystem.patterns.behavioral.mediator.md2;

/**
 * TriageComponent — Concrete Colleague in Mediator pattern MD2
 * Represents the emergency triage subsystem.
 * It is the event PRODUCER: it assesses emergency severity
 * and notifies the mediator so other components can react.
 * Author: Yassin
 */
public class TriageComponent extends EmergencyComponent {

    /**
     * Constructs the triage component registered with the given mediator.
     *
     * @param mediator the shared mediator
     */
    public TriageComponent(EmergencyMediator mediator) {
        super(mediator);
    }

    /**
     * Assesses an emergency incident and notifies the mediator.
     * The mediator will trigger medical response, facilities preparation,
     * and family notifications.
     *
     * @param incidentId the ID of the emergency incident
     * @param severity   the severity level of the emergency
     */
    public void assessEmergency(String incidentId, String severity) {
        System.out.println("[Triage] Assessing emergency " + incidentId + " with severity: " + severity);
        System.out.println("  - Patient vital signs evaluated");
        System.out.println("  - Injury type classified");
        System.out.println("  - Resource requirements determined");
        System.out.println("  ✓ Triage assessment completed");
    }

    /**
     * Updates the priority of an emergency incident and notifies the mediator.
     * The mediator will trigger priority-based resource allocation.
     *
     * @param incidentId   the ID of the emergency incident
     * @param newPriority  the new priority level
     */
    public void updatePriority(String incidentId, String newPriority) {
        System.out.println("[Triage] Updating priority for incident " + incidentId + " to: " + newPriority);
        System.out.println("  - Patient condition re-evaluated");
        System.out.println("  - Triage category adjusted");
        System.out.println("  - Resource urgency updated");
        System.out.println("  ✓ Priority update completed");
    }

    /**
     * Triggers a severity update event for an incident.
     *
     * @param incidentId the ID of the incident to update
     */
    public void triggerSeverityUpdate(String incidentId) {
        System.out.println("[Triage] Triggering severity update for incident " + incidentId);
        send("SEVERITY_UPDATE", incidentId);
    }

    /**
     * Marks an emergency as resolved and notifies the mediator.
     *
     * @param incidentId the ID of the resolved incident
     */
    public void resolveEmergency(String incidentId) {
        System.out.println("[Triage] Marking emergency " + incidentId + " as resolved");
        send("EMERGENCY_RESOLVED", incidentId);
    }
}
