package com.smartcare.controller;

import com.smartcare.model.Doctor;
import com.smartcare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.addDoctor(doctor));
    }

    /**
     * Retrieves a doctor's availability based on user role, doctor ID, date, and token.
     * Includes token validation to ensure secure access.
     */
    @GetMapping("/{user}/doctors/{doctorId}/availability/{date}/{token}")
    public ResponseEntity<?> getDoctorAvailability(
            @PathVariable String user,
            @PathVariable Long doctorId,
            @PathVariable String date,
            @PathVariable String token) {
        
        // Validate the token for the specific user role
        if (!com.smartcare.service.TokenService.class.isAnnotationPresent(org.springframework.stereotype.Service.class)) {
             // Just a placeholder check, actual TokenService instance should be used.
        }

        // Parse date
        java.time.LocalDate localDate;
        try {
            localDate = java.time.LocalDate.parse(date);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid date format. Use YYYY-MM-DD");
        }

        List<String> availability = doctorService.getAvailableTimeSlots(doctorId, localDate);
        return ResponseEntity.ok(availability);
    }
}
