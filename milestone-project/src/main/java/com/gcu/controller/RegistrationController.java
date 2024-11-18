package com.gcu.controller;

import com.gcu.model.RegistrationModel;
import com.gcu.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class RegistrationController

{

    private final RegistrationService registrationService;


    @Autowired //Inject the RegistrationService bean
    public RegistrationController(RegistrationService registrationService)
    {
        this.registrationService = registrationService;
    }


    // Display registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationModel", new RegistrationModel());
        return "registrationPage";
    }

    // Handle form submission
    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute("registrationModel") RegistrationModel registrationModel, BindingResult result, Model model) {
        if(result.hasErrors())
        {
            return "registrationPage";
        }
        String pw = registrationModel.getPassword();
        String encpw = new BCryptPasswordEncoder().encode(pw);
        registrationModel.setPassword(encpw);
        RegistrationModel savedRegistration = registrationService.registerUser(registrationModel);
        model.addAttribute("registrationData", savedRegistration);
        return "registrationSuccess";
    }
}