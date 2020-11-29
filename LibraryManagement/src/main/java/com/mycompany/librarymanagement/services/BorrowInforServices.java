/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.services;

import com.mycompany.librarymanagement.pojo.BorrowInfor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hp
 */
public class BorrowInforServices {

    public static void addBorrowInfor(BorrowInfor infor) throws SQLException {
        Connection connect = jdbcUtils.getConnection();
        String query = "insert into borrowinfor(id, ObjectName, PhoneNumber,"
                + " Object, Book, BorrowDate, ReturnDate) values (?, ?, ?, ?, ?, ?, ?)";

        connect.setAutoCommit(false);

        PreparedStatement stm = connect.prepareStatement(query);
        stm.setString(1, infor.getId());
        stm.setString(2, infor.getObjectName());
        stm.setString(3, infor.getPhoneNum());
        stm.setString(4, infor.getObject());
        stm.setInt(5, infor.getBook());
        stm.setString(6, infor.getBorrowDate());
        stm.setString(7, infor.getReturnDate());

        stm.executeUpdate();

        connect.commit();
    }
   
    public static int getInforBookAmountment(String id) throws SQLException{
        String query =  "Select Book from borrowinfor where id=?";
        
        Connection connect = jdbcUtils.getConnection();
        PreparedStatement stm = connect.prepareStatement(query);
        stm.setString(1, id);
       
        ResultSet rs = stm.executeQuery();
        int sl = 0;
        while(rs.next()){
            sl = rs.getInt("Book");
        }
        return sl;
    }
}
