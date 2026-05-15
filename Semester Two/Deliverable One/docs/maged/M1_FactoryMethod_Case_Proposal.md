# M1 — Factory Method Case Proposal (Updated per A2 Frozen Scope)

**Owner:** Maged  
**Pattern:** Factory Method (GoF Creational)  
**Case:** AppointmentFactory  
**Output:** Case statement + justification

---

## Case: AppointmentFactory

### Problem Statement

Appointments in the HMS are currently created using direct instantiation:
```java
new Appointment(id, startTime, status)
```

However, hospitals manage different appointment types with distinct properties:
- **Checkup** – standard 30-minute consultation
- **Surgery** – 2-hour duration with pre-operative preparation
- **Follow-up** – 15-minute short visit linked to previous consultations
- **Emergency** – immediate high-priority appointment

Direct instantiation scatters creation logic across the system and violates the **Open/Closed Principle**, since adding a new appointment type requires modifying existing code throughout the codebase.

### Why Factory Method Pattern

The Factory Method pattern defines an interface for creating an object while allowing subclasses to determine the concrete class (Gamma et al., 1994).

| Criterion | Rationale |
|-----------|-----------|
| **Single Product Variants** | We create one product type (Appointment) with multiple subtypes (Checkup, Surgery, Follow-up, Emergency). Factory Method is designed for this exact scenario. |
| **Decoupling** | Controllers depend only on `AppointmentFactory` interface, not concrete appointment classes. |
| **Extensibility** | Adding a new appointment type (e.g., Telemedicine) requires only a new factory subclass—zero changes to existing controllers. |
| **Encapsulation** | Each factory encapsulates the correct type, duration, and default status for its appointment type. |

**Alternative Rejected — Abstract Factory:**
Abstract Factory is intended for families of different product types created together. We only need to create one product type (Appointment) with variants, so Abstract Factory would be overkill.

**Alternative Rejected — Simple Factory:**
A Simple Factory with if/else logic would centralize creation but still require modification when adding new types, violating Open/Closed Principle.

### GoF Participants

| Role | Class/Interface |
|------|-----------------|
| **Product** | `Appointment` (base class) |
| **Concrete Products** | `CheckupAppointment`, `SurgeryAppointment`, `FollowUpAppointment`, `EmergencyAppointment` |
| **Creator** | `AppointmentFactory` (abstract class) |
| **Concrete Creators** | `CheckupAppointmentFactory`, `SurgeryAppointmentFactory`, `FollowUpAppointmentFactory`, `EmergencyAppointmentFactory` |
| **Client** | `AppointmentController` |

### Insertion Points

1. **Package:** `hospitalmangementsystem.patterns.factory`
2. **Integration:** `AppointmentController` receives factory via constructor
3. **Wiring:** `HospitalMangementSystem.main()` creates appropriate factory

### Build/Run Verification

- `mvn clean compile` passes with zero errors
- Menu option allows creating different appointment types
- Each type shows correct duration and status

---

**Status:** ✅ M1 Complete — Factory Method case approved per A2 frozen scope.
