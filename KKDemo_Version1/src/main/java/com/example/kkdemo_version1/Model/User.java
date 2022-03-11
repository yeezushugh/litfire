package com.example.kkdemo_version1.Model;


//Basic User object
public class User {

    // Unique Identifier
    private long id;
    // Username in Application
    private String username;
    // Real name
    private String firstName;
    // Real name
    private String lastName;
    // Email Address
    private String emailAddress;

    // Constructor
    public User(){

    }

    // region Getter Setter  ************************************************************

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    // region End of Getter Setter  *****************************************************

}
