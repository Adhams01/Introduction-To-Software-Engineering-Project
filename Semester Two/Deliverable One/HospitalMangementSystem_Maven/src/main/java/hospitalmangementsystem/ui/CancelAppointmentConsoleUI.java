package hospitalmangementsystem.ui;

import hospitalmangementsystem.controller.AppointmentController;
import hospitalmangementsystem.domain.Appointment;

import java.util.Scanner;

public class CancelAppointmentConsoleUI {
    private final AppointmentController appointmentController;

    public CancelAppointmentConsoleUI(AppointmentController appointmentController) {
        this.appointmentController = appointmentController;
    }

    public void run(Scanner scanner) {
        System.out.println("UC-06 Cancel Appointment (Console UI)");

        System.out.print("Enter Patient National ID: ");
        String nationalId = scanner.nextLine();

        Appointment[] upcoming = appointmentController.listUpcomingAppointments(nationalId);
        if (upcoming.length == 0) {
            System.out.println("No upcoming appointments found for this patient.");
            return;
        }

        System.out.println("Upcoming appointments:");
        for (Appointment a : upcoming) {
            System.out.println("- appointmentId=" + a.getAppointmentId() + " | status=" + a.getStatus() + " | startTime=" + a.getStartTime());
        }

        System.out.print("Enter Appointment ID to cancel: ");
        String appointmentId = scanner.nextLine();

        String result = appointmentController.cancelAppointment(appointmentId);
        System.out.println(result);
    }
}
