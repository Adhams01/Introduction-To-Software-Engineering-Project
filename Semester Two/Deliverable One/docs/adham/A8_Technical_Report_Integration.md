# A8 — Technical Report Integration (Final PDF)

**Owner:** Adham  
**Deliverable:** Complete PDF technical report  
**Due:** March 7, 2025

---

## Report Structure (Final)

| Section | Content | Source | Status |
|---------|---------|--------|--------|
| Cover Page | Title, course info, team members, date | Adham | ✅ Template ready |
| Table of Contents | Auto-generated | Word/Google Docs | ⏳ Auto-gen |
| 1. Introduction | Project overview, team roles, scope | Adham | ✅ Draft ready |
| 2. Automated Java Code Generation | Maven integration status | A0 | ✅ Ready to paste |
| 3. Pattern Cases Overview | Summary of 5 cases | All | ✅ Compile from B1, B2, M1 |
| 4. Singleton Case #1 | NotificationServiceSingleton | Andrew B5 | ✅ Ready |
| 5. Singleton Case #2 | PatientRegistrySingleton | Yassin Y3 | ✅ Ready |
| 6. Factory Method Case | AppointmentFactory | Maged M3 | ⏳ Pending M3 |
| 7. Abstract Factory Case #1 | ReportAbstractFactory | Adham A4 | ✅ Ready |
| 8. Abstract Factory Case #2 | UIComponentAbstractFactory | Adham A5 | ✅ Ready |
| 9. Implementation Confirmation | Build/run evidence | D4 | ⏳ Pending execution |
| 10. Assumptions | Baseline checklist | A0 | ✅ Ready |
| Appendix | Screenshots, build logs | All | ⏳ Collect |

---

## Content Integration Plan

### Section 2: Automated Java Code Generation
```
Content from: A0_Baseline_Checklist.md
Focus: Maven project setup, NetBeans integration, build verification
Length: ~0.5 page
Key points:
- Maven project created parallel to Ant project
- pom.xml configured for Java 23
- NetBeans Clean and Build: SUCCESS
- mvn exec:java runs HMS menu
```

### Section 3: Pattern Cases Overview
```
Table format:
| # | Pattern | Case Name | Owner |
|---|---------|-----------|-------|
| 1 | Singleton | NotificationServiceSingleton | Andrew |
| 2 | Singleton | PatientRegistrySingleton | Yassin |
| 3 | Factory Method | AppointmentFactory | Andrew/Maged |
| 4 | Abstract Factory | ReportAbstractFactory | Adham |
| 5 | Abstract Factory | UIComponentAbstractFactory | Adham |
```

### Sections 4–8: Individual Pattern Cases

**Per section structure:**
1. **Problem Statement** (2–3 sentences)
2. **Why This Pattern** (bullet rationale)
3. **UML Class Diagram** (insert PNG, full page width)
4. **Implementation Notes** (package location, key classes)
5. **Build/Run Evidence** (screenshot reference)

**Copy sources:**
- Section 4: Copy from `docs/andrew/B5_Report_Singleton_Case1.md`
- Section 5: Copy from `docs/yassin/Y3_Report_Singleton_Case2.md`
- Section 6: ⏳ Waiting for `M3` from Maged
- Section 7: Copy from `docs/adham/A4_AbstractFactory_Case1_ReportFactory.md`
- Section 8: Copy from `docs/adham/A5_AbstractFactory_Case2_UIComponentFactory.md`

---

## UML Diagram Insertions

| Diagram | Source File | Insert Location |
|---------|-------------|-----------------|
| Singleton Case #1 | `uml/andrew/NotificationServiceSingleton.png` | Section 4 |
| Singleton Case #2 | `uml/andrew/PatientRegistrySingleton.png` | Section 5 |
| Factory Method | `uml/andrew/AppointmentFactory.png` | Section 6 |
| Abstract Factory #1 | ⏳ Export from A4 PlantUML | Section 7 |
| Abstract Factory #2 | ⏳ Export from A5 PlantUML | Section 8 |

**PlantUML Export Commands:**
```bash
# Install plantuml or use online renderer
java -jar plantuml.jar A4_AbstractFactory_Case1_ReportFactory.md -o uml/adham/
java -jar plantuml.jar A5_AbstractFactory_Case2_UIComponentFactory.md -o uml/adham/
```

---

## Formatting Standards

| Element | Specification |
|---------|---------------|
| Font | Times New Roman, 12pt |
| Margins | 1 inch all sides |
| Line spacing | 1.5 |
| Heading 1 | Bold, 16pt, center |
| Heading 2 | Bold, 14pt, left |
| Heading 3 | Bold, 12pt, left |
| Code | No code blocks in main text (only in appendix) |
| Diagrams | Centered, caption below |
| Page numbers | Bottom center |

---

## Critical Constraint: No Code in Report

**Allowed:**
- UML class diagrams (required)
- Method signatures (e.g., `getInstance(): NotificationService`)
- Package names (e.g., `hospitalmangementsystem.patterns.singleton`)
- Short inline snippets ≤3 lines for illustration

**NOT Allowed:**
- Full Java class implementations
- Import statements blocks
- Method bodies with logic
- XML/JSON configuration dumps

**Verification:** Search document for `public class`, `import java`, `{` after method signatures — should return 0 results in main sections.

---

## Assembly Steps

### Step 1: Collect All Content (Due: Mar 7, 10:00 AM)
- [ ] Copy B5 into Section 4
- [ ] Copy Y3 into Section 5
- [ ] Copy M3 into Section 6 (pending)
- [ ] Copy A4 into Section 7
- [ ] Copy A5 into Section 8
- [ ] Write Section 2 (from A0)
- [ ] Write Section 9 (from D4 execution)
- [ ] Write Section 10 (from A0)

### Step 2: Insert Diagrams (Due: Mar 7, 11:00 AM)
- [ ] Export A4 UML to PNG
- [ ] Export A5 UML to PNG
- [ ] Insert all 5 PNGs at full width
- [ ] Add captions: "Figure X: [Pattern] — [Case Name]"

### Step 3: Format and Review (Due: Mar 7, 11:30 AM)
- [ ] Apply formatting standards
- [ ] Verify no code violations (Ctrl+F `public class`)
- [ ] Check cross-references (diagrams ↔ text)
- [ ] Generate Table of Contents
- [ ] Add page numbers

### Step 4: Export PDF (Due: Mar 7, 11:45 AM)
- [ ] Export as PDF (Word: File → Save As → PDF)
- [ ] Verify file name: `HMS_Creational_Patterns_Technical_Report.pdf`
- [ ] Open in PDF viewer, check all pages render
- [ ] Check file size < 10MB

### Step 5: Final Sign-Off (Due: Mar 7, 11:55 AM)
- [ ] Adham reviews complete PDF
- [ ] Sign off on quality and completeness
- [ ] Hand to Yassin for D6 bundling

---

## Integration Dependencies

```
A8 depends on:
├── A1 (Report template) ✅
├── B5 (Andrew's report) ✅
├── Y3 (Yassin's report) ✅
├── M3 (Maged's report) ⏳
├── D5 (QA pass) ✅
├── A4 (AF UML #1) ✅
└── A5 (AF UML #2) ✅
```

**Blocker:** M3 (Maged's Factory Method + AF report sections)

---

## Evidence Requirements

| Evidence | Source | Status |
|----------|--------|--------|
| Build success screenshot | NetBeans | ⏳ D4 execution |
| Run menu screenshot | NetBeans | ⏳ D4 execution |
| Pattern test screenshots | Manual test | ⏳ D4 execution |

---

## Final PDF Checklist

Before submitting:
- [ ] 5 pattern cases documented
- [ ] 5 UML diagrams inserted and readable
- [ ] No source code in main text
- [ ] All 5 patterns compile and run (verified in D4)
- [ ] DevOps tools mentioned (Git, Maven, JIRA)
- [ ] Assumptions explicit
- [ ] Page numbers present
- [ ] File name correct
- [ ] File size reasonable (<10MB)
- [ ] Team member names on cover

---

## File Location

**Output:**
`C:\Users\Adham Sobhy\Downloads\Introduction-To-Software-Engineering-Project\Software-Design-&-Development-Project\HMS_Creational_Patterns_Technical_Report.pdf`

---

**Status:** ✅ A8 Plan Complete — Assembly pending M3 input from Maged.
