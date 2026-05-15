# Y0 — JIRA Timeline Setup + Dependencies

**Owner:** Yassin  
**Deliverable:** #2 — Structural Design Patterns  
**Status:** ⬜ PENDING — Screenshots Required

---

## 1. JIRA Project Configuration

### 1.1 Project Details
| Setting | Value |
|---------|-------|
| Project Name | SW312-D2-HMS |
| Project Key | HMSD2 |
| Template | Scrum or Kanban |
| Lead | Adham |

### 1.2 Team Members
| Member | Role | JIRA Username |
|--------|------|---------------|
| Adham | Team Lead | adham.hms |
| Andrew | Git/Integration | andrew.hms |
| Yassin | JIRA/QA | yassin.hms |
| Maged | Formatting/Submission | maged.hms |

---

## 2. Task Structure (To Be Created in JIRA)

### 2.1 Part 0 — Foundation Tasks
| Code | Summary | Assignee | Story Points | Status |
|------|---------|----------|--------------|--------|
| A0 | Confirm Project Baseline + DevOps | Adham | 3 | ⬜ |
| A1 | Create Deliverable #2 Master Template | Adham | 5 | ⬜ |
| B0 | Git Organization + Branch/PR Rules | Andrew | 3 | ⬜ |
| Y0 | JIRA Timeline Setup + Dependencies | Yassin | 3 | ⬜ |
| M0 | Report Formatting + Consistency Rules | Maged | 2 | ⬜ |

### 2.2 Part 1 — Pattern Implementation Tasks
| Code | Summary | Assignee | Story Points | Depends On | Status |
|------|---------|----------|--------------|------------|--------|
| A2 | Bridge BR1 — Notification System | Adham | 8 | A0, B0 | ⬜ |
| A3 | Decorator DC1 — Report Enhancements | Adham | 8 | A0, B0 | ⬜ |
| B1 | Bridge BR2 — Report Content × Renderer | Andrew | 8 | A0, B0 | ⬜ |
| B2 | Adapter AD1 — External Patient System | Andrew | 8 | A0, B0 | ⬜ |
| Y1 | Adapter AD2 — Payment Gateway | Yassin | 8 | A0, B0 | ⬜ |
| Y2 | Decorator DC2 — Notification Decorators | Yassin | 8 | A0, B0 | ⬜ |
| M1 | Flyweight FW1 — Medical Codes | Maged | 8 | A0, B0 | ⬜ |

### 2.3 Part 2 — Integration & Report Tasks
| Code | Summary | Assignee | Story Points | Depends On | Status |
|------|---------|----------|--------------|------------|--------|
| A4 | Merge Gate #1 — Integration Owner | Adham | 5 | B2, Y2 | ⬜ |
| B3 | Write Report Sections BR2 + AD1 | Andrew | 5 | B1, B2 | ⬜ |
| Y3 | Write Report Sections AD2 + DC2 | Yassin | 5 | Y1, Y2 | ⬜ |
| Y4 | "Runs With No Errors" Verification | Yassin | 3 | A4, M3 | ⬜ |
| M2 | Merge Gate #2 — Integration Owner | Maged | 5 | B1, Y1 | ⬜ |
| M3 | Requirements vs Output Checklist | Maged | 3 | A2, B1, B2, Y1, Y2, M1 | ⬜ |
| M4 | Submission Bundle Owner | Maged | 5 | A5, Y0, Y4 | ⬜ |

---

## 3. Dependency Links (To Be Configured in JIRA)

```
A0 ──┬──┬──┬──┬──┐
     │  │  │  │  │
     ▼  ▼  ▼  ▼  ▼
    A1 B0 Y0 M0 A2
     │           │
     ▼           ▼
    A3          A4 ◄── B2, Y2
                  │
                  ▼
                 M3 ◄── All pattern tasks
                  │
                  ▼
                 M4 ◄── Y0 (screenshots), Y4 (verification)
```

---

## 4. Timeline (To Be Set in JIRA)

| Milestone | Date | Deliverables |
|-----------|------|--------------|
| Sprint 1 Start | Week 1 | A0, A1, B0, Y0, M0 complete |
| Pattern Deadline | Week 3 | All 7 patterns (A2, A3, B1, B2, Y1, Y2, M1) complete |
| Integration Week | Week 4 | A4, M2, M3 complete |
| Report Finalization | Week 5 | B3, Y3 complete |
| QA & Verification | Nov 6 | Y4 complete |
| **Submission** | **Nov 7, 11:59 PM** | M4 submission |

---

## 5. Screenshots Required (For Report)

### 5.1 JIRA Board Views
- [ ] **Backlog View** — All tasks created with correct codes
- [ ] **Active Sprint View** — Tasks in progress/done
- [ ] **Kanban Board** — Columns: To Do, In Progress, Done
- [ ] **Task Detail View** — Example: Y1 task with description, assignee, dependencies

### 5.2 Dependency Views
- [ ] **Dependency Graph** — Network diagram showing task relationships
- [ ] **Gantt Chart** — Timeline view with start/end dates
- [ ] **Roadmap View** — High-level timeline

### 5.3 Team Activity
- [ ] **Burndown Chart** — Sprint progress
- [ ] **Velocity Chart** — Team capacity
- [ ] **Activity Stream** — Recent updates

---

## 6. How to Complete Y0

### Step 1: Create JIRA Project
1. Go to [JIRA](https://www.atlassian.com/software/jira)
2. Create new project: "SW312-D2-HMS"
3. Select Kanban or Scrum template
4. Add team members with usernames from Section 1.2

### Step 2: Create All Tasks
1. Create tasks from Section 2 (all 18 tasks)
2. Use exact codes: A0, A1, A2, ..., M4
3. Set assignees, story points, descriptions

### Step 3: Set Dependencies
1. Link tasks using "Blocks/Is Blocked By" relationships
2. Follow dependency graph from Section 3
3. Verify: A4 blocked by B2 and Y2

### Step 4: Set Due Dates
1. Set timeline from Section 4
2. Final deadline: November 7, 2026

### Step 5: Take Screenshots
1. Capture all views from Section 5
2. Save as: `Y0_JIRA_[ViewName].png`
3. Place in: `docs/Notes & Steps/`

---

## 7. Sign-off

**JIRA Setup by:** Yassin  
**Date:** ___________  
**Status:** ⬜ IN PROGRESS

| Check | Status |
|-------|--------|
| Project created | ⬜ |
| All 18 tasks created | ⬜ |
| Dependencies linked | ⬜ |
| Due dates set | ⬜ |
| Screenshots captured | ⬜ |

---

**Note:** This document is a template. Yassin must complete the JIRA setup and add screenshots for full A+ credit on Y0.
