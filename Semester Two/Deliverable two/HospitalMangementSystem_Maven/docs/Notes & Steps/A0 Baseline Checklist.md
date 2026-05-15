# A0 — Project Baseline + DevOps Compliance Snapshot

**Owner:** Adham (Team Lead)  
**Deliverable:** #2 — Structural Design Patterns  
**Date:** 2026-03-22  
**Status:** ✅ BASELINE CONFIRMED

---

## 1. Maven Build Verification

| Check | Expected | Actual | Status |
|-------|----------|--------|--------|
| Maven Version | 3.9+ | 3.9.6 | ✅ |
| Java Version | 17 | 17 | ✅ |
| Clean Build | BUILD SUCCESS | BUILD SUCCESS | ✅ |
| Zero Errors | 0 compilation errors | 0 errors | ✅ |
| Package Structure | `hospitalmanagementsystem.patterns.structural.*` | ✅ | ✅ |
| Main Class | `HospitalMangementSystem` | ✅ | ✅ |

**Build Command:**
```bash
mvn clean package
```

**Result:**
```
[INFO] Building HospitalMangementSystem_Maven 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] --- clean:3.2.0:clean (default-clean) @ HospitalMangementSystem_Maven ---
[INFO] --- compiler:3.12.1:compile (default-compile) @ HospitalMangementSystem_Maven ---
[INFO] Compiling 25 source files with javac [debug release 17]
[INFO] BUILD SUCCESS
```

---

## 2. Git Repository Status

| Check | Expected | Actual | Status |
|-------|----------|--------|--------|
| Repository URL | `https://github.com/Adhams01/Software-Engineering-Project` | ✅ | ✅ |
| Branch Strategy | feature/[CASE]-[owner] | ✅ | ✅ |
| Main Branch | Clean, protected | ✅ | ✅ |
| .gitignore | Excludes target/, .class, IDE files | ✅ | ✅ |

**Active Branches (Expected):**
- `main` — production code
- `feature/BR1-adham` — Bridge Notification (merged)
- `feature/BR2-andrew` — Bridge Report (merged)
- `feature/AD1-andrew` — Adapter Patient (merged)
- `feature/FW1-maged` — Flyweight (merged)

---

## 3. JIRA Project Status

| Check | Expected | Actual | Status |
|-------|----------|--------|--------|
| Project Created | SW312-D2 or similar | ⬜ PENDING | ⬜ |
| Tasks Created | A0-A5, B0-B3, Y0-Y4, M0-M4 | ⬜ PENDING | ⬜ |
| Dependencies Linked | A0 → B0, B0 → B1, etc. | ⬜ PENDING | ⬜ |
| Timeline Set | Due Nov 7, 11:59 PM | ⬜ PENDING | ⬜ |

**Action Required:** Yassin (Y0) to complete JIRA setup.

---

## 4. Project Structure Confirmation

```
Deliverable two/
├── HospitalMangementSystem_Maven/
│   ├── pom.xml                              ✅ Maven configured
│   ├── src/main/java/hospitalmanagementsystem/
│   │   ├── HospitalMangementSystem.java     ✅ Main menu
│   │   └── patterns/structural/
│   │       ├── bridge/
│   │       │   ├── notification/            ✅ BR1 - Adham
│   │       │   │   ├── Notification.java
│   │       │   │   ├── NotificationChannel.java
│   │       │   │   ├── EmailChannel.java
│   │       │   │   ├── SmsChannel.java
│   │       │   │   ├── InAppChannel.java
│   │       │   │   ├── NotificationBridgeDemo.java
│   │       │   │   ├── AppointmentReminder.java
│   │       │   │   └── BillingAlert.java
│   │       │   └── report/                  ✅ BR2 - Andrew
│   │       ├── adapter/
│   │       │   └── patient/               ✅ AD1 - Andrew
│   │       ├── flyweight/                 ✅ FW1 - Maged
│   │       └── decorator/
│   │           └── report/                ⬜ DC1 - Adham
│   ├── docs/
│   │   ├── UML Diagrams/                  ⚠️ Partial
│   │   │   ├── Bridge/
│   │   │   │   └── ReportBridge.mdj       ✅ BR2
│   │   │   ├── Adapter/
│   │   │   │   └── PatientSystemAdapter.mdj ✅ AD1
│   │   │   ├── Flyweight/
│   │   │   │   ├── Flyweight.mdj          ✅ FW1
│   │   │   │   └── Flyweight.png          ✅ FW1
│   │   │   └── Decorator/                 ⬜ DC1, DC2
│   │   └── Notes & Steps/
│   │       ├── B0 Git Rules.md            ✅ Andrew
│   │       ├── B3 Report Sections.md      ✅ Andrew
│   │       ├── M0 Formatting Rules.md     ✅ Maged
│   │       ├── M3 Requirements Check.md   ✅ Maged
│   │       ├── A0 Baseline Checklist.md   ✅ This doc
│   │       └── A1 Report Template.md      ✅ Adham
│   └── target/                            ✅ Build output
```

---

## 5. Assumptions

| # | Assumption | Rationale | Risk |
|---|------------|-----------|------|
| A1 | Java 17 is acceptable | Team JDK version | Low — confirmed working |
| A2 | Maven 3.9+ available | Build tool standard | Low — NetBeans bundled |
| A3 | UML created in StarUML | Team UML tool choice | Low — .mdj files confirmed |
| A4 | All demos run from console | No GUI required for D2 | Low — menu system works |

---

## 6. Sign-off

**Baseline confirmed by:** Adham  
**Date:** 2026-03-22  
**Status:** ✅ READY FOR IMPLEMENTATION

| Item | Status | Blocker |
|------|--------|---------|
| Maven Build | ✅ | None |
| Git Strategy | ✅ | None |
| JIRA Setup | ⬜ | Y0 pending |
| Package Structure | ✅ | None |
| Team Ready | ✅ | None |

---

## 7. Next Actions

1. **Y0** — Complete JIRA board setup with all tasks
2. **Adham** — Create DC1 Decorator implementation
3. **Yassin** — Create AD2 + DC2 implementations
4. **Maged** — Create DC2 Decorator implementation
5. **All** — Export UML diagrams as PNG for report
