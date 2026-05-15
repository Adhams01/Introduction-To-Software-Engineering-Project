package hospitalmangementsystem.patterns.abstractfactory;

/**
 * Abstract product: Report document body/content.
 */
public interface ReportDocument {
    void addSection(String title, String content);
    byte[] generate();
    String getContentType();
}
