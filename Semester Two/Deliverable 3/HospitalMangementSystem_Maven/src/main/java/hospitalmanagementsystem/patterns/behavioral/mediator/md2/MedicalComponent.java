package hospitalmanagementsystem.patterns.behavioral.mediator.md2;

/**
 * MedicalComponent — Concrete Colleague in Mediator pattern MD2
 * Represents the medical response subsystem.
 * It responds to emergency events by dispatching medical teams
 * and updating patient status.
 * Author: Yassin
 */
public class MedicalComponent extends EmergencyComponent {

    /**
     * Constructs the medical component registered with the given mediator.
     *
     * @param mediator the shared mediator
     */
    public MedicalComponent(EmergencyMediator mediator) {
        super(mediator);
    }

    /**
     * Dispatches a medical team for an emergency incident.
     *
     * @param incidentId the ID of the emergency incident
     * @param teamType   the type of medical team to dispatch
     */
    public void dispatchTeam(String incidentId, String teamType) {
        System.out.println("[Medical] Dispatching " + teamType + " for incident " + incidentId);
        System.out.println("  - Medical team assembled and briefed");
        System.out.println("  - Emergency equipment prepared");
        System.out.println("  - Response route planned");
        System.out.println("  ✓ Team dispatched to incident location");
    }

    /**
     * Updates the patient status for an emergency incident.
     *
     * @param incidentId the ID of the emergency incident
     * @param status     the new patient status
     */
    public void updatePatientStatus(String incidentId, String status) {
        System.out.println("[Medical] Updating patient status for incident " + incidentId + " to: " + status);
        System.out.println("  - Vital signs recorded");
        System.out.println("  - Treatment interventions documented");
        System.out.println("  - Prognosis updated");
        System.out.println("  ✓ Patient status updated in system");
    }

    /**
     * Administers emergency treatment to a patient.
     *
     * @param incidentId the ID of the emergency incident
     * @param treatment  the type of treatment administered
     */
    public void administerTreatment(String incidentId, String treatment) {
        System.out.println("[Medical] Administering " + treatment + " for incident " + incidentId);
        System.out.println("  - Treatment protocol initiated");
        System.out.println("  - Patient response monitored");
        System.out.println("  - Dosage and timing recorded");
        System.out.println("  ✓ Treatment administered successfully");
    }
}
