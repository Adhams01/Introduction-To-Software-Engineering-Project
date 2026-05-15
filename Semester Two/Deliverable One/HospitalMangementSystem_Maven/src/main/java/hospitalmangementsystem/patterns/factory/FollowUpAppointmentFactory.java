package hospitalmangementsystem.patterns.factory;

// [MAGED] - Concrete Factory #3: Creates Follow-up appointments
// Follow-ups are short 15-minute visits after initial treatment

import hospitalmangementsystem.domain.Appointment;
import hospitalmangementsystem.domain.FollowUpAppointment;

public class FollowUpAppointmentFactory extends AppointmentFactory {
    
    // [MAGED] - Creates a Follow-up appointment (15 minutes)
    @Override
    public Appointment createAppointment(String appointmentId, String patientId, String startTime) {
        return new FollowUpAppointment(appointmentId, patientId, startTime);
    }
}
