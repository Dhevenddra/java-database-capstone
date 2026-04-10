package com.smartcare.controller;

import com.smartcare.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DashboardController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/adminDashboard/{token}")
    public String adminDashboard(@PathVariable String token) {
        if(tokenService.validateToken(token, "admin")) {
            return "admin/adminDashboard";
        }
        return "redirect:/login";
    }

    @GetMapping("/doctorDashboard/{token}")
    public String doctorDashboard(@PathVariable String token) {
        if(tokenService.validateToken(token, "doctor")) {
            return "doctor/doctorDashboard";
        }
        return "redirect:/login";
    }

    @GetMapping("/patientDashboard/{token}")
    public String patientDashboard(@PathVariable String token) {
        if(tokenService.validateToken(token, "patient")) {
            return "patient/patientDashboard";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
