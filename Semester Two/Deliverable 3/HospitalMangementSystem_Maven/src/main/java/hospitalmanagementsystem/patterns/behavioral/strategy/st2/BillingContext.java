package hospitalmanagementsystem.patterns.behavioral.strategy.st2;

import java.util.ArrayList;
import java.util.List;

/**
 * BillingContext — Context class in Strategy pattern ST2
 * Manages patients, doctors, appointments and processes billing using strategies.
 * Author: Maged
 */
public class BillingContext {
    private final List<Patient> patients = new ArrayList<>();
    private final List<Doctor> doctors = new ArrayList<>();
    private final List<Appointment> appointments = new ArrayList<>();

    public void registerPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient registered: " + patient);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added: " + doctor);
    }

    public Appointment scheduleAppointment(Patient patient, Doctor doctor, String dateTime) {
        Appointment appt = new Appointment(patient, doctor, dateTime);
        appointments.add(appt);
        System.out.println("Appointment scheduled: " + appt);
        return appt;
    }

    public void processBilling(double amount, PaymentStrategy strategy) {
        if (amount <= 0) {
            System.err.println("Invalid billing amount.");
            return;
        }
        System.out.println("Processing billing...");
        strategy.processPayment(amount);
    }

    public List<Appointment> getAppointmentsByDoctor(Doctor doctor) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getDoctor().getId().equals(doctor.getId())) {
                result.add(a);
            }
        }
        return result;
    }

    public void displaySystemOverview() {
        System.out.println("\n=== HOSPITAL SYSTEM OVERVIEW ===");
        System.out.println("Patients: " + patients.size());
        System.out.println("Doctors:  " + doctors.size());
        System.out.println("Appointments: " + appointments.size());
        System.out.println("================================\n");
    }
}
