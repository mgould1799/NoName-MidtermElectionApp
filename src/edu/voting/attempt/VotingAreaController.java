package edu.voting.attempt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class VotingAreaController {
    // ObservableLists

    @FXML
    ObservableList<String> mayors = FXCollections.observableArrayList("Darth Vader", "Chewbacca", "Anakin Skywalker");
    @FXML
    ObservableList<String> treasurer = FXCollections.observableArrayList("Luke Skywalker", "Yoda", "Darth Maul");
    @FXML
    ObservableList<String> council = FXCollections.observableArrayList("Mace Windu", "Jar-Jar Binks", "C3PO");


    // ComboBoxes
    @FXML
    private ComboBox mayorBox;
    @FXML
    private ComboBox treasurerBox;
    @FXML
    private ComboBox councilBox;

    // Buttons
    @FXML private javafx.scene.control.Button submit;


    public void initialize(){
        mayorBox.setItems(mayors);
        treasurerBox.setItems(treasurer);
        councilBox.setItems(council);
    }

    public void pressSubmit(ActionEvent event) throws Exception {
        try{
            submit.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("successSubmit.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
