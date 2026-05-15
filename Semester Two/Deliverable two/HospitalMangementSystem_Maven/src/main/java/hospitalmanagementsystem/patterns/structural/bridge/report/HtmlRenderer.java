package hospitalmanagementsystem.patterns.structural.bridge.report;

public class HtmlRenderer implements ReportRenderer {

    @Override
    public String renderHeader(String title) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>\n");
        sb.append("<head><title>").append(title).append("</title></head>\n");
        sb.append("<body>\n");
        sb.append("  <h1>").append(title).append("</h1>\n");
        sb.append("  <table border=\"1\">\n");
        return sb.toString();
    }

    @Override
    public String renderRow(String[] columns) {
        StringBuilder sb = new StringBuilder();
        sb.append("    <tr>");
        for (String col : columns) {
            sb.append("<td>").append(col).append("</td>");
        }
        sb.append("</tr>\n");
        return sb.toString();
    }

    @Override
    public String renderFooter() {
        StringBuilder sb = new StringBuilder();
        sb.append("  </table>\n");
        sb.append("  <footer><em>Generated as HTML format</em></footer>\n");
        sb.append("</body>\n");
        sb.append("</html>\n");
        return sb.toString();
    }

    @Override
    public String getFormatName() {
        return "HTML";
    }
}
