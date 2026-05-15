package hospitalmangementsystem.patterns.abstractfactory.ui;

import java.util.Scanner;

/**
 * Abstract product: Menu component for displaying options.
 */
public interface MenuComponent {
    void addOption(String key, String description);
    String render();
    String captureSelection(Scanner scanner);
}
