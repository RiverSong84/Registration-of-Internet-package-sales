/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.User;

/**
 *
 * @author user
 */
public class SellingController {
    
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField adress;
    @FXML  
    private ChoiceBox<String> cbSpeed;  
    @FXML  
    private ChoiceBox<String> cbFlow;  
    @FXML  
    private ChoiceBox<String> cbContract;  
    @FXML
    private Button saveBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button closeBtn;
    @FXML
    private Button deleteBtn;

    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;

    ObservableList<User> persons = FXCollections.<User>observableArrayList();
    User person;

    @FXML
    TableView<User> table = new TableView<>();

    public SellingController() {
    }
     @FXML
    private void initialize()
    {
	person = new User();

	firstName.textProperty().bindBidirectional(person.firstNameProperty());
	lastName.textProperty().bindBidirectional(person.lastNameProperty());
	adress.textProperty().bindBidirectional(person.adressProperty());
        cbSpeed.valueProperty().bindBidirectional(person.speedProperty());
        cbFlow.valueProperty().bindBidirectional(person.flowProperty());
        cbContract.valueProperty().bindBidirectional(person.contractProperty()); 
    
        cbSpeed.getItems().addAll("2", "5", "10", "20", "50", "100"); 
        cbFlow.getItems().addAll("1", "5", "10", "100", "Flat"); 
        cbContract.getItems().addAll("1", "2");
    }
     @FXML
    private void save()
    {
	
	   
	    persons = table.getItems();
	    persons.add(new User(firstName.getText(), lastName.getText(), 
                    adress.getText(),cbSpeed.getSelectionModel().getSelectedItem(),
                    cbFlow.getSelectionModel().getSelectedItem(),
                    cbContract.getSelectionModel().getSelectedItem()));
	    table.setItems(persons);
	
    }
    @FXML
    private void close()
    {
	Platform.exit();
    }
    
     @FXML
    private void clear()
    {
        
          person.speedProperty().set("");
	  person.flowProperty().set("");
	  person.contractProperty().set("");
	  person.firstNameProperty().set("");
	  person.lastNameProperty().set("");
	  person.adressProperty().set("");
      	
    }
     @FXML
    private void delete()
    {
        
        persons = table.getItems();
        int index = table.selectionModelProperty().getValue().getSelectedIndex();
        if (index !=-1) {
            
	
	persons.remove(index);
	table.setItems(persons);
        }
        else{
        
                StringBuilder errMsg = new StringBuilder();

	    ArrayList<String> errList = person.errorsProperty().get();
            errList.stream().forEach((errList1) -> {
                errMsg.append(errList1);
            });

	    Alert alert = new Alert(Alert.AlertType.ERROR);
	    alert.setTitle("Error!");
	    alert.setHeaderText("Empty file can't be deleted!");
	    alert.setContentText(errMsg.toString());
	    alert.showAndWait();
	    errList.clear();
        
        } 
    }
}
    
