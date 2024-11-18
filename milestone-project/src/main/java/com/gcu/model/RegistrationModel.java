package com.gcu.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("registration")
public class RegistrationModel {

    @Id
    private Long id;

    @NotNull(message = "Username is required")
    @Size(min = 1)
    private String userName;

    @NotNull(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotNull(message = "First name is required")
    @Size(min = 1)
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min = 1)
    private String lastName;

    @NotNull(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotNull(message = "Phone number is required")
    private String phone;



    // Getters and setters for all fields

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}