package com.mycompany.librarymanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class IndexController implements Initializable {
    @FXML private ComboBox cbObject;
    
    public void switchToLogin(ActionEvent event) throws IOException
    {
        App.setRoot("Login");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<String> listObject = new ArrayList<>();
        
        listObject.add("SINH VIÊN");
        listObject.add("GIẢNG VIÊN");
        listObject.add("THỦ THƯ"); 
        
        this.cbObject.getItems().addAll(listObject);
    }    
    
}
