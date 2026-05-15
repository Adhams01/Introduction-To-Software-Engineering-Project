package hospitalmanagementsystem.patterns.behavioral.strategy.st1;

public interface BillingStrategy {

    BillingResult calculate(BillingContext context);

    String getStrategyName();
}
