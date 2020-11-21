/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement.services;

import com.mycompany.libarymanagement.pojo.Book;
import com.mycompany.libarymanagement.pojo.jdbcUtils;
import java.sql.Connection;
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
     public static List<Book> getBook() throws SQLException{
        Connection connect =  jdbcUtils.getConnection();
        Statement stm = connect.createStatement();
        ResultSet rs= stm.executeQuery("Select * from book");
        
        List<Book> listBook = new ArrayList<>();
        while(rs.next()){
           Book b = new Book(rs.getInt("idBook"),rs.getString("BookName"),
                   rs.getString("AuthorName"), rs.getString("Descriptions"),
                   rs.getDate("Release"), rs.getString("PlaceRelease"));
           
           listBook.add(b);
        }
        return listBook;
    }
}
