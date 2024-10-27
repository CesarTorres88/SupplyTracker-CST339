package com.gcu.service;

import org.springframework.stereotype.Service;
import com.gcu.model.LoginForm;

@Service
public class LoginService {

    // Hardcoded credentials for emulation
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public boolean authenticate(LoginForm loginForm) {
        return VALID_USERNAME.equals(loginForm.getUsername()) &&
               VALID_PASSWORD.equals(loginForm.getPassword());
    }
}