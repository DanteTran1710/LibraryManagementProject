/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement.services;

import com.mycompany.libarymanagement.pojo.Book;
import com.mycompany.libarymanagement.pojo.jdbcUtils;
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
public class BookServices {
//     public static List<Book> getBook() throws SQLException{
//        Connection connect =  jdbcUtils.getConnection();
//        Statement stm = connect.createStatement();
//        ResultSet rs = stm.executeQuery("Select * from book");
//        
//        List<Book> listBook = new ArrayList<>();
//        while(rs.next()){
//           Book b = new Book(rs.getString("idBook"),rs.getString("BookName"),
//                   rs.getString("AuthorName"), rs.getString("Descriptions"),
//                   rs.getString("Release"), rs.getString("PlaceRelease"));
//           
//           listBook.add(b);
//        }
//        return listBook;
//    }
//     
//    public static void addBook(Book b) throws SQLException{
//        Connection connect = jdbcUtils.getConnection();
//        String query = "insert into book(idBook, BookName, AuthorName, Descriptions, Release, PlaceRelease)"
//                + " values (?,?, ?, ?, ?, ?)";
//        
//        connect.setAutoCommit(false);
//        
//        PreparedStatement stm = connect.prepareCall(query);
//        stm.setString(1, b.getIdB());
//        stm.setString(2, b.getNameB());
//        stm.setString(3, b.getAuthorName());
//        stm.setString(4, b.getDescriptions());
//        stm.setString(5, b.getRelease());
//        stm.setString(6, b.getReleasePlace());
//        
//        stm.executeUpdate();
//        
//        connect.commit();
//    }
}
