package hospitalmanagementsystem.patterns.behavioral.strategy.st1;

public class BillingContext {

    private final String patientId;
    private final double baseAmount;
    private final boolean hasInsurance;
    private final int patientAge;

    public BillingContext(String patientId, double baseAmount, boolean hasInsurance, int patientAge) {
        this.patientId = patientId;
        this.baseAmount = baseAmount;
        this.hasInsurance = hasInsurance;
        this.patientAge = patientAge;
    }

    public String getPatientId() {
        return patientId;
    }

    public double getBaseAmount() {
        return baseAmount;
    }

    public boolean hasInsurance() {
        return hasInsurance;
    }

    public int getPatientAge() {
        return patientAge;
    }
}
