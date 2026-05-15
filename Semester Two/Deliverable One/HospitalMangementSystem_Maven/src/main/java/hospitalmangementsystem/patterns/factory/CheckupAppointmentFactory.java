package hospitalmangementsystem.patterns.factory;

// [MAGED] - Concrete Factory #1: Creates Checkup appointments
// Checkups are standard 30-minute consultations

import hospitalmangementsystem.domain.Appointment;
import hospitalmangementsystem.domain.CheckupAppointment;

public class CheckupAppointmentFactory extends AppointmentFactory {
    
    // [MAGED] - Creates a Checkup appointment (30 minutes)
    @Override
    public Appointment createAppointment(String appointmentId, String patientId, String startTime) {
        return new CheckupAppointment(appointmentId, patientId, startTime);
    }
}
