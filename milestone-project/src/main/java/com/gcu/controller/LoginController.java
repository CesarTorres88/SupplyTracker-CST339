package com.gcu.controller;

import com.gcu.model.LoginForm;
import com.gcu.model.ProductModel;
import com.gcu.service.LoginService;
import com.gcu.service.ProductsInterface;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	//@Autowired
    private final LoginService loginService;
    
    //@Autowired
    private ProductsInterface prodService;

    // Dependency injection of LoginService
    @Autowired
    public LoginController(LoginService loginService, ProductsInterface prodService) {
        this.loginService = loginService;
        this.prodService = prodService;
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

    @GetMapping("/login/products")
    public String showProductPage() {
    	System.out.println("Hello from ShowProductPage");
    	return "product";
    }
}