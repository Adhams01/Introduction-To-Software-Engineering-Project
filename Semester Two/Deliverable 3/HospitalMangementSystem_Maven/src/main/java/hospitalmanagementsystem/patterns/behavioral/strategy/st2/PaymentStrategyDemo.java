package hospitalmanagementsystem.patterns.behavioral.strategy.st2;

/**
 * PaymentStrategyDemo — Demonstrates Strategy pattern ST2
 * Shows how different payment strategies can be used interchangeably.
 * Author: Maged
 */
public class PaymentStrategyDemo {

    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern ST2: Payment Processing Demo ===");
        System.out.println("Author: Maged");
        System.out.println();

        BillingContext hospital = new BillingContext();

        // Register staff and patients
        Doctor drSmith = new Doctor("Alice Smith", "Cardiology");
        Doctor drJones = new Doctor("Robert Jones", "Neurology");
        hospital.addDoctor(drSmith);
        hospital.addDoctor(drJones);

        Patient p1 = new Patient("John Doe", 45, "john@email.com");
        Patient p2 = new Patient("Sarah Lee", 32, "sarah@email.com");
        hospital.registerPatient(p1);
        hospital.registerPatient(p2);

        // Schedule appointments
        Appointment appt1 = hospital.scheduleAppointment(p1, drSmith, "2025-06-10 09:00");
        Appointment appt2 = hospital.scheduleAppointment(p2, drJones, "2025-06-10 11:30");

        // Update appointment status
        appt1.updateStatus(AppointmentStatus.IN_PROGRESS);
        System.out.println("Appointment status updated: " + appt1);

        // Process billing using different strategies
        hospital.displaySystemOverview();

        System.out.println("Billing for John's visit:");
        hospital.processBilling(250.00, new InsurancePayment("POL-98765"));

        System.out.println("\nBilling for Sarah's visit:");
        hospital.processBilling(120.50, new CreditCardPayment("4242"));

        System.out.println("\nWalk-in emergency billing:");
        hospital.processBilling(85.00, new CashPayment());

        System.out.println("\n=== Strategy Demo Summary ===");
        System.out.println("- Three payment strategies used interchangeably:");
        System.out.println("  • InsurancePayment: for insured patients");
        System.out.println("  • CreditCardPayment: for card payments");
        System.out.println("  • CashPayment: for walk-in/emergency payments");
        System.out.println("- Strategy pattern allows runtime selection of payment method");
        System.out.println("- Easy to add new payment methods without changing existing code");
        System.out.println("=== Demo Complete ===");
    }
}
