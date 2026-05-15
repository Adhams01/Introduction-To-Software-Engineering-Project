package hospitalmangementsystem.patterns.factory;

import hospitalmangementsystem.domain.Appointment;

/**
 * Concrete Factory: Creates Emergency appointments.
 * Emergency appointments are high priority and immediate.
 */
public class EmergencyAppointmentFactory extends AppointmentFactory {

    @Override
    public Appointment createAppointment(String appointmentId, String patientId, String startTime) {
        return new EmergencyAppointment(appointmentId, patientId, startTime);
    }
}
