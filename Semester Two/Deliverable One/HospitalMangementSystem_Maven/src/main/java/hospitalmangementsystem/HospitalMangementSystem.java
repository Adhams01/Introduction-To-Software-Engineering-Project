package hospitalmangementsystem;

// [ADHAM] - Main entry point for Hospital Management System
// Demonstrates all 5 Creational Design Patterns

import hospitalmangementsystem.patterns.abstractfactory.*;
import hospitalmangementsystem.patterns.abstractfactory.ui.*;
import hospitalmangementsystem.patterns.factory.*;

public class HospitalMangementSystem {
    
    // [ADHAM] - Main method: starts the application
    public static void main(String[] args) {
        // Create DAOs (database access objects)
        hospitalmangementsystem.dao.AppointmentDAO appointmentDAO = new hospitalmangementsystem.dao.AppointmentDAO();
        hospitalmangementsystem.dao.PatientDAO patientDAO = new hospitalmangementsystem.dao.PatientDAO();
        
        // [ADHAM] - Get singleton notification service (Case #1)
        hospitalmangementsystem.external.NotificationService notificationService =
                hospitalmangementsystem.patterns.singleton.NotificationServiceSingleton.getInstance();
        
        // Create controllers
        hospitalmangementsystem.controller.AppointmentController appointmentController =
                new hospitalmangementsystem.controller.AppointmentController(appointmentDAO, notificationService);
        hospitalmangementsystem.controller.PatientController patientController =
                new hospitalmangementsystem.controller.PatientController(patientDAO);
        
        // [ADHAM] - Abstract Factory Case #1: PDF report generator
        ReportFactory pdfFactory = new PDFReportFactory();
        hospitalmangementsystem.controller.ReportController reportController =
                new hospitalmangementsystem.controller.ReportController(pdfFactory);
        
        // [ADHAM] - Abstract Factory Case #2: Console UI components
        UIComponentFactory uiFactory = new ConsoleUIFactory();
        
        // Add sample data
        seedAppointments(appointmentDAO);
        
        // Create UI handlers
        hospitalmangementsystem.ui.CancelAppointmentConsoleUI cancelUI =
                new hospitalmangementsystem.ui.CancelAppointmentConsoleUI(appointmentController);
        hospitalmangementsystem.ui.RegisterPatientConsoleUI registerUI =
                new hospitalmangementsystem.ui.RegisterPatientConsoleUI(patientController);
        
        // [ADHAM] - Main menu loop
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== Hospital Management System (Generated from StarUML) ===");
                System.out.println("1) UC-02 Register Patient");
                System.out.println("2) UC-06 Cancel Appointment");
                System.out.println("3) Generate Sample Report (Abstract Factory Demo)");
                System.out.println("4) Schedule Checkup Appointment (Factory Method Demo)");
                System.out.println("5) Schedule Surgery Appointment (Factory Method Demo)");
                System.out.println("6) Schedule Follow-up Appointment (Factory Method Demo)");
                System.out.println("7) Schedule Emergency Appointment (Factory Method Demo)");
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
                } else if ("3".equals(choice)) {
                    // [ADHAM] - Abstract Factory Demo: generate PDF report
                    System.out.println("\n--- Generating Report (Abstract Factory Demo) ---");
                    byte[] report = reportController.generatePatientReport("P001", "John Doe", "2025-03-06");
                    System.out.println("Report generated! Content-Type: " + reportController.getContentType());
                    System.out.println("Preview (first 200 chars):");
                    System.out.println(new String(report, 0, Math.min(200, report.length)));
                } else if ("4".equals(choice)) {
                    // [ADHAM] - Factory Method Demo: Checkup (30 min)
                    appointmentController.setAppointmentFactory(new CheckupAppointmentFactory());
                    System.out.println("\n--- Scheduling Checkup (Factory Method Demo) ---");
                    System.out.print("Enter appointment ID: ");
                    String apptId = scanner.nextLine();
                    System.out.print("Enter patient ID: ");
                    String patId = scanner.nextLine();
                    System.out.print("Enter date/time (e.g., 2025-03-10 10:00): ");
                    String dateTime = scanner.nextLine();
                    appointmentController.scheduleAppointment(apptId, patId, dateTime);
                } else if ("5".equals(choice)) {
                    // [ADHAM] - Factory Method Demo: Surgery (120 min)
                    appointmentController.setAppointmentFactory(new SurgeryAppointmentFactory());
                    System.out.println("\n--- Scheduling Surgery (Factory Method Demo) ---");
                    System.out.print("Enter appointment ID: ");
                    String apptId = scanner.nextLine();
                    System.out.print("Enter patient ID: ");
                    String patId = scanner.nextLine();
                    System.out.print("Enter date/time (e.g., 2025-03-10 10:00): ");
                    String dateTime = scanner.nextLine();
                    appointmentController.scheduleAppointment(apptId, patId, dateTime);
                } else if ("6".equals(choice)) {
                    // [ADHAM] - Factory Method Demo: Follow-up (15 min)
                    appointmentController.setAppointmentFactory(new FollowUpAppointmentFactory());
                    System.out.println("\n--- Scheduling Follow-up (Factory Method Demo) ---");
                    System.out.print("Enter appointment ID: ");
                    String apptId = scanner.nextLine();
                    System.out.print("Enter patient ID: ");
                    String patId = scanner.nextLine();
                    System.out.print("Enter date/time (e.g., 2025-03-10 10:00): ");
                    String dateTime = scanner.nextLine();
                    appointmentController.scheduleAppointment(apptId, patId, dateTime);
                } else if ("7".equals(choice)) {
                    // [ADHAM] - Factory Method Demo: Emergency (60 min)
                    appointmentController.setAppointmentFactory(new EmergencyAppointmentFactory());
                    System.out.println("\n--- Scheduling Emergency (Factory Method Demo) ---");
                    System.out.print("Enter appointment ID: ");
                    String apptId = scanner.nextLine();
                    System.out.print("Enter patient ID: ");
                    String patId = scanner.nextLine();
                    System.out.print("Enter date/time (e.g., 2025-03-10 10:00): ");
                    String dateTime = scanner.nextLine();
                    appointmentController.scheduleAppointment(apptId, patId, dateTime);
                } else {
                    System.out.println("Invalid choice.");
                }
            }
        }
    }
    
    // [ADHAM] - Adds sample appointment data for testing
    private static void seedAppointments(hospitalmangementsystem.dao.AppointmentDAO appointmentDAO) {
        appointmentDAO.save("123", new hospitalmangementsystem.domain.Appointment(
                "A1",
                "123",
                "2025-12-30 10:00",
                "SCHEDULED"
        ));
        appointmentDAO.save("123", new hospitalmangementsystem.domain.Appointment(
                "A2",
                "123",
                "2026-01-02 12:30",
                "SCHEDULED"
        ));
        appointmentDAO.save("999", new hospitalmangementsystem.domain.Appointment(
                "B1",
                "999",
                "2025-12-28 09:00",
                "SCHEDULED"
        ));
    }
}
