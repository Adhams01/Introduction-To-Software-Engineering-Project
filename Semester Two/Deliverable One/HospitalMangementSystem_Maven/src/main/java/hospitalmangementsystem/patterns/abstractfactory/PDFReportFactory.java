package hospitalmangementsystem.patterns.abstractfactory;

// [ADHAM] - Concrete Factory: PDF Report Family
// Creates all PDF-compatible parts: Document + Header + Footer + Chart
// These all work together as a family

import java.util.ArrayList;
import java.util.List;

public class PDFReportFactory implements ReportFactory {
    
    // [ADHAM] - Creates the main PDF document container
    @Override
    public ReportDocument createReportDocument() {
        return new PDFReportDocument();
    }
    
    // [ADHAM] - Creates a PDF-formatted header
    @Override
    public ReportHeader createReportHeader(String title) {
        return new PDFReportHeader(title);
    }
    
    // [ADHAM] - Creates a PDF-formatted footer with page numbers
    @Override
    public ReportFooter createReportFooter(int pageNum) {
        return new PDFReportFooter(pageNum);
    }
    
    // [ADHAM] - Creates a PDF-compatible chart
    @Override
    public ChartComponent createChart(double[] data) {
        return new PDFChartComponent(data);
    }
    
    // ===== PDF Product Family implementations =====
    
    // [ADHAM] - PDF Document: Stores sections and generates PDF format
    private static class PDFReportDocument implements ReportDocument {
        private final List<String> sections = new ArrayList<>();
        
        // [ADHAM] - Add a section to the PDF
        @Override
        public void addSection(String title, String content) {
            sections.add("## " + title + "\n" + content);
        }
        
        // [ADHAM] - Generate the final PDF bytes
        @Override
        public byte[] generate() {
            StringBuilder pdf = new StringBuilder();
            pdf.append("%PDF-1.4 (simulated)\n");
            pdf.append("1 0 obj << /Type /Catalog /Pages 2 0 R >> endobj\n");
            pdf.append("2 0 obj << /Type /Pages /Kids [3 0 R] /Count 1 >> endobj\n");
            pdf.append("3 0 obj << /Type /Page /Parent 2 0 R /MediaBox [0 0 612 792] /Contents 4 0 R >> endobj\n");
            pdf.append("4 0 obj << /Length 0 >> stream\n");
            for (String section : sections) {
                pdf.append(section).append("\n");
            }
            pdf.append("endstream endobj\n");
            pdf.append("xref\ntrailer << /Size 5 /Root 1 0 R >>\n%%EOF");
            return pdf.toString().getBytes();
        }
        
        // [ADHAM] - Returns MIME type for PDF
        @Override
        public String getContentType() {
            return "application/pdf";
        }
    }
    
    // [ADHAM] - PDF Header: Renders as PDF header tag
    private static class PDFReportHeader implements ReportHeader {
        private String title;
        
        public PDFReportHeader(String title) {
            this.title = title;
        }
        
        @Override
        public void setTitle(String title) {
            this.title = title;
        }
        
        @Override
        public String render() {
            return "<HEADER> " + (title != null ? title : "Report") + " </HEADER>";
        }
    }
    
    // [ADHAM] - PDF Footer: Shows page number
    private static class PDFReportFooter implements ReportFooter {
        private int pageNumber;
        
        public PDFReportFooter(int pageNumber) {
            this.pageNumber = pageNumber;
        }
        
        @Override
        public void setPageNumber(int n) {
            this.pageNumber = n;
        }
        
        @Override
        public String render() {
            return "<FOOTER> Page " + pageNumber + " </FOOTER>";
        }
    }
    
    // [ADHAM] - PDF Chart: Renders data as text chart
    private static class PDFChartComponent implements ChartComponent {
        private double[] data;
        
        public PDFChartComponent(double[] data) {
            this.data = data;
        }
        
        @Override
        public void setData(double[] values) {
            this.data = values;
        }
        
        @Override
        public String render() {
            if (data == null || data.length == 0) {
                return "[PDF Chart: No data]";
            }
            StringBuilder chart = new StringBuilder("[PDF Chart: ");
            for (double val : data) {
                chart.append(String.format("%.1f ", val));
            }
            chart.append("]");
            return chart.toString();
        }
    }
}
