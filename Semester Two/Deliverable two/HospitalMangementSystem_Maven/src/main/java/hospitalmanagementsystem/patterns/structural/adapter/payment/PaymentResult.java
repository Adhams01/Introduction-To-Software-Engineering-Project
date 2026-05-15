package hospitalmanagementsystem.patterns.structural.adapter.payment;

/**
 * AD2 — Payment Result Data Class
 * 
 * Holds the result of a payment transaction.
 * 
 * Structural Pattern: Adapter
 * Owner: Yassin
 * Deliverable: #2
 */
public class PaymentResult {
    
    private final boolean success;
    private final String transactionId;
    private final String message;
    private final double amount;
    private final String timestamp;
    private final String status;
    
    public PaymentResult(boolean success, String transactionId, String message, 
                        double amount, String status) {
        this.success = success;
        this.transactionId = transactionId;
        this.message = message;
        this.amount = amount;
        this.timestamp = java.time.LocalDateTime.now().toString();
        this.status = status;
    }
    
    // Getters
    public boolean isSuccess() { return success; }
    public String getTransactionId() { return transactionId; }
    public String getMessage() { return message; }
    public double getAmount() { return amount; }
    public String getTimestamp() { return timestamp; }
    public String getStatus() { return status; }
    
    @Override
    public String toString() {
        return String.format("PaymentResult{success=%s, txId='%s', amount=%.2f, status='%s'}",
                success, transactionId, amount, status);
    }
}
