/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.test;

import com.mycompany.librarymanagement.pojo.ReturnInfor;
import com.mycompany.librarymanagement.services.ReturnInforServices;
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
public class ReturnInforTester {

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
    public void testAddRI(){
        ReturnInfor ri = new ReturnInfor("123456", "12a2b", "SV", "Tan Thanh", 2, 
                "20/10/2020", "22/11/2020", 1, 2, 20000);
        
        try {
            boolean kq = ReturnInforServices.addReturnInfor(ri);
            
            Assert.assertTrue(kq);
            System.out.println("Add return form successfully!");
        } catch (SQLException ex) {
            
            System.err.println("Add return form successfully!");
            Logger.getLogger(ReturnInforTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testAddDeficientInfors(){
        ReturnInfor ri = new ReturnInfor(" ", "2", " ", "Tan Thanh", 2, 
                "20/10/2020", "22/11/2020", 1, 2, 20000);
        
        try {
            boolean kq = ReturnInforServices.addReturnInfor(ri);
            
            Assert.assertFalse(kq);
            System.out.println("Add deficient infors successfully!");
        } catch (SQLException ex) {
            
            System.err.println("Add deficient infors unsuccessfully!");
            Logger.getLogger(ReturnInforTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testGetListReturnInfor(){
        try {
            List<ReturnInfor> list = ReturnInforServices.getReturnInfor();
            
            Assert.assertEquals(3, list.size());
            System.out.println("Test get list return-infor successfully!");
        } catch (SQLException ex) {
            System.err.println("Test get list return-infor unsuccessfully!");
            Logger.getLogger(ReturnInforTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
