package hospitalmanagementsystem.patterns.structural.flyweight;

/**
 * Purpose: Context class holding the extrinsic state specific to a patient's usage 
 * of a MedicalCode, along with a reference to the shared MedicalCode flyweight.
 * Owner: [MAGED]
 */
public class MedicalCodeContext {
    // Extrinsic state (unique per usage)
    private final String patientName;
    private final String usageDate;
    private final String dosage;
    private final String notes;

    // Reference to the shared Flyweight
    private final MedicalCode medicalCode;

    public MedicalCodeContext(String patientName, String usageDate, String dosage, 
                              String notes, MedicalCode medicalCode) {
        this.patientName = patientName;
        this.usageDate = usageDate;
        this.dosage = dosage;
        this.notes = notes;
        this.medicalCode = medicalCode;
    }

    public void processUsage() {
        System.out.println("Processing Usage for Patient: " + patientName);
        System.out.println(" - Date: " + usageDate);
        System.out.println(" - Medical Code: " + medicalCode.getCode() + " (" + medicalCode.getName() + ")");
        System.out.println(" - Dosage: " + dosage);
        System.out.println(" - Notes: " + notes);
        System.out.println(" - [Shared Object Reference Hash: " + System.identityHashCode(medicalCode) + "]\n");
    }
}
