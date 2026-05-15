package hospitalmanagementsystem.patterns.behavioral.strategy.st2;

/**
 * InsurancePayment — ConcreteStrategy in Strategy pattern ST2
 * Implements insurance payment processing.
 * Author: Maged
 */
public class InsurancePayment implements PaymentStrategy {
    private final String policyNumber;

    public InsurancePayment(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Insurance claim processed: $" + String.format("%.2f", amount) +
                " | Policy: " + policyNumber);
    }
}
