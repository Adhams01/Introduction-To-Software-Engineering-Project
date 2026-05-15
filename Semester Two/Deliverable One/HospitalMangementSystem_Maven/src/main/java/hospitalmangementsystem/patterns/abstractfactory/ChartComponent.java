package hospitalmangementsystem.patterns.abstractfactory;

/**
 * Abstract product: Chart/visualization component.
 */
public interface ChartComponent {
    void setData(double[] values);
    String render();
}
