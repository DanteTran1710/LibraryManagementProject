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
        if (MemberCardServices.checkLogin(this.txtUserName.getText(), this.txtPassword.getText())) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Log in successfully!");
            alert.getButtonTypes().setAll(new ButtonType("OK", ButtonBar.ButtonData.YES));
            if (alert.showAndWait().get() == ButtonType.YES) {
                App.setRoot("TradeInfors");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Log in unsuccessfully! Please try again!");
            alert.getButtonTypes().setAll(new ButtonType("OK", ButtonBar.ButtonData.YES));
            if (alert.showAndWait().get() == ButtonType.YES) {
                App.setRoot("Login");
            }
        }
    }
    
    public void switchtoSignUp(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Choose to move");
        alert.setContentText("Choose the option");

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
