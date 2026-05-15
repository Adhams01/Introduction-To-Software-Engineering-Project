package external;

import java.util.List;

public class SimpleNotificationService implements NotificationService {
    @Override
    public void sendConfirmation(String appointmentDetails) {
        System.out.println("[NotificationService] CONFIRMATION: " + appointmentDetails);
    }

    @Override
    public void sendReminderMessages(List<String> appointments) {
        System.out.println("[NotificationService] REMINDERS:");
        if (appointments == null || appointments.isEmpty()) {
            System.out.println("(none)");
            return;
        }
        for (String a : appointments) {
            System.out.println("- " + a);
        }
    }

    @Override
    public void sendCancellation(String details) {
        System.out.println("[NotificationService] CANCELLATION: " + details);
    }
}
