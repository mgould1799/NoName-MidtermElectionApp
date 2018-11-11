package com.csci360.electionapp.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.csci360.electionapp.model.Voter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.csci360.electionapp.model.Admin;

public class AdminLoginController {
    // Buttons
    @FXML
    private javafx.scene.control.Button adminReturnButton;
    @FXML
    private javafx.scene.control.Button adminTallyVotes;
    @FXML
    private javafx.scene.control.Button printVotes;

    private Admin admin = new Admin();

    public void pressPrintVotes(ActionEvent event) throws Exception{
        admin.print();
    }
    public void pressAdminReturn(ActionEvent event) throws Exception {
        try {
            adminReturnButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginPage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void pressTallyVotes(ActionEvent event) throws Exception {
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
                        "Darth Maul = " + darthCnt + "\n" +
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


}

