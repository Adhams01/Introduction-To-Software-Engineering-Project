package hospitalmangementsystem.patterns.factory;

import hospitalmangementsystem.domain.Appointment;

/**
 * Concrete Factory: Creates Checkup appointments.
 * Checkups are standard 30-minute consultations.
 */
public class CheckupAppointmentFactory extends AppointmentFactory {

    @Override
    public Appointment createAppointment(String appointmentId, String patientId, String startTime) {
        return new CheckupAppointment(appointmentId, patientId, startTime);
    }
}
