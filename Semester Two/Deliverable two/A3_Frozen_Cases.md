# A3 — Frozen Cases for Deliverable #2

**Owner:** Adham  
**Deadline:** Must complete after reviewing all case proposals  
**Purpose:** Lock the exact scope — no changes without team vote

---

## ⚠️ IMPORTANT: SCOPE IS FROZEN

These 7 cases are the **ONLY** cases that will be included in Deliverable #2.  
No additions, no removals, no case swaps without **unanimous team agreement**.

---

## Approved Cases Summary

| Pattern | Count Required | Count Approved | Status |
|---------|---------------|----------------|--------|
| Bridge | 2 | 2 | ✅ FROZEN |
| Adapter | 2 | 2 | ✅ FROZEN |
| Flyweight | 1 | 1 | ✅ FROZEN |
| Decorator | 2 | 2 | ✅ FROZEN |
| **Total** | **7** | **7** | ✅ **COMPLETE** |

---

## Case Details (Frozen)

### Bridge Pattern — Case #1 (BR1)
- **Code:** BR1
- **Name:** Notification (Message Type × Delivery Channel)
- **Owner:** Adham
- **Problem:** Multiple notification types (appointment reminder, billing alert, lab result) need multiple delivery channels (Email, SMS, In-app). Without Bridge, we'd need a class for every combination (ReminderEmail, ReminderSMS, BillingEmail, BillingSMS, etc.) causing class explosion.
- **Solution:** Bridge separates `Notification` (abstraction) from `NotificationChannel` (implementation), allowing both hierarchies to vary independently.
- **Key Classes:**
  - Abstraction: `Notification`
  - Refined Abstractions: `AppointmentReminderNotification`, `BillingAlertNotification`
  - Implementor: `NotificationChannel`
  - Concrete Implementors: `EmailChannel`, `SmsChannel`, `InAppChannel`

**Status:** ☐ UML ☐ Code ☐ Report

---

### Bridge Pattern — Case #2 (BR2)
- **Code:** BR2
- **Name:** Report (Content × Renderer)
- **Owner:** Andrew
- **Problem:** Same report content (appointment schedule, billing summary, patient history) needs export in multiple formats (PDF, HTML, CSV). Without Bridge, each report type would need subclasses for each format.
- **Solution:** Bridge separates `Report` (what content) from `ReportRenderer` (how to render), allowing new report types and new formats independently.
- **Key Classes:**
  - Abstraction: `Report`
  - Refined Abstractions: `AppointmentScheduleReport`, `BillingSummaryReport`
  - Implementor: `ReportRenderer`
  - Concrete Implementors: `PdfRenderer`, `HtmlRenderer`, `CsvRenderer`

**Status:** ☐ UML ☐ Code ☐ Report

---

### Adapter Pattern — Case #1 (AD1)
- **Code:** AD1
- **Name:** External Patient System Integration
- **Owner:** Andrew
- **Problem:** HMS expects a `PatientDataProvider` interface with methods like `getPatientById()`, `getPatientHistory()`, but an external legacy system has incompatible methods like `fetchPatientRecord()`, `retrieveHistoryXML()`.
- **Solution:** Adapter wraps the external system's API to match HMS's expected interface without changing either system.
- **Key Classes:**
  - Target: `PatientDataProvider` (interface HMS expects)
  - Adaptee: `ExternalPatientSystemApi` (existing external system)
  - Adapter: `ExternalPatientSystemAdapter` (translates calls)

**Status:** ☐ UML ☐ Code ☐ Report

---

### Adapter Pattern — Case #2 (AD2)
- **Code:** AD2
- **Name:** Payment Gateway / Insurance Adapter
- **Owner:** Yassin
- **Problem:** HMS billing module expects a clean `PaymentService` interface with `processPayment()`, but third-party payment gateway SDK has methods like `initiateTransaction()`, `confirmPayment()`, `handleCallback()` with different parameters.
- **Solution:** Adapter translates HMS's simple payment calls to gateway-specific method sequences.
- **Key Classes:**
  - Target: `PaymentService` (interface HMS expects)
  - Adaptee: `ThirdPartyPaymentGateway` (gateway SDK)
  - Adapter: `PaymentGatewayAdapter` (translation layer)

**Status:** ☐ UUML ☐ Code ☐ Report

---

### Flyweight Pattern — Case #1 (FW1)
- **Code:** FW1
- **Name:** Medical Codes / Medication Catalog
- **Owner:** Maged
- **Problem:** Thousands of patient records reference the same ICD-10 diagnosis codes and medication items. Creating full objects for each reference wastes massive memory (imagine 10,000 patients all referencing "Code J18" for Pneumonia — that's 10,000 identical objects).
- **Solution:** Flyweight shares intrinsic state (code, name, description) across all references. Only store extrinsic state (patient-specific usage date, dosage, notes) separately.
- **Key Classes:**
  - Flyweight: `MedicalCode` (immutable, shared)
  - FlyweightFactory: `MedicalCodeFactory` (caches and reuses instances)
  - Context: `MedicalCodeContext` (holds extrinsic state)
  - Client: Patient records that use `MedicalCode` via factory

**Status:** ☐ UML ☐ Code ☐ Report

---

### Decorator Pattern — Case #1 (DC1)
- **Code:** DC1
- **Name:** Report Enhancements
- **Owner:** Yassin
- **Problem:** Reports need optional features like watermark, encryption, digital signature. Without Decorator, we'd need subclasses for every combination (BasicReport, WatermarkedReport, EncryptedReport, WatermarkedEncryptedReport, etc.) — 2^n subclasses nightmare.
- **Solution:** Decorator wraps report objects to add responsibilities dynamically. Can stack decorators: `new EncryptedReport(new WatermarkedReport(new BasicReport()))`.
- **Key Classes:**
  - Component: `ReportDocument` (interface)
  - Concrete Component: `BasicReportDocument`
  - Decorator: `ReportDecorator` (abstract base)
  - Concrete Decorators: `WatermarkedReport`, `EncryptedReport`, `SignedReport`

**Status:** ☐ UML ☐ Code ☐ Report

---

### Decorator Pattern — Case #2 (DC2)
- **Code:** DC2
- **Name:** Notification Sender Decorators
- **Owner:** Maged
- **Problem:** Notification sending needs cross-cutting concerns: logging (record what was sent), retry (if send fails), throttling (don't spam). Without Decorator, these would be copy-pasted or tangled in every sender implementation.
- **Solution:** Decorators wrap senders to add behaviors at runtime. `new ThrottlingSender(new RetrySender(new LoggingSender(new BaseNotificationSender())))`.
- **Key Classes:**
  - Component: `NotificationSender` (interface)
  - Concrete Component: `BaseNotificationSender`
  - Decorator: `SenderDecorator` (abstract base)
  - Concrete Decorators: `LoggingSender`, `RetrySender`, `ThrottlingSender`

**Status:** ☐ UML ☐ Code ☐ Report

---

## Case Ownership Matrix

| Case | Pattern | Owner | UML | Code | Report | Overall |
|------|---------|-------|-----|------|--------|---------|
| BR1 | Bridge | Adham | ☐ | ☐ | ☐ | ☐ |
| BR2 | Bridge | Andrew | ☐ | ☐ | ☐ | ☐ |
| AD1 | Adapter | Andrew | ☐ | ☐ | ☐ | ☐ |
| AD2 | Adapter | Yassin | ☐ | ☐ | ☐ | ☐ |
| FW1 | Flyweight | Maged | ☐ | ☐ | ☐ | ☐ |
| DC1 | Decorator | Yassin | ☐ | ☐ | ☐ | ☐ |
| DC2 | Decorator | Maged | ☐ | ☐ | ☐ | ☐ |

---

## Verification Checklist

Before starting work, each owner must confirm:

- [ ] I understand my assigned cases
- [ ] I understand the problem each case solves
- [ ] I understand the pattern structure (participants)
- [ ] I agree the scope is frozen

---

## Change Request Process

If anyone believes a case must change:

1. **Propose:** Write 1-2 sentences explaining why current case doesn't work
2. **Alternative:** Suggest replacement case with same pattern type
3. **Vote:** All 4 members must agree (unanimous)
4. **Update:** If approved, Adham updates this document

**Without unanimous vote, scope remains frozen.**

---

## Sign-off

**Frozen by:** Adham (Team Lead)  
**Date:** _________________

**Team Acknowledgment** (I agree scope is frozen and I will complete my assigned cases):
- [ ] Adham — Cases: BR1
- [ ] Andrew — Cases: BR2, AD1
- [ ] Yassin — Cases: AD2, DC1
- [ ] Maged — Cases: FW1, DC2

**Status:** ☐ SCOPE FROZEN — Proceed to implementation phase
