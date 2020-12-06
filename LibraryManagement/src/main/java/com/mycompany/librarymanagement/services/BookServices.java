/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.services;


import com.mycompany.librarymanagement.pojo.Book;
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

    /**
     *
     * @return list of book
     * @throws SQLException
     */
    public static List<Book> getBook() throws SQLException{
         Connection connect =  jdbcUtils.getConnection();
         Statement stm = connect.createStatement();
         ResultSet rs = stm.executeQuery("Select * from book");
         
         List<Book> list = new ArrayList<>();
         while(rs.next()){
             Book b = new Book(rs.getString("idBook"), rs.getString("BookName"),
                    rs.getString("AuthorName"), rs.getString("Description"),
                    rs.getString("Release"), rs.getString("PlaceRelease"),
                    rs.getString("State"), rs.getString("Category"));
           
             list.add(b);
         }
         return list;
    }
    
        public static List<Book> getBook2(String keyWord) throws SQLException{
            String sql =("Select * from book");         
            if(!keyWord.isEmpty())
               sql += "Where idBook like ?";
            
            Connection connect =  jdbcUtils.getConnection();
            PreparedStatement stm = connect.prepareStatement(sql);
            
            if(!keyWord.isEmpty())
                stm.setString(1, String.format("%s", keyWord));
            ResultSet rs = stm.executeQuery();
         
            List<Book> list = new ArrayList<>();
            while(rs.next()){
                Book b2 = new Book(rs.getString("idBook"), rs.getString("BookName"),
                    rs.getString("AuthorName"));
           
                list.add(b2);
            }
         return list;
    }
//     
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
    
     public static void updateStateBook(String id, String state) throws SQLException {
        String query = "Update book set State=? where idBook=?";

        Connection connect = jdbcUtils.getConnection();
        
        connect.setAutoCommit(false);
        
        PreparedStatement stm = connect.prepareStatement(query);
        stm.setString(1, state);
        stm.setString(2, id);

        stm.executeUpdate();
        
        connect.commit();
    }
}
