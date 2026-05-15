# B0 — Git Organization + Branch/PR Rules Enforcement

**Owner:** Andrew  
**Applies to:** Deliverable #2 — Structural Design Patterns  
**Repository:** `https://github.com/Adhams01/Software-Engineering-Project`

---

## 1  Branch Strategy

### 1.1 Branch Naming Convention

Format: `feature/[CASE]-[owner]`

| Case | Owner | Branch Name |
|------|-------|-------------|
| BR1 | Adham | `feature/BR1-adham` |
| BR2 | Andrew | `feature/BR2-andrew` |
| AD1 | Andrew | `feature/AD1-andrew` |
| AD2 | Yassin | `feature/AD2-yassin` |
| FW1 | Maged | `feature/FW1-maged` |
| DC1 | Yassin | `feature/DC1-yassin` |
| DC2 | Maged | `feature/DC2-maged` |

### 1.2 Branch Rules

- Each owner works **only** on their assigned feature branch(es).
- All branches are created from `main`.
- No direct commits to `main` — all changes go through Pull Requests.
- Feature branches are deleted after successful merge.

---

## 2  Commit Message Format

Format: `[CASE] Brief description — [OWNER]`

### Examples:
```
[BR2] Add Report abstraction and ReportRenderer interface — ANDREW
[BR2] Implement PdfRenderer, HtmlRenderer, CsvRenderer — ANDREW
[BR2] Add ReportBridgeDemo with console output — ANDREW
[AD1] Add PatientDataProvider target interface — ANDREW
[AD1] Implement ExternalPatientSystemAdapter — ANDREW
[AD1] Add PatientAdapterDemo with console output — ANDREW
```

### Rules:
- One logical change per commit (do not bundle unrelated changes).
- Case code `[BR2]`, `[AD1]`, etc. must appear at the start.
- Owner tag `— ANDREW` must appear at the end.
- Use present tense imperative: "Add", "Implement", "Fix", not "Added", "Implemented".

---

## 3  Pull Request Rules

### 3.1 PR Title Format

Format: `[CASE] Complete implementation — [OWNER]`

Examples:
- `[BR2] Complete implementation — ANDREW`
- `[AD1] Complete implementation — ANDREW`

### 3.2 PR Checklist (copy into every PR description)

```markdown
## PR Checklist — [CASE]

### Before Requesting Review:
- [ ] Code is in correct package: `patterns/structural/[pattern]/[case]/`
- [ ] All classes follow PascalCase naming convention
- [ ] Demo class has `main()` method and produces expected console output
- [ ] Code compiles with **zero errors** (NetBeans Clean and Build = BUILD SUCCESS)
- [ ] Application still runs after changes (existing menu works)
- [ ] No `target/`, `.class`, `.nbproject/`, or `.idea/` files included
- [ ] Doer tag `[ANDREW]` / `[ADHAM]` / `[YASSIN]` / `[MAGED]` on every file
- [ ] Each class has a brief comment explaining its purpose
- [ ] UML diagram exported to `UML Diagrams/exports/`
- [ ] UML source file saved to `UML Diagrams/source/`

### Files Changed:
- [ ] List all new/modified files here

### How to Test:
- [ ] Run `[DemoClass].main()` → describe expected output

### Confirmation:
- [ ] I confirm Clean and Build = BUILD SUCCESS
- [ ] I confirm the app runs and existing features still work
```

### 3.3 PR Review Process

1. Owner creates PR when UML + code + demo are all complete.
2. **Adham** (team lead) reviews and merges.
3. If reviewer finds issues, they comment and request changes.
4. Owner fixes issues, pushes to same branch, and re-requests review.
5. After merge, owner deletes the feature branch.

---

## 4  .gitignore Enforcement

The following must **never** be committed:

```gitignore
# Maven build output
target/

# Compiled classes
*.class

# NetBeans project files
.nbproject/
nbproject/
nb-configuration.xml
build/
dist/
manifest.mf

# IntelliJ IDEA
.idea/
*.iml

# OS files
.DS_Store
Thumbs.db

# Backup files
*.bak
*.tmp
*~
```

If `target/` or `.class` files are found in a PR, the PR must be rejected until they are removed and `.gitignore` is updated.

---

## 5  Package Structure Enforcement

All structural pattern code must reside under:
```
src/main/java/hospitalmangementsystem/patterns/structural/
```

Per A2 rules, the exact layout is:

```
patterns/structural/
  bridge/
    notification/    # BR1 — Adham
    report/          # BR2 — Andrew
  adapter/
    patient/         # AD1 — Andrew
    payment/         # AD2 — Yassin
  flyweight/         # FW1 — Maged
  decorator/
    report/          # DC1 — Yassin
    notification/    # DC2 — Maged
```

### Rules:
- Do **not** create classes outside your assigned sub-package.
- Do **not** modify classes in another owner's sub-package.
- Do **not** modify existing `domain/`, `dao/`, `controller/`, `ui/`, or `external/` code without team agreement.
- Demo classes must be self-contained (no cross-pattern dependencies).

---

## 6  Merge Conflict Prevention

- Pull from `main` before starting work: `git pull origin main`
- Pull from `main` before creating PR: `git pull origin main` then resolve conflicts locally.
- Each owner works in isolated sub-packages — conflicts should be rare.
- If conflict occurs in shared files (e.g., `HospitalMangementSystem.java`), coordinate with the other owner before resolving.

---

## Sign-off

**Document created by:** Andrew  
**Date:** _______________

**Team Acknowledgment:**
- [ ] Adham has read and will follow these rules
- [ ] Andrew has read and will follow these rules
- [ ] Yassin has read and will follow these rules
- [ ] Maged has read and will follow these rules

**Status:** ☐ RULES ACTIVE — Team may begin implementation
