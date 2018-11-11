package com.csci360.electionapp.model;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Admin {


    /**
     * a dummy default contructor and until one can be thought of
     */
    public Admin(){

    }


    /**
     * counts the votes in the csv file and prints it to the screen
     * @return
     */
    public void tallyVote(){
        try {
            String[] candidates = {"Darth Vader", "Chewbacca", "Anakin Skywalker", "Luke Skywalker", "Yoda", "Darth Maul", "Mace Windu", "Jar-Jar Binks", "C3PO"};
            int darthCnt = 0;
            int chewbaccaCnt = 0;
            int anakinCnt = 0;
            int lukeCnt = 0;
            int yodaCnt = 0;
            int maulCnt = 0;
            int maceCnt = 0;
            int jarCnt = 0;
            int c3p0Cnt = 0;
            BufferedReader fileReader=null;
            //try to read the file. if it fails, the catch prints the stack trace
            try{
                fileReader=new BufferedReader(new FileReader("castedVotes.csv"));
                String line="";
                while ((line = fileReader.readLine()) != null) {
                    //get all tokens available in a line by splitting it by the commas
                    String[] tokens = line.split(",");
                    for(int i = 0; i < tokens.length; i++) {
                        if (tokens[i].equalsIgnoreCase("Darth Vader")){
                            darthCnt++;
                        }
                        else if (tokens[i].equalsIgnoreCase("Chewbacca")){
                            chewbaccaCnt++;
                        }
                        else if (tokens[i].equalsIgnoreCase("Anakin Skywalker")){
                            anakinCnt++;
                        }
                        else if (tokens[i].equalsIgnoreCase("Luke Skywalker")){
                            lukeCnt++;
                        }
                        else if (tokens[i].equalsIgnoreCase("Yoda")){
                            yodaCnt++;
                        }
                        else if (tokens[i].equalsIgnoreCase("Darth Maul")){
                            maulCnt++;
                        }
                        else if (tokens[i].equalsIgnoreCase("Mace Windu")){
                            maceCnt++;
                        }
                        else if (tokens[i].equalsIgnoreCase("Jar-Jar Binks")){
                            jarCnt++;
                        }
                        else if (tokens[i].equalsIgnoreCase("C3PO")){
                            c3p0Cnt++;
                        }
                    }

                }

                System.out.println("Total Votes" + "\n" +
                        "Darth Vader = " + darthCnt + "\n" +
                        "Chewbacca = " + chewbaccaCnt + "\n" +
                        "Anakin Skywalker = " + chewbaccaCnt + "\n" +
                        "Luke Skywalker = " + lukeCnt + "\n" +
                        "Yoda = " + yodaCnt + "\n" +
                        "Darth Maul = " + maulCnt + "\n" +
                        "Mace Windu = " + maceCnt + "\n" +
                        "Jar-Jar Binks = " + jarCnt + "\n" +
                        "C3P0 = " + c3p0Cnt + "\n");

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
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * prints the votes
     */
    public void print(){
        try {
            JEditorPane text = new JEditorPane("castedVotes.csv");
            PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            text.print(null, null, false, service, null, false);
            System.out.println("the file has been printed");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
