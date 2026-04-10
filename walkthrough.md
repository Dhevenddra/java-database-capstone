# SmartCare System Walkthrough

This document outlines the recent functional modifications applied to the SmartCare Clinic Management System and demonstrates the UI flows with corresponding screenshots.

## Changes Made

1. **Fixed Patient Dashboard Error (`Whitelabel 500`)**
   - Corrected duplicate syntax parsing attribute errors caused by tight Thymeleaf XML rules in `patientDashboard.html`.
   - Wired up the `/patientDashboard/{token}` mapping natively into the `DashboardController`.

2. **Implemented Patient Portal Search By Doctor Feature**
   - Wired up the frontend asynchronous DOM `fetch` hook so patients can securely POST queries directly against `/api/doctors`.
   - Result matches dynamically populate a structured Medical Record return array without forcing complete browser re-renders.

3. **Activated Doctor Add Modal on Admin Panel**
   - Built a sleek overlay Modal window bound directly to the Admin Dashboard interface, replacing static browser `alert()` prompts.
   - Connected form elements tightly to real Spring Boot backend arrays via JavaScript JSON payload injection.

4. **Wired up Doctor Interface for Viewing Patient Prescriptions**
   - Overhauled `doctorDashboard.html` to integrate REST fetching to the `/api/prescriptions` mapping endpoints.
   - Resolved HTTP 500 crashes and DDL validation limits related to `appointment_id` missing variables inside testing stubs.

## Feature Validation Walkthroughs

Below is a demonstration of the executed web application workflow interfaces.

### Role Logins
Navigate seamlessly to your respective interfaces from the root security layer.

![Admin Login](/AdminPortal%20Login.png)
![Doctor Login](/DoctorPortal%20Login.png)
![Patient Login](/PatientPortal%20Login.png)

### Administrative Duties

Authorized admins can cleanly spawn interactive modals to securely add fully-mapped physicians into the database layer via `/api/doctors`.

![Add Doctor Form Execution](/AddNewDoctor.png)

### Patient Scheduling

Patients can intuitively search the live, remote directory for real providers matching requested queries.

![Doctor Searches List](/SearchByDoctor.png)

### Diagnostics / Medical Records 

Doctors maintain absolute control over referencing generated persistent prescription charts loaded from backend Spring pipelines dynamically within current patient visits.

![Patient Medical Data Retrieval](/PatientRecords.png)

---
*Testing locally successfully executed on H2 In-Memory DB bypass. Changes are structurally safe for dual MySQL-MongoDB production clones.*
