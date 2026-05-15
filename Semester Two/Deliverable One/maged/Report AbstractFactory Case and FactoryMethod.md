Part A — Abstract Factory: MedicalDocumentAbstractFactory
1. Problem Description

The Hospital Management System generates several medical documents during patient care, including discharge summaries, prescriptions, and medical records. Although the domain classes exist, they currently lack a structured creation mechanism.

These documents must be produced in different operational contexts:

Clinical context – detailed documents for medical staff (diagnosis codes, treatment details, examination notes).

Administrative context – simplified documents for insurance processing and archival.

Without a unified creation mechanism, three issues arise:

Inconsistent document families — clinical and administrative formats may be unintentionally mixed.

Violation of the Open/Closed Principle — adding new contexts requires modifying multiple creation points.

Controller coupling — controllers must directly instantiate concrete document classes.

2. Pattern Application

The Abstract Factory pattern provides an interface for creating families of related objects without exposing concrete classes.

In this design, a MedicalDocumentAbstractFactory defines methods to create the three document types:

createDischargeSummary()

createPrescription()

createMedicalRecord()

Concrete factories implement these methods:

ClinicalDocumentFactory → produces clinical document variants

AdministrativeDocumentFactory → produces administrative document variants

The client selects a factory once and generates all documents through the factory interface. This ensures consistent document families, reduces coupling, and allows new contexts to be introduced without modifying existing code.

3. UML Structure

The design follows the four GoF Abstract Factory participants.

Abstract Products

DischargeSummaryDocument

PrescriptionDocument

MedicalRecordDocument

Concrete Products

Clinical family: ClinicalDischargeSummary, ClinicalPrescription, ClinicalMedicalRecord

Administrative family: AdministrativeDischargeSummary, AdministrativePrescription, AdministrativeMedicalRecord

Abstract Factory

MedicalDocumentAbstractFactory

Concrete Factories

ClinicalDocumentFactory

AdministrativeDocumentFactory

The client MedicalDocumentConsoleUI depends only on the abstract factory and product interfaces, ensuring full decoupling from concrete implementations.

4. Implementation Summary

The implementation resides in:

hospitalmangementsystem.patterns.abstractfactory

The abstract factory defines three document creation methods.
Each concrete factory returns the appropriate document family.

The client selects the desired context and obtains all documents through the factory interface, guaranteeing consistent formatting and behavior across document types.

Integration required only adding a document generation option to the main HMS menu. No existing domain or controller classes were modified.

5. Execution Evidence

The project compiled successfully with zero build errors.

When the application runs, the main menu includes the option:

3) Generate Medical Documents (Abstract Factory)

Selecting a context generates three documents using the chosen factory.

Clinical mode produces detailed medical records, while administrative mode produces abbreviated filing documents, confirming correct factory switching and document family consistency.

Part B — Factory Method: AppointmentFactory
1. Problem Description

Appointments in the HMS are currently created using direct instantiation:

new Appointment(...)

However, hospitals manage different appointment types with distinct properties:

Checkup – standard consultation duration

Surgery – long duration with pre-operative preparation

Follow-up – shorter visits linked to previous consultations

Emergency – immediate high-priority appointments

Direct instantiation scatters creation logic across the system and violates the Open/Closed Principle, since adding a new appointment type requires modifying existing code.

2. Pattern Application

The Factory Method pattern defines an interface for creating an object while allowing subclasses to determine the concrete class.

An abstract AppointmentFactory declares:

createAppointment(id, startTime)

Concrete factories implement the method for specific appointment types:

CheckupAppointmentFactory

SurgeryAppointmentFactory

FollowUpAppointmentFactory

Each factory encapsulates the correct type, duration, and default status for its appointment type.

The client interacts only with the factory interface, improving extensibility and separation of responsibilities.

3. UML Structure

The design includes the four Factory Method participants.

Product

Appointment

Concrete Products

CheckupAppointment

SurgeryAppointment

FollowUpAppointment

Creator

AppointmentFactory

Concrete Creators

CheckupAppointmentFactory

SurgeryAppointmentFactory

FollowUpAppointmentFactory

The AppointmentController depends only on the abstract factory and product types, ensuring loose coupling.

4. Design Rationale

Factory Method is appropriate because the system creates one product type (Appointment) with multiple variants.

Abstract Factory would be unnecessary in this case because it is intended for families of different product types created together.

Thus:

Factory Method → single product with multiple subtypes

Abstract Factory → multiple related products created as a group