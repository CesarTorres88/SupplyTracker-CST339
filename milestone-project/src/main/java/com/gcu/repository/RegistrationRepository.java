package com.gcu.repository;


import com.gcu.model.RegistrationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * RegistrationRepository
 *
 * This interface acts as a Data Access Layer for the `registration` table.
 * It extends Spring Data's `CrudRepository` to provide basic CRUD (Create, Read, Update, Delete) operations.
 *
 * Responsibilities:
 * - Interact with the `registration` database table.
 * - Define custom query methods for specific database operations.
 */

@Repository // Indicates that this is a Spring Data repository component
public interface RegistrationRepository extends CrudRepository<RegistrationModel, Long> {

	/**
	 * Custom method to find a registration by username.
	 *
	 * @param username The username to search for.
	 * @return The RegistrationModel object matching the given username, or null if none exists.
	 */

	RegistrationModel findByUserName(String username);
    
}
