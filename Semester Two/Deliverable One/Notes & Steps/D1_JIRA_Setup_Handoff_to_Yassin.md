D1 — JIRA Board Setup for Deliverable #1 (Creational Design Patterns)
================================================================

Yassin, please create Jira tasks with these exact IDs and dependencies. Use the “depends on” field or link tasks in the description.

Deadline: Saturday 7 March 2025 11:59 pm
Repo: https://github.com/[your-repo-link] (replace with actual repo link)
Report template: [link to A1 Google Doc/Word file]
Implementation rules: [link to A3 file]

---

A0 – Baseline checklist (status: DONE)
- Confirm build/run/Maven/IDE/Git/Jira
- Evidence: screenshots + checklist
- Depends on: none

A1 – Report master template (status: DONE)
- Empty PDF structure with headings matching rubric
- Depends on: none

A2 – Freeze pattern cases (status: PENDING)
- Final list: 2 Singleton, 1 Factory Method, 2 Abstract Factory
- Depends on: B1, B2, D1

A3 – Implementation rules (status: DONE)
- 1-page rules doc attached
- Depends on: none

A4 – Abstract Factory UML #1 (status: PENDING)
- UML class diagram + rationale
- Depends on: A2

A5 – Abstract Factory UML #2 (status: PENDING)
- UML class diagram + rationale
- Depends on: A2

A6 – Abstract Factory implementation (status: PENDING)
- Java code for both Abstract Factory cases
- Depends on: A4, A5, A3

A7 – Integration gate (status: PENDING)
- Merge all branches, resolve conflicts, ensure build/run passes
- Depends on: B4, A6, D2

A8 – Final PDF assembly (status: PENDING)
- Merge all sections + diagrams into final PDF
- Depends on: A4, A5, B5, D5

A9 – Submission checklist (status: PENDING)
- Confirm all deliverables are ready and uploaded
- Depends on: A7, A8

---

B1 – Singleton cases proposal (status: PENDING)
- Propose 2 Singleton cases from the project
- Depends on: A0

B2 – Factory Method case proposal (status: PENDING)
- Propose 1 Factory Method case from the project
- Depends on: A0

B3 – UMLs for Andrew cases (status: PENDING)
- Create UML class diagrams for:
  - Singleton Case #1
  - Singleton Case #2
  - Factory Method case
- Depends on: B1, B2, A3

B4 – Implement Singleton + Factory Method (status: PENDING)
- Java code for:
  - 2 Singleton cases
  - 1 Factory Method case
- Depends on: B3, A3

B5 – Write Singleton + Factory Method sections (status: PENDING)
- Report text + embed UMLs for Singleton + Factory Method
- Depends on: B3, B4

---

D1 – JIRA board setup (status: PENDING)
- Create all tasks above with correct dependencies
- Depends on: this plan

D2 – Git organization + branch strategy (status: PENDING)
- Create branches:
  - main (protected)
  - develop (integration)
  - feature/andrew-singleton-factory
  - feature/adham-abstract-factory
  - feature/yassin-qa-packaging
- Enforce PR rules
- Depends on: A0

D3 – Consistency check (status: PENDING)
- Verify all requirements are satisfied:
  - 2 Singleton cases
  - 1 Factory Method case
  - 2 Abstract Factory cases
  - UML diagram for each case
  - Implementation runs without errors
  - DevOps tools reflected (Git, Maven, JIRA, IDE)
- Depends on: A2, B3, A4, A5

D4 – Final run verification (status: PENDING)
- Pull latest integrated code and verify compile/run
- Output: pass/fail + exact errors if fail
- Depends on: B4, A6

D5 – Diagram & text QA (status: PENDING)
- Review naming consistency, pattern correctness, diagram readability
- Output: “ready to freeze” sign-off or fix list
- Depends on: B5, A4, A5

D6 – Submission bundle (status: PENDING)
- Prepare submission bundle:
  - PDF Technical Report
  - NetBeans project (complete runnable)
  - UML project files (zipped)
  - Exported UML diagrams used in report
- Depends on: A8, A7

================================================================
Instructions for Yassin:
1. Create the above tasks in Jira.
2. Link dependencies as listed.
3. Set due dates:
   - B1, B2, D1, D2: within 2 days
   - B3, B4, A2, A3, A4, A5: within 4 days
   - B5, A6, D3, D4, D5: within 6 days
   - A7, A8, A9: final 2 days before deadline
4. Share the board link with the team.
5. Update task statuses as work progresses.

If any task is unclear, ask Adham before creating it.
