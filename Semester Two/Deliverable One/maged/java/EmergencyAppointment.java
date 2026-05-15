package hospitalmangementsystem.patterns.factory;

import hospitalmangementsystem.domain.Appointment;

/**
 * Concrete Product: Emergency appointment.
 * High priority, immediate care.
 */
public class EmergencyAppointment extends Appointment {

    public EmergencyAppointment(String appointmentId, String patientId, String startTime) {
        super(appointmentId, patientId, startTime, "EMERGENCY");
    }

    @Override
    public String getType() {
        return "EMERGENCY";
    }

    @Override
    public int getDurationMinutes() {
        return 60; // 1 hour for emergency assessment
    }

    @Override
    public String getStatus() {
        return "URGENT"; // Emergency appointments are always urgent
    }
}
