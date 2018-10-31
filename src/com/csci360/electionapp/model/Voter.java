package com.csci360.electionapp.model;



public class Voter {

    private String firstName;
    private String lastName;
    private long dateOfBirth;
    private long socialSecurityNumber;
    private String address;
    private String userName;
    private String password;



    public Voter(String firstName, String lastName, long dateOfBirth, long socialSecurityNumber, String address, String userName, String password){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDateOfBirth(dateOfBirth);
        this.setSocialSecurityNumber(socialSecurityNumber);
        this.setAddress(address);
        this.setUserName(userName);
        this.setPassword(password);
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

    public long getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(long dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(long socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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


}
