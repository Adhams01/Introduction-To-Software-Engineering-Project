package hospitalmangementsystem.patterns.abstractfactory;

/**
 * Abstract product: Report header.
 */
public interface ReportHeader {
    void setTitle(String title);
    String render();
}
