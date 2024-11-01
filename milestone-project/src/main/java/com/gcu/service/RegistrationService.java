package com.gcu.service;

import com.gcu.model.RegistrationModel;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService{
    RegistrationModel registerUser(RegistrationModel registrationModel);
    Iterable<RegistrationModel> getAllRegistrations();



    //String registerUser(RegistrationModel registrationModel);
}
