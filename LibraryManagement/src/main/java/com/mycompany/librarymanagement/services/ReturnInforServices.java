/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.services;

import com.mycompany.librarymanagement.pojo.ReturnInfor;
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
                + "StolenBook, TornBook, ObjectName, idMC, lateDate, fine) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        connect.setAutoCommit(false);
        
        PreparedStatement stm = connect.prepareCall(query);
        stm.setString(1, infor.getId());
        stm.setString(2, infor.getObject());
        stm.setInt(3, infor.getBook());
        stm.setString(4, infor.getBorrowDate());
        stm.setInt(5, infor.getStolenBook());
        stm.setInt(5, infor.getTornBook());
        stm.setString(7, infor.getObjectName());
        stm.setString(8, infor.getIdMC());
        stm.setString(9, infor.getLateDay());
        stm.setFloat(10, infor.getFine());
        
        stm.executeUpdate();
        
        connect.commit();
    }
}
