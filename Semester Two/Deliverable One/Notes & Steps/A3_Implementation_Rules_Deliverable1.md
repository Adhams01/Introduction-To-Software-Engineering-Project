Implementation Rules for Deliverable #1 — Creational Design Patterns
============================================================

1. Root Package
   • All code must stay under the root package: hospitalmangementsystem
   • Do not create new top-level packages outside this root.

2. Where Patterns Live
   • All creational patterns must be placed under:
       hospitalmangementsystem.patterns.*
   • Sub-packages:
       - hospitalmangementsystem.patterns.singleton
       - hospitalmangementsystem.patterns.factory
       - hospitalmangementsystem.patterns.abstractfactory
   • This makes review and testing easier and keeps patterns discoverable.

3. Layering Rules (no violations)
   • UI / Main → Controller → Domain / DAO
   • UI may only call Controllers.
   • Controllers may call Domain and DAO.
   • Domain may call DAO (but not UI or Controllers directly).
   • DAO may not call Controllers or UI.
   • No circular dependencies across packages.

4. Naming Conventions
   • Classes: PascalCase (e.g., PatientController, AppointmentDAO)
   • Methods: camelCase (e.g., registerPatient, cancelAppointment)
   • Patterns:
       - Singleton classes end with “Singleton” (e.g., NotificationServiceSingleton)
       - Factory classes end with “Factory” (e.g., AppointmentFactory)
       - Abstract Factory classes end with “AbstractFactory” (e.g., ReportAbstractFactory)
   • Packages: lowercase, dot-separated (e.g., dao, controller, domain, patterns)

5. Build and Run Verification
   • Before any PR, you must:
       1) NetBeans → Clean and Build → confirm BUILD SUCCESS
       2) NetBeans → Run → confirm app starts and menu appears
   • If either step fails, do not submit the PR.

6. Branch and PR Discipline
   • Work only on your assigned feature branch.
   • PR title must include the Jira task ID (e.g., “B4: Implement Singleton cases”).
   • PR description must include:
       - What was implemented
       - How to test it
       - Confirmation that Clean and Build + Run passed

7. No Hardcoded Paths or Configs
   • Do not hardcode file paths or environment-specific values.
   • Use relative paths or configurable properties.

8. Documentation in Code (minimal but required)
   • Each pattern class must include:
       - A short comment explaining why the pattern is used
       - A comment showing the public API (what other classes should call)
   • Do not include implementation details in the report (as per rubric).

9. Testing Evidence (for the report)
   • For each pattern, capture:
       - A screenshot of NetBeans Clean and Build (BUILD SUCCESS)
       - A screenshot of the app running with the pattern in use (menu flow or console output)
   • Store these screenshots in a shared folder for the final report.

10. Maven and DevOps Compliance
    • All changes must be committed to the correct branch.
    • Maven project (HospitalMangementSystem_Maven) must build and run.
    • Use the same Maven project for all pattern implementations.
    • Do not add external dependencies without team agreement.

============================================================
Enforcement
- Any PR violating these rules will be rejected and must be fixed before re-submission.
- These rules apply to all team members (Adham, Andrew, Yassin).
