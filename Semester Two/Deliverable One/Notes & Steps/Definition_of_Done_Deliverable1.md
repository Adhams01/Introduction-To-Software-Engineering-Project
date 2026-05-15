Definition of Done — Deliverable #1 (Creational Design Patterns)
=================================================================

For each pattern case (Singleton, Factory Method, Abstract Factory), the following must be completed and verified before the task is considered DONE:

1. Case Statement (Problem)
   - Clearly describe the problem or scenario that requires the pattern.
   - Include context from the HMS project (e.g., “Ensure a single notification service across the system”).

2. Why This Pattern (Justification)
   - Explain why the chosen design pattern is the optimal solution.
   - Contrast with alternatives (e.g., “Without Singleton, multiple instances would send duplicate notifications”).

3. UML Class Diagram
   - Create a UML class diagram that conceptually illustrates the proposed solution.
   - Include classes, interfaces, relationships, and key methods.
   - Export the diagram as an image for embedding in the report.

4. Java Implementation Integrated
   - Implement the pattern in Java under hospitalmangementsystem.patterns.*
   - Follow A3 Implementation Rules (layering, naming, no circular dependencies).
   - Ensure the code is part of the Maven project and compiles without errors.

5. Proof It Runs
   - NetBeans Clean and Build: BUILD SUCCESS (screenshot required).
   - NetBeans Run: Application starts and the pattern’s effect is visible (screenshot or console output snippet).
   - Store screenshots in the shared folder for the final report.

Additional Quality Gates
------------------------
- PR must include a brief description of how to test the pattern.
- PR title must reference the Jira task ID (e.g., “B4: Implement Singleton cases”).
- No external dependencies are added without team agreement.
- Changes are localized to the pattern package; existing code is not unnecessarily modified.

Enforcement
-----------
- Any task missing any of the above items will be marked as NOT DONE and must be completed before merge.
- These criteria apply to all team members (Adham, Andrew, Yassin).
