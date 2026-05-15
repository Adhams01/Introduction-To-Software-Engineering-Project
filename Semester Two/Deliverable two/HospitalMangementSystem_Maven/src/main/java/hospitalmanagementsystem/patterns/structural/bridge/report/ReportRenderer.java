package hospitalmanagementsystem.patterns.structural.bridge.report;


public interface ReportRenderer {

    /**
     * Renders a report header with the given title.
     *
     * @param title the report title
     * @return formatted header string
     */
    String renderHeader(String title);

    /**
     * Renders a single data row from column values.
     *
     * @param columns the column values for this row
     * @return formatted row string
     */
    String renderRow(String[] columns);

    /**
     * Renders the report footer/closing.
     *
     * @return formatted footer string
     */
    String renderFooter();

    /**
     * Returns the name of this output format (e.g., "PDF", "HTML", "CSV").
     *
     * @return format name
     */
    String getFormatName();
}
