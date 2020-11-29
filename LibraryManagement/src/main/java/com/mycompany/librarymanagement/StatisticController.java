/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.pojo.Book;
import com.mycompany.librarymanagement.pojo.MemberCard;
import com.mycompany.librarymanagement.pojo.ReturnInfor;
import com.mycompany.librarymanagement.services.BookServices;
import com.mycompany.librarymanagement.services.MemberCardServices;
import com.mycompany.librarymanagement.services.MethodNeeded;
import com.mycompany.librarymanagement.services.ReturnInforServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
    @FXML Text amountBorrowBook;
    @FXML Text punctualityBorrowBook;
    @FXML Text lateBorrowBook;
    @FXML Text blockMC;
    @FXML Text disrepairBook;
    @FXML Text time;
    @FXML ComboBox<Book> cbb;
    
    public void swtichToIndex(ActionEvent event) throws IOException{
        App.setRoot("Index");
    }
    
    public void checkStatistic(ActionEvent event){
        checkedChangingTime();
    }
    
    public void loadStatistic(ActionEvent event) {
        try {
            List<ReturnInfor> listRI = ReturnInforServices.getReturnInfor();
            int sldh, slth, slsh;
            sldh = slth = slsh = 0;
            for (int i = 1; i <= listRI.size(); i++) {
                if (MethodNeeded.caculateDate(listRI.get(i).getBorrowDate(),
                        listRI.get(i).getLateDay()) < 30) {
                    sldh++;
                } else {
                    slth++;
                }
                if(listRI.get(i).getStolenBook() > 1 || listRI.get(i).getTornBook() > 1)
                    slsh++;
            }
            List<MemberCard> listMC = MemberCardServices.getMC();
            int sltk = 0;
            for(int i=1; i <= listMC.size(); i++)
                if(listMC.get(i).getStateCard().equals("Disable"));
                    sltk++;
            
        this.disrepairBook.textProperty().set("SL : " + slsh);
        this.punctualityBorrowBook.textProperty().set("SL : "+ sldh);
        this.lateBorrowBook.textProperty().set("SL : " + slth);
        this.blockMC.textProperty().set("SL : " + sltk);
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
        try {
            this.cbb.getItems().addAll(BookServices.getBook());
        } catch (SQLException ex) {
            Logger.getLogger(StatisticController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
