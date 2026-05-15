package hospitalmangementsystem.patterns.factory;

// [MAGED] - Concrete Factory #4: Creates Emergency appointments
// Emergency appointments are high priority and immediate

import hospitalmangementsystem.domain.Appointment;
import hospitalmangementsystem.domain.EmergencyAppointment;

public class EmergencyAppointmentFactory extends AppointmentFactory {
    
    // [MAGED] - Creates an Emergency appointment (60 minutes, URGENT status)
    @Override
    public Appointment createAppointment(String appointmentId, String patientId, String startTime) {
        return new EmergencyAppointment(appointmentId, patientId, startTime);
    }
}
