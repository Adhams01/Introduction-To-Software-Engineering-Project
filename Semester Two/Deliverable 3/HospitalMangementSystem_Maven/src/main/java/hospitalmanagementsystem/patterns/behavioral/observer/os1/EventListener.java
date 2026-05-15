package hospitalmanagementsystem.patterns.behavioral.observer.os1;

/**
 * Interface for the Observer role in the Observer pattern.
 * Author: Maged
 */
public interface EventListener {
    void onEvent(HospitalEvent event);
    String getListenerId();
    boolean isInterestedIn(EventType type, String department);
}
