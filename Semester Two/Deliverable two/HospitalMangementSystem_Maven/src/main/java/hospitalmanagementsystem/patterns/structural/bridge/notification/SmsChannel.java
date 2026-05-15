package hospitalmanagementsystem.patterns.structural.bridge.notification;

/**
 * SmsChannel — BRIDGE PATTERN BR1 (Deliverable #2)
 * Part of: Software Design & Development - Structural Design Patterns
 * Author: [ADHAM]
 * 
 * Concrete Implementor: Sends notifications via SMS/Text message.
 * Implements NotificationChannel interface for SMS delivery.
 * 
 * Deliverable #2: Bridge Pattern implementation showing mobile text
 * delivery as an alternative channel for all notification types.
 */
public class SmsChannel implements NotificationChannel {
    
    @Override
    public void sendNotification(String message, String notificationType) {
        System.out.println("[SMS] Sending " + notificationType + ": " + message);
        System.out.println("      To: +1-555-123-4567");
        System.out.println("      Text: " + notificationType + " - " + message.substring(0, Math.min(50, message.length())) + "...");
        System.out.println("      Status: ✓ Sent via SMS");
        System.out.println();
    }
}
