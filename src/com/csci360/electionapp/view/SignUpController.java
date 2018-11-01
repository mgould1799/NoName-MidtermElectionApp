package com.csci360.electionapp.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.csci360.electionapp.model.Voter;
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

    public void pressRegister(ActionEvent event) throws Exception {
        Voter newVoter=new Voter(firstName.getText(),lastName.getText(),dateOfBirth.getText(),address.getText(),socialSecurityNumber.getText(),userName.getText(),password.getText());
        if(!newVoter.isUserNameTaken(newVoter)) {
            newVoter.storeVoter(newVoter);
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
            change.setText("Please pick a new username. That one is taken.");
        }
    }
}
