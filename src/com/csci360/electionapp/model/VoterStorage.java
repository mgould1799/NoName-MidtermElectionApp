package com.csci360.electionapp.model;

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
            fileWriter = new FileWriter("voters.csv", true);
            fileWriter.append(voter.getFirstName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(voter.getLastName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(voter.getDateOfBirth());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(voter.getSocialSecurityNumber());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(voter.getAddress());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(voter.getUserName());
            fileWriter.append(COMMA_DELIMITER);
            String hash = BCrypt.hashpw(voter.getPassword(), BCrypt.gensalt());
            fileWriter.append(hash);
            fileWriter.append(NEW_LINE_SEPARATOR);


            System.out.println("The new voter was added to the file");


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