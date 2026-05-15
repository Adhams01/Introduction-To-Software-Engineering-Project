import controller.AppointmentController;
import controller.PatientController;
import dao.AppointmentDAO;
import dao.PatientDAO;
import domain.Appointment;
import external.NotificationService;
import external.SimpleNotificationService;
import ui.CancelAppointmentConsoleUI;
import ui.RegisterPatientConsoleUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        PatientDAO patientDAO = new PatientDAO();
        NotificationService notificationService = new SimpleNotificationService();

        AppointmentController appointmentController = new AppointmentController(appointmentDAO, notificationService);
        PatientController patientController = new PatientController(patientDAO);

        seedAppointments(appointmentDAO);

        CancelAppointmentConsoleUI cancelUI = new CancelAppointmentConsoleUI(appointmentController);
        RegisterPatientConsoleUI registerUI = new RegisterPatientConsoleUI(patientController);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== HMS Walking Skeleton (A7) ===");
                System.out.println("1) UC-02 Register Patient");
                System.out.println("2) UC-06 Cancel Appointment");
                System.out.println("0) Exit");
                System.out.print("Choose: ");

                String choice = scanner.nextLine();
                if ("0".equals(choice)) {
                    System.out.println("Goodbye.");
                    return;
                }

                if ("1".equals(choice)) {
                    registerUI.run(scanner);
                } else if ("2".equals(choice)) {
                    cancelUI.run(scanner);
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        }
    }

    private static void seedAppointments(AppointmentDAO appointmentDAO) {
        appointmentDAO.save(new Appointment("A1", "123", "Checkup with Dr. Ahmed on 2025-12-30 10:00", "SCHEDULED"));
        appointmentDAO.save(new Appointment("A2", "123", "Dental cleaning on 2026-01-02 12:30", "SCHEDULED"));
        appointmentDAO.save(new Appointment("B1", "999", "Eye exam on 2025-12-28 09:00", "SCHEDULED"));
    }
}
