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
import hospitalmanagementsystem.patterns.behavioral.templatemethod.tm1.TemplateMethodTM1Demo;
import hospitalmanagementsystem.patterns.behavioral.strategy.st1.StrategyST1Demo;
import hospitalmanagementsystem.patterns.behavioral.mediator.md1.AppointmentMediatorDemo;
import hospitalmanagementsystem.patterns.behavioral.iterator.it1.AppointmentIteratorDemo;
import hospitalmanagementsystem.patterns.behavioral.templatemethod.tm2.TreatmentPlanDemo;
import hospitalmanagementsystem.patterns.behavioral.mediator.md2.EmergencyMediatorDemo;
import hospitalmanagementsystem.patterns.behavioral.strategy.st2.PaymentStrategyDemo;
import hospitalmanagementsystem.patterns.behavioral.observer.os1.ObserverSingletonDemo;

public class HospitalMangementSystem {
    
    public static void main(String[] args) {
        System.out.println("\n=== Hospital Management System ===");
        System.out.println("=== Deliverable #2/#3: Structural + Behavioral Design Patterns ===");
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
        System.out.println("15) Patient Discharge Workflow (Template Method Demo - D3) [ADHAM]");
        System.out.println("16) Billing Calculation Strategies (Strategy Demo - D3) [ADHAM]");
        System.out.println("17) Appointment Coordination (Mediator Demo - D3) [ANDREW]");
        System.out.println("18) Appointment Collection Traversal (Iterator Demo - D3) [ANDREW]");
        System.out.println("19) Treatment Plan Process (Template Method Demo - D3) [YASSIN]");
        System.out.println("20) Emergency Response Coordination (Mediator Demo - D3) [YASSIN]");
        System.out.println("21) Payment Processing (Strategy Demo - D3) [MAGED]");
        System.out.println("22) Hospital Event System (Observer+Singleton Demo - D3) [MAGED]");
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
            } else if ("15".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #3: TEMPLATE METHOD PATTERN DEMO [ADHAM]");
                System.out.println("TM1 - Patient Discharge Workflow");
                System.out.println("========================================");
                TemplateMethodTM1Demo.main(new String[]{});
            } else if ("16".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #3: STRATEGY PATTERN DEMO [ADHAM]");
                System.out.println("ST1 - Billing Calculation Strategies");
                System.out.println("========================================");
                StrategyST1Demo.main(new String[]{});
            } else if ("17".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #3: MEDIATOR PATTERN DEMO [ANDREW]");
                System.out.println("MD1 - Appointment Coordination");
                System.out.println("========================================");
                AppointmentMediatorDemo.main(new String[]{});
            } else if ("18".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #3: ITERATOR PATTERN DEMO [ANDREW]");
                System.out.println("IT1 - Appointment Collection Traversal");
                System.out.println("========================================");
                AppointmentIteratorDemo.main(new String[]{});
            } else if ("19".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #3: TEMPLATE METHOD PATTERN DEMO [YASSIN]");
                System.out.println("TM2 - Treatment Plan Process");
                System.out.println("========================================");
                TreatmentPlanDemo.main(new String[]{});
            } else if ("20".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #3: MEDIATOR PATTERN DEMO [YASSIN]");
                System.out.println("MD2 - Emergency Response Coordination");
                System.out.println("========================================");
                EmergencyMediatorDemo.main(new String[]{});
            } else if ("21".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #3: STRATEGY PATTERN DEMO [MAGED]");
                System.out.println("ST2 - Payment Processing");
                System.out.println("========================================");
                PaymentStrategyDemo.main(new String[]{});
            } else if ("22".equals(choice)) {
                System.out.println("\n========================================");
                System.out.println("DELIVERABLE #3: OBSERVER + SINGLETON PATTERN DEMO [MAGED]");
                System.out.println("OS1 - Hospital Event System");
                System.out.println("========================================");
                ObserverSingletonDemo.main(new String[]{});
            } else {
                System.out.println("Option not recognized.");
            }
        }
    }
}
