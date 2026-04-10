-- SQL Script to generate daily appointment reports for doctors
-- Selects doctor name, appointment time, patient name, and patient phone
-- Joins relevant tables and orders by time for clarity

SELECT 
    d.name AS doctor_name, 
    a.appointment_time, 
    p.name AS patient_name, 
    p.phone AS patient_phone
FROM appointment a
JOIN doctor d ON a.doctor_id = d.id
JOIN patient p ON a.patient_id = p.id
ORDER BY a.appointment_time ASC;
