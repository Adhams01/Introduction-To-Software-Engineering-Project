package hospitalmangementsystem.patterns.abstractfactory;

// [ADHAM] - Concrete Factory: CSV Report Family
// Creates all CSV-compatible parts: Document + Header + Footer + Chart
// CSV format uses commas for spreadsheets and data analysis

import java.util.ArrayList;
import java.util.List;

public class CSVReportFactory implements ReportFactory {
    
    // [ADHAM] - Creates the main CSV document container
    @Override
    public ReportDocument createReportDocument() {
        return new CSVReportDocument();
    }
    
    // [ADHAM] - Creates a CSV-formatted header (uses # for comments)
    @Override
    public ReportHeader createReportHeader(String title) {
        return new CSVReportHeader(title);
    }
    
    // [ADHAM] - Creates a CSV-formatted footer (shows row count)
    @Override
    public ReportFooter createReportFooter(int pageNum) {
        return new CSVReportFooter(pageNum);
    }
    
    // [ADHAM] - Creates a CSV-compatible chart (data as CSV rows)
    @Override
    public ChartComponent createChart(double[] data) {
        return new CSVChartComponent(data);
    }
    
    // ===== CSV Product Family implementations =====
    
    // [ADHAM] - CSV Document: Stores data as rows of comma-separated values
    private static class CSVReportDocument implements ReportDocument {
        private final List<String[]> rows = new ArrayList<>();
        
        // [ADHAM] - Add a section as a CSV row (escapes commas)
        @Override
        public void addSection(String title, String content) {
            rows.add(new String[]{title, content.replace(",", ";")});
        }
        
        // [ADHAM] - Generate CSV format: header row + data rows
        @Override
        public byte[] generate() {
            StringBuilder csv = new StringBuilder();
            csv.append("Title,Content\n");
            for (String[] row : rows) {
                csv.append(row[0]).append(",").append(row[1]).append("\n");
            }
            return csv.toString().getBytes();
        }
        
        // [ADHAM] - Returns MIME type for CSV
        @Override
        public String getContentType() {
            return "text/csv";
        }
    }
    
    // [ADHAM] - CSV Header: Uses # for comment style header
    private static class CSVReportHeader implements ReportHeader {
        private String title;
        
        public CSVReportHeader(String title) {
            this.title = title;
        }
        
        @Override
        public void setTitle(String title) {
            this.title = title;
        }
        
        @Override
        public String render() {
            return "# " + (title != null ? title : "Report");
        }
    }
    
    // [ADHAM] - CSV Footer: Shows total row count
    private static class CSVReportFooter implements ReportFooter {
        private int rowCount;
        
        public CSVReportFooter(int rowCount) {
            this.rowCount = rowCount;
        }
        
        @Override
        public void setPageNumber(int n) {
            this.rowCount = n;
        }
        
        @Override
        public String render() {
            return "# Total rows: " + rowCount;
        }
    }
    
    // [ADHAM] - CSV Chart: Data formatted as CSV rows
    private static class CSVChartComponent implements ChartComponent {
        private double[] data;
        
        public CSVChartComponent(double[] data) {
            this.data = data;
        }
        
        @Override
        public void setData(double[] values) {
            this.data = values;
        }
        
        @Override
        public String render() {
            if (data == null || data.length == 0) {
                return "chart,data";
            }
            StringBuilder csv = new StringBuilder("chart,value\n");
            for (int i = 0; i < data.length; i++) {
                csv.append(i).append(",").append(data[i]).append("\n");
            }
            return csv.toString();
        }
    }
}
