package com.csci360.electionapp.model;


import java.io.*;


public class Voter {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String socialSecurityNumber;
    private String address;
    private String userName;
    private String password;

    /**
     * default constructor
     */
    public Voter(){

    }
    /**
     * Constructor
     * @param firstName
     * @param lastName
     * @param dateOfBirth
     * @param socialSecurityNumber
     * @param address
     * @param userName
     * @param password
     */
    public Voter(String firstName, String lastName, String dateOfBirth, String socialSecurityNumber, String address, String userName, String password){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDateOfBirth(dateOfBirth);
        this.setSocialSecurityNumber(socialSecurityNumber);
        this.setAddress(address);
        this.setUserName(userName);
        this.setPassword(password);
    }

    /**
     *
     * Setter and getter methods below for each attribute of a voter
     */
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

    public String getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
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

    public String toString(){
        return "The voter's username is "+ userName + ", and their password is "+password +" .";
    }



    //



}