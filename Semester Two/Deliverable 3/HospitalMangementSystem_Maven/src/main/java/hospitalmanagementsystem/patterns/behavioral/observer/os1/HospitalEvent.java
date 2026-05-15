package hospitalmanagementsystem.patterns.behavioral.observer.os1;

/**
 * Immutable data carrier for hospital events.
 * Author: Maged
 */
public final class HospitalEvent {
    private final EventType type;
    private final String message;
    private final String department;
    private final long timestamp;
    private final String source;

    public HospitalEvent(EventType type, String message, String department, String source) {
        if (type == null) {
            throw new IllegalArgumentException("Event type cannot be null");
        }
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Event message cannot be null or empty");
        }
        this.type = type;
        this.message = message;
        this.department = department != null ? department : "GENERAL";
        this.source = source != null ? source : "UNKNOWN";
        this.timestamp = System.currentTimeMillis();
    }

    public EventType getType() { return type; }
    public String getMessage() { return message; }
    public String getDepartment() { return department; }
    public long getTimestamp() { return timestamp; }
    public String getSource() { return source; }

    @Override
    public String toString() {
        return String.format("[%s] %s | Dept: %s | Source: %s | Time: %d",
                type, message, department, source, timestamp);
    }
}
