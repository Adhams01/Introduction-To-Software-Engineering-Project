package hospitalmanagementsystem.patterns.behavioral.strategy.st2;

import java.util.UUID;

/**
 * Patient — Domain model for Strategy pattern ST2 demo.
 * Author: Maged
 */
public class Patient {
    private final String id;
    private final String name;
    private final int age;
    private final String contactInfo;

    public Patient(String name, int age, String contactInfo) {
        this.id = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.name = name;
        this.age = age;
        this.contactInfo = contactInfo;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Patient[" + id + "] " + name + " (Age: " + age + ")";
    }
}
