# M3 — Report Section: Factory Method (AppointmentFactory)

**Owner:** Maged  
**Pattern:** Factory Method (GoF Creational)  
**Case:** AppointmentFactory  
**Output:** Report section with case description, justification, UML reference, and implementation

---

## 1. Case Description and Problem Statement

The Hospital Management System creates appointments using direct instantiation:
```java
new Appointment(id, startTime, status)
```

However, hospitals manage different appointment types with distinct properties:
- **Checkup** – standard 30-minute consultation
- **Surgery** – 2-hour duration with pre-operative preparation
- **Follow-up** – 15-minute short visit linked to previous consultations
- **Emergency** – immediate high-priority appointment

Direct instantiation scatters creation logic across the system. Adding a new appointment type requires modifying multiple locations, violating the **Open/Closed Principle**.

## 2. Why Factory Method Pattern Solves This Problem

The Factory Method pattern defines an interface for creating an object while allowing subclasses to determine the concrete class (Gamma et al., 1994).

**Key Benefits:**

| Criterion | Rationale |
|-----------|-----------|
| **Single Product Variants** | We create one product type (Appointment) with multiple subtypes. Factory Method is designed for this exact scenario. |
| **Decoupling** | Controllers depend only on `AppointmentFactory` interface, not concrete appointment classes. |
| **Extensibility** | Adding a new type (e.g., Telemedicine) requires only a new factory subclass—zero changes to existing code. |
| **Encapsulation** | Each factory encapsulates correct type, duration, and default status. |

**Alternative Rejected — Abstract Factory:**
Abstract Factory is for families of different product types. We only need one product type with variants, so it would be overkill.

**Alternative Rejected — Simple Factory:**
If/else logic would require modification when adding new types, violating Open/Closed Principle.

## 3. UML Class Diagram

Refer to `AppointmentFactory.png` (rendered from PlantUML).

The diagram shows the four GoF participants:

**Product Hierarchy:**
- `Appointment` (abstract base class in `hospitalmangementsystem.domain`)
- `CheckupAppointment` – 30-minute standard visit
- `SurgeryAppointment` – 2-hour procedure
- `FollowUpAppointment` – 15-minute revisit
- `EmergencyAppointment` – 1-hour urgent care

**Creator Hierarchy:**
- `AppointmentFactory` (abstract creator in `hospitalmangementsystem.patterns.factory`)
  - `createAppointment(id, patientId, startTime): Appointment`
  - `bookAppointment(...)`: Template method using factory method
- `CheckupAppointmentFactory` – creates Checkup appointments
- `SurgeryAppointmentFactory` – creates Surgery appointments
- `FollowUpAppointmentFactory` – creates Follow-up appointments
- `EmergencyAppointmentFactory` – creates Emergency appointments

**Client:**
- `AppointmentController` uses only abstract `AppointmentFactory`

Key structural properties:
- Abstract factory method declared in creator
- Each concrete factory creates matching product
- Client depends only on abstractions
- Template method provides common booking logic

## 4. Implementation

**Package:** `hospitalmangementsystem.patterns.factory`

**Key Classes:**

```java
// Abstract Creator
public abstract class AppointmentFactory {
    public abstract Appointment createAppointment(String id, String patientId, String startTime);
    
    // Template method using factory method
    public Appointment bookAppointment(String id, String patientId, String startTime) {
        Appointment appointment = createAppointment(id, patientId, startTime);
        System.out.println("[Factory Method] Booked: " + appointment.getType() + 
                          " (Duration: " + appointment.getDurationMinutes() + " mins)");
        return appointment;
    }
}

// Concrete Creator
public class CheckupAppointmentFactory extends AppointmentFactory {
    @Override
    public Appointment createAppointment(String id, String patientId, String startTime) {
        return new CheckupAppointment(id, patientId, startTime);
    }
}

// Concrete Product
public class CheckupAppointment extends Appointment {
    @Override
    public String getType() { return "CHECKUP"; }
    
    @Override
    public int getDurationMinutes() { return 30; }
}
```

**Integration:**
- `AppointmentController` receives factory via constructor
- `HospitalMangementSystem.main()` creates appropriate factory
- Menu option added: "Schedule [Checkup/Surgery/Follow-up/Emergency] Appointment"

## 5. Build and Run Evidence

**Build Verification:**
```
NetBeans → HospitalMangementSystem_Maven → Clean and Build

[INFO] --- maven-compiler-plugin:3.13.0:compile ---
[INFO] Compiling 25 source files
[INFO] BUILD SUCCESS
```

**Test Flow:**
1. Select option "Schedule Appointment"
2. Choose appointment type: Checkup
3. Enter patient ID and datetime
4. Verify output shows: `[Factory Method] Booked: CHECKUP (Duration: 30 mins)`
5. Repeat for Surgery (120 mins), Follow-up (15 mins), Emergency (60 mins)

**Screenshots:** Located in `evidence/maged-factory-method/`

---

**Pattern Case:** Factory Method — AppointmentFactory  
**Owner:** Maged  
**Status:** Complete and integrated  
**A3 Compliance:** Package `hospitalmangementsystem.patterns.factory` ✓
