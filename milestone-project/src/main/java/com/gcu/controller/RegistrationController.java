package com.gcu.controller;

import com.gcu.model.RegistrationModel;
import com.gcu.model.User;
import com.gcu.service.RegistrationService;
import com.gcu.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * RegistrationController
 *
 * This controller handles user registration processes, including displaying the
 * registration form, processing user inputs, validating the form data, and saving
 * the user data to the database after encrypting their password.
 *
 * Responsibilities:
 * - Serve the registration form to users.
 * - Validate and process submitted registration forms.
 * - Encrypt the user's password using BCrypt.
 * - Interact with the RegistrationService to persist user data.
 */


@Controller
public class RegistrationController

{

    private final RegistrationService registrationService;

    private final UserService userService;

    /**
     * Constructor for RegistrationController.
     *
     * @param registrationService Service used to handle registration logic and data persistence.
     */


    @Autowired //Inject the RegistrationService bean
    public RegistrationController(RegistrationService registrationService, UserService userService)
    {
        this.registrationService = registrationService;
        this.userService = userService;
    }


    /**
     * Handles GET requests to display the registration form.
     *
     * @param model Spring Model object used to pass data to the view.
     * @return The name of the Thymeleaf template for the registration form.
     */

    // Display registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationModel", new RegistrationModel());
        return "registrationPage";
    }

    /**
     * Handles POST requests to process the submitted registration form.
     *
     * @param registrationModel The model object containing the user's registration data.
     * @param result            BindingResult object for form validation.
     * @param model             Spring Model object used to pass data to the view.
     * @return The name of the view to display after processing the form.
     */

    // Handle form submission
    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute("registrationModel") RegistrationModel registrationModel, BindingResult result, Model model) {

        //Check for validation errors in the submitted form
        if(result.hasErrors())
        {
            return "registrationPage"; // Redisplay the form with validation errors
        }

        // Check if the user already exists
        if (userService.isUserExists(registrationModel.getUserName())) {
            model.addAttribute("error", "This username is already in use");
            return "registrationPage";
        }

        // Save the username and password into the user table
        User newUser = new User();
        newUser.setUserName(registrationModel.getUserName());
        newUser.setPassword(registrationModel.getPassword());
        userService.createUser(newUser);

        // Encrypt the user's password using BCrypt
        String pw = registrationModel.getPassword();
        String encpw = new BCryptPasswordEncoder().encode(pw);
        registrationModel.setPassword(encpw);

        // Save the registration details via the RegistrationService
        RegistrationModel savedRegistration = registrationService.registerUser(registrationModel);

        // Add the saved registration data to the model for display
        model.addAttribute("registrationData", savedRegistration);
        return "registrationSuccess"; // Redirect to the success page
    }
}