package hospitalmanagementsystem.patterns.structural.adapter.payment;

/**
 * AD2 — Target Interface for Payment Gateway Adapter
 * 
 * Defines the interface that the Hospital Management System expects
 * for payment processing operations.
 * 
 * Structural Pattern: Adapter
 * Owner: Yassin
 * Deliverable: #2
 */
public interface PaymentService {
    
    /**
     * Process a payment transaction
     * @param details the payment details
     * @return the payment result
     */
    PaymentResult processPayment(PaymentDetails details);
    
    /**
     * Refund a previous payment
     * @param transactionId the transaction to refund
     * @param amount the amount to refund
     * @return the refund result
     */
    RefundResult processRefund(String transactionId, double amount);
    
    /**
     * Validate payment details without processing
     * @param details the payment details to validate
     * @return true if valid, false otherwise
     */
    boolean validatePaymentDetails(PaymentDetails details);
}
