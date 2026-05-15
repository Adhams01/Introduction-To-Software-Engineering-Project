package hospitalmangementsystem.patterns.abstractfactory;

/**
 * Abstract product: Report footer.
 */
public interface ReportFooter {
    void setPageNumber(int n);
    String render();
}
