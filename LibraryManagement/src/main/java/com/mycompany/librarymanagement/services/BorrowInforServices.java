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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class BorrowInforServices {

    public static boolean addBorrowInfor(BorrowInfor infor) throws SQLException {
        Connection connect = jdbcUtils.getConnection();
        String query = "insert into borrowinfor(id, ObjectName, PhoneNumber,"
                + " Object, Book, BorrowDate, ReturnDate, idBs, idMC) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        connect.setAutoCommit(false);

        PreparedStatement stm = connect.prepareStatement(query);
        stm.setString(1, infor.getId());
        stm.setString(2, infor.getObjectName());
        stm.setString(3, infor.getPhoneNum());
        stm.setString(4, infor.getObject());
        stm.setInt(5, infor.getBook());
        stm.setString(6, infor.getBorrowDate());
        stm.setString(7, infor.getReturnDate());
        stm.setString(8, infor.getIdB());
        stm.setString(9, infor.getIdMC());

        stm.executeUpdate();

        connect.commit();
        
        return true;
    }
   
    public static List<BorrowInfor> getBorrowInfor() throws SQLException {
        Connection connect = jdbcUtils.getConnection();
        Statement stm = connect.createStatement();
        ResultSet rs = stm.executeQuery("Select * from borrowinfor");

        List<BorrowInfor> list = new ArrayList<>();
        while (rs.next()) {
            BorrowInfor bi = new BorrowInfor(rs.getString("id"), rs.getString("ObjectName"),
                    rs.getString("PhoneNumber"), rs.getString("Object"), rs.getInt("Book"),
                    rs.getString("BorrowDate"), rs.getString("ReturnDate"), rs.getString("idBs"), rs.getString("idMC"));

            list.add(bi);
        }
        return list;
    }

    public static String getIdBsFromBI(String id) throws SQLException {
        String query = "Select idBs from borrowinfor where idMC=?";

        Connection connect = jdbcUtils.getConnection();
        PreparedStatement stm = connect.prepareStatement(query);
        stm.setString(1, id);

        ResultSet rs = stm.executeQuery();
        String state = "";
        while (rs.next()) {
            state = rs.getString("idBs");
        }
        return state;
    }
}
