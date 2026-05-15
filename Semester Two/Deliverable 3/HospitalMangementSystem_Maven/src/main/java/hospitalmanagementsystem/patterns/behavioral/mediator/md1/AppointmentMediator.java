package hospitalmanagementsystem.patterns.behavioral.mediator.md1;

/**
 * AppointmentMediator — Mediator interface in Mediator pattern MD1
 * Defines the communication contract between colleague components.
 * Colleagues call notify() to report events; the ConcreteMediator
 * decides which other colleagues must react and how.
 * Author: [ANDREW]
 */
public interface AppointmentMediator {

    /**
     * Receives an event from a colleague and coordinates the response
     * across all registered colleague components.
     *
     * @param sender      the colleague component that triggered the event
     * @param event       the event name (e.g., APPOINTMENT_BOOKED, APPOINTMENT_CANCELLED)
     * @param appointmentId the ID of the appointment involved
     */
    void notify(AppointmentColleague sender, String event, String appointmentId);
}
