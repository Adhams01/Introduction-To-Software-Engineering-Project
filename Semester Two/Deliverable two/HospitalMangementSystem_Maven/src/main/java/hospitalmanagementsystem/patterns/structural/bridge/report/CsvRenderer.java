package hospitalmanagementsystem.patterns.structural.bridge.report;
public class CsvRenderer implements ReportRenderer {

    @Override
    public String renderHeader(String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("# CSV Report: ").append(title).append("\n");
        return sb.toString();
    }

    @Override
    public String renderRow(String[] columns) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columns.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            // Escape commas within column values
            String value = columns[i];
            if (value.contains(",") || value.contains("\"")) {
                value = "\"" + value.replace("\"", "\"\"") + "\"";
            }
            sb.append(value);
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public String renderFooter() {
        return "# End of CSV report\n";
    }

    @Override
    public String getFormatName() {
        return "CSV";
    }
}
