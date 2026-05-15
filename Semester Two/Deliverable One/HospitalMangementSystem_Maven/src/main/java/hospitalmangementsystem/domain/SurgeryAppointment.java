package hospitalmangementsystem.domain;

// [MAGED] - Concrete Product: Surgery appointment
// 2-hour procedure with preparation time
// Created by SurgeryAppointmentFactory

import hospitalmangementsystem.domain.Appointment;

public class SurgeryAppointment extends Appointment {
    
    // [MAGED] - Constructor: creates a SURGERY appointment (120 minutes)
    public SurgeryAppointment(String appointmentId, String patientId, String startTime) {
        super(appointmentId, patientId, startTime, "SURGERY");
    }
    
    // [MAGED] - Returns SURGERY type
    @Override
    public String getType() {
        return "SURGERY";
    }
    
    // [MAGED] - Returns 120 minutes (2 hours) duration
    @Override
    public int getDurationMinutes() {
        return 120; // 2 hours
    }
}
