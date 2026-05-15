package hospitalmanagementsystem.patterns.behavioral.observer.os1;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * HospitalEventBus - Thread-safe Singleton implementing the Subject role in the Observer pattern.
 * Uses Bill Pugh Singleton initialization pattern for thread-safe lazy initialization.
 * Author: Maged
 */
public class HospitalEventBus {

    private static class EventBusHolder {
        private static final HospitalEventBus INSTANCE = new HospitalEventBus();
    }

    public static HospitalEventBus getInstance() {
        return EventBusHolder.INSTANCE;
    }

    private HospitalEventBus() {
        if (EventBusHolder.INSTANCE != null) {
            throw new IllegalStateException("Use getInstance() to obtain the singleton instance");
        }
        this.listeners = new CopyOnWriteArrayList<>();
        this.listenerMap = new ConcurrentHashMap<>();
    }

    private final List<WeakReference<EventListener>> listeners;
    private final Map<String, WeakReference<EventListener>> listenerMap;

    public void attachListener(EventListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener cannot be null");
        }
        String listenerId = listener.getListenerId();
        if (listenerMap.containsKey(listenerId)) {
            throw new IllegalArgumentException("Listener with ID " + listenerId + " is already registered");
        }
        WeakReference<EventListener> weakRef = new WeakReference<>(listener);
        listeners.add(weakRef);
        listenerMap.put(listenerId, weakRef);
        System.out.println("[EventBus] Registered listener: " + listenerId);
    }

    public boolean detachListener(String listenerId) {
        WeakReference<EventListener> removed = listenerMap.remove(listenerId);
        if (removed != null) {
            listeners.remove(removed);
            System.out.println("[EventBus] Unregistered listener: " + listenerId);
            return true;
        }
        return false;
    }

    public void publishEvent(HospitalEvent event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
        System.out.println("[EventBus] Publishing event: " + event.getType() + " - " + event.getMessage());
        cleanupGarbageCollectedListeners();
        for (WeakReference<EventListener> weakRef : listeners) {
            EventListener listener = weakRef.get();
            if (listener != null && listener.isInterestedIn(event.getType(), event.getDepartment())) {
                try {
                    listener.onEvent(event);
                } catch (Exception e) {
                    System.err.println("[EventBus] Error notifying listener " + listener.getListenerId() + ": " + e.getMessage());
                }
            }
        }
    }

    private void cleanupGarbageCollectedListeners() {
        listeners.removeIf(ref -> ref.get() == null);
    }

    public int getListenerCount() {
        cleanupGarbageCollectedListeners();
        return listeners.size();
    }

    public void clearAllListeners() {
        listeners.clear();
        listenerMap.clear();
        System.out.println("[EventBus] All listeners cleared");
    }
}
