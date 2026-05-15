package hospitalmangementsystem.patterns.factory;

// [MAGED] - Concrete Factory #2: Creates Surgery appointments
// Surgeries are 2-hour procedures with preparation

import hospitalmangementsystem.domain.Appointment;
import hospitalmangementsystem.domain.SurgeryAppointment;

public class SurgeryAppointmentFactory extends AppointmentFactory {
    
    // [MAGED] - Creates a Surgery appointment (120 minutes)
    @Override
    public Appointment createAppointment(String appointmentId, String patientId, String startTime) {
        return new SurgeryAppointment(appointmentId, patientId, startTime);
    }
}
