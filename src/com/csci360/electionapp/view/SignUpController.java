package com.csci360.electionapp.view;

import com.csci360.electionapp.model.VoterCheck;
import com.csci360.electionapp.model.VoterStorage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.csci360.electionapp.model.Voter;
import com.csci360.electionapp.model.VoterStorage;
import com.csci360.electionapp.model.VoterCheck;

import static com.csci360.electionapp.model.VoterCheck.isUserNameTaken;

public class SignUpController {

    @FXML
    private javafx.scene.control.Button register;
    @FXML
    private javafx.scene.control.Button cancel;


    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField address;
    @FXML
    private TextField dateOfBirth;
    @FXML
    private TextField socialSecurityNumber;
    @FXML
    private TextField userName;
    @FXML
    private TextField password;

    @FXML
    private Label change;
    @FXML
    private Label invSocial;
    @FXML
    private Label userNameTaken;


    /**
     * if a user presses cancel, it takes them back to the log in screen.
     * @param event
     * @throws Exception
     */
    public void pressCancel(ActionEvent event) throws Exception {
        try{
            cancel.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginPage.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * voter enters all of there information to register. if a username is not taken, they move onto the succesfully
     *      registered screen.
     * @param event
     * @throws Exception
     */
    public void pressRegister(ActionEvent event) throws Exception {
        if (!isInt(socialSecurityNumber.getText())) {
            invSocial.setText("Enter a valid SSN.");
            return;
        }
        Voter newVoter=new Voter(firstName.getText(),lastName.getText(),dateOfBirth.getText(),address.getText(),socialSecurityNumber.getText(),userName.getText(),password.getText());
        if(!VoterCheck.isUserNameTaken(newVoter)) {
            VoterStorage.storeVoter(newVoter);
            try {
                register.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("successReg.fxml"));
                Parent root2 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root2));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            userNameTaken.setText("That username already exists. \n Please enter another.");
        }
    }

    private boolean isInt(String input){
        try {
            int num = Integer.parseInt(input);
            return true;
        }
        catch(NumberFormatException e){
            System.out.println("Error: " + input + " is not a number!");
            return false;
        }
    }
}
