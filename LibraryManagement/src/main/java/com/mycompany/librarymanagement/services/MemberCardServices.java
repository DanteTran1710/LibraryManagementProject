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

    public static boolean addMC(MemberCard mc) throws SQLException {
        Connection connect = jdbcUtils.getConnection();
        String query = "insert into membercard(idMemberCard, MemberName, DOB, Object,"
                + "StateCard, UserName, Gmail, Sex, PhoneNumber, Major) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        connect.setAutoCommit(false);

        PreparedStatement stm = connect.prepareCall(query);
        stm.setString(1, mc.getIdMC());
        stm.setString(2, mc.getMemberName());
        stm.setString(3, mc.getDOB());
        stm.setString(4, mc.getObject());
        stm.setString(5, mc.getStateCard());
        stm.setString(6, mc.getUserName());
        stm.setString(7, mc.getGmail());
        stm.setString(8, mc.getSex());
        stm.setString(9, mc.getPhoneNum());
        stm.setString(10, mc.getMajor());

        stm.executeUpdate();

        connect.commit();

        return true;
    }

    public static List<MemberCard> getMC() throws SQLException {
        Connection connect = jdbcUtils.getConnection();
        Statement stm = connect.createStatement();
        ResultSet rs = stm.executeQuery("Select * from membercard");

        List<MemberCard> list = new ArrayList<>();
        while (rs.next()) {
            MemberCard mc = new MemberCard(rs.getString("idMemberCard"),
                    rs.getString("MemberName"), rs.getString("DOB"),
                    rs.getString("Object"), rs.getString("StateCard"), rs.getString("UserName"),
                    rs.getString("Gmail"), rs.getString("Sex"), rs.getString("PhoneNumber"),
                    rs.getString("Major"));
            list.add(mc);
        }
        return list;
    }

    public static boolean checkLogin(String name, String pass) throws Exception {
        String sql = "Select UserName,idMemberCard From membercard where UserName = ? and idMemberCard  = ?";

        Connection connect = jdbcUtils.getConnection();
        PreparedStatement stm = connect.prepareStatement(sql);
        stm.setString(1, name);
        stm.setString(2, pass);
        ResultSet rs = stm.executeQuery();

        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public static String checkObject(String nameUser) throws SQLException {
        String query = "Select Object from membercard where UserName=?";

        Connection connect = jdbcUtils.getConnection();
        PreparedStatement stm = connect.prepareStatement(query);
        stm.setString(1, nameUser);

        ResultSet rs = stm.executeQuery();
        String object = "";
        while (rs.next()) {
            object = rs.getString("Object");
        }
        return object;
    }
    
    public static String checkMemberCard(String id) throws SQLException {
        String query = "Select StateCard from membercard where idMemberCard=?";

        Connection connect = jdbcUtils.getConnection();
        PreparedStatement stm = connect.prepareStatement(query);
        stm.setString(1, id);

        ResultSet rs = stm.executeQuery();
        String state = "";
        while (rs.next()) {
            state = rs.getString("StateCard");
        }
        return state;
    }

    public static void updateStateMC(String id, String state) throws SQLException {
        String query = "Update membercard set StateCard=? where idMemberCard=?";

        Connection connect = jdbcUtils.getConnection();

        connect.setAutoCommit(false);

        PreparedStatement stm = connect.prepareStatement(query);
        stm.setString(1, state);
        stm.setString(2, id);

        stm.executeUpdate();

        connect.commit();
    }
}
