package hospitalmanagementsystem.patterns.behavioral.strategy.st2;

import java.util.UUID;

/**
 * Doctor — Domain model for Strategy pattern ST2 demo.
 * Author: Maged
 */
public class Doctor {
    private final String id;
    private final String name;
    private final String specialization;

    public Doctor(String name, String specialization) {
        this.id = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.name = name;
        this.specialization = specialization;
    }

    public String getId() { return id; }
    public String getSpecialization() { return specialization; }

    @Override
    public String toString() {
        return "Dr. " + name + " [" + specialization + "] (" + id + ")";
    }
}
