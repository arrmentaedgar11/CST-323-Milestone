package main.java.com.gcu.models;
//Added by Alethea Morton

public class UserModel {
    // User personal details
    @NotNull(message="Please enter a first name")
    private String firstName;
    @NotNull(message="Please enter a last name")
    private String lastName;
    // User registration/login details
    @NotNull(message="Username required")
    @Size(min=1, max=32, message="Username must be between 1 and 32 characters")
    private String userName;
    @NotNull(message="Password required")
    @Size(min=1, max=32, message="Username must be between 1 and 32 characters")
    private String password;
    @NotNull(message="Please enter an email address")
    private String email;

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getUserName(){return userName;}
    public void setUserName(String userName){this.userName = userName;}

    public String getPassword() {return password;}
    public void setPassword(String pass) {password = pass;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    //Constructor as an alternative method of creating user objects
    public UserModel(String first, String last, String username, String pass, String email){
        firstName = first;
        lastName = last;
        userName = username;
        password = pass;
        this.email = email;
    }
}
