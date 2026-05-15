# A1 — Deliverable #2 Technical Report Master Template

**Owner:** Adham  
**Deadline:** Must complete before team starts writing report sections  
**Purpose:** Define exact report structure so everyone knows where to insert content

---

## Report Structure (Copy this into final document)

---

# Hospital Management System — Deliverable #2
## Structural Design Patterns Implementation

**Course:** C-SW311: Software Design and Development  
**Semester:** Spring 2026  
**Team Members:** Adham, Andrew, Yassin, Maged

---

## Table of Contents

1. [Introduction](#1-introduction)
2. [Bridge Design Pattern](#2-bridge-design-pattern)
3. [Adapter Design Pattern](#3-adapter-design-pattern)
4. [Flyweight Design Pattern](#4-flyweight-design-pattern)
5. [Decorator Design Pattern](#5-decorator-design-pattern)
6. [DevOps Tools Evidence](#6-devops-tools-evidence)
7. [Assumptions and Rationale](#7-assumptions-and-rationale)

Appendix A: UML Diagram Source Files

---

## 1. Introduction

### 1.1 Project Context
[Write 3-4 sentences about the Hospital Management System project context]

### 1.2 Deliverable #2 Scope
[Write 2-3 sentences explaining this deliverable focuses on Structural Design Patterns]

---

## 2. Bridge Design Pattern

### 2.1 Bridge Case #1: Notification (Message Type × Delivery Channel)

#### 2.1.1 Problem Statement
[Owner: Adham — Describe the problem: multiple notification types need multiple delivery channels, without Bridge pattern we get class explosion]

#### 2.1.2 Why Bridge Pattern
[Explain: Bridge separates abstraction (message type) from implementation (delivery channel), allowing both to vary independently]

#### 2.1.3 UML Class Diagram
**INSERT DIAGRAM:** `BR1_Notification_Bridge.png`

[Description of diagram structure]

#### 2.1.4 Implementation Confirmation
[2-3 sentences confirming implementation exists in project, compiles and runs. NO CODE SHOWN IN REPORT.]

---

### 2.2 Bridge Case #2: Report (Content × Renderer)

#### 2.2.1 Problem Statement
[Owner: Andrew — Describe: same report content needs export in PDF/HTML/CSV formats]

#### 2.2.2 Why Bridge Pattern
[Explain: separates report content from rendering algorithm]

#### 2.2.3 UML Class Diagram
**INSERT DIAGRAM:** `BR2_Report_Bridge.png`

#### 2.2.4 Implementation Confirmation
[2-3 sentences, no code shown]

---

## 3. Adapter Design Pattern

### 3.1 Adapter Case #1: External Patient System Integration

#### 3.1.1 Problem Statement
[Owner: Andrew — Describe: existing HMS expects PatientDataProvider interface but external system has different API]

#### 3.1.2 Why Adapter Pattern
[Explain: Adapter wraps external API to match expected interface without changing either]

#### 3.1.3 UML Class Diagram
**INSERT DIAGRAM:** `AD1_PatientSystem_Adapter.png`

#### 3.1.4 Implementation Confirmation
[2-3 sentences, no code shown]

---

### 3.2 Adapter Case #2: Payment Gateway Integration

#### 3.2.1 Problem Statement
[Owner: Yassin — Describe: third-party payment SDK has incompatible interface with HMS PaymentService]

#### 3.2.2 Why Adapter Pattern
[Explain: Adapter translates HMS calls to gateway-specific calls]

#### 3.2.3 UML Class Diagram
**INSERT DIAGRAM:** `AD2_Payment_Adapter.png`

#### 3.2.4 Implementation Confirmation
[2-3 sentences, no code shown]

---

## 4. Flyweight Design Pattern

### 4.1 Flyweight Case #1: Medical Codes Catalog

#### 4.1.1 Problem Statement
[Owner: Maged — Describe: thousands of repeated medical code objects across patient records waste memory]

#### 4.1.2 Why Flyweight Pattern
[Explain: shares intrinsic state (code, name) across objects, stores extrinsic state separately]

#### 4.1.3 UML Class Diagram
**INSERT DIAGRAM:** `FW1_MedicalCodes_Flyweight.png`

#### 4.1.4 Implementation Confirmation
[2-3 sentences, no code shown]

---

## 5. Decorator Design Pattern

### 5.1 Decorator Case #1: Report Enhancements

#### 5.1.1 Problem Statement
[Owner: Yassin — Describe: need optional features (watermark, encryption, signature) on reports without subclass explosion]

#### 5.1.2 Why Decorator Pattern
[Explain: wraps objects to add responsibilities dynamically, follows open/closed principle]

#### 5.1.3 UML Class Diagram
**INSERT DIAGRAM:** `DC1_Report_Decorator.png`

#### 5.1.4 Implementation Confirmation
[2-3 sentences, no code shown]

---

### 5.2 Decorator Case #2: Notification Sender Enhancements

#### 5.2.1 Problem Statement
[Owner: Maged — Describe: need to add logging, retry logic, rate limiting to notification sending without modifying existing senders]

#### 5.2.2 Why Decorator Pattern
[Explain: decorators wrap senders to add behaviors at runtime]

#### 5.2.3 UML Class Diagram
**INSERT DIAGRAM:** `DC2_Notification_Decorator.png`

#### 5.2.4 Implementation Confirmation
[2-3 sentences, no code shown]

---

## 6. DevOps Tools Evidence

### 6.1 Git Repository Usage
[Screenshots of: commits history, branches, merge history]

### 6.2 Maven Configuration
[Screenshot of pom.xml + BUILD SUCCESS output]

### 6.3 JIRA Project Management
[Screenshots of: JIRA board with tasks, task details with dependencies, burndown/progress]

---

## 7. Assumptions and Rationale

### 7.1 Assumptions Made
[List all assumptions explicitly]
1. 
2. 
3. 

### 7.2 Pattern Selection Rationale
[Summary table of why each pattern was chosen for each case]

| Case | Pattern | Rationale Summary |
|------|---------|-------------------|
| BR1 | Bridge | [1 line] |
| BR2 | Bridge | [1 line] |
| AD1 | Adapter | [1 line] |
| AD2 | Adapter | [1 line] |
| FW1 | Flyweight | [1 line] |
| DC1 | Decorator | [1 line] |
| DC2 | Decorator | [1 line] |

---

# Appendix A: UML Diagram Source Files

All UML diagrams were created using [StarUML/PlantUML/VisualParadigm — specify tool].
Source files (.mdj/.puml/.vpp) are included in submission under `UML Diagrams/source/`.

| Diagram | Source File | Export File |
|---------|-------------|-------------|
| BR1 | BR1_Notification.mdj | BR1_Notification_Bridge.png |
| BR2 | BR2_Report.mdj | BR2_Report_Bridge.png |
| AD1 | AD1_PatientSystem.mdj | AD1_PatientSystem_Adapter.png |
| AD2 | AD2_Payment.mdj | AD2_Payment_Adapter.png |
| FW1 | FW1_MedicalCodes.mdj | FW1_MedicalCodes_Flyweight.png |
| DC1 | DC1_Report.mdj | DC1_Report_Decorator.png |
| DC2 | DC2_Notification.mdj | DC2_Notification_Decorator.png |

---

## Naming Conventions for Diagram Files

### Export Files (PNG for report):
- `BR1_Notification_Bridge.png`
- `BR2_Report_Bridge.png`
- `AD1_PatientSystem_Adapter.png`
- `AD2_Payment_Adapter.png`
- `FW1_MedicalCodes_Flyweight.png`
- `DC1_Report_Decorator.png`
- `DC2_Notification_Decorator.png`

### Source Files (Keep original format):
- `BR1_Notification.mdj` (or .puml, .vpp)
- `BR2_Report.mdj`
- etc.

Save exports to: `UML Diagrams/exports/`  
Save sources to: `UML Diagrams/source/`

---

## Report Section Writing Guidelines

### Each Case Section Must Include:
1. **Problem Statement** (what problem does this solve in HMS context)
2. **Why This Pattern** (justification for pattern choice)
3. **UML Class Diagram** (insert PNG, describe briefly)
4. **Implementation Confirmation** (confirm it works, NO CODE IN REPORT)

### Length Guidelines:
- Problem Statement: 3-5 sentences
- Why Pattern: 3-5 sentences
- Diagram Description: 2-3 sentences
- Implementation Confirmation: 2-3 sentences

### Formatting:
- Use this exact heading structure
- Insert diagrams as images, centered
- Use tables where appropriate
- Page break between major sections

---

## Sign-off

**Template Created by:** _________________  
**Date:** _________________  
**Status:** ☐ READY FOR TEAM TO USE

**Team Acknowledgment:**
- [ ] Adham has read and understands structure
- [ ] Andrew has read and understands structure
- [ ] Yassin has read and understands structure
- [ ] Maged has read and understands structure
