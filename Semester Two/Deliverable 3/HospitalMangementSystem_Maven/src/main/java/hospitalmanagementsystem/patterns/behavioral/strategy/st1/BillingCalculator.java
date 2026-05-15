package hospitalmanagementsystem.patterns.behavioral.strategy.st1;

public class BillingCalculator {

    private BillingStrategy strategy;

    public BillingCalculator(BillingStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(BillingStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("strategy is required");
        }
        this.strategy = strategy;
    }

    public BillingStrategy getStrategy() {
        return strategy;
    }

    public BillingResult calculateFinalBill(BillingContext context) {
        return strategy.calculate(context);
    }
}
