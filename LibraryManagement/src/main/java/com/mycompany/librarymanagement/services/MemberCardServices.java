/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.services;

import com.mycompany.librarymanagement.pojo.MemberCard;
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
public class MemberCardServices {
    public static List<MemberCard> getMC() throws SQLException{
        Connection connect = jdbcUtils.getConnection();
        Statement stm = connect.createStatement();
        ResultSet rs = stm.executeQuery("Select * from returninfor");

        List<MemberCard> list = new ArrayList<>();
        while (rs.next()) {
            MemberCard mc = new MemberCard(rs.getString("idMemberCard"),
                    rs.getString("MemberName"), rs.getString("DOB"), 
                    rs.getString("Object"), rs.getString("StateCard"));
             list.add(mc);
         }
         return list;
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
}
