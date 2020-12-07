package com.mycompany.librarymanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.librarymanagement.pojo.MemberCard;
import com.mycompany.librarymanagement.services.MemberCardServices;
import com.mycompany.librarymanagement.services.MethodNeeded;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
    @FXML private DatePicker dtpNgaySinh;
    @FXML private TextField txtSDT;
    @FXML private TextField txtHanThe;
    @FXML private ComboBox cmbGioiTinh;
    @FXML private ComboBox cmbBoPhan;
    @FXML private ComboBox cmbDoiTuong;
    
    
// han the
// ngay sinh
    public void SignUp(ActionEvent evt) throws IOException, ParseException {
        String id = MethodNeeded.createUUID();
        MemberCard mc = new MemberCard(id, this.txtTenDocGia.getText(),
                dtpNgaySinh.getEditor().getText(),
                this.cmbDoiTuong.getSelectionModel().getSelectedItem().toString(),
                "Enable", this.txtMaDocGia.getText(), this.txtGmail.getText(),
                this.cmbGioiTinh.getSelectionModel().getSelectedItem().toString(),
                this.txtSDT.getText(), this.cmbBoPhan.getSelectionModel().getSelectedItem().toString());

        try {
            MemberCardServices.addMC(mc);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Sign up succesfully! Your account password is :" + id);
            alert.getButtonTypes().setAll(new ButtonType("OK", ButtonBar.ButtonData.YES));
            if (alert.showAndWait().get() == ButtonType.YES) {
                alert.close();
            }
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Sign up unsuccesfully!Please try again later");
            alert.getButtonTypes().setAll(new ButtonType("OK", ButtonBar.ButtonData.YES));
            if (alert.showAndWait().get() == ButtonType.YES) {
                alert.close();

                Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MethodNeeded.editFormmatDate(dtpNgaySinh);
        
        ObservableList<String> gioiTinh = 
                FXCollections.observableArrayList("Nam","Nữ");
        cmbGioiTinh.setItems(gioiTinh);
        
        ObservableList<String> boPhan = 
                FXCollections.observableArrayList("Công Nghệ Thông Tin","Đào Tạo Đặc Biệt","Quản Trị Kinh Doanh","Kế Toán Kiểm Toán");
        cmbBoPhan.setItems(boPhan);
        
        ObservableList<String> doiTuong = 
                FXCollections.observableArrayList("Sinh Viên", "Giảng Viên");
        cmbDoiTuong.setItems(doiTuong);
    }    
    
}
