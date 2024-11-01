package com.gcu.service;


import com.gcu.model.RegistrationModel;
import com.gcu.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //This class is a Spring-managed service bean
public class RegistrationServiceImpl implements RegistrationService
{

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository){
        this.registrationRepository = registrationRepository;
    }

    @Override
    public RegistrationModel registerUser(RegistrationModel registrationModel){
        return registrationRepository.save(registrationModel); //Save to the database
    }

    @Override
    public Iterable<RegistrationModel> getAllRegistrations(){
        return registrationRepository.findAll(); //retrieve all registrations
    }









    /*@Override
        public String registerUser(RegistrationModel registrationModel)
        {
            //simulated  registration logic
            // Any complex logic or validations can be placed here
            return "Registration successful for user: " + registrationModel.getUserName();
        }*/
}
