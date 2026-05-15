# M0 — Report Formatting + Consistency Rules

**Owner:** Maged  
**Applies to:** Deliverable #2 — Structural Design Patterns  
**Status:** ACTIVE

---

## 1. Naming Conventions

### 1.1 File Naming

| Item | Format | Example |
|------|--------|---------|
| Java Classes | PascalCase | `ReportBridgeDemo.java` |
| Interfaces | PascalCase + descriptive | `ReportRenderer.java` |
| Packages | lowercase, no underscores | `hospitalmanagementsystem.patterns.structural.bridge` |
| UML Files | `[CASE]_[Pattern]_[CaseName].mdj` | `BR2_Report_Bridge.mdj` |
| Exported Diagrams | `[CASE]_[Pattern]_[CaseName].png` | `BR2_Report_Bridge.png` |
| Documentation | `[CODE]_[ShortDescription].md` | `B0_Git_Rules.md` |

### 1.2 Class Naming

- **Demo classes:** `[Case]Demo` → `ReportBridgeDemo`, `PatientAdapterDemo`
- **Interfaces:** Descriptive noun → `ReportRenderer`, `PatientDataProvider`
- **Implementations:** `[Format/Type] + [Interface]` → `PdfRenderer`, `ExternalPatientSystemAdapter`

---

## 2. Numbering System

### 2.1 Pattern Codes (Fixed)

| Code | Pattern | Owner |
|------|---------|-------|
| BR1 | Bridge — Notification | Adham |
| BR2 | Bridge — Report | Andrew |
| AD1 | Adapter — Patient System | Andrew |
| AD2 | Adapter — Payment/Insurance | Yassin |
| FW1 | Flyweight — Medical Codes | Maged |
| DC1 | Decorator — Report | Yassin |
| DC2 | Decorator — Notification | Maged |

### 2.2 Workload Codes (Fixed)

| Code | Owner | Description |
|------|-------|-------------|
| A0–A5 | Adham | Foundation + BR1 + DC1 + Integration |
| B0–B3 | Andrew | Git Rules + BR2 + AD1 + Report |
| Y0–Y4 | Yassin | JIRA + AD2 + DC2 + QA |
| M0–M4 | Maged | Formatting + FW1 + Integration + Submission |

---

## 3. Terminology Standards

### 3.1 Consistent Terms (Use These)

| Use This | Not This |
|----------|----------|
| Hospital Management System (HMS) | "the system", "our project" |
| Deliverable #2 | "Assignment 2", "D2" |
| Structural Pattern | "Structure pattern" |
| Implementation | "Code", "Solution" |
| Rationale | "Why", "Reason" |
| Demo | "Test", "Main", "Example" |
| UML Class Diagram | "Diagram", "UML" |
| Build Success | "Compiles", "Works" |

### 3.2 Pattern-Specific Terms

| Pattern | Abstraction | Implementation | Variation |
|---------|-------------|----------------|-----------|
| Bridge | Abstraction | Implementation | Renderer/Channel |
| Adapter | Target | Adaptee | Adapter class |
| Flyweight | Flyweight | Context | Factory/Cache |
| Decorator | Component | Concrete | Decorator chain |

---

## 4. Documentation Structure

### 4.1 Report Section Template

Every pattern section in the PDF report must contain:

1. **Header:** `[CASE]: [Pattern] — [Case Name]`
2. **1.1 Problem Statement** — What problem does this solve?
3. **1.2 Why [Pattern] Pattern** — Why this pattern specifically?
4. **1.3 UML Class Diagram** — Insert diagram + brief explanation
5. **1.4 Implementation Confirmation** — File list + build proof + demo proof

### 4.2 Code File Header Template

```java
/**
 * [CASE] — [Brief description]
 * 
 * Structural Pattern: [PATTERN]
 * Owner: [NAME]
 * Deliverable: #2
 */
```

### 4.3 Commit Message Format

```
[CASE] Brief description — [OWNER]
```

---

## 5. Assumptions (Document These)

All team members must document assumptions in their report sections:

### 5.1 Required Assumptions

- **Scope:** What is included vs excluded
- **Dependencies:** What must exist first
- **Constraints:** Time, technology, compatibility
- **Data:** Sample data vs production data

### 5.2 Assumption Format

```markdown
**Assumption [A#]:** [Statement]
**Rationale:** [Why this assumption exists]
**Impact if Wrong:** [Consequences]
```

---

## 6. Formatting Checklist (Apply Before Submission)

- [ ] All files use correct naming conventions
- [ ] All codes (BR1, AD1, etc.) are correct and consistent
- [ ] All terminology matches Section 3 standards
- [ ] All report sections follow 1.1–1.4 structure
- [ ] All code files have header comments with [CASE], [PATTERN], [OWNER]
- [ ] All assumptions documented per Section 5
- [ ] No "TODO", "FIXME", or placeholder text remains
- [ ] All UML diagrams exported as PNG
- [ ] All spellings checked (US English)

---

## 7. Sign-off

**Formatting Rules created by:** Maged  
**Applied to:** Deliverable #2 Technical Report  
**Date:** 2026-03-22

| Role | Name | Approved |
|------|------|----------|
| Team Lead | Adham | [ ] |
| Git/Integration | Andrew | [ ] |
| QA/Verification | Yassin | [ ] |
| Formatting/Submission | Maged | [x] |
