# A2 — Team Implementation Rules

**Owner:** Adham  
**Deadline:** Must complete before anyone starts coding  
**Purpose:** Prevent merge chaos by defining exact package structure, naming, and workflow

---

## Package Structure (Mandatory)

All structural patterns MUST be placed under:
```
src/main/java/hospitalmangementsystem/patterns/structural/
```

### Detailed Package Layout:

```
patterns/
  structural/
    bridge/
      notification/              # BR1: Adham
        Notification.java
        NotificationChannel.java
        EmailChannel.java
        SmsChannel.java
        InAppChannel.java
        AppointmentReminderNotification.java
        BillingAlertNotification.java
        NotificationBridgeDemo.java
      report/                  # BR2: Andrew
        Report.java
        ReportRenderer.java
        PdfRenderer.java
        HtmlRenderer.java
        CsvRenderer.java
        AppointmentScheduleReport.java
        BillingSummaryReport.java
        ReportBridgeDemo.java
    adapter/
      patient/                 # AD1: Andrew
        PatientDataProvider.java
        ExternalPatientSystemApi.java
        ExternalPatientSystemAdapter.java
        PatientAdapterDemo.java
      payment/                 # AD2: Yassin
        PaymentService.java
        ThirdPartyPaymentGateway.java
        PaymentGatewayAdapter.java
        PaymentAdapterDemo.java
    flyweight/
      MedicalCode.java
      MedicalCodeFactory.java
      MedicalCodeContext.java
      MedicalCodeFlyweightDemo.java
    decorator/
      report/                  # DC1: Yassin
        ReportDocument.java
        BasicReportDocument.java
        ReportDecorator.java
        WatermarkedReport.java
        EncryptedReport.java
        SignedReport.java
        ReportDecoratorDemo.java
      notification/            # DC2: Maged
        NotificationSender.java
        BaseNotificationSender.java
        SenderDecorator.java
        LoggingSender.java
        RetrySender.java
        ThrottlingSender.java
        NotificationDecoratorDemo.java
```

---

## Naming Conventions (Mandatory)

### Classes:
- **PascalCase** for all class names
- Examples: `NotificationChannel`, `EmailChannel`, `ReportRenderer`

### Interfaces:
- Descriptive nouns or adjectives
- Examples: `Notification`, `Report`, `PatientDataProvider`, `PaymentService`

### Demo Classes:
- Must end with `Demo`
- Format: `[Pattern][Case]Demo.java`
- Examples: `NotificationBridgeDemo.java`, `PatientAdapterDemo.java`

### Methods:
- **camelCase**
- Verbs that describe action
- Examples: `sendNotification()`, `renderReport()`, `adaptPatientData()`

### Variables:
- **camelCase**
- Descriptive names
- Examples: `emailChannel`, `pdfRenderer`, `medicalCodeFactory`

---

## Demo Requirements (Mandatory)

Every pattern case MUST include a runnable demo class with:

### 1. Main Method
```java
public static void main(String[] args) {
    // Demo code here
}
```

### 2. Console Output
Demo must print to console showing:
- What pattern is being demonstrated
- Step-by-step execution
- Final result proving pattern works

### Example Output:
```
=== Bridge Pattern: Notification Demo ===
Creating notification types...
Creating channels...
Sending appointment reminder via Email: "Your appointment is tomorrow at 2PM"
Sending billing alert via SMS: "Payment of $150 due"
=== Demo Complete ===
```

### 3. Comments
- Each demo line should have brief comment explaining what it shows
- Include doer tag: [ADHAM], [ANDREW], [YASSIN], or [MAGED]

---

## Git Workflow (Mandatory)

### Branch Naming:
- Format: `feature/[CASE]-[owner]`
- Examples:
  - `feature/BR1-adham`
  - `feature/AD2-yassin`
  - `feature/FW1-maged`

### Commit Messages:
- Format: `[CASE] Brief description — [OWNER]`
- Examples:
  - `[BR1] Add Notification abstraction and Email channel — ADHAM`
  - `[AD2] Implement PaymentGatewayAdapter — YASSIN`

### Pull Request Rules:
1. Create PR when UML + code + demo are complete
2. PR title: `[CASE] Complete implementation — [OWNER]`
3. Must compile without errors before requesting review
4. Adham reviews and merges

### Files to NEVER Commit:
- `target/` folder (Maven build output)
- `.class` files
- IDE-specific files (`.nbproject/`, `.idea/`)
- Backup files

---

## Code Quality Rules

### Compilation:
- Zero compilation errors
- Zero warnings (or document why warning is acceptable)

### Dependencies:
- Only use existing project dependencies from Deliverable #1
- Do not add new Maven dependencies without team approval

### Integration:
- Each pattern must compile independently
- Demos should not depend on other patterns
- No circular dependencies between pattern packages

---

## Documentation Rules

### JavaDoc (Optional but recommended):
- Brief class-level comment explaining purpose
- Method-level comments for public methods

### Comments (Required):
- [ADHAM], [ANDREW], [YASSIN], or [MAGED] tag on each file
- Brief explanation of what the class does

Example:
```java
// NotificationChannel interface — part of Bridge pattern BR1
// Defines how different channels send notifications
// Author: [ADHAM]
public interface NotificationChannel {
    void send(String message);
}
```

---

## UML Export Rules

### File Naming:
```
[Pattern][Case]_[ShortDescription]_[PatternType].png
```

Examples:
- `BR1_Notification_Bridge.png`
- `BR2_Report_Bridge.png`
- `AD1_PatientSystem_Adapter.png`

### Save Locations:
- **Exports (PNG):** `UML Diagrams/exports/`
- **Sources (mdj/puml):** `UML Diagrams/source/`

### Diagram Requirements:
- Clear class names
- Show relationships (inheritance, composition, aggregation)
- Show method signatures for key methods
- Show pattern participants clearly labeled

---

## Definition of Done (Per Case)

Before marking a case as complete, verify:

- [ ] UML diagram created and exported to `UML Diagrams/exports/`
- [ ] Source file saved to `UML Diagrams/source/`
- [ ] Java implementation in correct package
- [ ] Demo class with `main()` method created
- [ ] Demo runs and produces expected console output
- [ ] Code compiles with zero errors
- [ ] Report section written following A1 template
- [ ] Doer tags added to all files
- [ ] PR created and reviewed

---

## Sign-off

**Rules Document Created by:** _________________  
**Date:** _________________  

**Team Acknowledgment:** (Each member confirms they read and will follow these rules)
- [ ] Adham
- [ ] Andrew  
- [ ] Yassin
- [ ] Maged

**Status:** ☐ RULES FROZEN — Team may begin implementation
