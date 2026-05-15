package hospitalmangementsystem.domain;

// [MAGED] - Concrete Product: Follow-up appointment
// Short 15-minute revisit after initial treatment
// Created by FollowUpAppointmentFactory

import hospitalmangementsystem.domain.Appointment;

public class FollowUpAppointment extends Appointment {
    
    // [MAGED] - Constructor: creates a FOLLOW_UP appointment (15 minutes)
    public FollowUpAppointment(String appointmentId, String patientId, String startTime) {
        super(appointmentId, patientId, startTime, "FOLLOW_UP");
    }
    
    // [MAGED] - Returns FOLLOW_UP type
    @Override
    public String getType() {
        return "FOLLOW_UP";
    }
    
    // [MAGED] - Returns 15 minutes duration
    @Override
    public int getDurationMinutes() {
        return 15;
    }
}
