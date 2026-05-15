package hospitalmangementsystem.patterns.singleton;

// [ADHAM] - Case #1: NotificationServiceSingleton
// This makes sure we only have ONE notification service for the whole app
// Without this, we might send duplicate notifications
// Implemented by Adham Sobhy

import hospitalmangementsystem.external.NotificationService;
import hospitalmangementsystem.external.SimpleNotificationService;
import java.util.List;

/**
 * Singleton class for notification service.
 * Ensures only one instance of the notification service is created.
 */
public final class NotificationServiceSingleton implements NotificationService {
    
    // [ADHAM] - The single instance (starts as null)
    // Volatile keyword ensures thread safety
    private static volatile NotificationServiceSingleton instance;
    
    // [ADHAM] - The real notification service we use
    // Delegate pattern to forward notifications to the actual service
    private final NotificationService delegate;
    
    // [ADHAM] - Private constructor - nobody can make new ones from outside
    // Initializes the delegate notification service
    private NotificationServiceSingleton() {
        this.delegate = new SimpleNotificationService();
    }
    
    // [ADHAM] - Get the single instance (creates it if needed)
    // Uses "double-checked locking" to be thread-safe
    public static NotificationServiceSingleton getInstance() {
        if (instance == null) {                          // First check (no lock)
            synchronized (NotificationServiceSingleton.class) {
                if (instance == null) {                  // Second check (with lock)
                    instance = new NotificationServiceSingleton();
                }
            }
        }
        return instance;                                 // Return the one instance
    }
    
    // [ADHAM] - Forward confirmation to the real service
    // Sends a confirmation notification using the delegate service
    @Override
    public void sendConfirmation(String appointmentDetails) {
        delegate.sendConfirmation(appointmentDetails);
    }
    
    // [ADHAM] - Forward reminders to the real service
    // Sends reminder notifications using the delegate service
    @Override
    public void sendReminderMessages(List<String> appointments) {
        delegate.sendReminderMessages(appointments);
    }
    
    // [ADHAM] - Forward cancellation to the real service
    // Sends a cancellation notification using the delegate service
    @Override
    public void sendCancellation(String details) {
        delegate.sendCancellation(details);
    }
}
