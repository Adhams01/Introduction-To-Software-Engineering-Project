package hospitalmangementsystem.patterns.factory;

import hospitalmangementsystem.domain.Appointment;

/**
 * Concrete Product: Follow-up appointment.
 * Short 15-minute revisit.
 */
public class FollowUpAppointment extends Appointment {

    public FollowUpAppointment(String appointmentId, String patientId, String startTime) {
        super(appointmentId, patientId, startTime, "FOLLOW_UP");
    }

    @Override
    public String getType() {
        return "FOLLOW_UP";
    }

    @Override
    public int getDurationMinutes() {
        return 15;
    }
}
