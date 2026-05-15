package hospitalmanagementsystem.patterns.behavioral.strategy.st2;

/**
 * CreditCardPayment — ConcreteStrategy in Strategy pattern ST2
 * Implements credit card payment processing.
 * Author: Maged
 */
public class CreditCardPayment implements PaymentStrategy {
    private final String lastFourDigits;

    public CreditCardPayment(String lastFourDigits) {
        this.lastFourDigits = lastFourDigits;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Credit card charged: $" + String.format("%.2f", amount) +
                " | Card: ****-" + lastFourDigits);
    }
}
