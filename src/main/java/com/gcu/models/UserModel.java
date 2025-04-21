package com.gcu.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserModel {
    // User personal details
    @NotNull(message="Please enter a first name")
    @Size(min=1, max=32, message="First Name must be between 1 and 32 characters")
    private String firstName;
    @NotNull(message="Please enter a last name")
    @Size(min=1, max=32, message="Last Name must be between 1 and 32 characters")
    private String lastName;
    // User registration/login details
    @NotNull(message="Username required")
    @Size(min=1, max=32, message="Username must be between 1 and 32 characters")
    private String username;
    @NotNull(message="Password required")
    @Size(min=1, max=32, message="Password must be between 1 and 32 characters")
    private String password;
    @NotNull(message="Please enter an email address")
    @Size(min=1, max=32, message="Email must be between 1 and 64 characters")
    @Email(message="Valid email is required")
    private String email;

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getUsername(){return username;}
    public void setUsername(String userName){this.username = userName;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
}
