# Singleton Case #1 — NotificationServiceSingleton


## 1  Case Description and Problem Statement

The Hospital Management System (HMS) relies on a notification service to inform patients and staff about appointment confirmations, cancellations, and reminders. In the Walking Skeleton baseline, the application's main method inside HospitalMangementSystem.java instantiates a SimpleNotificationService object directly with the new operator and passes it through constructor parameters to every controller that requires notification capabilities, such as AppointmentController.

This design introduces three concrete problems as the system grows.

First, there is a risk of duplicate instances. Without a centralized control point, different modules or future developers may independently create their own SimpleNotificationService objects. Each instance operates in isolation, potentially sending duplicate notifications for the same clinical event and producing inconsistent log output.

Second, configuration becomes fragmented. When the notification channel evolves beyond console output to, for example, SMTP email or an SMS gateway, each independently created instance would need its own configuration. Keeping multiple instances in sync is error-prone and violates the DRY (Don't Repeat Yourself) principle.

Third, the constructor wiring in the main method grows increasingly complex. Every new controller or service that needs notification access must receive the service through its constructor, coupling the main wiring code tightly to the rest of the application and making the main method harder to maintain with every new feature.


## 2  Why This Pattern Solves the Problem

The Singleton creational design pattern ensures that a class has exactly one instance and provides a global point of access to it (Gamma et al., Design Patterns: Elements of Reusable Object-Oriented Software, 1994).

Applied to the notification service, the Singleton resolves each identified problem as follows.

The risk of duplicate instances is eliminated because the private constructor prevents any external code from calling new. The sole instance is created internally on first access through the static getInstance() method.

Configuration fragmentation disappears because there is only one instance. Any configuration (for example, an SMTP host or a rate-limiting window) is applied once and remains consistent across all consumers for the lifetime of the application.

Constructor-wiring complexity is reduced because the shared instance can be obtained at composition time through NotificationServiceSingleton.getInstance() inside main(), and then injected into controllers via their existing constructor parameters. Controllers continue to depend on the NotificationService interface, not on the Singleton class itself. This preserves testability: in a unit-test context, a mock NotificationService can be passed to the controller constructor, completely bypassing the Singleton. The Singleton is therefore used only at wiring time, not scattered across the codebase as a hidden global dependency.

Three alternative designs were considered and rejected.

A static utility class was rejected because it cannot implement the NotificationService interface, cannot be lazily initialized, and cannot be substituted with a mock during testing.

A dependency-injection framework such as Spring was rejected because it would add an external dependency, violating the team's agreed-upon rule that no external dependencies may be introduced without team consensus (A3, Rule 10). The manual Singleton achieves the same goal with zero added dependencies.

Creating a new instance on every use was rejected because it wastes memory and loses any accumulated state, such as a future send counter or rate-limiting window.


## 3  UML Class Diagram

(Refer to the exported diagram Singleton_Case1_NotificationServiceSingleton, produced from the PlantUML source in B3_UML_Diagrams.)

The class diagram shows three classes and one interface, organized across three packages.

In the hospitalmangementsystem.external package, the NotificationService interface declares three methods: sendConfirmation, sendReminderMessages, and sendCancellation. The concrete class SimpleNotificationService in the same package implements this interface by printing formatted messages to the console.

In the hospitalmangementsystem.patterns.singleton package, the NotificationServiceSingleton class also implements the NotificationService interface. It holds a private static volatile field instance of its own type, and a private final field delegate of type NotificationService. The constructor is private, preventing external instantiation. The static method getInstance() provides the sole global access point using double-checked locking. Each interface method (sendConfirmation, sendReminderMessages, sendCancellation) simply forwards the call to the delegate. At construction time the delegate is initialized as a new SimpleNotificationService, but because the field type is the interface, the Singleton is not structurally coupled to the concrete class.

In the hospitalmangementsystem.controller package, AppointmentController depends on the NotificationService interface. It is unaware of whether it receives the Singleton instance or any other implementation, maintaining loose coupling.

The key structural properties of the Singleton are:

The private constructor prevents external instantiation. The static factory method getInstance() is the single global access point. Double-checked locking with a volatile field ensures thread-safe lazy initialization, which is important if the system is extended to a multi-threaded environment. The class is declared final to prevent subclassing, which could otherwise break the single-instance guarantee.


## 4  Implementation

The implementation resides in a single new file:

    HospitalMangementSystem_Maven/
      src/main/java/hospitalmangementsystem/patterns/singleton/
        NotificationServiceSingleton.java

The Singleton infrastructure consists of the volatile static field and the private constructor:

```java
private static volatile NotificationServiceSingleton instance;
private final NotificationService delegate;

private NotificationServiceSingleton() {
    this.delegate = new SimpleNotificationService();
}
```

The getInstance() method uses double-checked locking so that the synchronized block is entered only once during the lifetime of the application:

```java
public static NotificationServiceSingleton getInstance() {
    if (instance == null) {
        synchronized (NotificationServiceSingleton.class) {
            if (instance == null) {
                instance = new NotificationServiceSingleton();
            }
        }
    }
    return instance;
}
```

Each NotificationService method delegates to the internal instance. For example:

```java
@Override
public void sendCancellation(String details) {
    delegate.sendCancellation(details);
}
```

The integration required minimal changes in the application wiring code. Inside the main() method of HospitalMangementSystem.java, the direct instantiation of SimpleNotificationService was replaced with a call to the Singleton:

Before:

```java
NotificationService notificationService = new SimpleNotificationService();
```

After:

```java
NotificationService notificationService =
        NotificationServiceSingleton.getInstance();
```

The Singleton class is fully contained in the patterns.singleton package. No other existing files required structural changes. All controllers continue to receive the notification service through their constructors and depend only on the NotificationService interface, preserving testability.


## 5  Build and Run Evidence

The project was verified using NetBeans Clean and Build. The build completed with zero errors and zero warnings across all source files, including the new NotificationServiceSingleton class.

The application was then launched using NetBeans Run. The HMS main menu appeared as expected:

    === Hospital Management System (Generated from StarUML) ===
    1) UC-02 Register Patient
    2) UC-06 Cancel Appointment
    0) Exit
    Choose:

To verify that the Singleton is correctly wired, option 2 (Cancel Appointment) was selected. After entering a patient national ID and selecting an appointment to cancel, the following output was produced:

    [NotificationService] CANCELLATION: Appointment cancelled: 2025-12-30 10:00 (id=A1)
    SUCCESS: Appointment cancelled (id=A1)

The [NotificationService] prefix is printed by SimpleNotificationService, which is the delegate held by the Singleton. This confirms that the pattern chain is working correctly: HospitalMangementSystem.main() obtains the Singleton, passes it to AppointmentController, and when the controller calls sendCancellation(), the Singleton delegates to the concrete SimpleNotificationService, which prints the message.

(Screenshots of the NetBeans Clean and Build output and the application run are included in the appendix.)
