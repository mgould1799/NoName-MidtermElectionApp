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

    // Admit Credentials
    String adminUserName = "admin";
    String adminPW = "admin";


    /**
     * takes the user to the registration page
     * @param event
     * @throws Exception
     */
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

    /**
     * if the user logs in with admin, they will be taken to the admin page.
     * if a user enters any login information that ins't admin, they will be taken to the voting ballot
     *  if they give a correct username and password.
     * @param event
     * @throws Exception
     */
    @FXML
    public void pressLogin(ActionEvent event) throws Exception {
        if (usernameField.getText().equalsIgnoreCase(adminUserName) && passwordField.getText().equalsIgnoreCase(adminPW))
        {
            try {
                logInButton.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminLogin.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            if (random.verifyPassword(passwordField.getText()) && random.verifyUserName(usernameField.getText())) {
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
            } else {
                System.out.println("username and password doesn't exist. Try again.");
            }
        }
    }

}
