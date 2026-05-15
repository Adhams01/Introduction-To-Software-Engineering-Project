package hospitalmangementsystem.patterns.abstractfactory.ui;

import java.util.Scanner;

/**
 * Abstract product: Input component for capturing user input.
 */
public interface InputComponent {
    void setPrompt(String label);
    void setHint(String hint);
    String render();
    String captureInput(Scanner scanner);
}
