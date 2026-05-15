package domain;

public class Appointment {
    private final String id;
    private final String patientNationalId;
    private String status;
    private final String details;

    public Appointment(String id, String patientNationalId, String details, String status) {
        this.id = id;
        this.patientNationalId = patientNationalId;
        this.details = details;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getPatientNationalId() {
        return patientNationalId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }
}
