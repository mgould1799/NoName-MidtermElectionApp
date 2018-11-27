package com.csci360.electionapp.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VoterCheck {

    /**
     * Checks to see if a voter is in a the voters.csv
     * @param voter
     * @return
     */
    public static boolean isUserNameTaken(Voter voter){
        BufferedReader fileReader=null;
        //try to read the file. if it fails, the catch prints the stack trace
        try{
            fileReader=new BufferedReader(new FileReader("./voters.csv"));
            String line="";
            while ((line = fileReader.readLine()) != null) {
                //get all tokens available in a line by splitting it by the commas
                String[] tokens = line.split(",");
                if(tokens.length>0) {
                    //creates a tempory voter
                    Voter tempVoter=new Voter(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6]);
                    //if the userName exists it returns true
                    if(tempVoter.getUserName().equals(voter.getUserName()))
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

    public static boolean verifyUserName(String givenUserName){
        BufferedReader fileReader=null;
        //try to read the file. if it fails, the catch prints the stack trace
        try{
            fileReader=new BufferedReader(new FileReader("./voters.csv"));
            String line="";
            while ((line = fileReader.readLine()) != null) {
                //get all tokens available in a line by splitting it by the commas
                String[] tokens = line.split(",");
                if(tokens.length>0) {
                    //creates a tempory voter
                    Voter tempVoter=new Voter(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6]);
                    //if the userName exists it returns true
                    if(givenUserName.equals(tempVoter.getUserName()))
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

    public static boolean verifyPassword(String givenPassword){
        BufferedReader fileReader=null;
        //try to read the file. if it fails, the catch prints the stack trace
        boolean isRight=false;
        try{
            fileReader=new BufferedReader(new FileReader("./voters.csv"));
            String line="";
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                //get all tokens available in a line by splitting it by the commas
                String[] tokens = line.split(",");
                if(tokens.length>0) {
                    //creates a tempory voter
                    Voter tempVoter=new Voter(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6]);
                    //if the userName exists it returns true
                    if(BCrypt.checkpw(givenPassword,tempVoter.getPassword())) {
                        isRight = true;
                        System.out.println("Is right var " + isRight);
                    }
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

    /**
     * Checks if a user has voted before.
     * @param
     * @return
     */

    public static boolean hasVoted(String username){
        boolean voteStatus = false;
        BufferedReader fileReader=null;
        //try to read the file. if it fails, the catch prints the stack trace
        try{
            fileReader=new BufferedReader(new FileReader("./usersVoted.csv"));
            String line="";
            while ((line = fileReader.readLine()) != null) {
                //get all tokens available in a line by splitting it by the commas
                String[] tokens = line.split(",");
                if(tokens.length>0) {
                    if(tokens[0].equals(username)){
                        voteStatus = true;
                    }
                    //if the userName exists it returns true
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
        return voteStatus;


    }
}
