/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.test;

import com.mycompany.librarymanagement.pojo.MemberCard;
import com.mycompany.librarymanagement.services.MemberCardServices;
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
 * @author thinh
 */
public class MemberCardTester {
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
            Logger.getLogger(MemberCardTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Test
    public void testLogin() throws Exception {       
        try{
            boolean user = MemberCardServices.checkLogin("nhinhi", "21bb2");            
            Assert.assertTrue(user);
            
            System.out.println("Check login successfully!");

        } catch (SQLException ex) {
            System.err.println("Check login unsuccessfully!");
            Logger.getLogger(MemberCardTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @Test
    public void testAddMC() {
          MemberCard mc = new MemberCard("thanh.h", "050400", "THINH","05/04/2000",
                "SV", "", "thinh@ou.edu.vn", "Nam", "0365708408", "Công Ngh? Thông Tin");

        try {
            boolean kq = MemberCardServices.addMC(mc);
            Assert.assertTrue(kq);

            System.out.println("Add Member successfully!");
        } catch (SQLException ex) {

            System.err.println("Add member unsuccessfully!");
            Logger.getLogger(MemberCardTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testidMCInMCListNotNull() {

        try {
            List<MemberCard> listMC = MemberCardServices.getMC();

            for (MemberCard mc : listMC) {
                Assert.assertNotNull(mc.getUserName());
                Assert.assertNotEquals("", mc.getUserName().trim());
            }
            System.out.println("Check id member card in list is not null");
        } catch (SQLException ex) {
            System.err.println("Check id member card in list is null");
            Logger.getLogger(MemberCardTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testGetListBorrowInfor() {
        try {
            List<MemberCard> listMC = MemberCardServices.getMC();

            Assert.assertTrue(listMC.size() > 0);
            System.out.println("Test get list Member Card successfully!");
        } catch (SQLException ex) {
            System.err.println("Test get list Member Card unsuccessfully!");
            Logger.getLogger(MemberCardTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
