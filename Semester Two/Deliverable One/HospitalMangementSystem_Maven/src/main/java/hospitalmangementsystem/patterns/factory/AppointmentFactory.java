package hospitalmangementsystem.patterns.factory;

// [MAGED] - Factory Method Pattern: Abstract Creator
// This is the base factory that all concrete factories extend
// Each factory creates a different type of appointment

import hospitalmangementsystem.domain.Appointment;

/**
 * Abstract Factory (Creator) for Factory Method pattern.
 * Different appointment types need different properties (duration, type).
 * Factory Method lets subclasses decide which concrete appointment to make.
 */
public abstract class AppointmentFactory {
    
    // [MAGED] - Factory Method: Each subclass implements this differently
    // Returns a specific appointment type (Checkup, Surgery, etc.)
    public abstract Appointment createAppointment(String appointmentId, String patientId, String startTime);
    
    // [MAGED] - Template method that uses the factory method
    // Creates appointment + adds common booking logic
    public Appointment bookAppointment(String appointmentId, String patientId, String startTime) {
        Appointment appointment = createAppointment(appointmentId, patientId, startTime);
        // Log the booking
        System.out.println("[Factory Method] Booked: " + appointment.getType() +
                          " (Duration: " + appointment.getDurationMinutes() + " mins)");
        return appointment;
    }
}
