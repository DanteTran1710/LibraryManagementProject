/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement.services;

import com.mycompany.libarymanagement.pojo.LibaryCard;
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
public class LibaryCardServices {
     public static List<LibaryCard> getLC() throws SQLException{
        Connection connect =  jdbcUtils.getConnection();
        Statement stm = connect.createStatement();
        ResultSet rs= stm.executeQuery("Select * from libarycard");
        
        List<LibaryCard> listLC = new ArrayList<>();
        while(rs.next()){
           LibaryCard lc = new LibaryCard(rs.getInt("idLibaryCard"), 
                   rs.getInt("idMC"), rs.getInt("idB"), 
                   rs.getDate("ReturnDate"), rs.getInt("LateDay"), 
                   rs.getInt("LateDateMoney"));
        }
        return listLC;
    }
}
