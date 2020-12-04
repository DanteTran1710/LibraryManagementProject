/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;


/**
 *
 * @author thinh
 */
public class LoginServices {
        
    public static void checkUser(String name, String pass) throws Exception{
        
        Connection connect = jdbcUtils.getConnection();
        //Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        String sql = "Select userName,passWord From membercard where userName = ? and passWord  = ?";
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setString(1, name );
            stm.setString(2, pass );
            ResultSet rs=  stm.executeQuery();
            if(rs.next()){
                alert.setContentText("Connect to the database successfully!");
               // alert.showAndWait();
            }
            else{
                alert.setContentText("Connect to the fail!");
               // alert.showAndWait();
            }
            alert.showAndWait();
        } catch (SQLException e) {
            }      
        }
}

