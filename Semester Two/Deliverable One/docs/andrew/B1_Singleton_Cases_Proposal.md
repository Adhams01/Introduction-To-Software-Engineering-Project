# B1 — Singleton Pattern: 2 Case Proposals

## Singleton Case #1: NotificationServiceSingleton

### Problem Statement
In the current HMS codebase, a `SimpleNotificationService` instance is created via `new` in the main class and passed manually to every controller that needs it (e.g., `AppointmentController`). As the system grows, multiple modules (appointment cancellation, appointment confirmation, reminder scheduling) will each require access to the notification service. Without a centralized access point, the following problems arise:

- **Duplicate instances**: Different parts of the application may independently create their own `SimpleNotificationService`, leading to duplicated log streams, inconsistent notification formatting, and wasted resources.
- **Configuration drift**: If the notification service requires runtime configuration (e.g., SMTP settings, rate limits), each instance would need to be configured separately — a maintenance burden and a source of bugs.
- **Tight coupling to wiring code**: Every new controller or module that needs notifications must receive the service via constructor injection from the main class, making the wiring code increasingly complex.

### Justification — Why Singleton?
| Criterion | Rationale |
|-----------|-----------|
| **Single shared resource** | The notification channel (console output, future email/SMS gateway) is inherently a single shared resource. Exactly one instance should coordinate all outbound messages. |
| **Global access point** | Singleton provides `NotificationServiceSingleton.getInstance()` — any layer that needs to send a notification can obtain the same instance without constructor threading. |
| **Lazy initialization** | The Singleton is created only when first requested, saving resources if the notification feature is never invoked in a particular run. |
| **Thread safety** | Using double-checked locking with a `volatile` field ensures thread-safe lazy initialization, even in a future multi-threaded environment. |
| **Alternative rejected — new instance per call** | Creating a fresh `SimpleNotificationService` each time wastes memory and loses any accumulated state (e.g., a send counter or rate limiter). |
| **Testability tradeoff** | To keep testability, controllers still depend on the `NotificationService` interface (not the Singleton class directly). The Singleton is used at composition/wiring time in `main()` to provide the shared instance — controllers remain mockable and unit-testable. |

### Insertion Point
- **Package**: `hospitalmangementsystem.patterns.singleton`
- **Class**: `NotificationServiceSingleton`
- **Wraps**: `hospitalmangementsystem.external.NotificationService` interface
- **Consumed by**: `AppointmentController`, `ReminderController`, and any future controller needing notifications

---

## Singleton Case #2: PatientRegistrySingleton

### Problem Statement
The HMS creates a `PatientDAO` in the main class and passes it to `PatientController`. However, patient lookup is a cross-cutting concern — appointment booking needs to verify a patient exists, billing needs patient details, discharge needs patient records. Currently:

- **No central registry**: Each module that needs patient data must receive a `PatientDAO` reference, leading to long constructor chains.
- **No caching**: Every patient lookup hits the DAO's array scan from scratch, even for recently accessed patients.
- **Data inconsistency risk**: If two controllers hold separate DAO references (possible in a refactored codebase), updates in one may not be visible to the other.

### Justification — Why Singleton?
| Criterion | Rationale |
|-----------|-----------|
| **Single source of truth** | A `PatientRegistrySingleton` guarantees all modules read and write to exactly one patient store, eliminating stale-data bugs. |
| **Global access** | Any controller or service can call `PatientRegistrySingleton.getInstance()` to look up or register patients without needing a DAO reference threaded through constructors. |
| **Caching opportunity** | The Singleton can maintain a lookup map (nationalId → Patient) on top of the underlying DAO, providing O(1) lookups for recently registered patients. |
| **Alternative rejected — static utility class** | A static utility class cannot implement an interface, cannot be lazily initialized, and cannot be replaced with a mock for testing. Singleton preserves object-oriented flexibility. |

### Insertion Point
- **Package**: `hospitalmangementsystem.patterns.singleton`
- **Class**: `PatientRegistrySingleton`
- **Wraps**: `hospitalmangementsystem.dao.PatientDAO`
- **Consumed by**: `PatientController`, `AppointmentController`, `BillingBatchController`, `DischargeController`

---