package hospitalmangementsystem.controller;

// [ANDREW] - Controller for managing appointments
// Uses Factory Method pattern to create different appointment types
// Uses Singleton pattern for notifications

import hospitalmangementsystem.dao.AppointmentDAO;
import hospitalmangementsystem.domain.Appointment;
import hospitalmangementsystem.external.NotificationService;
import hospitalmangementsystem.patterns.factory.AppointmentFactory;

public class AppointmentController {
    
    // [ANDREW] - Database access for saving appointments
    private final AppointmentDAO appointmentDAO;
    
    // [ANDREW] - Notification service (Singleton pattern)
    private final NotificationService notificationService;
    
    // [ANDREW] - Factory for creating appointments (Factory Method pattern)
    private AppointmentFactory factory;
    
    // [ANDREW] - Constructor: takes DAO and notification service
    public AppointmentController(AppointmentDAO appointmentDAO, NotificationService notificationService) {
        this.appointmentDAO = appointmentDAO;
        this.notificationService = notificationService;
    }
    
    // [ANDREW] - Sets which factory to use for creating appointments
    // This is how we switch between Checkup, Surgery, etc.
    public void setAppointmentFactory(AppointmentFactory factory) {
        this.factory = factory;
    }
    
    // [ANDREW] - Creates and schedules an appointment using the factory
    // 1. Creates appointment via factory
    // 2. Saves to database
    // 3. Sends confirmation notification
    public Appointment scheduleAppointment(String appointmentId, String patientId, String startTime) {
        if (factory == null) {
            throw new IllegalStateException("Factory not set. Call setAppointmentFactory() first.");
        }
        // Create appointment using factory method
        Appointment appointment = factory.bookAppointment(appointmentId, patientId, startTime);
        // Save to database
        appointmentDAO.save(patientId, appointment);
        // Notify patient
        notificationService.sendConfirmation("Appointment scheduled: " + appointment.getType() +
                " (Duration: " + appointment.getDurationMinutes() + " mins)");
        return appointment;
    }
    
    // [ANDREW] - Gets upcoming appointments for a patient
    public Appointment[] listUpcomingAppointments(String patientNationalId) {
        if (patientNationalId == null || patientNationalId.trim().isEmpty()) {
            return new Appointment[0];
        }
        return appointmentDAO.findUpcomingByPatientNationalId(patientNationalId.trim());
    }
    
    // [ANDREW] - Cancels an appointment and sends notification
    public String cancelAppointment(String appointmentId) {
        if (appointmentId == null || appointmentId.trim().isEmpty()) {
            return "ERROR: Appointment ID is required.";
        }
        // Find the appointment
        Appointment appointment = appointmentDAO.findById(appointmentId.trim());
        if (appointment == null) {
            return "ERROR: Appointment not found.";
        }
        // Check if already cancelled
        if ("CANCELLED".equalsIgnoreCase(appointment.getStatus())) {
            return "ERROR: Appointment already cancelled.";
        }
        // Update status and notify
        appointmentDAO.updateStatus(appointment.getAppointmentId(), "CANCELLED");
        notificationService.sendCancellation(
                "Appointment cancelled: startTime=" + appointment.getStartTime() + " (appointmentId=" + appointment.getAppointmentId() + ")"
        );
        return "SUCCESS: Appointment cancelled (appointmentId=" + appointment.getAppointmentId() + ")";
    }
}
