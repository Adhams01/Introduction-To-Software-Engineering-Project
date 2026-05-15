Dev Handoff to Andrew — Deliverable #1 (Creational Design Patterns)
================================================================

Andrew, here is everything you need to start B1/B2/B3/B4 safely.

Deadline: Saturday 7 March 2025 11:59 pm
Repo: https://github.com/Adhams01/Introduction-To-Software-Engineering-Project (replace with actual repo link)
Maven project (coding target): Software-Design-&-Development-Project/HospitalMangementSystem_Maven
Report template: [link to A1 Google Doc/Word file]
Implementation rules: [link to A3 file]
Git branch: feature/andrew-singleton-factory

---

Coding Target and Environment
-----------------------------
- Use the Maven project: HospitalMangementSystem_Maven
- Main class: hospitalmangementsystem.HospitalMangementSystem
- IDE: NetBeans
- Java version: 23 (configured in pom.xml)
- Build/Run verification: NetBeans Clean and Build -> BUILD SUCCESS; Run -> HMS menu appears

Where to Work Safely
--------------------
- Add all pattern code under: hospitalmangementsystem.patterns.*
  - hospitalmangementsystem.patterns.singleton
  - hospitalmangementsystem.patterns.factory
  - hospitalmangementsystem.patterns.abstractfactory
- Do not modify existing packages (controller, dao, domain, ui) unless absolutely necessary.

Core Domain Services (for context)
----------------------------------
- hospitalmangementsystem.domain.* (Appointment, Patient, Bill, etc.)
- hospitalmangementsystem.dao.* (AppointmentDAO, PatientDAO, etc.)
- hospitalmangementsystem.controller.* (AppointmentController, PatientController, etc.)
- hospitalmangementsystem.ui.* (Console UI classes)

Gotchas and Constraints
-----------------------
- No external dependencies without team agreement.
- Follow A3 Implementation Rules strictly (layering, naming, no circular dependencies).
- Always NetBeans Clean and Build + Run before creating a PR.
- PR title must include Jira task ID (e.g., “B1: Singleton cases proposal”).
- PR description must include:
  - What was implemented
  - How to test it
  - Confirmation that Clean and Build + Run passed

Your Tasks (B1–B5)
------------------
B1 – Singleton cases proposal (depends on A0)
- Propose 2 realistic Singleton cases from the HMS project.
- Output: case statements + justification bullets.

B2 – Factory Method case proposal (depends on A0)
- Propose 1 Factory Method case from the HMS project.
- Output: case statement + justification bullets.

B3 – UMLs for Andrew cases (depends on B1, B2, A3)
- Create UML class diagrams for:
  - Singleton Case #1
  - Singleton Case #2
  - Factory Method case
- Output: 3 UML diagrams + brief rationale text for each.

B4 – Implement Singleton + Factory Method (depends on B3, A3)
- Implement the patterns in Java under hospitalmangementsystem.patterns.*
- Ensure NetBeans Clean and Build + Run PASS.
- Output: working implementations merged-ready.

B5 – Write Singleton + Factory Method sections (depends on B3, B4)
- Write report text for Singleton + Factory Method sections.
- Embed UML diagrams.
- Output: report-ready text + exported diagrams.

How We Will Freeze Cases (A2)
-----------------------------
- After you submit B1 and B2, Adham will review and freeze the final list in A2.
- Each case must be:
  - Real in the HMS context
  - Unique (no overlap with other patterns)
  - Have a clear insertion point in code (class/package)

Definition of Done (for each case)
----------------------------------
- Case statement (problem)
- Why this pattern (justification)
- UML class diagram
- Java implementation integrated
- Proof it runs (NetBeans Clean and Build + Run screenshots)

If anything is unclear, ask Adham before starting B1/B2.
