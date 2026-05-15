package hospitalmangementsystem.patterns.abstractfactory;

// [ADHAM] - Abstract Factory Case #1: ReportAbstractFactory
// Creates families of related report components (PDF, CSV, HTML)
// Each format has: Document + Header + Footer + Chart that all work together

/**
 * Abstract Factory interface for report generation.
 * Different formats (PDF, CSV, HTML) need compatible components.
 * This ensures PDF factory only makes PDF parts - no mixing formats!
 */
public interface ReportFactory {
    
    // [ADHAM] - Create the main document for this report format
    ReportDocument createReportDocument();
    
    // [ADHAM] - Create the header section for this report format
    ReportHeader createReportHeader(String title);
    
    // [ADHAM] - Create the footer section for this report format
    ReportFooter createReportFooter(int pageNum);
    
    // [ADHAM] - Create a chart component for this report format
    ChartComponent createChart(double[] data);
}
