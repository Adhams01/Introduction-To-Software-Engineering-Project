# B3 — Report Sections for BR2 (Bridge) and AD1 (Adapter)

## 1.1 Problem Statement

The system needs to support different types of medical reports (such as Summary Report and Detailed Report) and different output formats (such as PDF and HTML).

If we directly combine each report type with each format, we would end up with many classes like SummaryPDFReport, SummaryHTMLReport, DetailedPDFReport, and so on. This quickly becomes difficult to manage and does not scale well when new report types or formats are added.

Also, the structure of a report (what data it contains and how it is organized) should be separate from how it is displayed (PDF, HTML, etc.). If both are tightly connected, any change in formatting or report content would require modifying multiple classes, making the system harder to maintain.

## 1.2 Why Bridge Pattern

The Bridge pattern is used to separate report structure from how it is displayed, so both can change independently.

In this design, the abstract class Report represents a general report and contains a reference to a ReportRenderer. The renderer is responsible only for formatting the output.

Concrete report classes like AppointmentScheduleReport and BillingSummaryReport define what data goes into the report and how it is organized (for example, what rows to include and what information to show). The renderer does not control this logic — it only handles how the data is displayed.

On the other side, PdfRenderer, HtmlRenderer, and CsvRenderer define how the report is formatted.

This means:

* A new report type can be added without changing any renderer
* A new format can be added without changing any report
* The same report can be displayed in different formats by simply changing the renderer

Without using the Bridge pattern, every new report type would need to be combined with every format, increasing the number of classes and making the system harder to extend and maintain.

## 1.3 UML Class Diagram

**INSERT DIAGRAM:** `BR2_Report_Bridge.png`

The diagram shows two separate hierarchies connected through a reference from Report to ReportRenderer. The Report class contains a renderer field and defines general report behavior. Subclasses like AppointmentScheduleReport and BillingSummaryReport generate the actual report content.

On the other side, ReportRenderer defines the rendering interface, and classes like PdfRenderer, HtmlRenderer, and CsvRenderer implement different output formats. The connection between these two hierarchies allows report logic and rendering logic to vary independently.

## 1.4 Implementation Confirmation

The Bridge pattern implementation includes eight Java files: ReportRenderer, PdfRenderer, HtmlRenderer, CsvRenderer, Report, AppointmentScheduleReport, BillingSummaryReport, and ReportBridgeDemo.

All files compile without errors. The demo shows that the same report can be displayed in multiple formats by switching the renderer at runtime. This confirms that report content and output format are independent and no extra classes are needed when adding new features.

---

## 2.1 Problem Statement (Adapter)

The system needs to get patient data from an external system, but the external API does not match the format used inside the system.

There are three main differences:

* The system uses String IDs, while the external system uses integers
* The system expects plain text, while the external system returns XML
* The system expects a boolean status, while the external system uses numeric codes

Without using an adapter, we would need to modify many parts of the system to handle these differences, which would increase complexity and make the code harder to maintain.

## 2.2 Why Adapter Pattern

The Adapter pattern is used to make the external system compatible with the system without changing either one.

The PatientDataProvider interface defines what the system expects. The ExternalPatientSystemApi provides the actual data but in a different format.

The ExternalPatientSystemAdapter sits between them and converts:

* String IDs to integers
* XML data to plain text
* numeric status values to boolean

The rest of the system only interacts with PatientDataProvider and does not need to know anything about the external system.
This also avoids spreading conversion logic across the system and keeps all external system handling in one place.

## 2.3 UML Class Diagram

**INSERT DIAGRAM:** `AD1_PatientSystem_Adapter.png`

The diagram shows three main parts: the PatientDataProvider interface (Target), the ExternalPatientSystemApi class (Adaptee), and the ExternalPatientSystemAdapter (Adapter).

The adapter implements PatientDataProvider and holds a reference to ExternalPatientSystemApi. It is responsible for converting data between the two systems. The rest of the system depends only on the interface, not on the external API directly.

## 2.4 Implementation Confirmation

The Adapter implementation includes four Java files: PatientDataProvider, ExternalPatientSystemApi, ExternalPatientSystemAdapter, and PatientAdapterDemo.

All files compile without errors. The demo shows retrieving patient data using String IDs, checking patient status, and getting medical history through the adapter. It also handles invalid and missing data correctly.

This confirms that the adapter successfully converts between the system and the external API without requiring changes to existing code.