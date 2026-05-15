package hospitalmangementsystem.patterns.abstractfactory.ui;

// [ADHAM] - Concrete Factory: Console UI Family
// Creates ASCII/text components for standard terminal output
// Console menu, input prompts, buttons as [LABEL], and line dividers

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUIFactory implements UIComponentFactory {
    
    // [ADHAM] - Creates a console menu (numbered options)
    @Override
    public MenuComponent createMenu(String title) {
        return new ConsoleMenu(title);
    }
    
    // [ADHAM] - Creates a console input prompt (label + hint)
    @Override
    public InputComponent createInput(String label, String hint) {
        return new ConsoleInput(label, hint);
    }
    
    // [ADHAM] - Creates a console button ([LABEL] format)
    @Override
    public ButtonComponent createButton(String label, String action) {
        return new ConsoleButton(label, action);
    }
    
    // [ADHAM] - Creates a console divider (dashed line)
    @Override
    public DividerComponent createDivider() {
        return new ConsoleDivider();
    }
    
    // ===== Console Product Family implementations =====
    
    // [ADHAM] - Console Menu: Shows title + numbered options
    private static class ConsoleMenu implements MenuComponent {
        private final String title;
        private final List<String> options = new ArrayList<>();
        
        public ConsoleMenu(String title) {
            this.title = title;
        }
        
        // [ADHAM] - Add numbered option to menu
        @Override
        public void addOption(String key, String description) {
            options.add(key + ") " + description);
        }
        
        // [ADHAM] - Render as text menu with border
        @Override
        public String render() {
            StringBuilder menu = new StringBuilder();
            menu.append("\n=== ").append(title).append(" ===\n");
            for (String option : options) {
                menu.append("  ").append(option).append("\n");
            }
            return menu.toString();
        }
        
        // [ADHAM] - Read user choice from console
        @Override
        public String captureSelection(Scanner scanner) {
            System.out.print("Choose: ");
            return scanner.nextLine().trim();
        }
    }
    
    // [ADHAM] - Console Input: Prompt with optional hint
    private static class ConsoleInput implements InputComponent {
        private String label;
        private String hint;
        
        public ConsoleInput(String label, String hint) {
            this.label = label;
            this.hint = hint;
        }
        
        @Override
        public void setPrompt(String label) {
            this.label = label;
        }
        
        @Override
        public void setHint(String hint) {
            this.hint = hint;
        }
        
        // [ADHAM] - Render as "Label (hint): "
        @Override
        public String render() {
            return label + (hint != null ? " (" + hint + ")" : "") + ": ";
        }
        
        // [ADHAM] - Display prompt and read user input
        @Override
        public String captureInput(Scanner scanner) {
            System.out.print(render());
            return scanner.nextLine().trim();
        }
    }
    
    // [ADHAM] - Console Button: Renders as [LABEL]
    private static class ConsoleButton implements ButtonComponent {
        private String label;
        private String action;
        
        public ConsoleButton(String label, String action) {
            this.label = label;
            this.action = action;
        }
        
        @Override
        public void setLabel(String label) {
            this.label = label;
        }
        
        @Override
        public void setAction(String action) {
            this.action = action;
        }
        
        // [ADHAM] - Render as [Label] brackets
        @Override
        public String render() {
            return "[" + (label != null ? label : "Button") + "]";
        }
        
        // [ADHAM] - Trigger the button action
        @Override
        public void trigger() {
            System.out.println("Action triggered: " + action);
        }
    }
    
    // [ADHAM] - Console Divider: Dashed line separator
    private static class ConsoleDivider implements DividerComponent {
        // [ADHAM] - Render as 40 dashes
        @Override
        public String render() {
            return "----------------------------------------";
        }
    }
}
