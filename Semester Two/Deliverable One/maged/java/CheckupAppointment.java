package hospitalmangementsystem.patterns.factory;

import hospitalmangementsystem.domain.Appointment;

/**
 * Concrete Product: Checkup appointment.
 * Standard 30-minute consultation.
 */
public class CheckupAppointment extends Appointment {

    public CheckupAppointment(String appointmentId, String patientId, String startTime) {
        super(appointmentId, patientId, startTime, "CHECKUP");
    }

    @Override
    public String getType() {
        return "CHECKUP";
    }

    @Override
    public int getDurationMinutes() {
        return 30;
    }
}
