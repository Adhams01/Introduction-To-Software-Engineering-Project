package hospitalmangementsystem.patterns.factory;

import hospitalmangementsystem.domain.Appointment;

/**
 * Concrete Factory: Creates Surgery appointments.
 * Surgeries are 2-hour procedures with preparation.
 */
public class SurgeryAppointmentFactory extends AppointmentFactory {

    @Override
    public Appointment createAppointment(String appointmentId, String patientId, String startTime) {
        return new SurgeryAppointment(appointmentId, patientId, startTime);
    }
}
