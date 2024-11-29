package com.gcu.service;

import com.gcu.model.RegistrationModel;
import com.gcu.repository.RegistrationRepository;

import java.util.ArrayList;
import java.util.List;

import com.gcu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * RegistrationServiceImpl
 *
 * This class provides the implementation of the RegistrationService interface
 * and integrates with the UserDetailsService for Spring Security authentication.
 *
 * Responsibilities:
 * - Handle user registration by saving user details into the database.
 * - Retrieve all registered users for administrative or reporting purposes.
 * - Load user details by username for authentication purposes in Spring Security.
 *
 * Annotations:
 * - @Service: Marks this class as a Spring-managed service component.
 */

@Service //This class is a Spring-managed service bean
public class RegistrationServiceImpl implements RegistrationService, UserDetailsService
{

    private final RegistrationRepository registrationRepository;

    /**
     * Constructor-based dependency injection for RegistrationRepository.
     *
     * @param registrationRepository The repository to manage registration data.
     */

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository){
        this.registrationRepository = registrationRepository;
    }

    @Autowired
    private UserRepository userRepository;

    /**
     * Registers a new user by saving their registration details to the database.
     *
     * @param registrationModel The registration details of the user.
     * @return The saved RegistrationModel object, including any database-generated fields.
     */

    @Override
    public RegistrationModel registerUser(RegistrationModel registrationModel){
        return registrationRepository.save(registrationModel); //Save to the database
    }

    /**
     * Retrieves all registered users from the database.
     *
     * @return An Iterable containing all RegistrationModel objects.
     */

    @Override
    public Iterable<RegistrationModel> getAllRegistrations(){
        return registrationRepository.findAll(); //retrieve all registrations
    }

    /**
     * Loads user details by username for Spring Security authentication.
     *
     * @param username The username of the user to load.
     * @return UserDetails object containing user information and roles.
     * @throws UsernameNotFoundException If the username is not found in the database.
     */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        RegistrationModel user = registrationRepository.findByUserName(username);
		if(user != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(user.getUserName(), user.getPassword(), authorities);
		}
		else {
			throw new UsernameNotFoundException("username not found" + username);
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
