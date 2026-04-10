package com.smartcare.service;

import com.smartcare.model.Appointment;
import com.smartcare.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    /**
     * Retrieves appointments for a specific date.
     */
    public List<Appointment> getAppointmentsByDate(java.time.LocalDate date) {
        java.time.LocalDateTime startOfDay = date.atStartOfDay();
        java.time.LocalDateTime endOfDay = date.atTime(23, 59, 59);
        return appointmentRepository.findByAppointmentTimeBetween(startOfDay, endOfDay);
    }

    /**
     * Schedules a new appointment by directly calling save() on the repository.
     */
    public Appointment bookAppointment(Appointment appointment) {
        appointment.setStatus(0); // 0 = Scheduled
        return appointmentRepository.save(appointment);
    }
}
