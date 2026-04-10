package com.smartcare.controller;

import com.smartcare.model.Prescription;
import com.smartcare.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @GetMapping("/patient/{name}")
    public ResponseEntity<List<Prescription>> getPatientPrescriptions(@PathVariable String name) {
        return ResponseEntity.ok(prescriptionRepository.findByPatientName(name));
    }

    @PostMapping
    public ResponseEntity<java.util.Map<String, String>> generatePrescription(@jakarta.validation.Valid @RequestBody Prescription prescription) {
        prescriptionRepository.save(prescription);
        java.util.Map<String, String> response = new java.util.HashMap<>();
        response.put("status", "success");
        response.put("message", "Prescription generated successfully for patient: " + prescription.getPatientName());
        return ResponseEntity.ok(response);
    }
}
