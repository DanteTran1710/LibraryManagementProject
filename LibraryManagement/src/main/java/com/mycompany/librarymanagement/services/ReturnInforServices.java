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

    public static boolean addReturnInfor(ReturnInfor infor) throws SQLException {
        if (infor.getBook() != 0 && !infor.getBorrowDate().trim().equals("")
            && infor.getFine() != 0 && !infor.getId().trim().equals("") 
            && !infor.getUserName().trim().equals("") && !infor.getObject().trim().equals("")
            && !infor.getObjectName().trim().equals("") && !infor.getReturnDate().trim().equals("")) {
            Connection connect = jdbcUtils.getConnection();
            String query = "insert into returninfor(id, UserName, Object, ObjectName, Book, BorrowDate, "
                    + "ReturnDate, StolenBook, TornBook, Fine) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            connect.setAutoCommit(false);

            PreparedStatement stm = connect.prepareCall(query);
            stm.setString(1, infor.getId());
            stm.setString(2, infor.getUserName());
            stm.setString(3, infor.getObject());
            stm.setString(4, infor.getObjectName());
            stm.setInt(5, infor.getBook());
            stm.setString(6, infor.getBorrowDate());
            stm.setString(7, infor.getReturnDate());
            stm.setInt(8, infor.getStolenBook());
            stm.setInt(9, infor.getTornBook());
            stm.setDouble(10, infor.getFine());

            stm.executeUpdate();

            connect.commit();

            return true;
        }
        return false;
    }

    public static List<ReturnInfor> getReturnInfor() throws SQLException {
        Connection connect = jdbcUtils.getConnection();
        Statement stm = connect.createStatement();
        ResultSet rs = stm.executeQuery("Select * from returninfor");

        List<ReturnInfor> list = new ArrayList<>();
        while (rs.next()) {
            ReturnInfor ri = new ReturnInfor(rs.getString("id"), rs.getString("userName"),
                    rs.getString("Object"), rs.getString("ObjectName"), rs.getInt("Book"),
                    rs.getString("BorrowDate"), rs.getString("ReturnDate"),
                    rs.getInt("StolenBook"), rs.getInt("TornBook"), rs.getDouble("Fine"));

            list.add(ri);
        }
        return list;
    }
}
