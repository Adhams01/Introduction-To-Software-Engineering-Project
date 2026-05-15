# B3 — UML Class Diagrams for Andrew's Pattern Cases

All diagrams are provided in PlantUML notation for reproducibility.
Export each diagram using any PlantUML renderer (e.g., plantuml.com, StarUML PlantUML plugin, or VS Code PlantUML extension).

---

## 1. Singleton Case #1 — NotificationServiceSingleton

### Rationale
The `NotificationServiceSingleton` wraps the existing `NotificationService` interface and guarantees a single, globally accessible instance. It delegates all notification operations to a concrete `SimpleNotificationService`. Double-checked locking with a `volatile` field is used for thread-safe lazy initialization.

### PlantUML Diagram

```plantuml
@startuml Singleton_Case1_NotificationServiceSingleton

skinparam classAttributeIconSize 0
skinparam packageStyle rectangle

package "hospitalmangementsystem.external" {
    interface NotificationService {
        + sendConfirmation(appointmentDetails : String) : void
        + sendReminderMessages(appointments : List<String>) : void
        + sendCancellation(details : String) : void
    }

    class SimpleNotificationService {
        + sendConfirmation(appointmentDetails : String) : void
        + sendReminderMessages(appointments : List<String>) : void
        + sendCancellation(details : String) : void
    }
}

package "hospitalmangementsystem.patterns.singleton" {
    class NotificationServiceSingleton {
        - {static} instance : NotificationServiceSingleton
        - delegate : NotificationService
        - NotificationServiceSingleton()
        + {static} getInstance() : NotificationServiceSingleton
        + sendConfirmation(appointmentDetails : String) : void
        + sendReminderMessages(appointments : List<String>) : void
        + sendCancellation(details : String) : void
    }
}

package "hospitalmangementsystem.controller" {
    class AppointmentController {
        - appointmentDAO : AppointmentDAO
        - notificationService : NotificationService
        + cancelAppointment(appointmentId : String) : String
        + listUpcomingAppointments(patientNationalId : String) : Appointment[]
    }
}

SimpleNotificationService ..|> NotificationService : implements
NotificationServiceSingleton ..|> NotificationService : implements
NotificationServiceSingleton --> NotificationService : "delegates to\n(constructed as SimpleNotificationService)"
AppointmentController --> NotificationService : "uses"

note right of NotificationServiceSingleton
  **Singleton Pattern**
  - Private constructor prevents external instantiation
  - Static getInstance() returns the sole instance
  - Lazy initialization on first call
  - Implements NotificationService so it can be
    used transparently wherever the interface is expected
end note

@enduml
```

---

## 2. Singleton Case #2 — PatientRegistrySingleton

### Rationale
The `PatientRegistrySingleton` provides a single, globally accessible patient registry that wraps the `PatientDAO`. It adds a `HashMap` cache for O(1) lookups by national ID, ensuring all modules read from and write to the same patient store.

### PlantUML Diagram

```plantuml
@startuml Singleton_Case2_PatientRegistrySingleton

skinparam classAttributeIconSize 0
skinparam packageStyle rectangle

package "hospitalmangementsystem.domain" {
    class Patient {
        - id : String
        - nationalId : String
        - name : String
        + getId() : String
        + getNationalId() : String
        + getName() : String
    }
}

package "hospitalmangementsystem.dao" {
    class PatientDAO {
        - patients : Patient[]
        - count : int
        + findByNationalId(nationalId : String) : Patient
        + saveOrUpdate(patient : Patient) : boolean
        + count() : int
    }
}

package "hospitalmangementsystem.patterns.singleton" {
    class PatientRegistrySingleton {
        - {static} instance : PatientRegistrySingleton
        - patientDAO : PatientDAO
        - cache : HashMap<String, Patient>
        - PatientRegistrySingleton()
        + {static} getInstance() : PatientRegistrySingleton
        + registerPatient(id : String, nationalId : String, name : String) : boolean
        + findByNationalId(nationalId : String) : Patient
        + getPatientCount() : int
    }
}

package "hospitalmangementsystem.controller" {
    class PatientController {
        - patientDAO : PatientDAO
        + registerPatient(nationalId : String, name : String) : String
    }
}

PatientRegistrySingleton --> PatientDAO : "delegates to"
PatientRegistrySingleton --> Patient : "caches"
PatientController --> PatientRegistrySingleton : "can use (alternative to direct DAO)"

note right of PatientRegistrySingleton
  **Singleton Pattern**
  - Private constructor prevents external instantiation
  - Static getInstance() returns the sole instance
  - Internal HashMap provides O(1) cached lookups
  - All modules share the same patient data store
  - Wraps PatientDAO for persistence operations
end note

@enduml
```

---

## 3. Factory Method — AppointmentFactory

### Rationale
The diagram models all **four GoF Factory Method participants**:

1. **Product** — `Appointment` (existing domain class, serves as the abstract product base with `protected` fields `type` and `durationMinutes`).
2. **ConcreteProduct** — `CheckupAppointment`, `SurgeryAppointment`, `FollowUpAppointment` (each extends `Appointment` and hardcodes type-specific defaults: duration, initial status).
3. **Creator** — `AppointmentFactory` (abstract class declaring `createAppointment(id, startTime) : Appointment`).
4. **ConcreteCreator** — `CheckupAppointmentFactory`, `SurgeryAppointmentFactory`, `FollowUpAppointmentFactory` (each overrides `createAppointment()` to instantiate its paired ConcreteProduct).

Each ConcreteCreator is paired 1-to-1 with a ConcreteProduct. The client (`AppointmentController`) programs against the abstract `AppointmentFactory` and abstract `Appointment` — it never references a concrete subtype. Adding a new appointment type (e.g., `TelemedicineAppointment`) requires only a new ConcreteProduct + ConcreteCreator pair with zero changes to existing code, satisfying the Open/Closed Principle.

### PlantUML Diagram

```plantuml
@startuml FactoryMethod_AppointmentFactory

skinparam classAttributeIconSize 0
skinparam packageStyle rectangle

' ===== PRODUCT HIERARCHY (GoF: Product + ConcreteProduct) =====

package "hospitalmangementsystem.domain" {
    class Appointment {
        - appointmentId : String
        - startTime : String
        - status : String
        # type : String
        # durationMinutes : int
        + Appointment(appointmentId : String, startTime : String, status : String)
        + getAppointmentId() : String
        + getStartTime() : String
        + getStatus() : String
        + setStatus(status : String) : void
        + getType() : String
        + getDurationMinutes() : int
    }
}

package "hospitalmangementsystem.patterns.factory" {

    class CheckupAppointment {
        + CheckupAppointment(id : String, startTime : String)
        + getType() : String
        + getDurationMinutes() : int
    }

    class SurgeryAppointment {
        + SurgeryAppointment(id : String, startTime : String)
        + getType() : String
        + getDurationMinutes() : int
    }

    class FollowUpAppointment {
        + FollowUpAppointment(id : String, startTime : String)
        + getType() : String
        + getDurationMinutes() : int
    }

' ===== CREATOR HIERARCHY (GoF: Creator + ConcreteCreator) =====

    abstract class AppointmentFactory {
        + {abstract} createAppointment(id : String, startTime : String) : Appointment
    }

    class CheckupAppointmentFactory {
        + createAppointment(id : String, startTime : String) : Appointment
    }

    class SurgeryAppointmentFactory {
        + createAppointment(id : String, startTime : String) : Appointment
    }

    class FollowUpAppointmentFactory {
        + createAppointment(id : String, startTime : String) : Appointment
    }
}

package "hospitalmangementsystem.controller" {
    class AppointmentController {
        - appointmentDAO : AppointmentDAO
        - notificationService : NotificationService
        + cancelAppointment(appointmentId : String) : String
        + listUpcomingAppointments(patientNationalId : String) : Appointment[]
    }
}

' ===== RELATIONSHIPS =====

' Product hierarchy
Appointment <|-- CheckupAppointment : extends
Appointment <|-- SurgeryAppointment : extends
Appointment <|-- FollowUpAppointment : extends

' Creator hierarchy
AppointmentFactory <|-- CheckupAppointmentFactory : extends
AppointmentFactory <|-- SurgeryAppointmentFactory : extends
AppointmentFactory <|-- FollowUpAppointmentFactory : extends

' Each ConcreteCreator creates its corresponding ConcreteProduct
CheckupAppointmentFactory ..> CheckupAppointment : "<<creates>>"
SurgeryAppointmentFactory ..> SurgeryAppointment : "<<creates>>"
FollowUpAppointmentFactory ..> FollowUpAppointment : "<<creates>>"

' Creator returns abstract Product type
AppointmentFactory ..> Appointment : "returns"

' Client depends on Creator
AppointmentController ..> AppointmentFactory : "uses"

note bottom of AppointmentFactory
  **Factory Method Pattern (GoF)**
  All 4 participants present:
  1. **Product** = Appointment
  2. **ConcreteProduct** = CheckupAppointment,
     SurgeryAppointment, FollowUpAppointment
  3. **Creator** = AppointmentFactory
  4. **ConcreteCreator** = CheckupAppointmentFactory,
     SurgeryAppointmentFactory, FollowUpAppointmentFactory
  Each ConcreteCreator overrides createAppointment()
  to return its matching ConcreteProduct.
  Open/Closed: new type = new subclass pair only.
end note

@enduml
```

---

## Summary Table

| Diagram | Pattern | Package | Key Classes |
|---------|---------|---------|-------------|
| Singleton #1 | Singleton | `patterns.singleton` | `NotificationServiceSingleton` |
| Singleton #2 | Singleton | `patterns.singleton` | `PatientRegistrySingleton` |
| Factory Method | Factory Method | `patterns.factory` | **Creators**: `AppointmentFactory`, `CheckupAppointmentFactory`, `SurgeryAppointmentFactory`, `FollowUpAppointmentFactory`; **Products**: `Appointment` (base, in `domain`), `CheckupAppointment`, `SurgeryAppointment`, `FollowUpAppointment` |

All three diagrams are self-contained and do not overlap with Adham's Abstract Factory UMLs (which target `patterns.abstractfactory`).
