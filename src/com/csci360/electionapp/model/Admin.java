package com.csci360.electionapp.model;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.*;

public class Admin {


    /**
     * a dummy default contructor and until one can be thought of
     */
    public Admin(){

    }


    /**
     * Eventually this will read a CSV file that will store votes and be able to count them
     * @return
     */
    public int tallyVote(){
        String[] candidates = {"Darth Vader", "Chewbacca", "Anakin Skywalker", "Luke Skywalker", "Yoda", "Darth Maul", "Mace Windu", "Jar-Jar Binks", "C3PO"};
        System.out.println(candidates[0]);
        return 0;
    }

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
