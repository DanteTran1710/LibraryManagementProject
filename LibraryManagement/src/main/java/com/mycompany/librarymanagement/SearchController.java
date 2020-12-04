/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement;

import static com.mycompany.librarymanagement.TradeInforsController.loadBook;
import com.mycompany.librarymanagement.pojo.Book;
import com.mycompany.librarymanagement.services.BookServices;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author thinh
 */
    public class SearchController implements Initializable{ 
        @FXML private TableView<Book> viewSearch;

    public void loadView(ActionEvent event){
        try {
            loadBook(viewSearch);
        } catch (SQLException ex) {
        }
    }
    public static void inForBook(TableView<Book> infB) throws SQLException{
         TableColumn idBook = new TableColumn("Book Code");
         idBook.setCellValueFactory(new PropertyValueFactory("idB"));
         TableColumn nameBook = new TableColumn("Name");
         nameBook.setCellValueFactory(new PropertyValueFactory("nameB"));
         TableColumn authorName = new TableColumn("Author");
         authorName.setCellValueFactory(new PropertyValueFactory("authorName"));
         
         infB.getColumns().addAll(idBook, nameBook,authorName);
         
        infB.setItems(FXCollections.observableArrayList(BookServices.getBook()));
     }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
