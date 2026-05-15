package hospitalmanagementsystem.patterns.behavioral.mediator.md1;

/**
 * AppointmentColleague — Abstract Colleague in Mediator pattern MD1
 * Base class for all components that participate in appointment coordination.
 * Each colleague holds a reference to the mediator and communicates
 * exclusively through it — never directly with other colleagues.
 * Author: [ANDREW]
 */
public abstract class AppointmentColleague {

    protected AppointmentMediator mediator;

    /**
     * Constructs a colleague registered with the given mediator.
     *
     * @param mediator the shared mediator instance
     */
    public AppointmentColleague(AppointmentMediator mediator) {
        this.mediator = mediator;
    }

    /**
     * Replaces the mediator reference (allows runtime mediator switching).
     *
     * @param mediator the new mediator
     */
    public void setMediator(AppointmentMediator mediator) {
        this.mediator = mediator;
    }

    /**
     * Sends an event to the mediator for coordination.
     * Subclasses call this when they produce an event.
     *
     * @param event         the event name
     * @param appointmentId the relevant appointment ID
     */
    protected void send(String event, String appointmentId) {
        mediator.notify(this, event, appointmentId);
    }
}
