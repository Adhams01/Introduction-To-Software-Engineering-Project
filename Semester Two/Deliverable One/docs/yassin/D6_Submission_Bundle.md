# D6 — Submission Bundle Owner (ZIPs + Folder Structure + Final Artifacts)

**Owner:** Yassin  
**Deliverable:** Complete submission package ready for Canvas upload  
**Due:** March 7, 2025 11:59 PM (hard deadline)

---

## Submission Requirements (From Rubric)

| # | Required Item | Format | Owner | Status |
|---|---------------|--------|-------|--------|
| 1 | PDF Technical Report | `.pdf` | Adham A8 | ⏳ Pending |
| 2 | NetBeans Project (complete, runnable) | `.zip` | Adham A7 | ⏳ Pending |
| 3 | UML diagrams for each case (5 total) | `.png` or `.jpg` | All | ⏳ 3/5 ready |
| 4 | UML project files (StarUML/PlantUML) | `.zip` | All | ⏳ Pending |
| 5 | DevOps evidence (Git, Maven, JIRA, IDE) | Screenshots/docs | Adham A0, Yassin D1-D2 | ✅ Ready |

---

## Bundle Structure

```
HMS-Deliverable-1-Submission/
├── 01-Technical-Report/
│   └── HMS_Creational_Patterns_Technical_Report.pdf
│       └── [A8 owner: Adham]
│       └── Sections: Intro, Automated Code Gen, Pattern Cases (×5),
│                      UML Diagrams, Implementation Confirmation,
│                      Assumptions
│
├── 02-NetBeans-Project/
│   └── HospitalMangementSystem_Maven.zip
│       └── [A7 owner: Adham]
│       └── Contents:
│           ├── src/main/java/hospitalmangementsystem/
│           │   ├── patterns/
│           │   │   ├── singleton/
│           │   │   │   ├── NotificationServiceSingleton.java  [Andrew B4]
│           │   │   │   └── PatientRegistrySingleton.java      [Yassin Y1]
│           │   │   ├── factory/
│           │   │   │   └── AppointmentFactory.java (and subclasses) [Maged M2]
│           │   │   └── abstractfactory/
│           │   │       ├── ReportAbstractFactory.java         [Adham A6]
│           │   │       └── UIComponentAbstractFactory.java      [Adham A6]
│           │   ├── HospitalMangementSystem.java (wiring)
│           │   └── ... (existing code)
│           ├── pom.xml (Maven config)
│           └── README.md (build/run instructions)
│
├── 03-UML-Diagrams/
│   ├── 01-Singleton-Case-1_NotificationServiceSingleton.png
│   ├── 02-Singleton-Case-2_PatientRegistrySingleton.png
│   ├── 03-Factory-Method_AppointmentFactory.png
│   ├── 04-Abstract-Factory-Case-1_ReportAbstractFactory.png      [Pending A4]
│   └── 05-Abstract-Factory-Case-2_UIComponentAbstractFactory.png [Pending A5]
│
├── 04-UML-Project-Files/
│   └── UML_Projects.zip
│       └── Contents:
│           ├── andrew/
│           │   ├── NotificationServiceSingleton.mdj
│           │   ├── PatientRegistrySingleton.mdj
│           │   └── AppointmentFactory.mdj
│           └── adham/
│               ├── ReportAbstractFactory.mdj                      [Pending A4]
│               └── UIComponentAbstractFactory.mdj                 [Pending A5]
│
├── 05-DevOps-Evidence/
│   ├── Git/
│   │   ├── branch-list.txt
│   │   ├── branch-protection-settings.png
│   │   └── sample-merged-pr.png
│   ├── Maven/
│   │   ├── pom.xml (copy)
│   │   ├── clean-build-success.png
│   │   └── run-menu-screenshot.png
│   ├── JIRA/
│   │   ├── board-view.png
│   │   ├── backlog-view.png
│   │   └── task-dependencies.png
│   └── IDE/
│       └── netbeans-project-view.png
│
└── 06-Individual-Deliverables/
    ├── andrew/
    │   ├── B1_Singleton_Cases_Proposal.md
    │   ├── B2_FactoryMethod_Case_Proposal.md
    │   ├── B3_UML_Diagrams.md
    │   ├── B5_Report_Singleton_Case1.md
    │   └── NotificationServiceSingleton.java
    ├── yassin/
    │   ├── D1_JIRA_Setup.md
    │   ├── D2_Git_Strategy.md
    │   ├── D3_Consistency_Check.md
    │   ├── D4_Final_Verification.md
    │   ├── D5_Diagram_Text_QA.md
    │   ├── Y1_PatientRegistrySingleton.java
    │   └── Y3_Report_Singleton_Case2.md
    ├── maged/
    │   ├── M1_AbstractFactory_Cases.md           [Pending M1]
    │   ├── M2_AppointmentFactory_Implementation.java [Pending M2]
    │   └── M3_Report_Sections.md                 [Pending M3]
    └── adham/
        ├── A0_Baseline_Checklist.md
        ├── A1_Report_Template.md
        ├── A3_Implementation_Rules.md
        └── A4-A6_AbstractFactory_UML_and_Code.md  [Pending A4-A6]
```

---

## File Naming Convention

| Item | Format | Example |
|------|--------|---------|
| PDF Report | `HMS_[PatternType]_Technical_Report.pdf` | `HMS_Creational_Patterns_Technical_Report.pdf` |
| Project ZIP | `HospitalMangementSystem_Maven.zip` | `HospitalMangementSystem_Maven.zip` |
| UML Images | `[Pattern]-Case-[#]_[ClassName].png` | `Singleton-Case-1_NotificationServiceSingleton.png` |
| UML Projects | `UML_Projects.zip` | `UML_Projects.zip` |
| Evidence | `[Tool]-[Description].png` | `maven-clean-build-success.png` |

---

## Pre-Submission Checklist

### PDF Technical Report Verification

- [ ] File name correct: `HMS_Creational_Patterns_Technical_Report.pdf`
- [ ] Page count reasonable (8-15 pages typical)
- [ ] All 5 pattern cases documented
- [ ] 5 UML diagrams inserted and readable
- [ ] No Java source code pasted (only UML)
- [ ] Assumptions section present
- [ ] Team members listed on cover page

### NetBeans Project Verification

- [ ] ZIP file name: `HospitalMangementSystem_Maven.zip`
- [ ] Unzips to valid Maven project structure
- [ ] `pom.xml` present in root
- [ ] `src/main/java/` structure intact
- [ ] All 5 pattern implementations present
- [ ] `HospitalMangementSystem.java` runnable entry point
- [ ] README with build/run instructions

### UML Diagrams Verification

- [ ] Exactly 5 PNG files (one per pattern case)
- [ ] Resolution ≥150 DPI (check file properties)
- [ ] Naming follows convention
- [ ] All diagrams show GoF structure correctly

### UML Project Files Verification

- [ ] ZIP file name: `UML_Projects.zip`
- [ ] Contains `.mdj` files (StarUML) or `.puml` files (PlantUML)
- [ ] Source files editable (not just exports)
- [ ] Organized by owner (andrew/, adham/)

### DevOps Evidence Verification

- [ ] Git: Branch protection screenshot
- [ ] Maven: Build success screenshot
- [ ] Maven: Run success screenshot
- [ ] JIRA: Board view screenshot
- [ ] IDE: Project structure screenshot

---

## Canvas Upload Instructions

### Step 1: Verify Bundle Contents

```powershell
cd C:\Users\Adham Sobhy\Downloads\Introduction-To-Software-Engineering-Project\Software-Design-&-Development-Project

# Check ZIP integrity
Expand-Archive -Path "HMS-Deliverable-1-Submission.zip" -DestinationPath "test-extract" -WhatIf
```

### Step 2: Create Final ZIP

```powershell
Compress-Archive -Path "HMS-Deliverable-1-Submission" -DestinationPath "HMS-Deliverable-1-FINAL.zip" -Force
```

### Step 3: Canvas Upload

| Field | Value |
|-------|-------|
| Assignment | Deliverable #1: Creational Design Patterns |
| File | `HMS-Deliverable-1-FINAL.zip` |
| Comments | "Team HMS submission: Singleton ×2, Factory Method ×1, Abstract Factory ×2. All code runs with zero errors. DevOps: Git, Maven, JIRA, NetBeans." |

---

## Sign-Off

**Bundle Prepared By:** Yassin  
**Date:** March 7, 2025  
**Status:** ⏳ Pending A7-A9 completion

| Component | Status | Blocker |
|-----------|--------|---------|
| PDF Report | ⏳ | Waiting A8 |
| NetBeans Project | ⏳ | Waiting A7 merge |
| UML Diagrams | ⏳ 3/5 | Waiting A4-A5 |
| UML Project Files | ⏳ 3/5 | Waiting A4-A5 |
| DevOps Evidence | ✅ | Ready |

**Final Sign-Off:** ❌ Not ready (pending Adham completion A4-A9)

---

## Emergency Contacts (If Issues)

| Issue | Contact | Backup |
|-------|---------|--------|
| Build fails | Adham (integration) | Andrew |
| Report incomplete | Adham (A8 owner) | — |
| UML missing | Adham (A4-A5) | — |
| Git issues | Yassin (D2 owner) | Adham |
| JIRA issues | Yassin (D1 owner) | — |

---

## Evidence Files

| File | Path |
|------|------|
| This bundle plan | `docs/yassin/D6_Submission_Bundle.md` |
| ZIP integrity check | `evidence/d6-zip-test.log` |
| Canvas upload confirmation | `evidence/d6-canvas-receipt.png` |

---

**Status:** ✅ D6 Complete — Bundle structure defined, checklist ready, pending final deliverables (A7-A9).
