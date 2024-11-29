package com.gcu.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


/**
 * RegistrationModel
 *
 * Represents a registration entity used for capturing user details during the registration process.
 * This model is annotated for use with both Spring Data and Java Bean Validation.
 *
 * Responsibilities:
 * - Serve as the data transfer object (DTO) for user registration.
 * - Validate user input fields using annotations.
 * - Map the fields to the "registration" table in the database.
 */


@Table("registration") // Maps this class to the "registration" table in the database
public class RegistrationModel {

    /**
     * Unique identifier for the registration entry.
     */

    @Id
    private Long id;

    /**
     * The username of the user.
     *
     * Constraints:
     * - Must not be null.
     * - Must have at least one character.
     */

    @NotNull(message = "Username is required")
    @Size(min = 1)
    private String userName;

    /**
     * The password of the user.
     *
     * Constraints:
     * - Must not be null.
     * - Must be at least 6 characters long.
     */

    @NotNull(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    /**
     * The first name of the user.
     *
     * Constraints:
     * - Must not be null.
     * - Must have at least one character.
     */

    @NotNull(message = "First name is required")
    @Size(min = 1)
    private String firstName;

    /**
     * The last name of the user.
     *
     * Constraints:
     * - Must not be null.
     * - Must have at least one character.
     */

    @NotNull(message = "Last name is required")
    @Size(min = 1)
    private String lastName;

    /**
     * The email address of the user.
     *
     * Constraints:
     * - Must not be null.
     * - Must be a valid email address format.
     */

    @NotNull(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;

    /**
     * The phone number of the user.
     *
     * Constraints:
     * - Must not be null.
     */

    @NotNull(message = "Phone number is required")
    private String phone;



    // Getters and setters for all fields

    /**
     * Gets the username.
     *
     * @return The username of the user.
     */

    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username.
     *
     * @param userName The username to set.
     */

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password.
     *
     * @return The password of the user.
     */

    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password The password to set.
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the first name.
     *
     * @return The first name of the user.
     */

    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName The first name to set.
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return The last name of the user.
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName The last name to set.
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email.
     *
     * @return The email address of the user.
     */


    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email The email address to set.
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the phone number.
     *
     * @return The phone number of the user.
     */

    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number.
     *
     * @param phone The phone number to set.
     */

    public void setPhone(String phone) {
        this.phone = phone;
    }
}