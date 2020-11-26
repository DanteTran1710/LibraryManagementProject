/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement.services;

import com.mycompany.libarymanagement.pojo.BorrowInfor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    
    public static String checkMemberCard(String id) throws SQLException{
        String query =  "Select StateCard from membercard where idMemberCard=?";
        
        Connection connect = jdbcUtils.getConnection();
        PreparedStatement stm = connect.prepareStatement(query);
        stm.setString(1, id);
       
        ResultSet rs = stm.executeQuery();
        String state = "";
        while(rs.next()){
            state = rs.getString("StateCard");
        }
        return state;
    }
    
     public static String checkBook(String name) throws SQLException{
        String query =  "Select State from book where BookName=?";
        
        Connection connect = jdbcUtils.getConnection();
        PreparedStatement stm = connect.prepareStatement(query);
        stm.setString(1, name);
       
        ResultSet rs = stm.executeQuery();
        String state = "";
        while(rs.next()){
            state = rs.getString("State");
        }
        return state;
    }
     
     public static void loadBook(TableView tbv) throws SQLException{
         TableColumn colSTT = new TableColumn("STT");
         colSTT.setCellValueFactory(new PropertyValueFactory("nameB"));
//         TableColumn colName = new TableColumn("Name");
//         colName.setCellValueFactory(new PropertyValueFactory("nameB"));
//         TableColumn colAuthorName = new TableColumn("Author");
//         colAuthorName.setCellValueFactory(new PropertyValueFactory("authorName"));
//         TableColumn colDescript = new TableColumn("Description");
//         colDescript.setCellValueFactory(new PropertyValueFactory("Description"));
//         TableColumn colRelease = new TableColumn("Release Day");
//         colRelease.setCellValueFactory(new PropertyValueFactory("release"));
//         TableColumn colNXB = new TableColumn("Release Place");
//         colNXB.setCellValueFactory(new PropertyValueFactory("releasePlace"));
//         TableColumn colState = new TableColumn("State");
//         colState.setCellValueFactory(new PropertyValueFactory("state"));   
         
//         tbv.getColumns().addAll(colName,colAuthorName,colDescript,
//                                 colRelease,colNXB,colState);
        tbv.getColumns().addAll(colSTT);
        tbv.setItems(FXCollections.observableArrayList(BookServices.getBook()));
     }
}
