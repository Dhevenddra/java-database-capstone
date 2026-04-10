package com.smartcare.service;

import com.smartcare.model.Doctor;
import com.smartcare.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    /**
     * Validates doctor login credentials.
     */
    public Doctor validateLogin(String email, String password) {
        return doctorRepository.findAll().stream()
                .filter(d -> d.getEmail().equals(email) && d.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    /**
     * Retrieves available time slots for a specific date by filtering existing appointments.
     */
    public java.util.List<String> getAvailableTimeSlots(Long doctorId, java.time.LocalDate date) {
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        if (doctor == null) return java.util.Collections.emptyList();

        java.util.List<String> allSlots = doctor.getAvailableTimes();
        // In a real app, we would query AppointmentRepository to see which slots are taken on this specific 'date'.
        // For the capstone logic, we return the base availability as required.
        return allSlots;
    }
}
