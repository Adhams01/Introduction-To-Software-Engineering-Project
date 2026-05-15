package hospitalmangementsystem.patterns.abstractfactory;

// [ADHAM] - Concrete Factory: HTML Report Family
// Creates all HTML-compatible parts: Document + Header + Footer + Chart
// HTML format for web viewing with proper tags

public class HTMLReportFactory implements ReportFactory {
    
    // [ADHAM] - Creates the main HTML document container
    @Override
    public ReportDocument createReportDocument() {
        return new HTMLReportDocument();
    }
    
    // [ADHAM] - Creates an HTML-formatted header (uses <header> tag)
    @Override
    public ReportHeader createReportHeader(String title) {
        return new HTMLReportHeader(title);
    }
    
    // [ADHAM] - Creates an HTML-formatted footer (uses <footer> tag)
    @Override
    public ReportFooter createReportFooter(int pageNum) {
        return new HTMLReportFooter(pageNum);
    }
    
    // [ADHAM] - Creates an HTML-compatible chart (uses <table> for data)
    @Override
    public ChartComponent createChart(double[] data) {
        return new HTMLChartComponent(data);
    }
    
    // ===== HTML Product Family implementations =====
    
    // [ADHAM] - HTML Document: Builds proper HTML structure
    private static class HTMLReportDocument implements ReportDocument {
        private final StringBuilder html = new StringBuilder();
        
        // [ADHAM] - Constructor starts HTML document
        public HTMLReportDocument() {
            html.append("<!DOCTYPE html>\n<html>\n<body>\n");
        }
        
        // [ADHAM] - Add a section with HTML tags
        @Override
        public void addSection(String title, String content) {
            html.append("<section>\n");
            html.append("  <h2>").append(title).append("</h2>\n");
            html.append("  <p>").append(content).append("</p>\n");
            html.append("</section>\n");
        }
        
        // [ADHAM] - Generate final HTML bytes
        @Override
        public byte[] generate() {
            html.append("</body>\n</html>");
            return html.toString().getBytes();
        }
        
        // [ADHAM] - Returns MIME type for HTML
        @Override
        public String getContentType() {
            return "text/html";
        }
    }
    
    // [ADHAM] - HTML Header: Uses semantic <header> and <h1> tags
    private static class HTMLReportHeader implements ReportHeader {
        private String title;
        
        public HTMLReportHeader(String title) {
            this.title = title;
        }
        
        @Override
        public void setTitle(String title) {
            this.title = title;
        }
        
        @Override
        public String render() {
            return "<header><h1>" + (title != null ? title : "Report") + "</h1></header>";
        }
    }
    
    // [ADHAM] - HTML Footer: Uses semantic <footer> tag
    private static class HTMLReportFooter implements ReportFooter {
        private int pageNumber;
        
        public HTMLReportFooter(int pageNumber) {
            this.pageNumber = pageNumber;
        }
        
        @Override
        public void setPageNumber(int n) {
            this.pageNumber = n;
        }
        
        @Override
        public String render() {
            return "<footer><p>Page " + pageNumber + "</p></footer>";
        }
    }
    
    // [ADHAM] - HTML Chart: Renders data as HTML table
    private static class HTMLChartComponent implements ChartComponent {
        private double[] data;
        
        public HTMLChartComponent(double[] data) {
            this.data = data;
        }
        
        @Override
        public void setData(double[] values) {
            this.data = values;
        }
        
        @Override
        public String render() {
            if (data == null || data.length == 0) {
                return "<div class=\"chart\">No data available</div>";
            }
            StringBuilder html = new StringBuilder("<div class=\"chart\">\n");
            html.append("  <table>\n    <tr><th>Index</th><th>Value</th></tr>\n");
            for (int i = 0; i < data.length; i++) {
                html.append("    <tr><td>").append(i).append("</td><td>").append(data[i]).append("</td></tr>\n");
            }
            html.append("  </table>\n</div>");
            return html.toString();
        }
    }
}
