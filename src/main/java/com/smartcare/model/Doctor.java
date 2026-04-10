package com.smartcare.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

/**
 * Entity representing a Doctor in the SmartCare Clinic System.
 * Stores personal, authentication, and availability info for medical queries.
 */
@Entity
public class Doctor {
    /**
     * Unique identifier for the doctor.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Full name of the doctor.
     */
    @NotNull
    @Size(min = 3, max = 100)
    private String name;
    
    /**
     * Medical specialty of the doctor.
     */
    @NotNull
    @Size(min = 3, max = 50)
    private String specialty;
    
    /**
     * Unique email address for notifications and login.
     */
    @Email
    @NotNull
    private String email;
    
    /**
     * Password credentials for secure access. Excluded from JSON reads.
     */
    @Size(min = 6)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
    /**
     * 10-digit direct contact phone number.
     */
    @Pattern(regexp = "\\d{10}")
    private String phone;
    
    /**
     * Available operating hours stored as dynamic list strings.
     */
    @ElementCollection
    private List<String> availableTimes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(List<String> availableTimes) {
        this.availableTimes = availableTimes;
    }
}
