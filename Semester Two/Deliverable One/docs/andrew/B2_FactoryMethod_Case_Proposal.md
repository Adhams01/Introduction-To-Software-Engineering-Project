# B2 — Factory Method Pattern: 1 Case Proposal

## Factory Method Case: AppointmentFactory

### Problem Statement
In the current HMS codebase, appointments are created directly using `new Appointment(id, startTime, status)` inside the main class's `seedAppointments()` method and potentially in controllers. All appointments are treated identically regardless of their clinical nature. In a real hospital, however, different appointment types have fundamentally different characteristics:

- **Checkup appointments**: standard 30-minute slots, no special equipment, general practitioner.
- **Surgery appointments**: require operating room allocation, anesthesiology team, extended duration (2–4 hours), and mandatory pre-operative checks.
- **Follow-up appointments**: shorter duration (15 minutes), linked to a previous appointment, same doctor required.
- **Emergency appointments**: no advance scheduling, highest priority, override existing slots.

Currently, the code has no mechanism to encapsulate these differences. Adding a new appointment type requires modifying every place that creates an `Appointment` object, violating the **Open/Closed Principle**.

### Justification — Why Factory Method?
| Criterion | Rationale |
|-----------|-----------|
| **Encapsulates creation logic** | Each appointment type has different validation rules, default durations, and required fields. The Factory Method moves this logic into dedicated factory subclasses, keeping controllers clean. |
| **Open/Closed Principle** | Adding a new appointment type (e.g., `Telemedicine`) requires only a new factory subclass — no changes to existing code. |
| **Decouples client from concrete class** | Controllers call `factory.createAppointment(...)` and receive an `Appointment` object. They don't need to know which concrete subtype was created. |
| **Single Responsibility** | The creation logic (validation, default values, type-specific rules) is separated from the business logic (booking, cancelling, confirming). |
| **Alternative rejected — Simple if/else in controller** | An `if/else` chain in the controller to create different appointment types would grow with every new type, making the controller bloated and fragile. |
| **Alternative rejected — Abstract Factory** | Abstract Factory creates *families* of related objects. Here we create a *single product* (an Appointment) with varying subtypes — Factory Method is the precise fit. |

### Concrete Design — Full GoF Structure (4 Participants)

**Product hierarchy** (GoF participants 1 & 2):
- **Product** (abstract base): `Appointment` — the existing domain class, extended with `protected` fields `type` and `durationMinutes` so subclasses can specialize.
- **ConcreteProduct** subclasses (in `patterns.factory`):
  - `CheckupAppointment extends Appointment` — type="CHECKUP", durationMinutes=30, status=SCHEDULED.
  - `SurgeryAppointment extends Appointment` — type="SURGERY", durationMinutes=240, status=PRE_OP_PENDING.
  - `FollowUpAppointment extends Appointment` — type="FOLLOW_UP", durationMinutes=15, status=SCHEDULED.

**Creator hierarchy** (GoF participants 3 & 4):
- **Creator** (abstract): `AppointmentFactory` — declares `createAppointment(String id, String startTime)` returning `Appointment`.
- **ConcreteCreator** subclasses:
  - `CheckupAppointmentFactory` — overrides `createAppointment()` to return a `CheckupAppointment`.
  - `SurgeryAppointmentFactory` — overrides `createAppointment()` to return a `SurgeryAppointment`.
  - `FollowUpAppointmentFactory` — overrides `createAppointment()` to return a `FollowUpAppointment`.

Each ConcreteCreator is paired with exactly one ConcreteProduct. The client (`AppointmentController`) programs against the abstract `AppointmentFactory` and receives `Appointment` — it never references a concrete subtype directly.

### Insertion Point
- **Package**: `hospitalmangementsystem.patterns.factory`
- **Creator classes**: `AppointmentFactory` (abstract), `CheckupAppointmentFactory`, `SurgeryAppointmentFactory`, `FollowUpAppointmentFactory`
- **Product classes**: `CheckupAppointment`, `SurgeryAppointment`, `FollowUpAppointment` (all extend `Appointment` from `domain`)
- **Consumed by**: `AppointmentController` (or a booking service that selects the appropriate factory based on user input)