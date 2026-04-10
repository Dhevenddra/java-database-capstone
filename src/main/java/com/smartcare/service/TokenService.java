package com.smartcare.service;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class TokenService {
    
    // Mock token generation/validation for this simple scope
    public String generateToken(String role) {
        return role + "-" + UUID.randomUUID().toString();
    }

    public boolean validateToken(String token, String role) {
        if(token == null || token.isEmpty()) return false;
        return token.startsWith(role + "-");
    }
}
