# A9 — Submission Readiness Checklist (Final Sign-Off)

**Owner:** Adham (Team Leader)  
**Deliverable:** Final sign-off confirming submission completeness  
**Due:** March 7, 2025 11:59 PM

---

## Pre-Submission Verification

### Team Sign-Off Status

| Team Member | All Tasks Complete | Evidence Submitted | Sign-Off |
|-------------|-------------------|-------------------|----------|
| **Adham** (Leader, A*) | ⏳ A4-A8 done, pending final integration | ✅ | ⏳ |
| **Andrew** (B*) | ✅ B1-B5 complete | ✅ | ✅ |
| **Yassin** (Y*, D*) | ✅ Y1, Y3, D1-D6 complete | ✅ | ✅ |
| **Maged** (M*) | ⏳ M1 done, M2-M3 pending | ⏳ | ⏳ |

**Overall Readiness:** 75% (blocked on Maged M2-M3)

---

## Submission Components Checklist

### 1. PDF Technical Report ✅⚠️

| Check | Required | Status | Notes |
|-------|----------|--------|-------|
| File exists | `HMS_Creational_Patterns_Technical_Report.pdf` | ⏳ | Pending A8 assembly |
| Cover page with team info | Yes | ⏳ | Template ready |
| 5 pattern cases documented | Yes | ✅ 4/5 | AF #1, AF #2, Singleton #1, Singleton #2 ✅; Factory Method ⏳ |
| 5 UML diagrams inserted | Yes | ✅ 4/5 | Same as above |
| No code in report | Yes | ⏳ | Verify before export |
| Assumptions section | Yes | ✅ | From A0 |
| Page numbers | Yes | ⏳ | Auto-gen on export |

**Evidence Location:** `HMS_Creational_Patterns_Technical_Report.pdf`

---

### 2. NetBeans Project (Runnable) ✅⚠️

| Check | Required | Status | Notes |
|-------|----------|--------|-------|
| Maven project structure | Yes | ✅ | `HospitalMangementSystem_Maven/` |
| pom.xml configured | Yes | ✅ | Java 23, exec plugin |
| All 5 patterns implemented | Yes | ✅ 4/5 | AF#1, AF#2, S#1, S#2 ✅; Factory ⏳ |
| `mvn clean compile` passes | Yes | ⏳ | Verify before ZIP |
| `mvn exec:java` runs | Yes | ⏳ | Test menu appears |
| Zero compiler errors | Yes | ⏳ | D4 verification |
| Zero runtime errors | Yes | ⏳ | D4 verification |

**Evidence Location:** `HospitalMangementSystem_Maven.zip`

---

### 3. UML Diagrams (Exported) ✅

| Diagram | File | Status |
|---------|------|--------|
| Singleton Case #1 | `uml/andrew/NotificationServiceSingleton.png` | ✅ |
| Singleton Case #2 | `uml/andrew/PatientRegistrySingleton.png` | ✅ |
| Factory Method | `uml/andrew/AppointmentFactory.png` | ✅ |
| Abstract Factory #1 | ⏳ `uml/adham/ReportAbstractFactory.png` | Export from A4 |
| Abstract Factory #2 | ⏳ `uml/adham/UIComponentAbstractFactory.png` | Export from A5 |

---

### 4. UML Project Files (Editable) ✅

| Source | Files | Status |
|--------|-------|--------|
| Andrew | `.mdj` files in `uml/andrew/` | ✅ |
| Adham | ⏳ Export from A4-A5 PlantUML | Pending export |

**Bundle:** `UML_Projects.zip`

---

### 5. DevOps Evidence ✅

| Tool | Evidence | Status | Location |
|------|----------|--------|----------|
| **Git** | Branch list, protection rules, PR history | ✅ | D2, branch screenshots |
| **Maven** | pom.xml, build success, run success | ✅ | A0, build screenshots |
| **JIRA** | Board view, backlog, dependencies | ✅ | D1, board screenshots |
| **IDE** | NetBeans project view | ✅ | IDE screenshot |

**Bundle:** `05-DevOps-Evidence/`

---

## Rubric Compliance Check

| Rubric Item | Weight | Status | Evidence |
|-------------|--------|--------|----------|
| 2 Singleton cases | Mandatory | ✅ | B4, Y1 |
| 1 Factory Method case | Mandatory | ⏳ | M2 pending |
| 2 Abstract Factory cases | Mandatory | ✅ | A6 (AF#1, AF#2) |
| UML per case (5 total) | Mandatory | ✅ 4/5 | Export AF UMLs |
| Implementation runs | Mandatory | ⏳ | D4 execution |
| DevOps (Git/Maven/JIRA/IDE) | Mandatory | ✅ | A0, D1, D2 |
| Technical report PDF | Mandatory | ⏳ | A8 assembly |
| No code in report | Mandatory | ⏳ | Verify before submit |
| Assumptions documented | Mandatory | ✅ | A0 baseline checklist |

---

## Critical Blockers

| ID | Blocker | Owner | Resolution Due |
|----|---------|-------|----------------|
| B-1 | Factory Method implementation (M2) | Maged | Mar 6 EOD |
| B-2 | Factory Method report section (M3) | Maged | Mar 6 EOD |
| B-3 | AF UML diagram exports (A4-A5) | Adham | Mar 7 10AM |
| B-4 | Final build verification (D4) | Yassin | Mar 7 11AM |
| B-5 | PDF assembly and export (A8) | Adham | Mar 7 11:45AM |

---

## Contingency Plans

### If Maged M2-M3 Not Ready by Mar 6 EOD:
**Option A:** Adham implements Factory Method placeholder (2 hours) to unblock submission. Maged provides partial credit.  
**Option B:** Submit without Factory Method (violates rubric — not recommended).  
**Decision:** Proceed with Option A if Maged doesn't deliver.

### If Build Errors Found in D4:
**Action:** Adham fixes in A7 (merge gate), Yassin re-runs D4. Budget 1 hour for fixes.

### If File Size > 10MB:
**Action:** Compress images, exclude unnecessary files from ZIP. Yassin handles in D6.

---

## Final Sign-Off Procedure

### Step 1: Pre-Flight Check (11:30 PM)
- [ ] All 5 patterns compile (`mvn clean compile`)
- [ ] All 5 patterns run (`mvn exec:java` test each menu option)
- [ ] PDF exported and opens correctly
- [ ] ZIP file created and < 10MB
- [ ] Canvas upload page accessible

### Step 2: Upload to Canvas (11:45 PM)
- [ ] Navigate to assignment page
- [ ] Attach `HMS-Deliverable-1-FINAL.zip`
- [ ] Verify file name correct
- [ ] Add submission comment: "Team HMS: 5 creational patterns, all code runs, DevOps evidence included."
- [ ] Click Submit

### Step 3: Confirm Receipt (11:55 PM)
- [ ] Screenshot Canvas confirmation page
- [ ] Download submitted file to verify integrity
- [ ] Notify team: "Submission complete"

---

## Sign-Off Authority

**I, as Team Leader, confirm:**

- ✅ All team members have completed their assigned tasks (or contingency plans executed)
- ✅ All submission components are present and correct
- ✅ The submission meets all rubric requirements
- ✅ The code compiles and runs with zero errors
- ✅ The technical report contains no source code
- ✅ We are ready to submit

**Leader Signature:** _________________________  
**Date/Time:** March 7, 2025, _____ PM

---

## Emergency Contacts

| Issue | Contact | Backup |
|-------|---------|--------|
| Last-minute build failure | Adham | Andrew |
| Canvas upload issues | Yassin | Adham |
| File corruption | Yassin (D6 owner) | — |
| Missing deliverable | Adham (reassign) | — |

---

## Evidence Files

| File | Path |
|------|------|
| This checklist | `docs/adham/A9_Submission_Readiness_Checklist.md` |
| Canvas confirmation | `evidence/canvas-submission-confirmation.png` |
| Final ZIP integrity | `evidence/final-zip-contents.txt` |

---

**Status:** ⏳ Ready pending M2-M3 completion and final integration (A7).

**Final Submission Deadline:** March 7, 2025 11:59 PM
