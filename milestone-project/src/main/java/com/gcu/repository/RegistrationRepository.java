package com.gcu.repository;


import com.gcu.model.RegistrationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends CrudRepository<RegistrationModel, Long> {

	RegistrationModel findByUserName(String username);
    
}
