package hospitalmanagementsystem.patterns.structural.flyweight;

/**
 * Purpose: Client class to demonstrate the Flyweight pattern by reusing 
 * MedicalCode objects across different patient contexts.
 * Owner: [MAGED]
 */
public class MedicalCodeDemo {
    public static void main(String[] args) {
        System.out.println("--- Medical Code Flyweight Demo ---");
        
        MedicalCodeFactory factory = new MedicalCodeFactory();

        // 1. Request a medical code (first time, will be created)
        MedicalCode code1 = factory.getMedicalCode("J18.9", "Pneumonia", "Unspecified pneumonia");
        MedicalCodeContext context1 = new MedicalCodeContext("Alice Smith", "2023-10-01", "N/A", "High fever observed", code1);
        context1.processUsage();

        // 2. Request the SAME medical code (will be reused)
        MedicalCode code2 = factory.getMedicalCode("J18.9", "Pneumonia", "Unspecified pneumonia");
        MedicalCodeContext context2 = new MedicalCodeContext("Bob Jones", "2023-10-02", "N/A", "Mild symptoms", code2);
        context2.processUsage();

        // 3. Request a new medical code (medication)
        MedicalCode code3 = factory.getMedicalCode("MED-001", "Amoxicillin", "Antibiotic 500mg");
        MedicalCodeContext context3 = new MedicalCodeContext("Alice Smith", "2023-10-01", "500mg 3x/day", "Take with food", code3);
        context3.processUsage();

        // 4. Request the SAME medication code again
        MedicalCode code4 = factory.getMedicalCode("MED-001", "Amoxicillin", "Antibiotic 500mg");
        MedicalCodeContext context4 = new MedicalCodeContext("Charlie Brown", "2023-10-03", "250mg 2x/day", "Pediatric dose", code4);
        context4.processUsage();

        System.out.println("Total unique medical codes in factory cache: " + factory.getCacheSize());
        
        // Assert reuse
        if (code1 == code2 && code3 == code4) {
            System.out.println("Success: Medical codes were correctly shared and reused in memory.");
        }
    }
}
