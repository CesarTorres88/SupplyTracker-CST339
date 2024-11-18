package com.gcu.service;

import com.gcu.model.RegistrationModel;
import com.gcu.repository.RegistrationRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service //This class is a Spring-managed service bean
public class RegistrationServiceImpl implements RegistrationService, UserDetailsService
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		RegistrationModel user = registrationRepository.findByUserName(username);
		if(user != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(user.getUserName(), user.getPassword(), authorities);
		}
		else {
			throw new UsernameNotFoundException("username not found");
		}
	}









    /*@Override
        public String registerUser(RegistrationModel registrationModel)
        {
            //simulated  registration logic
            // Any complex logic or validations can be placed here
            return "Registration successful for user: " + registrationModel.getUserName();
        }*/
}
