/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thinh
 */
public class JDBCUtils {
    private static Connection conn;
    
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("mysql:jdbc://localhost/test", "root", "123456");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
                Logger.getLogger(JDBCUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static Connection getConnection(){
        return conn;
    }
}
