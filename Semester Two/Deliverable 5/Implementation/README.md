# Hospital Management System - Deliverable 5

**Course:** SW311 - Software Design and Development  
**Semester:** Spring 2026  
**Technology:** Spring Boot 3.2.5 + Java 17 + H2 Database

## Team Members

| Name | Tasks |
|------|-------|
| Adham Sobhy | Patient Service (GET), Composite Design, Final Assembly |
| Andrew | Doctor Service (POST), Composite Implementation, Jira |
| Yassin | Infrastructure, PUT APIs, Error Handling, Testing |
| Maged | Appointment Service (DELETE), OpenAPI, Requirements |

## How to Run

### Option 1: IntelliJ IDEA (recommended)
1. **File → Open** and select the **`Implementation`** folder (the one that contains `pom.xml`).
2. Wait for Maven to finish importing dependencies.
3. Open `src/main/java/com/mycompany/hms/HmsApplication.java` and click **Run** (green triangle), or use a **Spring Boot** run configuration with main class **`com.mycompany.hms.HmsApplication`** (no `.java` suffix).
4. Server starts at `http://localhost:8080`.

### Web GUI (bonus)

After the server starts, open:

- **HMS Portal:** [http://localhost:8080/](http://localhost:8080/) — browser UI for patients, doctors, appointments, and composite booking (uses the same REST APIs as Postman).

### Swagger UI (OpenAPI)

Interactive API docs and **Try it out** requests in the browser:

- **Swagger UI:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- **OpenAPI JSON:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

The hand-written spec file remains at `openapi.yaml` in this folder for the report / submission.

### Option 2: VS Code
1. Install "Extension Pack for Java"
2. Open the `Implementation` folder
3. Click "Run" above `main()` method in `HmsApplication.java`

### Option 3: Command Line (if Maven is installed)
```bash
mvn spring-boot:run
```

## API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/patients` | GET | Get all patients |
| `/api/patients/{id}` | GET | Get patient by ID |
| `/api/patients` | POST | Create patient |
| `/api/patients/{id}` | PUT | Update patient |
| `/api/patients/{id}` | DELETE | Delete patient |
| `/api/doctors` | GET | Get all doctors |
| `/api/doctors/{id}` | GET | Get doctor by ID |
| `/api/doctors` | POST | Create doctor |
| `/api/doctors/{id}` | PUT | Update doctor |
| `/api/doctors/{id}` | DELETE | Delete doctor |
| `/api/appointments` | GET | Get all appointments |
| `/api/appointments/{id}` | GET | Get appointment by ID |
| `/api/appointments` | POST | Create appointment |
| `/api/appointments/{id}` | PUT | Update appointment |
| `/api/appointments/{id}` | DELETE | Delete appointment |
| `/api/composite/book-appointment` | POST | Book appointment (composite) |

## Testing with Postman

1. Start the application
2. Import the provided Postman collection (if available)
3. Or test endpoints manually:
   - GET `http://localhost:8080/api/patients`
   - POST `http://localhost:8080/api/composite/book-appointment`
     ```json
     {
       "patientId": 1,
       "doctorId": 1,
       "date": "2026-05-20",
       "timeSlot": "10:00",
       "reason": "Checkup"
     }
     ```

## H2 Console

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:hmsdb`
- Username: `sa`
- Password: (empty)

## Project Structure

```
src/main/java/com/mycompany/hms/
├── controller/     # REST API controllers
├── service/        # Business logic layer
├── repository/     # Data access layer (JPA)
├── model/          # Entity classes
├── dto/            # Request/Response objects
├── exception/      # Custom exceptions + handler
└── config/         # Configuration (data seeder)
```

## Pre-loaded Data

On startup, 3 patients and 3 doctors are automatically inserted:
- Patient 1: Ahmed Hassan
- Patient 2: Sara Ali
- Patient 3: Mohamed Khaled
- Doctor 1: Dr. Fatima Zaki (Cardiology)
- Doctor 2: Dr. Omar Hamed (Neurology)
- Doctor 3: Dr. Layla Mostafa (Pediatrics)
