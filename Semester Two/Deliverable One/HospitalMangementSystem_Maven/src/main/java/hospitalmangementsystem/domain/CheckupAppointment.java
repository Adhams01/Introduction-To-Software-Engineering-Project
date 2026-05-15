package hospitalmangementsystem.domain;

// [MAGED] - Concrete Product: Checkup appointment
// Standard 30-minute consultation
// Created by CheckupAppointmentFactory

import hospitalmangementsystem.domain.Appointment;

public class CheckupAppointment extends Appointment {
    
    // [MAGED] - Constructor: creates a CHECKUP appointment (30 minutes)
    public CheckupAppointment(String appointmentId, String patientId, String startTime) {
        super(appointmentId, patientId, startTime, "CHECKUP");
    }
    
    // [MAGED] - Returns CHECKUP type
    @Override
    public String getType() {
        return "CHECKUP";
    }
    
    // [MAGED] - Returns 30 minutes duration
    @Override
    public int getDurationMinutes() {
        return 30;
    }
}
