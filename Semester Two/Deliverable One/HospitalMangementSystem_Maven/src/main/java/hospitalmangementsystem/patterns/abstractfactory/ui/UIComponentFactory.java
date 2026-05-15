package hospitalmangementsystem.patterns.abstractfactory.ui;

// [ADHAM] - Abstract Factory Case #2: UIComponentAbstractFactory
// Creates families of related UI components (Console, Web, Accessible)
// Each theme has: Menu + Input + Button + Divider that all work together

/**
 * Abstract Factory interface for UI components.
 * Different UIs (Console, Web, Accessible) need compatible components.
 * This ensures Console factory only makes ASCII parts - no mixing styles!
 */
public interface UIComponentFactory {
    
    // [ADHAM] - Create a menu component for this UI theme
    MenuComponent createMenu(String title);
    
    // [ADHAM] - Create an input component for this UI theme
    InputComponent createInput(String label, String hint);
    
    // [ADHAM] - Create a button component for this UI theme
    ButtonComponent createButton(String label, String action);
    
    // [ADHAM] - Create a divider component for this UI theme
    DividerComponent createDivider();
}
