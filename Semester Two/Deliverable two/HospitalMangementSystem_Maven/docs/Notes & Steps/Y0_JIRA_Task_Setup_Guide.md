# JIRA Setup Guide & Task List for Deliverable #2

## Project Configuration

### 1. Create JIRA Project
- **Project Name:** SW312-D2-HMS
- **Project Key:** HMSD2
- **Template:** Kanban (Software Development)
- **Project Lead:** Adham

### 2. Add Team Members
Invite these members to the project:
- Adham (Team Lead) - adham@university.edu
- Andrew (Git/Integration Lead) - andrew@university.edu
- Yassin (JIRA/QA Lead) - yassin@university.edu
- Maged (Documentation Lead) - maged@university.edu

---

## Task List (Create ALL 18 Tasks)

### PART 0: FOUNDATION TASKS (5 tasks)
Create these tasks first:

**A0 - Confirm Project Baseline + DevOps Compliance**
- Assignee: Adham
- Priority: High
- Labels: foundation, baseline
- Description: Verify Maven builds, Git repo ready, folder structure correct
- Due: Week 1

**A1 - Create Deliverable #2 Master Report Template**
- Assignee: Adham
- Priority: High
- Labels: foundation, documentation
- Description: Create PDF structure for all 7 pattern cases
- Due: Week 1
- Depends on: A0

**B0 - Git Organization + Branch/PR Rules**
- Assignee: Andrew
- Priority: High
- Labels: foundation, git, devops
- Description: Define branch naming, PR checklist, merge rules
- Due: Week 1
- Depends on: A0

**Y0 - JIRA Timeline Setup + Dependencies**
- Assignee: Yassin
- Priority: High
- Labels: foundation, jira, management
- Description: Create all tasks, set dependencies, configure timeline
- Due: Week 1
- Depends on: A0

**M0 - Report Formatting + Consistency Rules**
- Assignee: Maged
- Priority: Medium
- Labels: foundation, documentation, formatting
- Description: Define naming conventions, terminology, section structure
- Due: Week 1
- Depends on: A1

---

### PART 1: PATTERN IMPLEMENTATION TASKS (7 tasks)

**A2 - Bridge BR1: Notification System**
- Assignee: Adham
- Priority: High
- Labels: pattern, bridge, implementation
- Description: UML + Java code for Notification Content × Channel Bridge
- Due: Week 3
- Depends on: A0, B0, M0

**A3 - Decorator DC1: Report Enhancements**
- Assignee: Adham
- Priority: High
- Labels: pattern, decorator, implementation
- Description: UML + Java code for Header/Footer/Watermark decorators
- Due: Week 3
- Depends on: A0, B0, M0

**B1 - Bridge BR2: Report Content × Renderer**
- Assignee: Andrew
- Priority: High
- Labels: pattern, bridge, implementation
- Description: UML + Java code for Report content with multiple output formats
- Due: Week 3
- Depends on: A0, B0, M0

**B2 - Adapter AD1: External Patient System**
- Assignee: Andrew
- Priority: High
- Labels: pattern, adapter, implementation
- Description: UML + Java code for XML-to-Object patient data adapter
- Due: Week 3
- Depends on: A0, B0, M0

**Y1 - Adapter AD2: Payment Gateway**
- Assignee: Yassin
- Priority: High
- Labels: pattern, adapter, implementation
- Description: UML + Java code for External payment gateway adapter
- Due: Week 3
- Depends on: A0, B0, M0

**Y2 - Decorator DC2: Notification Decorators**
- Assignee: Yassin
- Priority: High
- Labels: pattern, decorator, implementation
- Description: UML + Java code for Logging/Retry/Throttling decorators
- Due: Week 3
- Depends on: A0, B0, M0

**M1 - Flyweight FW1: Medical Code Catalog**
- Assignee: Maged
- Priority: High
- Labels: pattern, flyweight, implementation
- Description: UML + Java code for Shared medical codes with factory cache
- Due: Week 3
- Depends on: A0, B0, M0

---

### PART 2: INTEGRATION & REPORT TASKS (6 tasks)

**A4 - Merge Gate #1: Integration Owner**
- Assignee: Adham
- Priority: Medium
- Labels: integration, merge, coordination
- Description: Merge 2 teammate PRs, resolve conflicts, verify build
- Due: Week 4
- Depends on: B2, Y2

**B3 - Write Report Sections for BR2 + AD1**
- Assignee: Andrew
- Priority: Medium
- Labels: documentation, report
- Description: Write problem statement, solution, justification sections
- Due: Week 4
- Depends on: B1, B2

**Y3 - Write Report Sections for AD2 + DC2**
- Assignee: Yassin
- Priority: Medium
- Labels: documentation, report
- Description: Write problem statement, solution, justification sections
- Due: Week 4
- Depends on: Y1, Y2

**Y4 - "Runs With No Errors" Verification Pass**
- Assignee: Yassin
- Priority: High
- Labels: qa, verification, testing
- Description: Run all 7 demos, document results, verify build success
- Due: Week 5
- Depends on: A4, M3

**M2 - Merge Gate #2: Integration Owner**
- Assignee: Maged
- Priority: Medium
- Labels: integration, merge, coordination
- Description: Merge remaining 2 PRs, resolve conflicts, verify build
- Due: Week 4
- Depends on: B1, Y1

**M3 - Requirements vs Output Consistency Checklist**
- Assignee: Maged
- Priority: High
- Labels: qa, checklist, verification
- Description: Verify all 7 patterns, UMLs, demos exist; list any issues
- Due: Week 4
- Depends on: A2, B1, B2, Y1, Y2, M1

**M4 - Submission Bundle Owner**
- Assignee: Maged
- Priority: High
- Labels: submission, bundle, final
- Description: Prepare ZIP with PDF report, project, UMLs, screenshots
- Due: March 19, 11:59 PM
- Depends on: A1 (final PDF), Y0 (screenshots), Y4 (verification)

---

## Task Dependencies (Set in JIRA)

Configure these "Blocks/Is Blocked By" relationships:

1. A0 blocks: A1, A2, A3, B0, Y0
2. A1 blocks: M0
3. B0 blocks: A2, A3, B1, B2, Y1, Y2, M1
4. M0 blocks: B3, Y3
5. A2, B1, B2, Y1, Y2, M1 block: M3
6. B2 and Y2 block: A4
7. B1 and Y1 block: M2
8. A4 and M3 block: Y4
9. A1, Y0, Y4 block: M4

---

## Screenshots Required (For Y0 Documentation)

Take these 4 screenshots from JIRA and save to `docs/Notes & Steps/`:

### Screenshot 1: Backlog View
- Show ALL 18 tasks listed
- Show columns: Key, Summary, Assignee, Priority, Status
- File name: `Y0_JIRA_Backlog_View.png`

### Screenshot 2: Kanban Board
- Show columns: To Do, In Progress, Done
- Show at least 3 tasks in each column
- File name: `Y0_JIRA_Kanban_Board.png`

### Screenshot 3: Task Detail with Dependencies
- Open any pattern task (e.g., Y1)
- Show: Description, Assignee, Due Date
- Show: "Depends on" and "Is blocked by" links
- File name: `Y0_JIRA_Task_Dependencies.png`

### Screenshot 4: Timeline/Gantt View
- Show all tasks on timeline
- Show dependency arrows between tasks
- Due date: March 19 marked
- File name: `Y0_JIRA_Timeline_View.png`

---

## Quick Setup Steps

1. **Create Project** (5 min)
   - Log into JIRA
   - Create project with settings above

2. **Add Tasks** (30 min)
   - Create all 18 tasks with details above
   - Set assignees and due dates

3. **Set Dependencies** (15 min)
   - Link tasks using "Blocks" relationship
   - Verify dependency chain is correct

4. **Take Screenshots** (10 min)
   - Navigate to each view
   - Screenshot and save with correct names

5. **Upload Evidence** (5 min)
   - Copy screenshots to `docs/Notes & Steps/`
   - Verify all 4 images present

---

## Sign-off Checklist

- [ ] JIRA Project created: HMSD2
- [ ] All 18 tasks created with correct codes
- [ ] All tasks have assignees
- [ ] All tasks have priorities
- [ ] Dependencies linked correctly
- [ ] Screenshot 1 taken: Backlog view
- [ ] Screenshot 2 taken: Kanban board
- [ ] Screenshot 3 taken: Task dependencies
- [ ] Screenshot 4 taken: Timeline view
- [ ] All 4 images saved to correct folder

**Completed by:** Yassin
**Date:** ___________
**Status:** ⬜ IN PROGRESS / ⬜ COMPLETE
