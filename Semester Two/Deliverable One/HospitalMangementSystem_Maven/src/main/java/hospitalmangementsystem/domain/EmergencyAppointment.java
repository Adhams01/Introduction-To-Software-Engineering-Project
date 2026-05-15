package hospitalmangementsystem.domain;

// [MAGED] - Concrete Product: Emergency appointment
// High priority, immediate care with URGENT status
// Created by EmergencyAppointmentFactory

import hospitalmangementsystem.domain.Appointment;

public class EmergencyAppointment extends Appointment {
    
    // [MAGED] - Constructor: creates an EMERGENCY appointment (60 minutes)
    public EmergencyAppointment(String appointmentId, String patientId, String startTime) {
        super(appointmentId, patientId, startTime, "EMERGENCY");
    }
    
    // [MAGED] - Returns EMERGENCY type
    @Override
    public String getType() {
        return "EMERGENCY";
    }
    
    // [MAGED] - Returns 60 minutes (1 hour) for emergency assessment
    @Override
    public int getDurationMinutes() {
        return 60; // 1 hour for emergency assessment
    }
    
    // [MAGED] - Returns URGENT status (emergency appointments are always urgent)
    @Override
    public String getStatus() {
        return "URGENT"; // Emergency appointments are always urgent
    }
}
