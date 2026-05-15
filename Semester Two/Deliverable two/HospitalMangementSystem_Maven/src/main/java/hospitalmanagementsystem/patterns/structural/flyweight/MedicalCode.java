package hospitalmanagementsystem.patterns.structural.flyweight;

/**
 * Purpose: Represents the Flyweight object holding shared intrinsic state 
 * for a medical code or medication item.
 * Owner: [MAGED]
 */
public class MedicalCode {
    // Intrinsic state (shared, immutable)
    private final String code;
    private final String name;
    private final String description;

    public MedicalCode(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "MedicalCode[code=" + code + ", name=" + name + "]";
    }
}
