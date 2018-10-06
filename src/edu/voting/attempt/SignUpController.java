package edu.voting.attempt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private javafx.scene.control.Button register;

    public void pressRegister(ActionEvent event) throws Exception {
        try{
            register.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("successReg.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
