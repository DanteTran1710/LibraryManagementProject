/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.pojo.ReturnInfor;
import com.mycompany.librarymanagement.services.MethodNeeded;
import com.mycompany.librarymanagement.services.ReturnInforServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;

/**
 *
 * @author hp
 */
public class StatisticController implements Initializable{
    @FXML RadioButton rbCourse1;
    @FXML RadioButton rbCourse2;
    @FXML RadioButton rbCourse3;
    @FXML RadioButton rbCourse4;
    @FXML RadioButton rbCourseYear;
    @FXML Text amountBorrowBook;
    @FXML Text punctualityBorrowBook;
    @FXML Text lateBorrowBook;
    @FXML Text fine;
    @FXML Text disrepairBook;
    @FXML Text time;
    private int minDay = 0;
    private int maxDay = 0;
    
    public void swtichToIndex(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Do you want to return to main?");
        alert.showAndWait();
        App.setRoot("Index");
    }
    
    public void checkStatistic(ActionEvent event) throws SQLException {
        
        checkedChangingTime();
        String kq = loadStatisticByCourse(minDay, maxDay);
        String[] sub = kq.split("/");

        this.amountBorrowBook.textProperty().set(sub[0]);
        this.punctualityBorrowBook.textProperty().set(sub[1]);
        this.lateBorrowBook.textProperty().set(sub[2]);
        this.fine.textProperty().set(sub[4] + " Đ");
        this.disrepairBook.textProperty().set(sub[3]);
    }

    public String loadStatisticByCourse(int minDay, int maxDay) throws SQLException {
        String s;

        List<ReturnInfor> listRI = ReturnInforServices.getReturnInfor();
        int ssm, sldh, slth, slsh, sltk;
        ssm = sldh = slth = slsh = sltk = 0;

        if (minDay == 1 && maxDay == 365) {
            for (int i = 0; i < listRI.size(); i++) {
                if (MethodNeeded.caculateDate("", "") >= minDay
                        && MethodNeeded.caculateDate("", "") <= maxDay) {
                    ssm += listRI.get(i).getBook();
                    slsh += (listRI.get(i).getTornBook() + listRI.get(i).getStolenBook());
                    sltk += listRI.get(i).getFine();
                    if (MethodNeeded.caculateDate(listRI.get(i).getBorrowDate(),
                            listRI.get(i).getReturnDate()) <= 30) {
                        sldh += listRI.get(i).getBook();
                    }
                }
            }
        } else{
            for (int i = 0; i < listRI.size(); i++) {
                if (MethodNeeded.caculateDate(listRI.get(i).getReturnDate(),"") >= minDay
                        && MethodNeeded.caculateDate(listRI.get(i).getReturnDate(), "") <= maxDay) {
                    ssm += listRI.get(i).getBook();
                    slsh += (listRI.get(i).getTornBook() + listRI.get(i).getStolenBook());
                    sltk += listRI.get(i).getFine();
                    if (MethodNeeded.caculateDate(listRI.get(i).getBorrowDate(),
                            listRI.get(i).getReturnDate()) <= 30) {
                        sldh += listRI.get(i).getBook();
                    }
                }
            }
        }
        slth = ssm - sldh;
        s = ssm + "/" + sldh + "/" + slth + "/" + slsh + "/" + sltk;
        return s;
    }
            
    public void checkedChangingTime() {
        if (this.rbCourse1.isSelected()){
            minDay = 1;
            maxDay = 90;
            this.time.textProperty().set("Jan - March");
        }
        else if (this.rbCourse2.isSelected()){
            minDay = 91;
            maxDay = 181;
            this.time.textProperty().set("April - Jun");
        }
        else if (this.rbCourse3.isSelected()){
            minDay = 182;
            maxDay = 273;
            this.time.textProperty().set("July - September");
        }
        else if (this.rbCourse4.isSelected()){
            minDay = 274;
            maxDay = 365;
            this.time.textProperty().set("October - December");
        }
        else if(this.rbCourseYear.isSelected()){
            minDay = 1;
            maxDay = 365;
        }
        else
            this.time.textProperty().set("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
