package hospitalmanagementsystem.patterns.structural.adapter.payment;

/**
 * AD2 — Refund Result Data Class
 * 
 * Holds the result of a refund transaction.
 * 
 * Structural Pattern: Adapter
 * Owner: Yassin
 * Deliverable: #2
 */
public class RefundResult {
    
    private final boolean success;
    private final String refundId;
    private final String originalTransactionId;
    private final double refundAmount;
    private final String message;
    private final String timestamp;
    
    public RefundResult(boolean success, String refundId, String originalTransactionId,
                       double refundAmount, String message) {
        this.success = success;
        this.refundId = refundId;
        this.originalTransactionId = originalTransactionId;
        this.refundAmount = refundAmount;
        this.message = message;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }
    
    // Getters
    public boolean isSuccess() { return success; }
    public String getRefundId() { return refundId; }
    public String getOriginalTransactionId() { return originalTransactionId; }
    public double getRefundAmount() { return refundAmount; }
    public String getMessage() { return message; }
    public String getTimestamp() { return timestamp; }
    
    @Override
    public String toString() {
        return String.format("RefundResult{success=%s, refundId='%s', amount=%.2f}",
                success, refundId, refundAmount);
    }
}
