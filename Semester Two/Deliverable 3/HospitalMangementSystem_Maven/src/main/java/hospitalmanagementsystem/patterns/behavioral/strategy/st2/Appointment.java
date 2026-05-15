package hospitalmanagementsystem.patterns.behavioral.strategy.st2;

import java.util.UUID;

/**
 * Appointment — Domain model for Strategy pattern ST2 demo.
 * Author: Maged
 */
public class Appointment {
    private final String id;
    private final Patient patient;
    private final Doctor doctor;
    private final String dateTime;
    private AppointmentStatus status;

    public Appointment(Patient patient, Doctor doctor, String dateTime) {
        this.id = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public void updateStatus(AppointmentStatus status) { this.status = status; }
    public String getId() { return id; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }

    @Override
    public String toString() {
        return "Appointment[" + id + "] | " + patient + " => " + doctor +
                " | Date: " + dateTime + " | Status: " + status;
    }
}
