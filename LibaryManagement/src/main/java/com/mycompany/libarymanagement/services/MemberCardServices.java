/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement.services;

import com.mycompany.libarymanagement.pojo.MemberCard;
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
public class MemberCardServices {
     public static List<MemberCard> getMember() throws SQLException{
        Connection connect =  jdbcUtils.getConnection();
        Statement stm = connect.createStatement();
        ResultSet rs= stm.executeQuery("Select * from membercard");
        
        List<MemberCard> listMember = new ArrayList<>();
        while(rs.next()){
          MemberCard member = new MemberCard(rs.getInt("idMemberCard"),
                  rs.getString("MemberName"), rs.getDate("DOB"),
                  rs.getString("Object"));
           
           listMember.add(member);
        }
        return listMember;
    }
}
