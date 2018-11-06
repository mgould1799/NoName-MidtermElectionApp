package com.csci360.electionapp.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

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

    //

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
            String COMMA_DELIMITER = ",";

            String NEW_LINE_SEPARATOR = "\n";

            String FILE_HEADER = "firstName,lastName,dateOfBirth,socialSecurityNumber,address,userName,password";

            FileWriter fileWriter=null;
            try{
                fileWriter = new FileWriter("castedVotes.csv",true);
                fileWriter.append(mayorBox.getValue().toString());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(treasurerBox.getValue().toString());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(councilBox.getValue().toString());
                fileWriter.append(NEW_LINE_SEPARATOR);


                System.out.println("The votes were added to the file.");


            }
            catch (Exception e){
                System.out.println("error while writing to the csv");
                System.out.println(e);
            }
            finally {
                try{
                    fileWriter.flush();
                    fileWriter.close();
                }
                catch(IOException e){
                    System.out.println("error while closing file writer");
                }
            }
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SuccessSubmit.fxml"));
            Parent root2 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root2));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
