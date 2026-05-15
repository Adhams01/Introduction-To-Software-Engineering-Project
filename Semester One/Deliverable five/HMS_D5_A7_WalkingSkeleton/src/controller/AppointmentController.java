package controller;

import dao.AppointmentDAO;
import domain.Appointment;
import external.NotificationService;

public class AppointmentController {
    private final AppointmentDAO appointmentDAO;
    private final NotificationService notificationService;

    public AppointmentController(AppointmentDAO appointmentDAO, NotificationService notificationService) {
        this.appointmentDAO = appointmentDAO;
        this.notificationService = notificationService;
    }

    public Appointment[] listUpcomingAppointments(String patientNationalId) {
        if (patientNationalId == null || patientNationalId.trim().isEmpty()) {
            return new Appointment[0];
        }
        return appointmentDAO.findUpcomingByPatientNationalId(patientNationalId.trim());
    }

    public String cancelAppointment(String appointmentId) {
        if (appointmentId == null || appointmentId.trim().isEmpty()) {
            return "ERROR: Appointment ID is required.";
        }

        Appointment appointment = appointmentDAO.findById(appointmentId.trim());
        if (appointment == null) {
            return "ERROR: Appointment not found.";
        }

        if ("CANCELLED".equalsIgnoreCase(appointment.getStatus())) {
            return "ERROR: Appointment already cancelled.";
        }

        appointmentDAO.updateStatus(appointment.getId(), "CANCELLED");

        notificationService.sendCancellation("Appointment cancelled: " + appointment.getDetails() + " (id=" + appointment.getId() + ")");

        return "SUCCESS: Appointment cancelled (id=" + appointment.getId() + ")";
    }
}
