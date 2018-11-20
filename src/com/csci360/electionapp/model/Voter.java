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
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "The voter's username is "+ userName + ", and their password is "+password +" .";
    }


    /**
     * Stores a voter in the csv
     * @param v
     */
    public void storeVoter(Voter voter) {

        String COMMA_DELIMITER = ",";

        String NEW_LINE_SEPARATOR = "\n";

        String FILE_HEADER = "firstName,lastName,dateOfBirth,socialSecurityNumber,address,userName,password";

        FileWriter fileWriter=null;
        try{
            fileWriter = new FileWriter("voters.csv",true);
            fileWriter.append(voter.firstName);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(voter.lastName);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(voter.dateOfBirth);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(voter.socialSecurityNumber);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(voter.address);
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(voter.userName);
            fileWriter.append(COMMA_DELIMITER);
            String hash= BCrypt.hashpw(voter.password,BCrypt.gensalt());
            fileWriter.append(hash);
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

    /**
     * Checks to see if a voter is in a the voters.csv
     * @param v
     * @return
     */
    public boolean isUserNameTaken(Voter voter){
        BufferedReader fileReader=null;
        //try to read the file. if it fails, the catch prints the stack trace
        try{
            fileReader=new BufferedReader(new FileReader("voters.csv"));
            String line="";
            while ((line = fileReader.readLine()) != null) {
                //get all tokens available in a line by splitting it by the commas
                String[] tokens = line.split(",");
                if(tokens.length>0) {
                    //creates a tempory voter
                    Voter tempVoter=new Voter(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6]);
                    //if the userName exists it returns true
                    if(tempVoter.userName.equals(voter.userName))
                        return true;
                }

            }

        }
        catch(Exception e){
            System.out.println("Error while reading csv");
            System.out.println(e);
            e.printStackTrace();;
        }
        finally{
            try{
                fileReader.close();
            }
            catch(IOException e){
                System.out.println("error while closing file reader");
            }
        }
        return false;


    }

    //com.csci360.electionapp.model.storeVoter followed this tutorial to store the voters in the csv file

    /**
     * verifies if a username is within the csv file, so a user can login. returns true is so; false otherwise
     * @param givenUserName
     * @return
     */

    public boolean verifyUserName(String givenUserName){
        BufferedReader fileReader=null;
        //try to read the file. if it fails, the catch prints the stack trace
        try{
            fileReader=new BufferedReader(new FileReader("voters.csv"));
            String line="";
            while ((line = fileReader.readLine()) != null) {
                //get all tokens available in a line by splitting it by the commas
                String[] tokens = line.split(",");
                if(tokens.length>0) {
                    //creates a tempory voter
                    Voter tempVoter=new Voter(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6]);
                    //if the userName exists it returns true
                    if(givenUserName.equals(tempVoter.userName))
                        return true;
                }

            }

        }
        catch(Exception e){
            System.out.println("Error while reading csv");
            System.out.println(e);
            e.printStackTrace();;
        }
        finally{
            try{
                fileReader.close();
            }
            catch(IOException e){
                System.out.println("error while closing file reader");
            }
        }
        return false;


    }

    /**
     * checks to see if a password is the correct one stated in the csv.
     * returns true if there. returns false otherwise.
     * @param givenPassword
     * @return
     */

    public boolean verifyPassword(String givenPassword){
        BufferedReader fileReader=null;
        //try to read the file. if it fails, the catch prints the stack trace
        boolean isRight=false;
        try{
            fileReader=new BufferedReader(new FileReader("voters.csv"));
            String line="";
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                //get all tokens available in a line by splitting it by the commas
                String[] tokens = line.split(",");
                if(tokens.length>0) {
                    //creates a tempory voter
                    Voter tempVoter=new Voter(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6]);
                    //if the userName exists it returns true
                    if(BCrypt.checkpw(givenPassword,tempVoter.password));
                    isRight=true;
                }

            }

        }
        catch(Exception e){
            System.out.println("Error while reading csv");
            System.out.println(e);
            e.printStackTrace();;
        }
        finally{
            try{
                fileReader.close();
            }
            catch(IOException e){
                System.out.println("error while closing file reader");
            }
        }
        return isRight;


    }
    //



}