/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.test;

import com.mycompany.librarymanagement.pojo.Book;
import com.mycompany.librarymanagement.services.BookServices;
import com.mycompany.librarymanagement.services.jdbcUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author hp
 */
public class BookTester {
    
    private static Connection connect;
    
    @BeforeEach
    public static void setUp() {
        connect = jdbcUtils.getConnection();
    }
    
    @AfterEach
    public static void tearDown() {
        try {
            jdbcUtils.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(BorrowInforTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testGetListBook(){
        try {
            List<Book> list = BookServices.getBook();
            
            Assert.assertEquals(2, list.size());
            System.err.println("Test get list book successfully!");
            
        } catch (SQLException ex) {
            System.err.println("Test get list book unsuccessfully!");
            Logger.getLogger(BookTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testCheckBookByName() {
        try {
            String name = BookServices.checkBookByName("Mắt Biếc");
            Assert.assertNotEquals("", name);
            Assert.assertNotNull(name);
            
            System.err.println("Check book by name successfully!");
        } catch (SQLException ex) {
            System.err.println("Check book by name unsuccessfully!");
            Logger.getLogger(BookTester.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    @Test    
    public void testChangeState() {
        String state = null;
        try {
            BookServices.updateStateBook("123", "Borrowed");
            List<Book> list = BookServices.getBook();
            for (Book b : list) {
                if (b.getIdB().equals("123")) {
                    state = b.getState();
                }
            }
            
            Assert.assertEquals("Borrowed", state);
            System.err.println("Change state by id book successfully!");
        } catch (SQLException ex) {
            System.err.println("Change state by id book unsuccessfully!");
            Logger.getLogger(BookTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
