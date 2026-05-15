package hospitalmanagementsystem.patterns.structural.decorator.report;

/**
 * DC1 — Base Report (Concrete Component)
 * 
 * The basic report implementation that can be decorated with
 * additional features like headers, footers, and watermarks.
 * 
 * Structural Pattern: Decorator
 * Owner: Adham
 * Deliverable: #2
 */
public class BaseReport implements ReportComponent {
    
    private final String title;
    private final String description;
    private final String content;
    
    /**
     * Constructs a base report with the given details.
     * 
     * @param title report title
     * @param description report description
     * @param content main report content
     */
    public BaseReport(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }
    
    @Override
    public String generate() {
        StringBuilder sb = new StringBuilder();
        sb.append("Report: ").append(title).append("\n");
        sb.append("Description: ").append(description).append("\n");
        sb.append("========================================\n");
        sb.append(content).append("\n");
        sb.append("========================================\n");
        return sb.toString();
    }
    
    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
}
