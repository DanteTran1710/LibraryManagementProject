/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    @FXML Text time;
    
    public void swtichToIndex(ActionEvent event) throws IOException
    {
        App.setRoot("Index");
    }
    
    public void checkStatistic(ActionEvent event){
        checkedChangingTime();
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
