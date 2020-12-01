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
        String query = "insert into returninfor(id, Object, Book, BorrowDate, "
                + "StolenBook, TornBook, ObjectName, idMC) values (?, ?, ?, ?, ?, ?, ?, ?)";
        
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
