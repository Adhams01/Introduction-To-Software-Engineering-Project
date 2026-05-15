M1 — Abstract Factory Pattern: 2 Case Proposals (Summary)
Case 1: MedicalDocumentAbstractFactory
Problem

The Hospital Management System must generate different medical documents: discharge summaries, prescriptions, and medical records. These documents appear in different contexts:

Clinical context – detailed documents for doctors (diagnosis codes, treatment details, full notes).

Administrative context – simplified documents for insurance and hospital records.

Currently, document classes exist but creation logic is scattered or missing. This can cause:

Inconsistent document sets (mixing clinical and administrative formats).

Tight coupling between controllers and concrete document classes.

Poor extensibility when adding new contexts.

Solution Idea

Use the Abstract Factory pattern to create families of related documents for each context.

How It Solves the Problem

A MedicalDocumentAbstractFactory defines methods to create:

Discharge Summary

Prescription

Medical Record

Concrete factories implement these methods:

ClinicalDocumentFactory → creates clinical documents

AdministrativeDocumentFactory → creates administrative documents

The client selects one factory and generates all documents from it.
This guarantees consistent document types and allows new contexts (e.g., research documents) without modifying existing code.
===============================================================================================================================================================
Case 2: DAOAbstractFactory
Problem

The system currently creates DAOs directly:

new PatientDAO()
new AppointmentDAO()

These implementations use in-memory storage. If the system later switches to file storage or a database, every instantiation must change.

This leads to:

Tight coupling to storage implementation

Risk of mixed persistence strategies

Difficult testing and system evolution

Solution Idea

Use an Abstract Factory to produce DAOs that share the same persistence strategy.

How It Solves the Problem

A DAOAbstractFactory defines methods to create:

PatientDataAccess

AppointmentDataAccess

Concrete factories provide implementations:

InMemoryDAOFactory → creates in-memory DAOs

FileBasedDAOFactory → creates file-based DAOs

The system selects one factory at startup, ensuring all DAOs use the same storage method.
Switching persistence only requires replacing the factory, without modifying client code.