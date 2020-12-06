/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.pojo.Book;
import com.mycompany.librarymanagement.services.MethodNeeded;
import com.mycompany.librarymanagement.pojo.BorrowInfor;
import com.mycompany.librarymanagement.pojo.ReturnInfor;
import com.mycompany.librarymanagement.services.BookServices;
import com.mycompany.librarymanagement.services.BorrowInforServices;
import com.mycompany.librarymanagement.services.MemberCardServices;
import com.mycompany.librarymanagement.services.ReturnInforServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    @FXML TextField cardID;
    @FXML Text stateCard;
    @FXML DatePicker borrowDay;
    @FXML TableView<Book> tbBook;
    @FXML TextField idBs;
    
    // Returning Book
    @FXML TextField nameCus;
    @FXML TextField idCus;
    @FXML ComboBox candidate1;
    @FXML DatePicker borrowDay1;
    @FXML Spinner bookCounted1;
    @FXML Spinner tornBookCounted;
    @FXML Spinner stolenBookCounted;
    @FXML TextField cardName1;
    @FXML Text stateCard1;
    @FXML Text nameBill;
    @FXML Text idMCBill;
    @FXML Text stateCardBill;
    @FXML Text feeBorrowBill;
    
    
    public void swtichToIndex(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Do you want return to main?");
        alert.showAndWait();
        App.setRoot("Index");
    }
    
    public void switchtoChoice(ActionEvent event) throws IOException  {
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
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
    
    public void completeReturnForm(ActionEvent event) throws IOException, SQLException {
        if (!this.nameCus.getText().equals("")
                && !this.candidate1.getSelectionModel().getSelectedItem().toString().equals("")
                && !this.idCus.getText().equals("") && !this.borrowDay1.getEditor().getText().equals("")
                && verifyCharacter(this.nameCus) && verifyID(this.idCus)) {
            String id = MethodNeeded.createUUID();

            ReturnInfor ri = new ReturnInfor(id, this.idCus.getText(),
                    this.candidate1.getSelectionModel().getSelectedItem().toString(),
                    this.nameCus.getText(), (int) this.bookCounted1.getValue(),
                    MethodNeeded.editFormmatDate(borrowDay1), MethodNeeded.getDateNow(),
                    (int) this.stolenBookCounted.getValue(), (int) this.tornBookCounted.getValue(),caculateFine());

            try {
                ReturnInforServices.addReturnInfor(ri);
                String[] sub = BorrowInforServices.getIdBsFromBI(this.idCus.getText()).split(",");
                for (int i = 0; i < sub.length; i++) {
                    BookServices.updateStateBook(sub[i], "Available");
                }
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Your returning-fill informations is done!");
                alert.showAndWait();

            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Error completed! Please try again");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please complete your form before submit!");
            alert.showAndWait();
        }
        if(MethodNeeded.caculateDate(MethodNeeded.editFormmatDate(borrowDay1),
                    MethodNeeded.getDateNow()) > 30)
            MemberCardServices.updateStateMC(this.idCus.getText(), "Disable");
    }

    public void checkoutMCBorrow(ActionEvent event) {
        if (verifyID(this.cardName)) {
            try {
                this.stateCard.textProperty().set(
                        MemberCardServices.checkMemberCard(this.cardName.getText()));

            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Your card is not exist");
                alert.showAndWait();
            }
        }
    }

    public void checkoutMCReturn(ActionEvent event) {
        if (verifyID(this.cardName1)) {
            try {
                this.stateCard1.textProperty().set(
                        MemberCardServices.checkMemberCard(this.cardName1.getText()));
            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Your card is not exist");
                alert.showAndWait();
            }
        }
    }

    public void checkoutBook(ActionEvent event) {
        try {
            this.stateBook.textProperty().set(
                    BookServices.checkBookByName(this.bookName.getText()));
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Your book is not exist");
            alert.showAndWait();
        }
    }
    
    public void loadB(ActionEvent event) throws SQLException{
        tbBook.getColumns().clear();
        loadBook(tbBook);
    }
    
    public void completedBorrowBook(ActionEvent event) throws SQLException {
        if (!this.name.getText().equals("") && !this.phoneNumber.getText().equals("")
                && !this.idBs.getText().equals("") && !this.borrowDay.getEditor().getText().equals("")
                && !this.returnDay.getEditor().getText().equals("")
                && !this.candidate.getSelectionModel().getSelectedItem().toString().equals("") 
                && !this.cardID.getText().equals("") && verifyNumText() 
                && verifyCharacter(name) && verifyID(cardID) && checkoutBookText()) {
            String id = MethodNeeded.createUUID();

            BorrowInfor bi = new BorrowInfor(id, this.name.getText(), this.phoneNumber.getText(),
                    this.candidate.getSelectionModel().getSelectedItem().toString(),
                    (int) this.bookCounted.getValue(),
                    MethodNeeded.editFormmatDate(borrowDay),
                    MethodNeeded.editFormmatDate(returnDay), this.idBs.getText(), this.cardID.getText());

            try {
                BorrowInforServices.addBorrowInfor(bi);
                String[] sub = this.idBs.getText().split(",");
                for(int i=0; i < sub.length; i++)
                    BookServices.updateStateBook(sub[i],"Borrowed");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Your borrow-fill informations is done!");
                alert.getButtonTypes().setAll(new ButtonType("OK", ButtonBar.ButtonData.YES));
                if (alert.showAndWait().get() == ButtonType.YES) {
                    alert.close();
                }
            } catch (SQLException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Error completed! Please try again later");
                alert.getButtonTypes().setAll(new ButtonType("OK",
                        ButtonBar.ButtonData.YES));
                if (alert.showAndWait().get() == ButtonType.YES) {
                    alert.close();
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please complete your form before submit!");
            alert.getButtonTypes().setAll(new ButtonType("OK", ButtonBar.ButtonData.YES));
            if (alert.showAndWait().get() == ButtonType.YES) {
                alert.close();
            }
        }
    }
    
    public void returnBill(ActionEvent event) throws SQLException {
        if (!this.nameCus.getText().equals("")
                && !this.candidate1.getSelectionModel().getSelectedItem().toString().equals("")
                && !this.idCus.getText().equals("") && !this.borrowDay1.getEditor().getText().equals("")
                && verifyCharacter(this.nameCus) && verifyID(this.idCus)) {
            this.nameBill.setText(this.nameCus.getText());
            this.idMCBill.setText(this.idCus.getText());
            this.stateCardBill.setText(MemberCardServices.checkMemberCard(this.idCus.getText()));
            this.feeBorrowBill.setText(caculateFine() + " Đ");
        }
    }
    
    public double caculateFine() {
        double fee = 0;
        double feeTorn = 100000;
        double feeStolen = 200000;
        double feeLate = 5000;
        if (MethodNeeded.caculateDate(MethodNeeded.editFormmatDate(borrowDay1),
                MethodNeeded.getDateNow()) <= 30) {
            if ((int) this.stolenBookCounted.getValue() >= 1) {
                if ((int) this.tornBookCounted.getValue() >= 1) {
                    fee += feeTorn * (int) this.tornBookCounted.getValue();
                } else {
                    fee += 0;
                }
                fee += feeStolen * (int) this.stolenBookCounted.getValue();
            } else {
                fee += 0;
            }
        } else if (MethodNeeded.caculateDate(MethodNeeded.editFormmatDate(borrowDay1),
                MethodNeeded.getDateNow()) > 30) {
            if ((int) this.stolenBookCounted.getValue() >= 1) {
                if ((int) this.tornBookCounted.getValue() >= 1) {
                    fee += feeTorn * (int) this.tornBookCounted.getValue();
                } else {
                    fee += 0;
                }
                fee += feeStolen * (int) this.stolenBookCounted.getValue();
            } else {
                fee += 0;
            }
            fee += feeLate * MethodNeeded.caculateDate(MethodNeeded.editFormmatDate(borrowDay1),
                    MethodNeeded.getDateNow());
        } else {
            fee += 0;
        }
        return fee;
    }
    
    public static void loadBook(TableView<Book> tbv) throws SQLException{
         TableColumn colSTT = new TableColumn("Book Code");
         colSTT.setCellValueFactory(new PropertyValueFactory("idB"));
         TableColumn colName = new TableColumn("Name");
         colName.setCellValueFactory(new PropertyValueFactory("nameB"));
         TableColumn colAuthorName = new TableColumn("Author");
         colAuthorName.setCellValueFactory(new PropertyValueFactory("authorName"));
         TableColumn colRelease = new TableColumn("Release Day");
         colRelease.setCellValueFactory(new PropertyValueFactory("release"));
         TableColumn colNXB = new TableColumn("Release Place");
         colNXB.setCellValueFactory(new PropertyValueFactory("releasePlace"));
         TableColumn colState = new TableColumn("State");
         colState.setCellValueFactory(new PropertyValueFactory("state")); 
         TableColumn colCategory = new TableColumn("Category");
         colCategory.setCellValueFactory(new PropertyValueFactory("category"));   
         
         tbv.getColumns().addAll(colSTT, colName,colAuthorName,
                                 colRelease,colNXB,colState,colCategory);
         
        tbv.setItems(FXCollections.observableArrayList(BookServices.getBook()));
     }
    
    public boolean verifyNumText(){
        Pattern p = Pattern.compile("(0)?[0-9]{9}");
        Matcher m = p.matcher(this.phoneNumber.getText());
        
        if(m.find() && m.group().equals(this.phoneNumber.getText())){
            return true;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter valid number!");
            alert.showAndWait();
            this.phoneNumber.clear();
            return false;
        }
    }
    
    public boolean verifyCharacter(TextField txt) {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(txt.getText());

        if (m.find() && m.group().equals(txt.getText())) {
            return true;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter valid character!");
            alert.showAndWait();
            txt.clear();
            return false;
        }
    }

    public boolean verifyID(TextField txt) {
        Pattern p = Pattern.compile("[a-zA-Z0-9]{5}+");
        Matcher m = p.matcher(txt.getText());

        if (m.find() && m.group().equals(txt.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter valid id!");
            alert.showAndWait();
            txt.clear();
            return false;
        }
    }
    
    public boolean checkoutBookText() throws SQLException {
        boolean flat = true;
        if (this.idBs.getText().length() == 3 &&
                BookServices.checkBookByID(this.idBs.getText()).equals("Available")) {
                return true;
        } else if (this.idBs.getText().length() > 3) {
            if (this.idBs.getText().contains(",")) {
                String[] sub = this.idBs.getText().split(",");
                for (int i = 0; i < sub.length; i++) {
                    if (BookServices.checkBookByID(sub[i]).equals("Borrowed")) {
                        flat = false;
                    }
                }
                if (flat) {
                    return true;
                }
            }
        }
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Please enter valid id book!");
        alert.showAndWait();
        this.idBs.clear();
        return false;
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
            loadBook(tbBook);
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Cannot load book from database!");
            alert.showAndWait();
        }
    }
}
