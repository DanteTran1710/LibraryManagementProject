/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.services;

import com.mycompany.librarymanagement.pojo.ReturnInfor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class ReturnInforServices {
        public static void addReturnInfor(ReturnInfor infor) throws SQLException{
        Connection connect = jdbcUtils.getConnection();
        String query = "insert into returninfor(id, idMC, Object, ObjectName, Book, BorrowDate, "
                + "ReturnDate, StolenBook, TornBook) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        connect.setAutoCommit(false);
        
        PreparedStatement stm = connect.prepareCall(query);
        stm.setString(1, infor.getId());
        stm.setString(2, infor.getIdMC());
        stm.setString(3, infor.getObject());
        stm.setString(4, infor.getObjectName());
        stm.setInt(5, infor.getBook());
        stm.setString(6, infor.getBorrowDate());
        stm.setString(7, infor.getReturnDate());
        stm.setInt(8, infor.getStolenBook());
        stm.setInt(9, infor.getTornBook());
        
        stm.executeUpdate();
        
        connect.commit();
    }
        
    public static List<ReturnInfor> getReturnInfor() throws SQLException{
        Connection connect = jdbcUtils.getConnection();
        Statement stm = connect.createStatement();
        ResultSet rs = stm.executeQuery("Select * from returninfor");

        List<ReturnInfor> list = new ArrayList<>();
        while (rs.next()) {
            ReturnInfor ri = new ReturnInfor(rs.getString("id"), rs.getString("idMC"),
                    rs.getString("Object"), rs.getString("ObjectName"), rs.getInt("Book"),
                    rs.getString("BorrowDate"),rs.getString("ReturnDate"),
                    rs.getInt("StolenBook"),rs.getInt("TornBook"));
           
             list.add(ri);
         }
         return list;
    }
}