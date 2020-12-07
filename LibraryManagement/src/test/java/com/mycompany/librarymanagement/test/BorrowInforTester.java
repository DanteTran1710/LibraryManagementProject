/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.test;

import com.mycompany.librarymanagement.pojo.BorrowInfor;
import com.mycompany.librarymanagement.services.BorrowInforServices;
import com.mycompany.librarymanagement.services.jdbcUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author hp
 */
public class BorrowInforTester {

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
    public void addBI() {

        BorrowInfor bi = new BorrowInfor("569871", "Truc Lam", "0321456987",
                "SV", 2, "11/11/2020", "18/11/2020", "123", "1");

        try {
            boolean kq = BorrowInforServices.addBorrowInfor(bi);
            Assert.assertTrue(kq);

            System.out.println("Add adding borrow form successfully!");
        } catch (SQLException ex) {

            System.err.println("Add adding borrow form unsuccessfully!");
            Logger.getLogger(BorrowInforTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testidBookInBIListNotNull() {
        try {
            List<BorrowInfor> listBI = BorrowInforServices.getBorrowInfor();

            for (BorrowInfor bi : listBI) {
                Assert.assertNotNull(bi.getIdB());
                Assert.assertNotEquals("", bi.getIdB().trim());

                System.out.println("Check id-book in list is not null");
            }
        } catch (SQLException ex) {
            System.err.println("Check id-Book in list is null");

            Logger.getLogger(BorrowInforTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testidMCInBIListNotNull() {

        try {
            List<BorrowInfor> listBI = BorrowInforServices.getBorrowInfor();

            for (BorrowInfor bi : listBI) {
                Assert.assertNotNull(bi.getIdMC());
                Assert.assertNotEquals("", bi.getIdMC().trim());
                System.out.println("Check id member card in list is not null");
            }
        } catch (SQLException ex) {
            System.err.println("Check id member card in list is null");
            Logger.getLogger(BorrowInforTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testGetidBFromList(){
        try {
            String kq = BorrowInforServices.getIdBsFromBI("1");
            
            Assert.assertEquals("123", kq);
            System.out.println("Get id successfully!");
        } catch (SQLException ex) {
            System.err.println("Get id unsuccessfully!");
            Logger.getLogger(BorrowInforTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testGetListBorrowInfor() {
        try {
            List<BorrowInfor> list = BorrowInforServices.getBorrowInfor();

            Assert.assertEquals(2, list.size());
            System.out.println("Test get list borrow-infors successfully!");
        } catch (SQLException ex) {
            System.err.println("Test get list borrow-infors unsuccessfully!");
            Logger.getLogger(BorrowInforTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
