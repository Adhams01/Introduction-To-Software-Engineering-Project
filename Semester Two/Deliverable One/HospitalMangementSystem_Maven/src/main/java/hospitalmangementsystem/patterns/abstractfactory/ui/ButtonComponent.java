package hospitalmangementsystem.patterns.abstractfactory.ui;

/**
 * Abstract product: Button component for actionable items.
 */
public interface ButtonComponent {
    void setLabel(String label);
    void setAction(String action);
    String render();
    void trigger();
}
