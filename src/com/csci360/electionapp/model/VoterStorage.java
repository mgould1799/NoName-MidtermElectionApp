package com.csci360.electionapp.model;

import com.csci360.electionapp.Security.AES;
import com.csci360.electionapp.Security.BCrypt;

import java.io.FileWriter;
import java.io.IOException;

public class VoterStorage {

    /**
     * Stores a voter in the csv
     *
     * @param voter
     */
    public static void storeVoter(Voter voter) {

        String COMMA_DELIMITER = ",";

        String NEW_LINE_SEPARATOR = "\n";

        String FILE_HEADER = "firstName,lastName,dateOfBirth,socialSecurityNumber,address,userName,password";

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("./voters.csv", true);
            fileWriter.append(voter.getFirstName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(voter.getLastName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(AES.encrypt(voter.getDateOfBirth()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(AES.encrypt(voter.getSocialSecurityNumber()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(AES.encrypt(voter.getAddress()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(voter.getUserName());
            fileWriter.append(COMMA_DELIMITER);
            String hash = BCrypt.hashpw(voter.getPassword(), BCrypt.gensalt());
            fileWriter.append(hash);
            fileWriter.append(NEW_LINE_SEPARATOR);




            System.out.println("The voter was successfully registered in our system.");


        } catch (Exception e) {
            System.out.println("error while writing to the csv");
            System.out.println(e);
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("error while closing file writer");
            }
        }

    }

    /**
     * Documents if a user has voted.
     *
     * @param username
     */
    public static void userVoted(String username) {

        String COMMA_DELIMITER = ",";

        String NEW_LINE_SEPARATOR = "\n";

        String FILE_HEADER = "username, hasVoted";

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("./usersVoted.csv", true);
            fileWriter.append(username);
            fileWriter.append(NEW_LINE_SEPARATOR);


        } catch (Exception e) {
            System.out.println("error while writing to the csv");
            System.out.println(e);
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("error while closing file writer");
            }
        }

    }

}