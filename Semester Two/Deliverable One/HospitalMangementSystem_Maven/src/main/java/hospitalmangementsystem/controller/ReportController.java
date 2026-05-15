package hospitalmangementsystem.controller;

// [ADHAM] - Controller for generating reports using Abstract Factory pattern
// Uses Abstract Factory to create format-specific report components (PDF, CSV, HTML)
// Same code works for all formats - just swap the factory!

import hospitalmangementsystem.patterns.abstractfactory.*;

public class ReportController {
    
    // [ADHAM] - The abstract factory - can be PDF, CSV, or HTML factory
    private final ReportFactory factory;
    
    // [ADHAM] - Constructor: takes any ReportFactory implementation
    public ReportController(ReportFactory factory) {
        if (factory == null) {
            throw new IllegalArgumentException("ReportFactory is required");
        }
        this.factory = factory;
    }
    
    // [ADHAM] - Generates a patient registration report
    // Uses factory to create all components (header, document, footer)
    public byte[] generatePatientReport(String patientId, String patientName, String registrationDate) {
        // Create components using factory
        ReportHeader header = factory.createReportHeader("Patient Registration Report");
        ReportDocument document = factory.createReportDocument();
        ReportFooter footer = factory.createReportFooter(1);
        
        // Build content
        String content = String.format(
            "Patient ID: %s%nName: %s%nRegistration Date: %s",
            patientId, patientName, registrationDate
        );
        document.addSection("Patient Details", content);
        
        // Combine all parts
        return buildOutput(header, document, footer);
    }
    
    // [ADHAM] - Generates an appointment summary report
    public byte[] generateAppointmentReport(String appointmentId, String patientId,
                                            String date, String status) {
        // Create components using factory
        ReportHeader header = factory.createReportHeader("Appointment Summary");
        ReportDocument document = factory.createReportDocument();
        ReportFooter footer = factory.createReportFooter(1);
        
        // Build content
        String content = String.format(
            "Appointment ID: %s%nPatient ID: %s%nDate/Time: %s%nStatus: %s",
            appointmentId, patientId, date, status
        );
        document.addSection("Appointment Details", content);
        
        return buildOutput(header, document, footer);
    }
    
    // [ADHAM] - Generates a statistics report with chart
    public byte[] generateStatisticsReport(double[] patientStats, double[] appointmentStats) {
        // Create components using factory (including chart)
        ReportHeader header = factory.createReportHeader("Hospital Statistics");
        ReportDocument document = factory.createReportDocument();
        ReportFooter footer = factory.createReportFooter(1);
        ChartComponent chart = factory.createChart(patientStats);
        
        // Add sections
        document.addSection("Patient Statistics", chart.render());
        document.addSection("Raw Data", formatData(patientStats));
        
        return buildOutput(header, document, footer);
    }
    
    // [ADHAM] - Helper: Combines header + document + footer into final report
    private byte[] buildOutput(ReportHeader header, ReportDocument document, ReportFooter footer) {
        byte[] docBytes = document.generate();
        String fullReport = header.render() + "\n" +
                           new String(docBytes) + "\n" +
                           footer.render();
        return fullReport.getBytes();
    }
    
    // [ADHAM] - Helper: Formats array data as readable text
    private String formatData(double[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("Data point %d: %.2f%n", i, data[i]));
        }
        return sb.toString();
    }
    
    // [ADHAM] - Returns content type (PDF, CSV, or HTML)
    public String getContentType() {
        ReportDocument doc = factory.createReportDocument();
        return doc.getContentType();
    }
}
