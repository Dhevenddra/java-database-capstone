## MySQL Database Design
Structured, validated, and interrelated data works well in MySQL. The core operational data for the clinic will be stored here.

### Table: admin
- id: BIGINT, Primary Key, Auto Increment
- username: VARCHAR(255), Not Null, Unique
- password: VARCHAR(255), Not Null

### Table: patients
- id: BIGINT, Primary Key, Auto Increment
- name: VARCHAR(100), Not Null
- email: VARCHAR(255), Not Null, Unique
- address: VARCHAR(255)

### Table: doctors
- id: BIGINT, Primary Key, Auto Increment
- name: VARCHAR(100), Not Null
- specialty: VARCHAR(50), Not Null
- email: VARCHAR(255), Not Null, Unique
- password: VARCHAR(255), Not Null
- phone: VARCHAR(15)

### Table: appointments
- id: BIGINT, Primary Key, Auto Increment
- doctor_id: BIGINT, Foreign Key → doctors(id), Not Null
- patient_id: BIGINT, Foreign Key → patients(id), Not Null
- appointment_time: DATETIME, Not Null
- status: INT (0 = Scheduled, 1 = Completed, 2 = Cancelled)

*Design comments: The `appointments` table establishes a many-to-many relationship mapping between patients and doctors (via `doctor_id` and `patient_id`), allowing a patient to visit multiple doctors and doctors to see multiple patients. Normalization prevents overlapping and keeps relational integrity.*

## MongoDB Collection Design
Unstructured content like flexible prescription records, which might include various medications, free-form notes, or complex pharmacy details, uses MongoDB.

### Collection: prescriptions
```json
{
  "_id": "ObjectId('64abc123456')",
  "patientName": "John Smith",
  "appointmentId": 51,
  "medication": "Amoxicillin",
  "dosage": "250mg",
  "doctorNotes": "Take 1 tablet every 8 hours with meals immediately.",
  "refillCount": 1,
  "pharmacy": {
    "name": "CVS Pharmacy",
    "location": "Main Street"
  }
}
```
*Design comments: While the structured identity of an appointment is enforced via `appointmentId` matching the MySQL record, storing the prescription data in MongoDB allows doctors to flexibly append extra metadata (like a nested `pharmacy` document or an array of multiple `medications`) without altering the SQL schemas.*
