/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.services.BorrowInforServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;


/**
 *
 * @author hp
 */
public class StatisticController {
    @FXML CheckBox ckCourse1;
    @FXML CheckBox ckCourse2;
    @FXML CheckBox ckCourse3;
    @FXML CheckBox ckCourse4;  
    @FXML Text amountBook;
    @FXML Text amountBorrowBook;
    @FXML Text time;
    
    public void swtichToIndex(ActionEvent event) throws IOException
    {
        App.setRoot("Index");
    }
    
    public void checkStatistic(ActionEvent event){
        checkedChangingTime();
    }
    
    public void loadStatistic(ActionEvent event) {
        try {
            int sl = BorrowInforServices.getInforBookAmountment("123");
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setContentText("Your borrows book : " + sl);
            
        } catch (SQLException ex) {
            Logger.getLogger(StatisticController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void checkedChangingTime(){
        if(this.ckCourse1.isSelected())
            this.time.textProperty().set("Jan - March");
        else if (this.ckCourse2.isSelected())
            this.time.textProperty().set("April - Jun");
        else if (this.ckCourse3.isSelected())
            this.time.textProperty().set("July - September");
        else if (this.ckCourse4.isSelected())
            this.time.textProperty().set("October - December");
        else
            this.time.textProperty().set("");
    }
    public void initialize(URL url, ResourceBundle rb) {

    }
}
