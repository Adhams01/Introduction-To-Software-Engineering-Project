package hospitalmangementsystem;

public class HospitalMangementSystem {
    public static void main(String[] args) {
        hospitalmangementsystem.dao.AppointmentDAO appointmentDAO = new hospitalmangementsystem.dao.AppointmentDAO();
        hospitalmangementsystem.dao.PatientDAO patientDAO = new hospitalmangementsystem.dao.PatientDAO();
        hospitalmangementsystem.external.NotificationService notificationService = new hospitalmangementsystem.external.SimpleNotificationService();

        hospitalmangementsystem.controller.AppointmentController appointmentController =
                new hospitalmangementsystem.controller.AppointmentController(appointmentDAO, notificationService);
        hospitalmangementsystem.controller.PatientController patientController =
                new hospitalmangementsystem.controller.PatientController(patientDAO);

        seedAppointments(appointmentDAO);

        hospitalmangementsystem.ui.CancelAppointmentConsoleUI cancelUI =
                new hospitalmangementsystem.ui.CancelAppointmentConsoleUI(appointmentController);
        hospitalmangementsystem.ui.RegisterPatientConsoleUI registerUI =
                new hospitalmangementsystem.ui.RegisterPatientConsoleUI(patientController);

        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== Hospital Management System (Generated from StarUML) ===");
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

    private static void seedAppointments(hospitalmangementsystem.dao.AppointmentDAO appointmentDAO) {
        appointmentDAO.save("123", new hospitalmangementsystem.domain.Appointment(
                "A1",
                "2025-12-30 10:00",
                "SCHEDULED"
        ));
        appointmentDAO.save("123", new hospitalmangementsystem.domain.Appointment(
                "A2",
                "2026-01-02 12:30",
                "SCHEDULED"
        ));
        appointmentDAO.save("999", new hospitalmangementsystem.domain.Appointment(
                "B1",
                "2025-12-28 09:00",
                "SCHEDULED"
        ));
    }
}
