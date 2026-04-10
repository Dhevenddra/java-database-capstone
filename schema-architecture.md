# Architecture Summary

The SmartCare Clinic Management System employs a full-stack architecture featuring a Frontend, Backend, and a dual-database approach. The frontend is built using HTML, CSS, JavaScript, and Thymeleaf templating to render role-based dashboards dynamically from the server. The backend is powered by Java and Spring Boot, relying on Spring Web for RESTful APIs, Spring Data JPA for structured operations, and Spring Data MongoDB for unstructured or document-based operations. 

Relational data such as Admin profiles, Doctors, Patients, and Appointments are persisted securely inside a MySQL relational database. The flexible, document-driven data, like Prescriptions containing nested pharmacy or notes data, are managed efficiently using MongoDB. The Spring Boot backend acts as the central middleware handling authentication (with basic implementation in this context), business logic, validation, and connecting the frontend layers to their corresponding databases.

# Numbered Flow

1. The User (Admin, Doctor, or Patient) opens the SmartCare web portal in their browser and initiates a request (e.g., logging in or viewing appointments).
2. The browser sends an HTTP GET/POST request to the Spring Boot REST Controllers or Dashboard Controllers.
3. The Spring Boot Controller validates the incoming request (e.g., checks tokens, form fields, inputs via `@Valid`).
4. If the request is for an HTML view, the DashboardController invokes Thymeleaf to render the appropriate template (e.g., `doctorDashboard.html`) with model data and sends it back as HTML.
5. If the request is an API call, it gets routed to a Service layer component (e.g., `DoctorService` or `AppointmentService`).
6. The Service layer processes business rules and triggers the appropriate Repository.
7. The Repository layer maps the entity data via Spring Data JPA (triggering an SQL query against the MySQL database for relational records) or via Spring Data MongoDB (querying the MongoDB document collection for prescriptions).
8. The database executes the required CRUD action and returns the results to the Repository.
9. The Repository passes the retrieved objects/entities back to the Service.
10. The Service returns the processed DTOs or objects back to the Controller.
11. The Controller formats the response as JSON (for API calls) and sends it over to the frontend via HTTP response.
12. The browser javascript code handles the JSON payload and dynamically updates the DOM elements on the user's screen.
