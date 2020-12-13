package com.mycompany.librarymanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package ;
import com.mycompany.librarymanagement.services.MemberCardServices;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML private TextField txtUserName;
    @FXML private PasswordField txtPassword;

    public void Login(ActionEvent event) throws Exception {
        if (!this.txtUserName.getText().equals("") && !this.txtPassword.getText().equals("")
                && verifyID(this.txtUserName)) {
            if (MemberCardServices.checkLogin(this.txtUserName.getText(), this.txtPassword.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Log in successfully!");
                alert.showAndWait();
                if (MemberCardServices.checkObject(this.txtUserName.getText()).equals("Admin")) {
                    App.setRoot("Statistic");
                } else {
                    App.setRoot("TradeInfors");
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Wrong password or username! Please try again");
                alert.showAndWait();  
                this.txtPassword.clear();
                this.txtUserName.clear();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please complete your form before submit!");
            alert.showAndWait();
        }
    }

    public boolean verifyID(TextField txt) {
        Pattern p = Pattern.compile("[a-z-|_|.]+");
        Matcher m = p.matcher(txt.getText());

        if (m.find() && m.group().equals(txt.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter valid character!");
            alert.showAndWait();
            txt.clear();
            return false;
        }
    }

    public void switchtoSignUp(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Do you want to create an account?");

        ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType btnNo = new ButtonType("No", ButtonBar.ButtonData.NO);

        alert.getButtonTypes().setAll(btnNo, btnYes);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == btnYes) {
            App.setRoot("SignUp");
        } else {
            App.setRoot("Login");
        }
    }
}
