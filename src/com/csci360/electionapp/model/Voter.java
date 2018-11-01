package com.csci360.electionapp.model;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;


public class Voter {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String socialSecurityNumber;
    private String address;
    private String userName;
    private String password;



    public Voter(String firstName, String lastName, String dateOfBirth, String socialSecurityNumber, String address, String userName, String password){
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSocialSecurityNumber() {
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


    public void storeVoter(Voter v) {

         String COMMA_DELIMITER = ",";

         String NEW_LINE_SEPARATOR = "\n";

        String FILE_HEADER = "firstName,lastName,dateOfBirth,socialSecurityNumber,address,userName,password";

        FileWriter fileWriter=null;
        try{
            fileWriter = new FileWriter("voters.csv",true);
            fileWriter.append(v.firstName);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(v.lastName);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(v.dateOfBirth);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(v.socialSecurityNumber);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(v.address);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(v.userName);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(v.password);
            fileWriter.append(NEW_LINE_SEPARATOR);


            System.out.println("The new voter was added to the file");


        }
        catch (Exception e){
            System.out.println("error while writing to the csv");
            System.out.println(e);
        }
        finally {
            try{
                fileWriter.flush();
                fileWriter.close();
            }
            catch(IOException e){
                System.out.println("error while closing file writer");
            }
        }

    }

    //com.csci360.electionapp.model.storeVoter followed this tutorial to store the voters in the csv file



}
