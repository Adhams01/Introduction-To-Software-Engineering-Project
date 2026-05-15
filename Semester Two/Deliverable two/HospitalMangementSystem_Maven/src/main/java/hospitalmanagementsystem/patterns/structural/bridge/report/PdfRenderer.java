package hospitalmanagementsystem.patterns.structural.bridge.report;

public class PdfRenderer implements ReportRenderer {

    @Override
    public String renderHeader(String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("╔══════════════════════════════════════════════════╗\n");
        sb.append("║  PDF REPORT                                      ║\n");
        sb.append("║  Title: ").append(String.format("%-41s", title)).append("║\n");
        sb.append("╠══════════════════════════════════════════════════╣\n");
        return sb.toString();
    }

    @Override
    public String renderRow(String[] columns) {
        StringBuilder sb = new StringBuilder();
        sb.append("║  ");
        for (int i = 0; i < columns.length; i++) {
            if (i > 0) {
                sb.append(" | ");
            }
            sb.append(columns[i]);
        }
        // Pad to fixed widt
        int currentLen = sb.length();
        int targetLen = 51; // width of the box
        if (currentLen < targetLen) {
            sb.append(" ".repeat(targetLen - currentLen));
        }
        sb.append("║\n");
        return sb.toString();
    }

    @Override
    public String renderFooter() {
        StringBuilder sb = new StringBuilder();
        sb.append("╠══════════════════════════════════════════════════╣\n");
        sb.append("║  [Generated as PDF format]                       ║\n");
        sb.append("╚══════════════════════════════════════════════════╝\n");
        return sb.toString();
    }

    @Override
    public String getFormatName() {
        return "PDF";
    }
}
