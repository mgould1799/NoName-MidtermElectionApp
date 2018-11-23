package com.csci360.electionapp.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;




public class Hash {


    /**
     * sha 512
     * @param passwordToHash
     * @param salt
     * @return
     */
    public static String get_SHA_512_SecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            System.out.println("inside of no such algorithm execption");
            e.printStackTrace();
        }
        return generatedPassword;
    }


    /**
     * returns a salt
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);

        return salt;
    }

    /**
     * stores the salt in a csv file
     * @param salt
     * @param voter
     */
    public static void storeSalt(byte[] salt,Voter voter){
        String COMMA_DELIMITER = ",";

        String NEW_LINE_SEPARATOR = "\n";
        FileWriter fileWriter=null;

        try{
            fileWriter=new FileWriter("salts.csv",true);
            fileWriter.append(voter.getUserName());
            fileWriter.append(COMMA_DELIMITER);
            System.out.println("Storing the salt. Here is the salt: "+salt);
            System.out.println("Here is the salt in string format"+byteToString(salt));
            System.out.println("here is the salt after going through algorithm "+stringToByte(byteToString(salt)));
            fileWriter.append(byteToString(salt));
            fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("The salt was added to the file");
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally{
            try{
                fileWriter.flush();
                fileWriter.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }

    }

    /**
     * gets the salt from the csv file and returns that salt
     * @param voter
     * @return
     */
    public static byte[] getSaltFromFile(Voter voter){
        byte[] salt =null;

        BufferedReader fileReader=null;
        try{
            fileReader=new BufferedReader(new FileReader("salts.csv"));
            String line="";
            while ((line = fileReader.readLine()) != null){
                String[] tokens=line.split(",");
                if(tokens.length>0){
                    if(tokens[0].equals(voter.getUserName())){
                        salt=stringToByte(tokens[1]);
                        System.out.println("Here is the stored salt in the file "+ salt);
                        return salt;
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            try{
                fileReader.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        return salt;
    }

    public static byte[] stringToByte(String salt){
        byte[] decodedSalt=Base64.getDecoder().decode(salt);
        return decodedSalt;
    }
    public static String byteToString(byte[] salt){
        String encodedSalt=Base64.getEncoder().encodeToString(salt);
        return encodedSalt;
    }




    


}

