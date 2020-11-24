/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement;

import com.mycompany.libarymanagement.pojo.BorrowInfor;
import com.mycompany.libarymanagement.pojo.MemberCard;
import com.mycompany.libarymanagement.services.BorrowInforServices;
import com.mycompany.libarymanagement.services.MemberCardServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
import javafx.scene.text.Text;

/**
 *
 * @author hp
 */
public class TradeInforsController implements Initializable{
    // Borrow Book
    @FXML TextField name;
    @FXML TextField phoneNumber;
    @FXML ComboBox<MemberCard> candidate;
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
    @FXML Text bienlai;
    
    @FXML 
    public void swtichToIndex() throws IOException
    {
        App.setRoot("Index");
    }
    
    @FXML
    public void switchtoChoice() throws IOException  {
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Choose to choice");
            alert.setContentText("Do you want to see your bill ?");

            
            ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType btnNo = new ButtonType("No", ButtonBar.ButtonData.NO);

            alert.getButtonTypes().setAll(btnNo, btnYes);
            Optional<ButtonType> result = alert.showAndWait();
            alert.show();

            if (result.get() == btnYes) {
                alert.close();
            } else {
                App.setRoot("Index");
            }
    }
    @FXML 
    public void noticeCompleteReturnForm(){
        
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setContentText("Your returning-fill informations is done!");
        alert.getButtonTypes().setAll(new ButtonType("OK", ButtonBar.ButtonData.YES)); 
        if(alert.showAndWait().get() == ButtonType.YES)
            alert.close();
    }
    
    @FXML 
    public void noticeCompleteBorrowForm(ActionEvent event){
        
        addBorrowInforHandler();
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setContentText("Your borrow-fill informations is done!");
        alert.getButtonTypes().setAll(new ButtonType("OK", ButtonBar.ButtonData.YES)); 
        if(alert.showAndWait().get() == ButtonType.YES)
            alert.close();
    }
    @FXML
    public void addBorrowInforHandler(){
        String id = MethodNeeded.createUUID();
        int sl = (int)this.bookCounted.valueFactoryProperty().getValue();
        String dateb = this.borrowDay.dayCellFactoryProperty().get().toString();
        String dater = this.borrowDay1.dayCellFactoryProperty().get().toString();
        
        BorrowInfor bi = new BorrowInfor(id, this.name.getText(),
                "1",//this.candidate.getSelectionModel().getSelectedItem().getObject(),
                this.phoneNumber.getText(), sl, dateb, dater);
        
        try {
            BorrowInforServices.addBorrowInfor(bi);
        } catch (SQLException ex) {
            Logger.getLogger(TradeInforsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            candidate.getItems().addAll(MemberCardServices.getMember());
        } catch (SQLException ex) {
            Logger.getLogger(TradeInforsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
