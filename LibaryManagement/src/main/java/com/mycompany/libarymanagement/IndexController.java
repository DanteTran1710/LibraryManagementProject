package com.mycompany.libarymanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class IndexController implements Initializable {
    @FXML 
        private Button btnSV;
    @FXML 
        private Button btnGV;
    @FXML
    public void switchToLogin() throws IOException
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Choose to move");
        alert.setContentText("Choose the option");
        
        ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType btnNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        
        alert.getButtonTypes().setAll(btnNo,btnYes);
        Optional<ButtonType> result = alert.showAndWait();
        
        if(result.get() == btnYes)
            App.setRoot("Login");
        else
            App.setRoot("Index");
        
       
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
