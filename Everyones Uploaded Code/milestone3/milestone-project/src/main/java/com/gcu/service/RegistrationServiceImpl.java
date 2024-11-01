package com.gcu.service;


import com.gcu.model.RegistrationModel;
import org.springframework.stereotype.Service;

@Service //This class is a Spring-managed service bean
public class RegistrationServiceImpl implements RegistrationService
{
        @Override
    public String registerUser(RegistrationModel registrationModel)
        {
            //simulated  registration logic
            // Any complex logic or validations can be placed here
            return "Registration successful for user: " + registrationModel.getUserName();
        }
}
