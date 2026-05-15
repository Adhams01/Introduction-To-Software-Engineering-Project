# A1 — Deliverable #2 Master Report Template

**Owner:** Adham (Team Lead)  
**Deliverable:** #2 — Structural Design Patterns  
**Course:** SW312 Software Design & Development  
**Due:** Thursday November 7th, 11:59 PM  
**Status:** TEMPLATE READY

---

## Cover Page

**Title:** Hospital Management System — Structural Design Patterns Implementation  
**Course:** SW312 Software Design & Development  
**Deliverable:** #2  
**Team:** Adham, Andrew, Yassin, Maged  
**Date:** November 2026  

---

## Table of Contents

1. Introduction
2. Project Baseline (A0)
3. Structural Patterns Overview
4. Bridge Pattern
   - 4.1 BR1: Notification System (Adham)
   - 4.2 BR2: Report Content × Renderer (Andrew)
5. Adapter Pattern
   - 5.1 AD1: External Patient System (Andrew)
   - 5.2 AD2: Payment/Insurance Gateway (Yassin)
6. Flyweight Pattern
   - 6.1 FW1: Medical Codes Catalog (Maged)
7. Decorator Pattern
   - 7.1 DC1: Report Enhancements (Adham)
   - 7.2 DC2: Notification Sender Decorators (Maged)
8. Implementation Confirmation
9. DevOps Evidence
10. Conclusion

---

## 1. Introduction

### 1.1 Project Overview
The Hospital Management System (HMS) is a Java-based healthcare application developed for SW312. Deliverable #2 focuses on implementing structural design patterns to improve code organization, flexibility, and maintainability.

### 1.2 Team Structure
| Member | Role | Primary Patterns |
|--------|------|------------------|
| Adham | Team Lead, Integration | BR1 (Bridge), DC1 (Decorator) |
| Andrew | Git Management, Implementation | BR2 (Bridge), AD1 (Adapter) |
| Yassin | JIRA Timeline, QA | AD2 (Adapter), DC2 (Decorator) |
| Maged | Formatting, Submission | FW1 (Flyweight), DC2 (Decorator) |

### 1.3 Structural Patterns Summary

| Pattern | Cases | Purpose |
|---------|-------|---------|
| Bridge | 2 cases | Separate abstraction from implementation |
| Adapter | 2 cases | Convert incompatible interfaces |
| Flyweight | 1 case | Share objects to support large numbers |
| Decorator | 2 cases | Add responsibilities dynamically |

**Total: 7 pattern cases**

---

## 2. Project Baseline (A0)

### 2.1 DevOps Compliance
- Maven project structure
- Git branching strategy: `feature/[CASE]-[owner]`
- JIRA task tracking
- Clean build verification

### 2.2 Assumptions
- Java 17 development environment
- StarUML for UML diagrams
- NetBeans IDE
- Maven 3.9+

---

## 3. Structural Patterns Overview

### 3.1 Why Structural Patterns?
Structural patterns concern class and object composition. They help ensure that when one part of a system changes, the entire system doesn't need to change with it.

### 3.2 Pattern Selection Rationale

| Pattern | HMS Application | Benefit |
|---------|-----------------|---------|
| Bridge | Notification types × channels | Add channels without changing notification logic |
| Bridge | Report types × output formats | Add formats (PDF, HTML, CSV) independently |
| Adapter | External patient systems | Integrate legacy APIs without system changes |
| Adapter | Payment gateways | Support multiple payment providers |
| Flyweight | Medical codes | Memory-efficient sharing of common codes |
| Decorator | Report enhancements | Add features (header, footer, watermark) dynamically |
| Decorator | Notification senders | Add logging, retry, throttling without changing sender |

---

## 4. Bridge Pattern

### 4.1 BR1: Notification System — Adham

#### 4.1.1 Problem Statement
The HMS needs to send various notification types (appointment reminders, billing alerts) through multiple channels (Email, SMS, In-App). Without a structured approach, each notification type would need custom code for each channel.

#### 4.1.2 Why Bridge Pattern
The Bridge pattern separates notification content from delivery mechanism, allowing:
- New notification types without changing channels
- New channels without changing notification logic
- Runtime switching of delivery methods

#### 4.1.3 UML Class Diagram
**INSERT:** `BR1_Notification_Bridge.png`

*Description: Shows Notification abstraction hierarchy (AppointmentReminder, BillingAlert) connected through NotificationChannel interface (EmailChannel, SmsChannel, InAppChannel).*

#### 4.1.4 Implementation
**Files:**
- `Notification.java` — Abstraction
- `NotificationChannel.java` — Implementation interface
- `EmailChannel.java`, `SmsChannel.java`, `InAppChannel.java` — Concrete channels
- `AppointmentReminder.java`, `BillingAlert.java` — Refined abstractions
- `NotificationBridgeDemo.java` — Demo

**Key Code:**
```java
public abstract class Notification {
    protected NotificationChannel channel;
    
    public Notification(NotificationChannel channel) {
        this.channel = channel;
    }
    
    public abstract void send();
}
```

#### 4.1.5 Demo Output
```
========================================
DELIVERABLE #2: BRIDGE PATTERN DEMO [ADHAM]
BR1 - Notification System
========================================
SENDING: Appointment Reminder
TO: patient@hospital.com
CHANNEL: Email
MESSAGE: You have an appointment tomorrow at 10:00 AM

SENDING: Billing Alert
TO: +1234567890
CHANNEL: SMS
MESSAGE: Your bill of $150.00 is due
```

---

### 4.2 BR2: Report Content × Renderer — Andrew

*[See B3 Report Sections.md for complete content]*

#### 4.2.1 Problem Statement
Reports need multiple output formats (PDF, HTML, CSV) without creating a class explosion (SummaryPDF, SummaryHTML, DetailedPDF, etc.).

#### 4.2.2 Why Bridge Pattern
Separates report content (what data) from rendering (how displayed).

#### 4.2.3 UML Class Diagram
**INSERT:** `BR2_Report_Bridge.png`

#### 4.2.4 Implementation
**Files:** Report.java, ReportRenderer.java, PdfRenderer.java, HtmlRenderer.java, CsvRenderer.java, AppointmentScheduleReport.java, BillingSummaryReport.java, ReportBridgeDemo.java

---

## 5. Adapter Pattern

### 5.1 AD1: External Patient System — Andrew

*[See B3 Report Sections.md for complete content]*

#### 5.1.1 Problem Statement
External patient system uses different data formats (XML vs. JSON, int vs. String IDs, numeric vs. boolean status).

#### 5.1.2 Why Adapter Pattern
Converts external API to HMS-compatible interface without modifying either system.

#### 5.1.3 UML Class Diagram
**INSERT:** `AD1_PatientSystem_Adapter.png`

#### 5.1.4 Implementation
**Files:** PatientDataProvider.java (Target), ExternalPatientSystemApi.java (Adaptee), ExternalPatientSystemAdapter.java (Adapter), PatientAdapterDemo.java

---

### 5.2 AD2: Payment/Insurance Gateway — Yassin

#### 5.2.1 Problem Statement
Multiple payment providers (Credit Card, Insurance, Cash) have incompatible APIs for processing payments and verifying coverage.

#### 5.2.2 Why Adapter Pattern
Provides unified PaymentProcessor interface while supporting diverse provider APIs.

#### 5.2.3 UML Class Diagram
**INSERT:** `AD2_Payment_Adapter.png`

#### 5.2.4 Implementation
**Files:** PaymentProcessor.java, InsuranceProviderApi.java, CreditCardGateway.java, InsuranceAdapter.java, CreditCardAdapter.java, PaymentDemo.java

---

## 6. Flyweight Pattern

### 6.1 FW1: Medical Codes Catalog — Maged

#### 6.1.1 Problem Statement
Medical codes (ICD-10, medication codes) are repeated thousands of times across patient records. Storing each instance separately wastes memory.

#### 6.1.2 Why Flyweight Pattern
Shares intrinsic state (code, description, category) across multiple patient contexts.

#### 6.1.3 UML Class Diagram
**INSERT:** `FW1_MedicalCode_Flyweight.png`

#### 6.1.4 Implementation
**Files:** MedicalCode.java (Flyweight), MedicalCodeContext.java (extrinsic state), MedicalCodeFactory.java (cache), MedicalCodeDemo.java

**Key Code:**
```java
public class MedicalCodeFactory {
    private static final Map<String, MedicalCode> cache = new HashMap<>();
    
    public static MedicalCode getCode(String code, String description, String category) {
        if (!cache.containsKey(code)) {
            cache.put(code, new MedicalCode(code, description, category));
        }
        return cache.get(code);
    }
}
```

#### 6.1.5 Demo Output
```
========================================
DELIVERABLE #2: FLYWEIGHT PATTERN DEMO [MAGED]
FW1 - Medical Codes Catalog
========================================
Total unique codes created: 3
Total context instances: 10
Memory saved: ~70%
Code: A00.0 (Cholera) used 4 times (same instance)
```

---

## 7. Decorator Pattern

### 7.1 DC1: Report Enhancements — Adham

#### 7.1.1 Problem Statement
Reports need optional enhancements (header, footer, watermark, page numbers) that should be added dynamically without subclassing every combination.

#### 7.1.2 Why Decorator Pattern
Adds responsibilities to reports dynamically without affecting other reports.

#### 7.1.3 UML Class Diagram
**INSERT:** `DC1_Report_Decorator.png`

*Description: Shows ReportComponent interface, ConcreteReport (base), and decorators (HeaderDecorator, FooterDecorator, WatermarkDecorator) each adding behavior while maintaining ReportComponent interface.*

#### 7.1.4 Implementation
**Files:**
- `ReportComponent.java` — Component interface
- `BaseReport.java` — Concrete component
- `ReportDecorator.java` — Abstract decorator
- `HeaderDecorator.java` — Adds header
- `FooterDecorator.java` — Adds footer
- `WatermarkDecorator.java` — Adds watermark
- `ReportDecoratorDemo.java` — Demo

**Key Code:**
```java
public abstract class ReportDecorator implements ReportComponent {
    protected ReportComponent decoratedReport;
    
    public ReportDecorator(ReportComponent report) {
        this.decoratedReport = report;
    }
    
    @Override
    public String generate() {
        return decoratedReport.generate();
    }
}
```

#### 7.1.5 Demo Output
```
========================================
DELIVERABLE #2: DECORATOR PATTERN DEMO [ADHAM]
DC1 - Report Enhancements
========================================
=== HOSPITAL MANAGEMENT SYSTEM ===
--- CONFIDENTIAL ---
Patient: John Doe
Report: Monthly Summary
...
--- End of Report ---
Generated: 2026-03-22
Page 1 of 1
```

---

### 7.2 DC2: Notification Sender Decorators — Maged

#### 7.2.1 Problem Statement
Notification sending needs cross-cutting concerns: logging, retry logic, rate throttling. These shouldn't be hardcoded into every sender.

#### 7.2.2 Why Decorator Pattern
Wraps notification senders with additional behaviors dynamically.

#### 7.2.3 UML Class Diagram
**INSERT:** `DC2_Notification_Decorator.png`

#### 7.2.4 Implementation
**Files:** NotificationSender.java, BasicNotificationSender.java, NotificationSenderDecorator.java, LoggingDecorator.java, RetryDecorator.java, ThrottleDecorator.java, NotificationDecoratorDemo.java

---

## 8. Implementation Confirmation

### 8.1 Build Verification
```
[INFO] Building HospitalMangementSystem_Maven 1.0-SNAPSHOT
[INFO] Compiling 32 source files with javac [debug release 17]
[INFO] BUILD SUCCESS
```

### 8.2 Demo Menu Integration
| Option | Pattern | Case | Owner |
|--------|---------|------|-------|
| 8 | Bridge | BR1 | Adham |
| 9 | Bridge | BR2 | Andrew |
| 10 | Adapter | AD1 | Andrew |
| 11 | Flyweight | FW1 | Maged |
| 12 | Adapter | AD2 | Yassin |
| 13 | Decorator | DC1 | Adham |
| 14 | Decorator | DC2 | Maged |

### 8.3 Files Summary
| Pattern | Cases | Java Files | UML Files |
|---------|-------|------------|-----------|
| Bridge | 2 | 16 | 2 .mdj, 2 .png |
| Adapter | 2 | 12 | 2 .mdj, 2 .png |
| Flyweight | 1 | 4 | 1 .mdj, 1 .png |
| Decorator | 2 | 14 | 2 .mdj, 2 .png |
| **Total** | **7** | **46** | **7 .mdj, 7 .png** |

---

## 9. DevOps Evidence

### 9.1 Git Repository
- URL: `https://github.com/Adhams01/Software-Engineering-Project`
- Branch strategy: feature branches per case
- PR checklist enforced (B0)

### 9.2 JIRA Timeline
*[Screenshots to be added by Y0]*

### 9.3 Build Automation
- Maven pom.xml configured
- Java 17 compatibility
- Clean build verification

---

## 10. Conclusion

### 10.1 Summary
Deliverable #2 implements 7 structural pattern cases across Bridge (2), Adapter (2), Flyweight (1), and Decorator (2). All patterns improve HMS flexibility:
- **Bridge:** Runtime format/channel switching
- **Adapter:** Legacy system integration
- **Flyweight:** Memory-efficient code sharing
- **Decorator:** Dynamic feature enhancement

### 10.2 Team Contributions
| Member | Patterns | Management | Integration |
|--------|----------|------------|-------------|
| Adham | BR1, DC1 | A0, A1, A4 | Menu integration |
| Andrew | BR2, AD1 | B0, B3 | Git rules |
| Yassin | AD2, DC2 | Y0, Y3, Y4 | JIRA, QA |
| Maged | FW1, DC2 | M0, M2, M3, M4 | Submission |

### 10.3 Deliverables Checklist
- [x] 7 pattern implementations
- [x] 7 UML class diagrams
- [x] 7 working demos
- [x] Maven build success
- [x] Git repository organized
- [x] JIRA timeline
- [x] Technical report (this document)

---

## Appendices

### Appendix A: File Structure
*[Include full tree of src/ and docs/]*

### Appendix B: Demo Output Samples
*[Include console output from all 7 demos]*

### Appendix C: JIRA Screenshots
*[To be added by Y0]*

### Appendix D: Git History
*[Optional: git log --oneline --graph]*

---

**Document Template Created by:** Adham  
**Date:** 2026-03-22  
**Version:** 1.0
