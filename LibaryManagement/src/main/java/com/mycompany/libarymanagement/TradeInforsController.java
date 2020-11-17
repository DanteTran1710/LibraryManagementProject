/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

/**
 *
 * @author hp
 */
public class TradeInforsController implements Initializable{
    // Borrow Book
    @FXML TextField name;
    @FXML TextField phoneNumber;
    @FXML ComboBox candidate;
    @FXML Spinner bookCounted;
    @FXML DatePicker returnDay;
    @FXML TextField bookName;
    @FXML TextField stateBook;
    @FXML TextField cardName;
    @FXML TextField stateCard;
    @FXML DatePicker borrowDay;
    
    // Returning Book
    @FXML TextField nameCus;
    @FXML TextField idCus;
    @FXML ComboBox candidate1;
    @FXML DatePicker borrowDay1;
    @FXML Spinner bookCounted1;
    @FXML CheckBox tornBookChk;
    @FXML CheckBox stolenBookChk;
    @FXML Spinner tornBookCounted;
    @FXML Spinner stolenBookCounted;
    
    @FXML 
    public void swtichToIndex() throws IOException
    {
        App.setRoot("Index");
    }
    
    @FXML
    public void switchtoChoice() throws IOException
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Choose to choice");
        alert.setContentText("Your returning-fill informations is done!/n"
                + "Do you want to see your bills?");
        
        ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType btnNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        
        alert.getButtonTypes().setAll(btnNo,btnYes);
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.get() == btnYes)
        {
            // Show the total bills
             App.setRoot("TradeInfors");
        }
        else
            App.setRoot("Index");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}
