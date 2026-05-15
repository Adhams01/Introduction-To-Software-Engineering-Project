package hospitalmanagementsystem.patterns.behavioral.strategy.st1;

public class BillingResult {

    private final double originalAmount;
    private final double discountAmount;
    private final double insuranceCoverageAmount;
    private final double finalPayableAmount;
    private final String appliedStrategy;

    public BillingResult(
            double originalAmount,
            double discountAmount,
            double insuranceCoverageAmount,
            double finalPayableAmount,
            String appliedStrategy
    ) {
        this.originalAmount = originalAmount;
        this.discountAmount = discountAmount;
        this.insuranceCoverageAmount = insuranceCoverageAmount;
        this.finalPayableAmount = finalPayableAmount;
        this.appliedStrategy = appliedStrategy;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getInsuranceCoverageAmount() {
        return insuranceCoverageAmount;
    }

    public double getFinalPayableAmount() {
        return finalPayableAmount;
    }

    public String getAppliedStrategy() {
        return appliedStrategy;
    }

    @Override
    public String toString() {
        return "BillingResult{" +
                "originalAmount=" + originalAmount +
                ", discountAmount=" + discountAmount +
                ", insuranceCoverageAmount=" + insuranceCoverageAmount +
                ", finalPayableAmount=" + finalPayableAmount +
                ", appliedStrategy='" + appliedStrategy + '\'' +
                '}';
    }
}
