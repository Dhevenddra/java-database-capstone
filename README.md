# SmartCare Clinic Management System

SmartCare is a comprehensive, full-stack clinic management system built with **Spring Boot** and **Thymeleaf**. The platform utilizes a dual-database architecture: it leverages **MySQL** for structured relational data (Users, Appointments) and **MongoDB** for flexible document-driven records (Prescriptions).

## Features
- **Role-based Authentication**: Distinct access controls for `Admin`, `Doctor`, and `Patient`.
- **Admin Portal**: Manage clinic doctors, perform fast searches, and control clinic rosters.
- **Doctor Portal**: View daily patient schedules and issue comprehensive digital prescriptions.
- **Patient Portal**: Effortless doctor search logic and integrated appointment booking flow.
- **Dual Databases**: Robust horizontal scaling logic using MongoDB for flexible health documents paired seamlessly with MySQL relationships.
- **Dockerized**: A multi-stage Docker build is configured for hassle-free deployments.

---

## Technical Stack
- **Backend Framework**: Java 17, Spring Boot 3
- **Frontend MVC**: Thymeleaf UI Templates, HTML5/CSS3, JavaScript
- **Relational DB**: MySQL (Entities, Joins, and Stored Procedures)
- **NoSQL DB**: MongoDB (Flexible JSON-style documents)
- **Wait/Build Tools**: Maven, GitHub Actions (CI Linting & Checks)
- **Containerization**: Docker

---

## Startup & Setup Guide

Since this is a deeply integrated platform, your environment must be capable of supporting standard relational and non-relational database ports before running the Spring application.

### Prerequisites
Before you start, ensure you have the following installed on your machine:
- Java 17+ and Maven
- **MySQL 8.0+** running on `localhost:3306`
- **MongoDB** running on `localhost:27017`
- *Optional:* **Docker**

### 1. Database Initialization
Ensure your MySQL and MongoDB services are active.
Spring Data JPA is configured to automatically create the database structure via `spring.jpa.hibernate.ddl-auto=update` in the application properties. 
Ensure you have created a root database in MySQL:
```sql
CREATE DATABASE IF NOT EXISTS cms;
```

*Note: Default application properties expect MySQL credentials `root:password`.* 

### 2. Running Locally (Development Mode)
Once your databases are healthy, navigate to the project root where the `.pom` file lives and execute standard maven runs:

```bash
# Clean and package the application
mvn clean install

# Spin up the Spring Boot server
mvn spring-boot:run
```
The application will safely start on `http://localhost:8080`.

### 3. Running via Docker (Production Mode)
For an encapsulating, isolated build layout, you can leverage the Docker structure:

```bash
# Build the Docker Image
docker build -t smartcare-app .

# Run the Docker Image (Make sure you configure docker networks for local DB linking)
docker run -p 8080:8080 smartcare-app
```

---

## Stored Procedures

For internal database management, the application occasionally hooks into core SQL-provided stored procedures:
- `GetDailyAppointmentReportByDoctor`
- `GetDoctorWithMostPatientsByMonth`
- `GetDoctorWithMostPatientsByYear`

*(These need to be pre-compiled into your MySQL shell if utilizing strict logic execution via DB hooks).*

## API Highlights
All routes are built securely with explicit role access requirements. 
- `GET /api/doctors`
- `GET /api/appointments/patient/{patientId}`
- `POST /api/prescriptions`
- `GET /adminDashboard/{token}`

Enjoy building a better healthcare system!
