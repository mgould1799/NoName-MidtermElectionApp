package com.csci360.electionapp.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.csci360.electionapp.model.Voter;

public class LoginPageController  {
    // Buttons
    @FXML private javafx.scene.control.Button logInButton;
    // Buttons
    @FXML private javafx.scene.control.Button regButton;

    //ChoiceBox
    @FXML
    private ChoiceBox<String> repBox;
    @FXML
    private ObservableList<String> repList = FXCollections.observableArrayList("John Smith","Han Solo","Darth Vader");

    @FXML
    private TextField usernameField;

    @FXML TextField passwordField;

    Voter random= new Voter();



    public void pressReg(ActionEvent event) throws Exception {
        try {
            regButton.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("signUp.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void pressLogin(ActionEvent event) throws Exception {

        if(random.verifyPassword(passwordField.getText())&&random.verifyUserName(usernameField.getText())) {
            try {
                logInButton.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("votingArea.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("username and password doesn't exist. Try again.");
        }
    }

}
