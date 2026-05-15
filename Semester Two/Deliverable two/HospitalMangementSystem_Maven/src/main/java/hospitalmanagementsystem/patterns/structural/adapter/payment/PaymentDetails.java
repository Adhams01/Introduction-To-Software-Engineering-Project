package hospitalmanagementsystem.patterns.structural.adapter.payment;

/**
 * AD2 — Payment Details Data Class
 * 
 * Holds payment information for processing through the
 * payment gateway adapter.
 * 
 * Structural Pattern: Adapter
 * Owner: Yassin
 * Deliverable: #2
 */
public class PaymentDetails {
    
    private final String patientId;
    private final double amount;
    private final String currency;
    private final String paymentMethod;
    private final String cardNumber;
    private final String expiryDate;
    private final String cvv;
    private final String billingAddress;
    
    public PaymentDetails(String patientId, double amount, String currency, 
                         String paymentMethod, String cardNumber, 
                         String expiryDate, String cvv, String billingAddress) {
        this.patientId = patientId;
        this.amount = amount;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.billingAddress = billingAddress;
    }
    
    // Getters
    public String getPatientId() { return patientId; }
    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getCardNumber() { return cardNumber; }
    public String getExpiryDate() { return expiryDate; }
    public String getCvv() { return cvv; }
    public String getBillingAddress() { return billingAddress; }
    
    /**
     * Masks card number for security display
     */
    public String getMaskedCardNumber() {
        if (cardNumber == null || cardNumber.length() < 4) {
            return "****";
        }
        return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }
}
