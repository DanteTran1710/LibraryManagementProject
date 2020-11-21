/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement;

import com.test.pojo.testhv;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author thinh
 */
public class Utils {
    public static List<testhv> gettesthv() throws SQLException{
        Connection conn = JDBCUtils.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM test");
        List<testhv> results = new ArrayList<>();
        while(rs.next()){
            testhv hv = new testhv(rs.getInt("idhv"), rs.getString("ten"), rs.getString("sdt"));
            results.add(hv);
        }
        return results;
    }
}
