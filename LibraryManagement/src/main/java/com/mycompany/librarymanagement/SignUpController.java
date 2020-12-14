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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    @FXML
    private TextField txtMaDocGia;
    @FXML
    private TextField txtTenDocGia;
    @FXML
    private TextField txtGmail;
    @FXML
    private DatePicker dtpNgaySinh;
    @FXML
    private TextField txtSDT;
    @FXML
    private ComboBox cmbGioiTinh;
    @FXML
    private ComboBox cmbBoPhan;
    @FXML
    private ComboBox cmbDoiTuong;

    public void swtichToIndex(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Do you want to return to main?");
        alert.showAndWait();
        App.setRoot("Index");
    }

// han the
// ngay sinh
    public void SignUp(ActionEvent evt) throws IOException, ParseException, Exception {
        if (!this.txtMaDocGia.getText().equals("") && !this.txtSDT.getText().equals("")
                && !this.txtTenDocGia.getText().equals("") && !this.cmbBoPhan.getSelectionModel().getSelectedItem().toString().equals("Khoa")
                && !this.dtpNgaySinh.getEditor().getText().equals("") && !this.cmbDoiTuong.getSelectionModel().getSelectedItem().toString().equals("Đối Tượng")
                && !this.cmbGioiTinh.getSelectionModel().getSelectedItem().toString().equals("Giới Tính")
                && !this.txtGmail.getText().equals("") && verifyNumText() && verifyGmail(txtGmail)
                && verifyCharacter(txtTenDocGia) && verifyID(txtMaDocGia)) {
            if (!MemberCardServices.checkExistUserName(this.txtMaDocGia.getText())) {

                String id = MethodNeeded.createUUID();
                MemberCard mc = new MemberCard(this.txtMaDocGia.getText(), id,
                        this.txtTenDocGia.getText(), dtpNgaySinh.getEditor().getText(),
                        this.cmbDoiTuong.getSelectionModel().getSelectedItem().toString(),
                        "Enable", this.txtGmail.getText(),
                        this.cmbGioiTinh.getSelectionModel().getSelectedItem().toString(),
                        this.txtSDT.getText(), this.cmbBoPhan.getSelectionModel().getSelectedItem().toString());

                try {
                    MemberCardServices.addMC(mc);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Sign up succesfully! Your account password is : " + id);
                    alert.showAndWait();
                    App.setRoot("Login");
                } catch (SQLException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Sign up unsuccesfully! Please try again later");
                    alert.showAndWait();
                }
            }
            else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Your account are already exist! Please try again");
                    alert.showAndWait();
                    this.txtMaDocGia.clear();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please complete your form before submit!");
            alert.getButtonTypes().setAll(new ButtonType("OK", ButtonBar.ButtonData.YES));
            if (alert.showAndWait().get() == ButtonType.YES) {
                alert.close();
            }
        }
    }

    public boolean verifyNumText() {
        Pattern p = Pattern.compile("(0)?[0-9]{9}");
        Matcher m = p.matcher(this.txtSDT.getText());

        if (m.find() && m.group().equals(this.txtSDT.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter valid number!");
            alert.showAndWait();
            this.txtSDT.clear();
            return false;
        }
    }

    public boolean verifyCharacter(TextField txt) {
        Pattern p = Pattern.compile("[a-zA-Z\\s]+");
        Matcher m = p.matcher(txt.getText());

        if (m.find() && m.group().equals(txt.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Name must be uppercase!");
            alert.showAndWait();
            txt.clear();
            return false;
        }
    }

    public boolean verifyID(TextField txt) {
        Pattern p = Pattern.compile("[a-z-|_|.]+");
        Matcher m = p.matcher(txt.getText());

        if (m.find() && m.group().equals(txt.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please enter valid character!");
            alert.showAndWait();
            txt.clear();
            return false;
        }
    }

    public boolean verifyGmail(TextField txt) {
        Pattern p = Pattern.compile("[a-zA-Z0-9]+@ou.edu.vn");
        Matcher m = p.matcher(txt.getText());

        if (m.find() && m.group().equals(txt.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Gmail must be @ou.edu.vn");
            alert.showAndWait();
            txt.clear();
            return false;
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MethodNeeded.editFormmatDate(dtpNgaySinh);

        ObservableList<String> gioiTinh
                = FXCollections.observableArrayList("Nam", "Nữ");
        cmbGioiTinh.setItems(gioiTinh);

        ObservableList<String> boPhan
                = FXCollections.observableArrayList("Công Nghệ Thông Tin", "Đào Tạo Đặc Biệt", "Quản Trị Kinh Doanh", "Kế Toán Kiểm Toán");
        cmbBoPhan.setItems(boPhan);

        ObservableList<String> doiTuong
                = FXCollections.observableArrayList("Sinh Viên", "Giảng Viên");
        cmbDoiTuong.setItems(doiTuong);
    }
}
