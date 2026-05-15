package hospitalmanagementsystem.patterns.structural.bridge.report;

public abstract class Report {

    protected ReportRenderer renderer;

    public Report(ReportRenderer renderer) {
        this.renderer = renderer;
    }

    /**
     * Allows switching the renderer at runtime without changing the report.
     *
     * @param renderer the new renderer to use
     */
    public void setRenderer(ReportRenderer renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("Renderer cannot be null");
        }
        this.renderer = renderer;
    }


    /**
     * Returns the current renderer.
     *
     * @return the active ReportRenderer
     */
    public ReportRenderer getRenderer() {
        return this.renderer;
    }

   
    public abstract String generate();


    public abstract String getTitle();
}
