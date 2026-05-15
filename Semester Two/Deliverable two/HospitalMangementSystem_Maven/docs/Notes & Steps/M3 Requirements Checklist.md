# M3 — Requirements vs Output Consistency Checklist

**Owner:** Maged  
**Applies to:** Deliverable #2 — Structural Design Patterns  
**Status:** IN PROGRESS → READY FOR VERIFICATION

---

## 1. Requirements Matrix (Must Have)

| # | Requirement | Code | Pattern | Owner | Status | Location | Verified |
|---|-------------|------|---------|-------|--------|----------|----------|
| 1 | 2 Bridge cases | BR1 | Bridge — Notification | Adham | ✅ | `bridge/notification/` | [ ] |
| 2 | 2 Bridge cases | BR2 | Bridge — Report | Andrew | ✅ | `bridge/report/` | [ ] |
| 3 | 2 Adapter cases | AD1 | Adapter — Patient | Andrew | ✅ | `adapter/patient/` | [ ] |
| 4 | 2 Adapter cases | AD2 | Adapter — Payment | Yassin | ⬜ | `adapter/payment/` | [ ] |
| 5 | 1 Flyweight case | FW1 | Flyweight — Medical Codes | Maged | ✅ | `flyweight/` | [ ] |
| 6 | 2 Decorator cases | DC1 | Decorator — Report | Adham | ⬜ | `decorator/report/` | [ ] |
| 7 | 2 Decorator cases | DC2 | Decorator — Notification | Maged | ⬜ | `decorator/notification/` | [ ] |

**Summary:** 5/7 cases complete (71%) — need AD2, DC1, DC2

---

## 2. UML Diagram Checklist (Per Case)

| Case | UML Source (.mdj) | Exported PNG | In Report | Verified |
|------|-------------------|--------------|-----------|----------|
| BR1 | ⬜ | ⬜ | ⬜ | [ ] |
| BR2 | ✅ `ReportBridge.mdj` | ⬜ | ✅ | [ ] |
| AD1 | ✅ `PatientSystemAdapter.mdj` | ⬜ | ✅ | [ ] |
| AD2 | ⬜ | ⬜ | ⬜ | [ ] |
| FW1 | ✅ `Flyweight.mdj` | ✅ `Flyweight.png` | ✅ | [ ] |
| DC1 | ⬜ | ⬜ | ⬜ | [ ] |
| DC2 | ⬜ | ⬜ | ⬜ | [ ] |

**Summary:** 3/7 UML sources complete, 1/7 PNG exported

---

## 3. Demo Existence Checklist (Per Case)

| Case | Demo Class | Main Method | Console Output | Menu Integration | Verified |
|------|------------|-------------|----------------|------------------|----------|
| BR1 | `NotificationBridgeDemo` | ✅ | ✅ | ✅ Option 8 | [ ] |
| BR2 | `ReportBridgeDemo` | ✅ | ✅ | ✅ Option 9 | [ ] |
| AD1 | `PatientAdapterDemo` | ✅ | ✅ | ✅ Option 10 | [ ] |
| AD2 | ⬜ | ⬜ | ⬜ | ⬜ | [ ] |
| FW1 | `MedicalCodeDemo` | ✅ | ✅ | ✅ Option 11 | [ ] |
| DC1 | ⬜ | ⬜ | ⬜ | ⬜ | [ ] |
| DC2 | ⬜ | ⬜ | ⬜ | ⬜ | [ ] |

**Summary:** 4/7 demos complete and integrated

---

## 4. Report Section Checklist (Per Case)

Each case needs in the PDF:
- [ ] 1.1 Problem Statement
- [ ] 1.2 Why [Pattern] Pattern (rationale)
- [ ] 1.3 UML Class Diagram (with explanation)
- [ ] 1.4 Implementation Confirmation

| Case | Problem | Why Pattern | UML Section | Implementation | Complete |
|------|---------|-------------|-------------|------------------|----------|
| BR1 | ⬜ | ⬜ | ⬜ | ⬜ | [ ] |
| BR2 | ✅ | ✅ | ✅ | ✅ | [ ] |
| AD1 | ✅ | ✅ | ✅ | ✅ | [ ] |
| AD2 | ⬜ | ⬜ | ⬜ | ⬜ | [ ] |
| FW1 | ⬜ | ⬜ | ✅ | ⬜ | [ ] |
| DC1 | ⬜ | ⬜ | ⬜ | ⬜ | [ ] |
| DC2 | ⬜ | ⬜ | ⬜ | ⬜ | [ ] |

**Summary:** Andrew's sections (BR2, AD1) are complete

---

## 5. Build & Run Verification

| Check | Expected | Actual | Status |
|-------|----------|--------|--------|
| Maven Clean Build | BUILD SUCCESS | BUILD SUCCESS | ✅ |
| Java Version | 17 | 17 | ✅ |
| Package Structure | `hospitalmanagementsystem.patterns.structural.*` | ✅ | ✅ |
| Main Menu Runs | Options 8-11 work | ✅ | ✅ |
| No Compilation Errors | 0 errors | 0 errors | ✅ |
| No Duplicate Classes | No class conflicts | ✅ | ✅ |

---

## 6. File Location Checklist

All files must be in correct locations:

| File Type | Correct Location | Status |
|-----------|------------------|--------|
| Java source | `src/main/java/hospitalmanagementsystem/...` | ✅ |
| UML source (.mdj) | `docs/UML Diagrams/[Pattern]/` | ✅ |
| UML export (.png) | `docs/UML Diagrams/[Pattern]/` | ⚠️ Partial |
| Documentation | `docs/Notes & Steps/` | ✅ |
| Report sections | Master PDF (TBD) | ⬜ |

---

## 7. Issues List

| # | Issue | Severity | Owner | Fix Required |
|---|-------|----------|-------|--------------|
| 1 | AD2 not implemented | HIGH | Yassin | Full implementation |
| 2 | DC1 not implemented | HIGH | Adham | Full implementation |
| 3 | DC2 not implemented | HIGH | Maged | Full implementation |
| 4 | BR2 PNG export missing | LOW | Andrew | Export from StarUML |
| 5 | AD1 PNG export missing | LOW | Andrew | Export from StarUML |
| 6 | FW1 report section incomplete | MEDIUM | Maged | Write problem + implementation text |

---

## 8. Sign-off

**Checklist completed by:** Maged  
**Date:** 2026-03-22  
**Status:** ⬜ PENDING — Awaiting completion of AD2, DC1, DC2

### Required for A+:
- [ ] All 7 cases implemented
- [ ] All 7 UML diagrams created and exported
- [ ] All 7 demos integrated into menu
- [ ] All 7 report sections complete
- [ ] Final build verification (Y4)
- [ ] Submission bundle prepared (M4)

**Current Grade:** B+ (5/7 cases, partial documentation)  
**Target Grade:** A+ (7/7 cases, complete documentation)
