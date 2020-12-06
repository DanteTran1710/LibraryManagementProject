/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement;

import com.mycompany.librarymanagement.pojo.Book;
import com.mycompany.librarymanagement.services.BookServices;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author thinh
 */
public class SearchController implements Initializable {

    @FXML
    private TextField txtSearch;
    @FXML
    private TableView<Book> View;

    public void loadB() throws SQLException{
        TableColumn colSTT = new TableColumn("Book Code");
        colSTT.setCellValueFactory(new PropertyValueFactory("idB"));
         TableColumn colName = new TableColumn("Name");
         colName.setCellValueFactory(new PropertyValueFactory("nameB"));
         TableColumn colAuthorName = new TableColumn("Author");
         colAuthorName.setCellValueFactory(new PropertyValueFactory("authorName"));  
         
        View.getColumns().addAll(colSTT, colName,colAuthorName);
         
        View.setItems(FXCollections.observableArrayList(BookServices.getBook2("")));

    }

//    public static void loadBook(TableView<Book> tbv) throws SQLException{
//         TableColumn colSTT = new TableColumn("Book Code");
//         colSTT.setCellValueFactory(new PropertyValueFactory("idB"));
//         TableColumn colName = new TableColumn("Name");
//         colName.setCellValueFactory(new PropertyValueFactory("nameB"));
//         TableColumn colAuthorName = new TableColumn("Author");
//         colAuthorName.setCellValueFactory(new PropertyValueFactory("authorName"));  
//         
//         tbv.getColumns().addAll(colSTT, colName,colAuthorName);
//         
//        tbv.setItems(FXCollections.observableArrayList(BookServices.getBook()));
//     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadB();
        } catch (SQLException ex) {
        }
        
        this.txtSearch.textProperty().addListener((et) -> {
            this.View.getItems().clear();
            try {
                View.setItems(FXCollections.observableArrayList(BookServices.getBook2(this.txtSearch.getText())));
            } catch (SQLException ex) {
                Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
}
