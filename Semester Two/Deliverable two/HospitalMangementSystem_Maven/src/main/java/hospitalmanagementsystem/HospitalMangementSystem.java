package hospitalmanagementsystem;

// [ADHAM] - Main entry point for Hospital Management System
// This file is part of Deliverable #2 (Structural Design Patterns)
// 
// Deliverable #2 Additions:
// - Option 8: Bridge Pattern Demo (Notification System)

import hospitalmanagementsystem.patterns.structural.bridge.notification.NotificationBridgeDemo;
import hospitalmanagementsystem.patterns.structural.bridge.report.ReportBridgeDemo;
import hospitalmanagementsystem.patterns.structural.adapter.patient.PatientAdapterDemo;
import hospitalmanagementsystem.patterns.structural.flyweight.MedicalCodeDemo;
import hospitalmanagementsystem.patterns.structural.decorator.report.ReportDecoratorDemo;
import hospitalmanagementsystem.patterns.structural.adapter.payment.PaymentAdapterDemo;
import hospitalmanagementsystem.patterns.structural.decorator.notification.NotificationDecoratorDemo;

public class HospitalMangementSystem {
    
    public static void main(String[] args) {
        System.out.println("\n=== Hospital Management System ===");
        System.out.println("=== Deliverable #2: Structural Design Patterns ===");
        System.out.println("1) UC-02 Register Patient");
        System.out.println("2) UC-06 Cancel Appointment");
        System.out.println("3) Generate Sample Report (Abstract Factory Demo - D1)");
        System.out.println("4) Schedule Checkup Appointment (Factory Method Demo - D1)");
        System.out.println("5) Schedule Surgery Appointment (Factory Method Demo - D1)");
        System.out.println("6) Schedule Follow-up Appointment (Factory Method Demo - D1)");
        System.out.println("7) Schedule Emergency Appointment (Factory Method Demo - D1)");
        System.out.println("8) Test Notification System (Bridge Pattern Demo - D2) [ADHAM]");
        System.out.println("9) Test Report Renderer (Bridge Pattern Demo - D2) [ANDREW]");
        System.out.println("10) Test External Patient System (Adapter Pattern Demo - D2) [ANDREW]");
        System.out.println("11) Test Medical Codes Catalog (Flyweight Pattern Demo - D2) [MAGED]");
        System.out.println("12) Test Report Decorator (Decorator Pattern Demo - D2) [ADHAM]");
        System.out.println("13) Test Payment Gateway (Adapter Pattern Demo - D2) [YASSIN]");
        System.out.println("14) Test Notification Decorators (Decorator Pattern Demo - D2) [YASSIN]");
        System.out.println("0) Exit");
        System.out.print("Choose: ");
        
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            String choice = scanner.nextLine();
            
            if ("8".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #2: BRIDGE PATTERN DEMO [ADHAM]");
                System.out.println("BR1 - Notification System");
                System.out.println("========================================");
                NotificationBridgeDemo.main(new String[]{});
            } else if ("9".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #2: BRIDGE PATTERN DEMO [ANDREW]");
                System.out.println("BR2 - Report (Content x Renderer)");
                System.out.println("========================================");
                ReportBridgeDemo.main(new String[]{});
            } else if ("10".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #2: ADAPTER PATTERN DEMO [ANDREW]");
                System.out.println("AD1 - External Patient System");
                System.out.println("========================================");
                PatientAdapterDemo.main(new String[]{});
            } else if ("11".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #2: FLYWEIGHT PATTERN DEMO [MAGED]");
                System.out.println("FW1 - Medical Codes Catalog");
                System.out.println("========================================");
                MedicalCodeDemo.main(new String[]{});
            } else if ("12".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #2: DECORATOR PATTERN DEMO [ADHAM]");
                System.out.println("DC1 - Report Enhancements");
                System.out.println("========================================");
                ReportDecoratorDemo.main(new String[]{});
            } else if ("13".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #2: ADAPTER PATTERN DEMO [YASSIN]");
                System.out.println("AD2 - Payment Gateway");
                System.out.println("========================================");
                PaymentAdapterDemo.main(new String[]{});
            } else if ("14".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #2: DECORATOR PATTERN DEMO [YASSIN]");
                System.out.println("DC2 - Notification Sender Decorators");
                System.out.println("========================================");
                NotificationDecoratorDemo.main(new String[]{});
            } else {
                System.out.println("Other options not implemented in this demo.");
            }
        }
    }
}
