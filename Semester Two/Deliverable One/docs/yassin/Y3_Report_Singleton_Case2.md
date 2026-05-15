# Y3 — Report Section: Singleton Case #2 (PatientRegistrySingleton)

## 1. Case Description and Problem Statement

The Hospital Management System (HMS) manages patient data through a `PatientDAO` that provides basic CRUD operations. In the baseline implementation, every controller that needs patient access receives a `PatientDAO` reference through constructor injection from the main application class.

This design creates three critical problems as the system scales:

**No Central Registry**: Each module (PatientController, AppointmentController, future BillingController, DischargeController) must receive its own DAO reference. This leads to long constructor chains and tight coupling between the wiring code and every consumer.

**No Caching Layer**: Every patient lookup performs a linear scan through the DAO's internal array. For frequently accessed patients (e.g., during appointment booking flows), this wastes compute cycles and creates latency.

**Data Consistency Risk**: If multiple controllers hold separate DAO references in a refactored codebase, updates in one module may not be immediately visible to others, creating stale-data bugs.

## 2. Why Singleton Pattern Solves This Problem

The Singleton creational design pattern ensures a class has exactly one instance and provides a global point of access to it (Gamma et al., 1994).

**Single Source of Truth**: `PatientRegistrySingleton` wraps `PatientDAO` and guarantees all modules interact with exactly one registry instance. All reads and writes flow through the same underlying data store.

**Global Access Point**: Controllers call `PatientRegistrySingleton.getInstance(patientDAO)` to obtain the shared registry without constructor threading. This decouples patient access from the wiring code.

**Caching Opportunity**: The singleton maintains a `HashMap<String, Patient>` cache mapping national IDs to patients. Lookups become O(1) for cached entries versus O(n) array scans.

**Lazy Initialization**: The registry is created only when first requested, saving resources if the patient module is never invoked.

**Alternative Rejected — Static Utility Class**: A static utility cannot implement interfaces, cannot be lazily initialized, and cannot be mocked for testing. Singleton preserves object-oriented flexibility.

## 3. UML Class Diagram

Refer to `PatientRegistrySingleton.png` (exported from StarUML/PlantUML).

The class diagram shows three packages:

**hospitalmangementsystem.domain**: `Patient` class with `id`, `nationalId`, `name` fields.

**hospitalmangementsystem.dao**: `PatientDAO` with `findByNationalId()`, `saveOrUpdate()`, `count()` methods.

**hospitalmangementsystem.patterns.singleton**: `PatientRegistrySingleton` implementing the Singleton pattern:
- Private static volatile `instance` field
- Private constructor taking `PatientDAO`
- Static `getInstance(patientDAO)` with double-checked locking
- `HashMap<String, Patient>` cache for O(1) lookups
- `findByNationalId()`, `saveOrUpdate()`, `count()` methods

The `PatientController` (in `hospitalmangementsystem.controller`) initializes the singleton in its constructor and delegates all patient operations to it.

Key structural properties:
- Private constructor prevents external instantiation
- Static factory method provides global access
- Double-checked locking ensures thread-safe lazy initialization
- Internal cache improves lookup performance

## 4. Implementation

**File Location**: `HospitalMangementSystem_Maven/src/main/java/hospitalmangementsystem/patterns/singleton/PatientRegistrySingleton.java`

**Key Implementation Details**:

```java
// Singleton infrastructure
private static volatile PatientRegistrySingleton instance;
private final PatientDAO patientDAO;
private final Map<String, Patient> cache;

private PatientRegistrySingleton(PatientDAO patientDAO) {
    this.patientDAO = patientDAO;
    this.cache = new HashMap<>();
}

public static PatientRegistrySingleton getInstance(PatientDAO patientDAO) {
    if (instance == null) {
        synchronized (PatientRegistrySingleton.class) {
            if (instance == null) {
                instance = new PatientRegistrySingleton(patientDAO);
            }
        }
    }
    return instance;
}
```

**Integration in PatientController**:

```java
public PatientController(PatientDAO patientDAO) {
    this.patientRegistry = PatientRegistrySingleton.getInstance(patientDAO);
}

public String registerPatient(String nationalId, String name) {
    // ... validation ...
    Patient patient = new Patient(normalizedNationalId, normalizedNationalId, name.trim());
    boolean ok = patientRegistry.saveOrUpdate(patient);
    // ... return result ...
}
```

**Cache Implementation**:

```java
public Patient findByNationalId(String nationalId) {
    String key = nationalId.trim();
    
    // Check cache first (O(1))
    Patient cached = cache.get(key);
    if (cached != null) {
        return cached;
    }
    
    // Fall back to DAO (O(n)) and cache result
    Patient found = patientDAO.findByNationalId(key);
    if (found != null) {
        cache.put(key, found);
    }
    return found;
}
```

## 5. Build and Run Evidence

**Build Verification**:
```
NetBeans → HospitalMangementSystem_Maven → Clean and Build

--- exec-maven-plugin:3.1.0:exec (default-cli) @ HospitalMangementSystem_Maven ---
=== Hospital Management System (Generated from StarUML) ===
1) UC-02 Register Patient
2) UC-06 Cancel Appointment
0) Exit
Choose: 1
Enter National ID: 123456
Enter Name: John Doe
SUCCESS: Patient registered (nationalId=123456)
```

**Test Flow**:
1. Select option 1 (Register Patient)
2. Enter National ID: 123456
3. Enter Name: John Doe
4. Verify success message appears
5. Re-register same patient to test cache hit

**Screenshots**: Located in `evidence/yassin-build-run/`
- `clean-build-success.png`
- `register-patient-flow.png`

---

**Pattern Case**: Singleton Case #2 — PatientRegistrySingleton  
**Owner**: Yassin  
**Status**: Complete and integrated  
**A3 Compliance**: Package `hospitalmangementsystem.patterns.singleton` ✓
