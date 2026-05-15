package domain;

public class Patient {
    private final String nationalId;
    private final String name;

    public Patient(String nationalId, String name) {
        this.nationalId = nationalId;
        this.name = name;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getName() {
        return name;
    }
}
