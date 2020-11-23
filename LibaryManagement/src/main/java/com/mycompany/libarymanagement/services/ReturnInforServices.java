/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement.services;

import com.mycompany.libarymanagement.MethodNeeded;
import com.mycompany.libarymanagement.pojo.ReturnInfor;
import com.mycompany.libarymanagement.pojo.jdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class ReturnInforServices {
        public static void addReturnInfor(ReturnInfor infor) throws SQLException{
        Connection connect = jdbcUtils.getConnection();
        String query = "insert into returninfor(id, Object, Book, BorrowDate, "
                + "StolenBook, TornBook, ObjectName, idMC) values (?, ?, ?, ?, ?, ?, ?, ?)";
        
        connect.setAutoCommit(false);
        
        PreparedStatement stm = connect.prepareCall(query);
        stm.setString(1, MethodNeeded.createUUID());
        stm.setString(2, infor.getObject());
        stm.setInt(3, infor.getBook());
        stm.setString(4, infor.getBorrowDate());
        stm.setInt(5, infor.getStolenBook());
        stm.setInt(5, infor.getTornBook());
        stm.setString(7, infor.getObjectName());
        stm.setString(7, infor.getIdMC());
        
        stm.executeUpdate();
        
        connect.commit();
    }
}
