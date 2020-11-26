/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement;

import com.mycompany.libarymanagement.pojo.Book;
import com.mycompany.libarymanagement.services.MethodNeeded;
import com.mycompany.libarymanagement.pojo.BorrowInfor;
import com.mycompany.libarymanagement.pojo.ReturnInfor;
import com.mycompany.libarymanagement.services.BorrowInforServices;
import com.mycompany.libarymanagement.services.ReturnInforServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;
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
    @FXML ComboBox candidate;
    @FXML Spinner bookCounted;
    @FXML DatePicker returnDay;
    @FXML TextField bookName;
    @FXML Text stateBook;
    @FXML TextField cardName;
    @FXML Text stateCard;
    @FXML DatePicker borrowDay;
    @FXML TableView<Book> tbBook;
    
    // Returning Book
    @FXML TextField nameCus;
    @FXML TextField idCus;
    @FXML ComboBox candidate1;
    @FXML DatePicker borrowDay1;
    @FXML Spinner bookCounted1;
    @FXML Spinner tornBookCounted;
    @FXML Spinner stolenBookCounted;
    
    public void swtichToIndex(ActionEvent event) throws IOException
    {
        App.setRoot("Index");
    }
    
    public void switchtoChoice(ActionEvent event) throws IOException  {
            
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
    
    public void noticeCompleteReturnForm(ActionEvent event){
        String id = MethodNeeded.createUUID();    
        
        ReturnInfor ri = new ReturnInfor(id, this.idCus.getText(), 
                this.candidate1.getSelectionModel().getSelectedItem().toString(), 
                this.nameCus.getText(), (int) this.bookCounted1.getValue(),
                MethodNeeded.editFormmatDate(borrowDay1), 
                (int)this.stolenBookCounted.getValue(), (int)this.tornBookCounted.getValue());
        
        try {
            ReturnInforServices.addReturnInfor(ri);
            
            Alert alert = new Alert(Alert.AlertType.NONE);
            alert.setContentText("Your returning-fill informations is done!");
            alert.getButtonTypes().setAll(new ButtonType("OK", ButtonBar.ButtonData.YES));
            if (alert.showAndWait().get() == ButtonType.YES)
            alert.close();
            
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error completed! Please try again");
            alert.getButtonTypes().setAll(new ButtonType("OK", ButtonBar.ButtonData.YES));
            if (alert.showAndWait().get() == ButtonType.YES)
                alert.close();
        }

    }
    
    public void noticeCompleteBorrowForm(ActionEvent event){
        String id = MethodNeeded.createUUID();
        
        BorrowInfor bi = new BorrowInfor(id, this.name.getText(), this.phoneNumber.getText()
                ,this.candidate.getSelectionModel().getSelectedItem().toString(),
              (int) this.bookCounted.getValue(), 
                MethodNeeded.editFormmatDate(borrowDay),
                MethodNeeded.editFormmatDate(returnDay));
            
        try {
            BorrowInforServices.addBorrowInfor(bi);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Your borrow-fill informations is done!");
            alert.getButtonTypes().setAll(new ButtonType("OK", ButtonBar.ButtonData.YES));
            if (alert.showAndWait().get() == ButtonType.YES)
                alert.close();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error completed! Please try again later");
            alert.getButtonTypes().setAll(new ButtonType("OK"
                    ,ButtonBar.ButtonData.YES));
            if (alert.showAndWait().get() == ButtonType.YES)
                alert.close();
        }

    }

    public void checkoutMC(ActionEvent event){
        try {
            this.stateCard.textProperty().set(
                 BorrowInforServices.checkMemberCard(this.cardName.getText()));
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Your card is not exist");
        }
    }

    public void checkoutBook(ActionEvent event) {
        try {
            this.stateBook.textProperty().set(
                    BorrowInforServices.checkBook(this.bookName.getText()));
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Your card is not exist");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MethodNeeded.addSpinnerValue(bookCounted);
        MethodNeeded.addSpinnerValue(bookCounted1);
        MethodNeeded.addSpinnerValue(stolenBookCounted);
        MethodNeeded.addSpinnerValue(tornBookCounted);
        
        List<String> listS = new ArrayList<>();
        listS.add("SV");
        listS.add("GV");
        
        this.candidate.getItems().addAll(listS);
        this.candidate1.getItems().addAll(listS);
     
        try {
            BorrowInforServices.loadBook(tbBook);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Cant find any book from database");
        }
    }
}
