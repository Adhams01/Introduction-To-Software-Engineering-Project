# A0 — Deliverable #2 Baseline Checklist

**Owner:** Adham  
**Deadline:** Must complete before anyone starts pattern work  
**Purpose:** Confirm environment is ready so team can build and test

---

## Environment Checks

| Check | Status | Evidence Required |
|-------|--------|-------------------|
| Maven builds without errors | ☐ PASS / ☐ FAIL | Screenshot of BUILD SUCCESS in NetBeans console |
| Project runs (GUI or console) | ☐ PASS / ☐ FAIL | Screenshot of running application |
| Git repo clean + push works | ☐ PASS / ☐ FAIL | `git status` output showing clean working tree |
| Remote URL correct | ☐ PASS / ☐ FAIL | `git remote -v` output showing `https://github.com/Adhams01/Software-Engineering-Project` |
| Branch `main` is current | ☐ PASS / ☐ FAIL | `git branch` output |
| JIRA project exists + accessible | ☐ PASS / ☐ FAIL | Screenshot of JIRA board |
| All 4 team members have JIRA access | ☐ PASS / ☐ FAIL | Team member list screenshot |

---

## Baseline Confirmation Steps

### Step 1: Maven Build Test
```bash
# In NetBeans:
Right-click HospitalMangementSystem_Maven → Clean and Build
Expected: BUILD SUCCESS
```

### Step 2: Run Test
```bash
# Run one of:
run.bat
run-gui.bat
run-console.bat
Expected: Application opens without errors
```

### Step 3: Git Status Check
```bash
cd "C:\Users\Adham Sobhy\Downloads\Introduction-To-Software-Engineering-Project\Software-Design-&-Development-Project\Deliverable two"
git status
Expected: "nothing to commit, working tree clean"
```

### Step 4: JIRA Verification
- Project name should include "Deliverable 2" or "Structural Patterns"
- Board should show: To Do, In Progress, Done columns
- All 4 members (Adham, Andrew, Yassin, Maged) should have access

---

## Assumptions

1. NetBeans 17+ with Maven plugin installed
2. Java 17+ configured
3. Git installed and configured with GitHub credentials
4. Team members have GitHub write access to repository
5. JIRA project was created for Deliverable #1 and can be reused/extended

---

## Output Checklist

- [ ] A0_Baseline_Checklist.md completed with all checkboxes marked
- [ ] Screenshots saved to `docs/adham/screenshots/`
- [ ] Team notified that baseline is ready
- [ ] Proceed to A1 (Report Template)

---

## Sign-off

**Completed by:** _________________  
**Date:** _________________  
**Status:** ☐ READY TO PROCEED / ☐ BLOCKED (see issues below)

### Issues (if any):
```
[List any blockers here]
```
