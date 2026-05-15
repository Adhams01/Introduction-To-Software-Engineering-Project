package hospitalmangementsystem.domain;

public class Appointment {
    private String status;
    private final String appointmentId;
    private final String startTime;

    public Appointment(String appointmentId, String startTime, String status) {
        this.appointmentId = appointmentId;
        this.startTime = startTime;
        this.status = status;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartTime() {
        return startTime;
    }
}
