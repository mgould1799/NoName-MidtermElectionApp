package com.csci360.electionapp.model;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import java.io.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import javax.print.event.*;

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

    /*

     */

    /**
     * prints the votes
     */
    public static void print(){
       /* try {
            String urlSite="castedVotes.csv";
            URL site= new URL(urlSite);
            JEditorPane text = new JEditorPane(site);
            PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            text.print(null, null, false, service, null, false);
            System.out.println("the file has been printed");
        }
        catch(Exception e){
            System.out.println(e);
        }*/
        DocFlavor flavor = DocFlavor.INPUT_STREAM.POSTSCRIPT;
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(MediaSizeName.ISO_A4);
        aset.add(new Copies(2));
        aset.add(Sides.TWO_SIDED_LONG_EDGE);
        aset.add(Finishings.STAPLE);

        /* locate a print service that can handle it */
        PrintService[] pservices = PrintServiceLookup.lookupPrintServices(flavor, aset);
        if (pservices.length > 0) {
            System.out.println("selected printer " + pservices[0].getName());

            /* create a print job for the chosen service */
            DocPrintJob pj = pservices[0].createPrintJob();
            try {
                /*
                 * Create a Doc object to hold the print data.
                 * Since the data is postscript located in a disk file,
                 * an input stream needs to be obtained
                 * BasicDoc is a useful implementation that will if requested
                 * close the stream when printing is completed.
                 */
                FileInputStream fis = new FileInputStream("castedVotes.csv");
                Doc doc = new SimpleDoc(fis, flavor, null);

                /* print the doc as specified */
                pj.print(doc, aset);


            } catch (IOException ie) {
                System.err.println(ie);
            } catch (PrintException e) {
                System.err.println(e);
            }
        }
    }
}
