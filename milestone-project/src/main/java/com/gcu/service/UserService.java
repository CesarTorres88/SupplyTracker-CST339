package com.gcu.service;

import com.gcu.model.User;



public interface UserService {

    // Check if a user exists by username
    boolean isUserExists(String username);

    // Create a new user
    User createUser(User userModel);

    // Optional: Fetch all users for Admin
    Iterable<User> getAllUsers();



}



