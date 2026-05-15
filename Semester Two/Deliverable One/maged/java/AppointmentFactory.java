package hospitalmangementsystem.patterns.factory;

import hospitalmangementsystem.domain.Appointment;

/**
 * Abstract Factory (Creator) for Factory Method pattern.
 * Defines the factory method for creating Appointment objects.
 *
 * Why Factory Method:
 *   Different appointment types (Checkup, Surgery, Follow-up, Emergency)
 *   have different durations and properties. Factory Method lets
 *   subclasses decide which concrete appointment to instantiate,
 *   decoupling the controller from specific appointment classes.
 */
public abstract class AppointmentFactory {

    /**
     * Factory Method: Creates a specific Appointment subtype.
     * Subclasses implement this to return their specific appointment type.
     *
     * @param appointmentId Unique identifier for the appointment
     * @param patientId Patient national ID
     * @param startTime Appointment date/time string
     * @return Concrete Appointment instance
     */
    public abstract Appointment createAppointment(String appointmentId, String patientId, String startTime);

    /**
     * Template method that uses the factory method.
     * Provides common booking logic while letting subclasses define the product.
     */
    public Appointment bookAppointment(String appointmentId, String patientId, String startTime) {
        Appointment appointment = createAppointment(appointmentId, patientId, startTime);
        // Common booking logic (logging, validation, etc.)
        System.out.println("[Factory Method] Booked: " + appointment.getType() +
                          " (Duration: " + appointment.getDurationMinutes() + " mins)");
        return appointment;
    }
}
