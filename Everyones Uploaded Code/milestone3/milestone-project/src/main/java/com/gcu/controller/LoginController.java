package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.model.LoginForm;
import com.gcu.service.LoginService;

import jakarta.validation.Valid;

@Controller
public class LoginController {

    private final LoginService loginService;

    // Dependency injection of LoginService
    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("admin");
        loginForm.setPassword("password");
        model.addAttribute("loginForm", loginForm);
        return "login";
    }

    @GetMapping("/login/products")
    public String showProductPage() {
        return "product"; // "product.html" file in the templates directory
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") LoginForm loginForm, 
                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login"; // Return to login if there are validation errors
        }

        if (loginService.authenticate(loginForm)) {
            model.addAttribute("username", loginForm.getUsername());
            return "redirect:/products"; // Redirect to the products page on successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login"; // Return to login page if authentication fails
        }
    }
}