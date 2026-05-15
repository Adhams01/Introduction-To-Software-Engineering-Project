package hospitalmanagementsystem.patterns.behavioral.mediator.md2;

/**
 * EmergencyMediator — Mediator interface in Mediator pattern MD2
 * Defines the communication contract between emergency response components.
 * Components call notify() to report events; the ConcreteMediator
 * decides which other components must react and how.
 * Author: Yassin
 */
public interface EmergencyMediator {

    /**
     * Receives an event from a component and coordinates the response
     * across all registered emergency response components.
     *
     * @param sender    the component that triggered the event
     * @param event     the event name (e.g., EMERGENCY_DETECTED, SEVERITY_UPDATE, EMERGENCY_RESOLVED)
     * @param incidentId the ID of the emergency incident involved
     */
    void notify(EmergencyComponent sender, String event, String incidentId);
}
