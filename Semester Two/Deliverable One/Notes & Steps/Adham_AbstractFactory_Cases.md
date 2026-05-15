Adham’s Abstract Factory Cases — Deliverable #1
===============================================

Chosen Cases (2)
----------------
1. ReportAbstractFactory
   - Creates a family of related report objects:
     - PatientReport
     - BillingReport
     - AppointmentReport
   - Why it fits:
     - Reports must be consistent in formatting and metadata.
     - Different output formats (PDF, HTML, Plain Text) can be swapped by changing the factory.
     - Avoids scattering report creation logic across the system.

2. UIComponentAbstractFactory
   - Creates a family of related UI component sets:
     - Console UI components (labels, inputs, menus)
     - Swing UI components (frames, panels, buttons)
     - Web UI components (HTML forms, tables, links)
   - Why it fits:
     - Ensures UI consistency within a chosen family (e.g., all console or all Swing).
     - Allows the application to switch UI styles without changing business logic.
     - Demonstrates true Abstract Factory intent: create families of related products.

Why These Cases Don’t Collide with Andrew’s Work
------------------------------------------------
- Andrew will likely focus on Singleton (e.g., NotificationService, PatientRegistry) and Factory Method (e.g., AppointmentFactory) which are domain/service-level patterns.
- These Abstract Factory cases target:
  - Cross-cutting concerns (reports)
  - Presentation layer (UI families)
- This separation keeps implementations independent and avoids merge conflicts.

Integration Plan
----------------
- Implement both factories under hospitalmangementsystem.patterns.abstractfactory
- Each factory will have:
  - Abstract factory interface
  - Concrete factory per family (e.g., PdfReportFactory, HtmlReportFactory)
  - Abstract product interfaces
  - Concrete product implementations
- Keep changes localized; do not modify existing UI or report logic unless necessary.
- Ensure NetBeans Clean and Build + Run PASS after each factory is added.
