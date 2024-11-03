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
    
    @Autowired
    private ProductsInterface prodService;

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
    	System.out.println("Hello from ShowProductPage");
    	return "product";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") LoginForm loginForm, 
                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "login";
        }

        if (loginService.authenticate(loginForm)) {
        	System.out.println("authenticated");
        	//List<ProductModel> products = prodService.getProducts();
    		
    		//model.addAttribute("title", "My Products");
    		//model.addAttribute("products", products);
            model.addAttribute("username", loginForm.getUsername());
            return "redirect:/products";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}