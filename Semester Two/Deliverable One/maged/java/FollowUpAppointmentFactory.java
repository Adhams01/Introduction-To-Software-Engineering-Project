package hospitalmangementsystem.patterns.factory;

import hospitalmangementsystem.domain.Appointment;

/**
 * Concrete Factory: Creates Follow-up appointments.
 * Follow-ups are short 15-minute visits.
 */
public class FollowUpAppointmentFactory extends AppointmentFactory {

    @Override
    public Appointment createAppointment(String appointmentId, String patientId, String startTime) {
        return new FollowUpAppointment(appointmentId, patientId, startTime);
    }
}
