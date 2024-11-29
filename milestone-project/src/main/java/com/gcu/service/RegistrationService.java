package com.gcu.service;

import com.gcu.model.RegistrationModel;
import org.springframework.stereotype.Service;

/**
 * RegistrationService
 *
 * This interface defines the contract for the registration-related business logic.
 * It acts as an abstraction layer between the controller and the repository, ensuring
 * that the registration operations are handled in a clean, modular way.
 *
 * Responsibilities:
 * - Register new users by saving their details into the database.
 * - Retrieve all registration records for administrative or auditing purposes.
 */

@Service //  Marks this interface as a Spring-managed service component
public interface RegistrationService{

    /**
     * Registers a new user by saving their registration details.
     *
     * @param registrationModel The registration details of the user.
     * @return The saved RegistrationModel object, including any database-generated fields.
     */
    RegistrationModel registerUser(RegistrationModel registrationModel);

    /**
     * Retrieves all registration records.
     *
     * @return An Iterable containing all RegistrationModel objects from the database.
     */
    Iterable<RegistrationModel> getAllRegistrations();




}
