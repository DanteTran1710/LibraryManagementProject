/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement.services;

import com.mycompany.libarymanagement.MethodNeeded;
import com.mycompany.libarymanagement.pojo.BorrowInfor;
import com.mycompany.libarymanagement.pojo.jdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class BorrowInforServices {
        public static void addBorrowInfor(BorrowInfor infor) throws SQLException{
        Connection connect = jdbcUtils.getConnection();
        String query = "insert into borrowinfor(id, ObjectName, PhoneNumber,"
                + " Object, Book, BorrowDate, ReturnDate) values (?, ?, ?, ?, ?, ?, ?)";
        
        connect.setAutoCommit(false);
        
        PreparedStatement stm = connect.prepareCall(query);
        stm.setString(1, MethodNeeded.createUUID());
        stm.setString(2, infor.getObjectName());
        stm.setString(3, infor.getPhoneNum());
        stm.setString(4, infor.getObject());
        stm.setInt(5, infor.getBook());
        stm.setString(6, infor.getBorrowDate());
        stm.setString(7, infor.getReturnDate());
        
        stm.executeUpdate();
        
        connect.commit();
    }
}
