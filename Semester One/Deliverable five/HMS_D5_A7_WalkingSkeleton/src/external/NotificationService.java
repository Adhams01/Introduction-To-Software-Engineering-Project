package external;

import java.util.List;

public interface NotificationService {
    void sendConfirmation(String appointmentDetails);

    void sendReminderMessages(List<String> appointments);

    void sendCancellation(String details);
}
