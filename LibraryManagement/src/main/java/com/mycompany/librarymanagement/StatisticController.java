/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.pojo.MemberCard;
import com.mycompany.librarymanagement.pojo.ReturnInfor;
import com.mycompany.librarymanagement.services.MemberCardServices;
import com.mycompany.librarymanagement.services.MethodNeeded;
import com.mycompany.librarymanagement.services.ReturnInforServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;


/**
 *
 * @author hp
 */
public class StatisticController implements Initializable{
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
    private int minDay = 0;
    private int maxDay = 0;
    
    public void swtichToIndex(ActionEvent event) throws IOException{
        App.setRoot("Index");
    }
    
    public void checkStatistic(ActionEvent event) throws SQLException{
        checkedChangingTime();
        String kq = loadStatisticByCourse(minDay, maxDay);
        
//        List<ReturnInfor> listRI = ReturnInforServices.getReturnInfor();
//        Alert alert = new Alert(Alert.AlertType.ERROR);
//        alert.setContentText("SL : " + MethodNeeded.countDay(listRI.get(0).getReturnDate()));
//        alert.showAndWait();

          this.amountBorrowBook.textProperty().set("SL : " + kq.substring(0,kq.indexOf("/")));
//        this.disrepairBook.textProperty().set("SL : " + slsh);
//        this.punctualityBorrowBook.textProperty().set("SL : " + sldh);
//        this.lateBorrowBook.textProperty().set("SL : " + slth);
//        this.blockMC.textProperty().set("SL : " + sltk);
    }
    
    public String loadStatisticByCourse(int minDay, int maxDay) throws SQLException {
        String s;
        List<ReturnInfor> listRI = ReturnInforServices.getReturnInfor();
        int ssm, sldh, slth, slsh, sltk;
        ssm = sldh = slth = slsh = sltk = 0;

        for (int i = 0; i < listRI.size(); i++) {
            if (MethodNeeded.countDay(listRI.get(i).getBorrowDate()) >= minDay &&
                   MethodNeeded.countDay(listRI.get(i).getBorrowDate()) <= maxDay ) {
                ssm += listRI.get(i).getBook();

                if (listRI.get(i).getStolenBook() >= 1 || listRI.get(i).getTornBook() >= 1) {
                    slsh += (listRI.get(i).getTornBook() + listRI.get(i).getStolenBook());
                }

                if (MethodNeeded.caculateDate(listRI.get(i).getBorrowDate(),
                        listRI.get(i).getReturnDate()) <= 30) {
                    sldh += listRI.get(i).getBook();
                } else {
                    slth += listRI.get(i).getBook();
                }
            }
        }

        s = ssm + "/" + sldh + "/" + slth + "/" + slsh;// + "/" + sltk;

        return s;
    }
            
    public void checkedChangingTime() {
        if (this.ckCourse1.isSelected()){
            minDay = 1;
            maxDay = 90;
            this.time.textProperty().set("Jan - March");
        }
        else if (this.ckCourse2.isSelected()){
            minDay = 91;
            maxDay = 181;
            this.time.textProperty().set("April - Jun");
        }
        else if (this.ckCourse3.isSelected()){
            minDay = 182;
            maxDay = 273;
            this.time.textProperty().set("July - September");
        }
        else if (this.ckCourse4.isSelected()){
            minDay = 274;
            maxDay = 365;
            this.time.textProperty().set("October - December");
        }
        else
            this.time.textProperty().set("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
