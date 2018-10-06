package edu.voting.attempt;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SuccessRegController {

    @FXML
    private javafx.scene.control.Button returnLogIn;
    public void pressLogIn(ActionEvent event) throws Exception {
        try {
            returnLogIn.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginPage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();


        //https://www.youtube.com/watch?v=RJOza3XQk34
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
