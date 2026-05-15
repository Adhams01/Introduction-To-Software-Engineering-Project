package hospitalmanagementsystem.patterns.behavioral.mediator.md2;

/**
 * EmergencyComponent — Abstract Colleague in Mediator pattern MD2
 * Base class for all components that participate in emergency response coordination.
 * Each component holds a reference to the mediator and communicates
 * exclusively through it — never directly with other components.
 * Author: Yassin
 */
public abstract class EmergencyComponent {

    protected EmergencyMediator mediator;

    /**
     * Constructs a component registered with the given mediator.
     *
     * @param mediator the shared mediator instance
     */
    public EmergencyComponent(EmergencyMediator mediator) {
        this.mediator = mediator;
    }

    /**
     * Replaces the mediator reference (allows runtime mediator switching).
     *
     * @param mediator the new mediator
     */
    public void setMediator(EmergencyMediator mediator) {
        this.mediator = mediator;
    }

    /**
     * Sends an event to the mediator for coordination.
     * Subclasses call this when they produce an event.
     *
     * @param event      the event name
     * @param incidentId the relevant incident ID
     */
    protected void send(String event, String incidentId) {
        mediator.notify(this, event, incidentId);
    }
}
