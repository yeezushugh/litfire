package com.example.kkdemo_version1.Model;

public class Account {

    // Unique Account Identifier, Related with User ID
    private long id;
    // Related with User ID
    private long userId;
    // Email Address
    private String emailAddress;
    // Password
    private String password;
    // Account status
    private int status;

    // Constructor
    public Account(){

    }

    // region Getter Setter  ************************************************************

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    // region End of Getter Setter  *****************************************************

}
