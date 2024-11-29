package com.gcu.service;

import com.gcu.model.User;
import com.gcu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Implementation of the UserService interface.
 * Provides business logic for user-related operations such as checking existence, creating users, and retrieving users.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructor for injecting dependencies.
     * @param userRepository User repository for database operations.
     * @param passwordEncoder Password encoder for securing user passwords.
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Checks if a user with the given username exists in the database.
     * @param username The username to check.
     * @return true if the user exists, false otherwise.
     */
    @Override
    public boolean isUserExists(String user_name) {
        return userRepository.findByUserName(user_name) != null;
    }

    /**
     * Creates and saves a new user in the database.
     * @param user The user model containing username and password.
     * @return The saved user model.
     */
    @Override
    public User createUser(User userModel) {
        // Encode the password before saving
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return userRepository.save(userModel);
    }

    /**
     * Retrieves all users from the database.
     * @return An iterable of all user models.
     */
    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
