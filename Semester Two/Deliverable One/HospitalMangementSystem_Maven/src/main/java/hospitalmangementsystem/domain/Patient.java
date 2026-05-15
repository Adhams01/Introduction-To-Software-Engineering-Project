package hospitalmangementsystem.domain;

public class Patient {
    private final String id;
    private final String nationalId;
    private final String name;

    public Patient(String id, String nationalId, String name) {
        this.id = id;
        this.nationalId = nationalId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getName() {
        return name;
    }
}
