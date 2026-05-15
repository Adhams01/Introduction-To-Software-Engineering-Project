package hospitalmanagementsystem.patterns.structural.bridge.report;

public class ReportBridgeDemo {

    public static void main(String[] args) {

        System.out.println("=== Bridge Pattern: Report (Content x Renderer) Demo ===");
        System.out.println("Author: [ANDREW]");
        System.out.println();

        ReportRenderer pdfRenderer = new PdfRenderer();
        ReportRenderer htmlRenderer = new HtmlRenderer();
        ReportRenderer csvRenderer = new CsvRenderer();

        System.out.println("--- Demo 1: Appointment Schedule Report ---");
        System.out.println();

        Report appointmentReport = new AppointmentScheduleReport(pdfRenderer);

        System.out.println("[PDF format]");
        System.out.println(appointmentReport.generate());

        appointmentReport.setRenderer(htmlRenderer);
        System.out.println("[HTML format]");
        System.out.println(appointmentReport.generate());

        appointmentReport.setRenderer(csvRenderer);
        System.out.println("[CSV format]");
        System.out.println(appointmentReport.generate());

        System.out.println("--- Demo 2: Billing Summary Report ---");
        System.out.println();

        Report billingReport = new BillingSummaryReport(pdfRenderer);

        System.out.println("[PDF format]");
        System.out.println(billingReport.generate());

        billingReport.setRenderer(csvRenderer);
        System.out.println("[CSV format]");
        System.out.println(billingReport.generate());

        System.out.println("=== Bridge Demo Summary ===");
        System.out.println("- 2 report types x 3 renderers");
        System.out.println("- Runtime renderer switching using setRenderer()");
        System.out.println("- No need to create new report objects for each format");
        System.out.println("- Easy to extend with new reports or new formats");
        System.out.println("=== Demo Complete ===");
    }
}