package com.gcu.controller;

import com.gcu.model.LoginForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") LoginForm loginForm, 
                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login";
        }

        // Emulating authentication
        if ("admin".equals(loginForm.getUsername()) && "password".equals(loginForm.getPassword())) {
            model.addAttribute("username", loginForm.getUsername());
            return "redirect:/product";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}