package com.gcu.repository;

import com.gcu.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    // Custom query to find a user by username
    User findByUserName(String userName);


}
