package hospitalmanagementsystem.patterns.behavioral.strategy.st2;

/**
 * CashPayment — ConcreteStrategy in Strategy pattern ST2
 * Implements cash payment processing.
 * Author: Maged
 */
public class CashPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Cash payment processed: $" + String.format("%.2f", amount));
    }
}
