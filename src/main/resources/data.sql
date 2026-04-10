INSERT INTO admin (username, password) VALUES ('admin1', 'adminpass');
INSERT INTO admin (username, password) VALUES ('admin2', 'adminpass2');

INSERT INTO doctor (name, specialty, email, password, phone) VALUES ('Dr. Sarah Miller', 'Cardiology', 'sarah.m@smartcare.com', 'docpass1', '1234567890');
INSERT INTO doctor (name, specialty, email, password, phone) VALUES ('Dr. House', 'Diagnostics', 'house@smartcare.com', 'docpass2', '0987654321');

-- Add some available times using the element collection table automatically generated
INSERT INTO doctor_available_times (doctor_id, available_times) VALUES (1, '09:00');
INSERT INTO doctor_available_times (doctor_id, available_times) VALUES (1, '10:00');
INSERT INTO doctor_available_times (doctor_id, available_times) VALUES (1, '11:00');

INSERT INTO patient (name, email, password, address) VALUES ('Alice Johnson', 'alice.j@example.com', 'patpass1', '123 Maple St, NY');
INSERT INTO patient (name, email, password, address) VALUES ('Bob Smith', 'bob.s@example.com', 'patpass2', '456 Elm St, CA');
INSERT INTO patient (name, email, password, address) VALUES ('Charlie Davis', 'charlie.d@example.com', 'patpass3', '789 Oak St, TX');
INSERT INTO patient (name, email, password, address) VALUES ('Diana Prince', 'diana.p@example.com', 'patpass4', '101 Amazon Way, WA');
INSERT INTO patient (name, email, password, address) VALUES ('Evan Wright', 'evan.w@example.com', 'patpass5', '202 Startup Blvd, SF');

-- Insert appointments
INSERT INTO appointment (doctor_id, patient_id, appointment_time, status) VALUES (1, 1, '2026-04-12 10:00:00', 0);
INSERT INTO appointment (doctor_id, patient_id, appointment_time, status) VALUES (2, 2, '2026-04-12 15:00:00', 0);

-- Insert fake prescriptions for John Smith
INSERT INTO prescription (patient_name, appointment_id, medication, doctor_notes) VALUES ('John Smith', 1, 'Lisinopril 10mg daily', 'Patient complained of mild chest pain. Blood pressure slightly elevated (140/90). Ordered EKG and resting monitor.');
INSERT INTO prescription (patient_name, appointment_id, medication, doctor_notes) VALUES ('John Smith', 2, 'Ibuprofen 400mg as needed', 'Follow-up from ankle sprain. Healing nicely. Recommended light physical therapy.');
