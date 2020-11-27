package com.mycompany.libarymanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package ;
import com.mycompany.libarymanagement.pojo.jdbcUtils;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
public class LoginController implements Initializable {
    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField txtPassword;
   
    @FXML
    private void checkUser(ActionEvent evt) throws Exception{
            Connection connect = jdbcUtils.getConnection();
            
            String sql = "Select * From libarydb.user Where userName = ? and password = ? ";
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                PreparedStatement stm = connect.prepareStatement(sql);
                stm.setString(1,txtUserName.getText() );
                stm.setString(1,txtPassword.getText() );
                ResultSet rs=  stm.executeQuery();
                if(rs.next())
                    alert.setContentText("Connect to the database successfully!");
                else
                    alert.setContentText("Connect to the database fail!");              
            } catch (SQLException e) {
            }
            
        }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

