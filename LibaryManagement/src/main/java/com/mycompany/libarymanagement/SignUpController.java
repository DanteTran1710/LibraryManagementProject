package com.mycompany.libarymanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author thinh
 */



public class SignUpController implements Initializable {
    
    @FXML private TextField txtMaDocGia;
    @FXML private TextField txtTenDocGia;
    @FXML private TextField txtGmail;
    @FXML private TextField txtDiaChi;
    @FXML private TextField txtSDT;
    @FXML private ComboBox cmbGioiTinh;
    @FXML private ComboBox cmbBoPhan;
    @FXML private ComboBox cmbDoiTuong;
    char keyboard;
    
// han the
// ngay sinh

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ObservableList<String> gioiTinh = 
                FXCollections.observableArrayList("Nam","Nữ");
        cmbGioiTinh.setItems(gioiTinh);
        
        ObservableList<String> boPhan = 
                FXCollections.observableArrayList("Công Nghệ Thông Tin","Đào Tạo Đặc Biệt","Quản Trị Kinh Doanh","Kế Toán Kiểm Toán");
        cmbBoPhan.setItems(boPhan);
        
        ObservableList<String> doiTuong = 
                FXCollections.observableArrayList("Sinh Viên", "Giảng Viên");
        cmbDoiTuong.setItems(doiTuong);
        
        if(txtSDT.getText().isEmpty() && txtSDT.Character.isLetter() );
    }    
    
}
