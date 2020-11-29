/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author hp
 */
public class MemberCardServices {
     
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
}
