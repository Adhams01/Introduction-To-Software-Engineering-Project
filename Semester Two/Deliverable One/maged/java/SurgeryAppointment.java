package hospitalmangementsystem.patterns.factory;

import hospitalmangementsystem.domain.Appointment;

/**
 * Concrete Product: Surgery appointment.
 * 2-hour procedure with preparation time.
 */
public class SurgeryAppointment extends Appointment {

    public SurgeryAppointment(String appointmentId, String patientId, String startTime) {
        super(appointmentId, patientId, startTime, "SURGERY");
    }

    @Override
    public String getType() {
        return "SURGERY";
    }

    @Override
    public int getDurationMinutes() {
        return 120; // 2 hours
    }
}
