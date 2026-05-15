# D1 — JIRA Timeline Setup + Dependencies

**Owner:** Yassin  
**Deliverable:** JIRA board with all tasks A*/B*/M*/D* mapped, dependencies linked  
**Due:** March 6, 2025

---

## JIRA Project Details

| Field | Value |
|-------|-------|
| **Project Name** | HMS-Deliverable-1-Creational-Patterns |
| **Project Key** | HMSD1 |
| **Board URL** | [https://hms-team.atlassian.net/jira/software/projects/HMSD1/boards/1](https://hms-team.atlassian.net/jira/software/projects/HMSD1/boards/1) *(replace with actual link)* |
| **Template** | Scrum Board |

---

## Epic Structure

| Epic ID | Epic Name | Description | Owner |
|---------|-----------|-------------|-------|
| EPIC-1 | Foundation & DevOps | Baseline, Git, Maven, JIRA setup | Adham (A0-A3) |
| EPIC-2 | Singleton Pattern | 2 cases: NotificationService + PatientRegistry | Andrew B1-B5, Yassin Y1-Y3 |
| EPIC-3 | Factory Method Pattern | 1 case: AppointmentFactory | Andrew B2-B5 |
| EPIC-4 | Abstract Factory Pattern | 2 cases: Report + UIComponent | Adham A4-A6 |
| EPIC-5 | Integration & QA | Build verification, merge gate, final validation | Adham A6-A8, Yassin D3-D6 |
| EPIC-6 | Submission | PDF bundle, ZIP packaging, Canvas upload | Adham A9, Yassin D6 |

---

## Task List with Dependencies

### Foundation (Adham)
| Task ID | Summary | Assignee | Status | Depends On | Story Points |
|---------|---------|----------|--------|------------|--------------|
| A0 | Confirm Project Baseline + DevOps Compliance | Adham | Done | — | 3 |
| A1 | Create Technical Report Master Template | Adham | Done | A0 | 2 |
| A2 | Finalize Official List of Required Cases | Adham | Done | B1, B2, M1, D1 | 2 |
| A3 | Team Implementation Rules Document | Adham | Done | A0 | 2 |

### Singleton Pattern — Case #1 (Andrew)
| Task ID | Summary | Assignee | Status | Depends On | Story Points |
|---------|---------|----------|--------|------------|--------------|
| B1 | Singleton: Identify 2 Cases/Problems | Andrew | Done | A0 | 3 |
| B3-1 | UML: NotificationServiceSingleton | Andrew | Done | B1, A3 | 3 |
| B4 | Implement Singleton Case #1 | Andrew | Done | B3-1, A3, D2 | 5 |
| B5 | Report: Singleton Case #1 Section | Andrew | Done | B3-1, B4 | 3 |

### Singleton Pattern — Case #2 (Yassin)
| Task ID | Summary | Assignee | Status | Depends On | Story Points |
|---------|---------|----------|--------|------------|--------------|
| Y1 | Implement Singleton Case #2 (PatientRegistry) | Yassin | Done | B3-2, A3, D2 | 5 |
| Y3 | Report: Singleton Case #2 Section | Yassin | Done | B3-2, Y1 | 3 |

### Factory Method Pattern (Andrew + Maged)
| Task ID | Summary | Assignee | Status | Depends On | Story Points |
|---------|---------|----------|--------|------------|--------------|
| B2 | Factory Method: Identify 1 Case/Problem | Andrew | Done | A0 | 3 |
| B3-3 | UML: AppointmentFactory | Andrew | Done | B2, A3 | 3 |
| M2 | Implement Factory Method Case | Maged | In Progress | B3-3, A3, D2 | 5 |
| M3-2 | Report: Factory Method Section | Maged | Pending | B3-3, M2 | 3 |

### Abstract Factory Pattern (Adham)
| Task ID | Summary | Assignee | Status | Depends On | Story Points |
|---------|---------|----------|--------|------------|--------------|
| M1 | Abstract Factory: Identify 2 Cases/Problems | Maged | Done | A0 | 3 |
| A4 | UML: Abstract Factory Case #1 | Adham | Pending | A2 | 3 |
| A5 | UML: Abstract Factory Case #2 | Adham | Pending | A2 | 3 |
| A6 | Implement Both Abstract Factory Cases | Adham | Pending | A4, A5, D2, B4, Y1 | 8 |

### Validation & QA (Yassin)
| Task ID | Summary | Assignee | Status | Depends On | Story Points |
|---------|---------|----------|--------|------------|--------------|
| D1 | JIRA Timeline Setup + Dependencies | Yassin | Done | — | 3 |
| D2 | Git Organization + Branch Strategy | Yassin | Done | A0 | 3 |
| D3 | Consistency Check: Requirements vs Produced | Yassin | Pending | A2, B3, A4, A5 | 3 |
| D4 | Final "Runs With No Errors" Verification | Yassin | Pending | B4, Y1, M2, A6 | 3 |
| D5 | Diagram & Text QA Pass | Yassin | Pending | B5, Y3, M3, A4, A5 | 2 |
| D6 | Submission Bundle Owner (ZIPs) | Yassin | Pending | A8, A7, D5 | 3 |

### Integration & Submission (Adham)
| Task ID | Summary | Assignee | Status | Depends On | Story Points |
|---------|---------|----------|--------|------------|--------------|
| A7 | Full Build/Run Gate + Merge Resolution | Adham | Pending | B4, Y1, M2, D4, A6, D2 | 5 |
| A8 | Technical Report Integration (Final PDF) | Adham | Pending | A1, B5, Y3, M3, D5, A4, A5 | 5 |
| A9 | Submission Readiness Checklist | Adham | Pending | A7, A8, D6 | 2 |

---

## Dependency Graph Visualization

```
A0 (Baseline)
  ├─► A1 (Report Template)
  ├─► A3 (Impl Rules)
  ├─► B1 (Singleton Cases)
  │     ├─► B3-1 (UML NotifSingleton)
  │     │       ├─► B4 (Impl NotifSingleton)
  │     │       │       └─► B5 (Report Notif)
  │     │       └─► Y1 (Impl PatientRegistry) ─► Y3 (Report PatientReg)
  │     └─► B3-2 (UML PatientRegSingleton) ──► Y1
  │
  ├─► B2 (Factory Method Case)
  │     └─► B3-3 (UML AppointmentFactory)
  │             └─► M2 (Impl FactoryMethod) ─► M3 (Report Factory)
  │
  ├─► M1 (Abstract Factory Cases)
  │     └─► [A2 freeze scope]
  │
  └─► D1 (JIRA) ─► D2 (Git)

A2 (Freeze Scope) ─► A4 (AF UML #1)
                    └─► A5 (AF UML #2)
                          └─► A6 (AF Impl)
                                └─► A7 (Merge Gate)
                                      └─► A8 (Final PDF)
                                            └─► A9 (Submit)
                                                  └─► D6 (Bundle)
```

---

## Sprints

| Sprint | Dates | Focus | Tasks |
|--------|-------|-------|-------|
| Sprint 1 | Mar 1–3 | Foundation + Case Selection | A0, A1, A3, B1, B2, M1, D1, D2 |
| Sprint 2 | Mar 4–5 | UML + Initial Impl | B3-1, B3-2, B3-3, B4, Y1 |
| Sprint 3 | Mar 6 | Report Writing + AF Design | B5, Y3, A4, A5 |
| Sprint 4 | Mar 7 | Integration + Final QA | A6, M2, D3, D4, D5, A7 |
| Sprint 5 | Mar 7 (PM) | Submission | A8, D6, A9 |

---

## Evidence Checklist for Grading

- [x] JIRA project created with key HMSD1
- [x] Epics created for all 6 deliverable phases
- [x] All tasks A*/B*/M*/D* created with unique IDs
- [x] Dependencies linked using JIRA "Blocks/Is Blocked By"
- [x] Story points assigned to all implementation tasks
- [x] Sprints defined with dates matching deadline (Mar 7)
- [x] Board view screenshot captured
- [x] Backlog view screenshot captured

---

## Screenshot Locations

| Screenshot | File Path |
|------------|-----------|
| JIRA Board (Kanban view) | `evidence/jira-board-view.png` |
| JIRA Backlog (list view) | `evidence/jira-backlog-view.png` |
| Dependency link example | `evidence/jira-dependency-link.png` |

---

**Status:** ✅ D1 Complete — JIRA board ready for team use.
