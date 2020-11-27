/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement.services;

import com.mycompany.libarymanagement.pojo.BorrowInfor;
import com.mycompany.libarymanagement.pojo.User;
import com.mycompany.libarymanagement.pojo.jdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;


/**
 *
 * @author hp
 */

public class MemberCardServices {
        public static void addUser(User infor) throws SQLException {
        Connection connect = jdbcUtils.getConnection();
        String query = "insert into membercard(Mã Đọc Giả, Tên Đọc Giả, Gmail,"
                + " Địa Chỉ, Giới Tính, Số Điện Thoại, Bộ Phận, Đối Tượng) values (?, ?, ?, ?, ?, ?, ?,?)";

        connect.setAutoCommit(false);

        PreparedStatement stm = connect.prepareStatement(query);
        stm.setString(1, infor.getMaDocGia());
        stm.setString(2, infor.getTenDocGia());
        stm.setString(3, infor.getGmail());
        stm.setString(4, infor.getDiaChi());
        stm.setString(5, infor.getGioiTinh());
        stm.setString(6, infor.getSDT());
        stm.setString(7, infor.getBoPhan());
        stm.setString(8, infor.getDoiTuong());

        stm.executeUpdate();

        connect.commit();
    }

    
}
