//SearchControoler

import com.mycompany.librarymanagement.pojo.Book;
import com.mycompany.librarymanagement.services.BookServices;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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

    
    ObservableList<Book> dataList;   
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private TextField txtSearch;
    @FXML
    private TableView<Book> View;
    @FXML
                void FindCX() throws SQLException {
            dataList = BookServices.getid_Name_AuthorofBook();
            View.setItems(dataList);
            FilteredList<Book> filteredData = new FilteredList<>(dataList, b -> true);
            txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(book -> {
                                        if (newValue == null || newValue.isEmpty()){
                                            return true;
                                        }
                                        String lowerCaSeFilter = newValue.toLowerCase();

                                        if (book.getIdB().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                        } else if (book.getNameB().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                        }else if (book.getAuthorName().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                                return true;
                                        }  
                                               else
                                                    return false;
                });                                                                             
            });
            SortedList<Book> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(View.comparatorProperty());
            View.setItems(sortedData);
        }
    public void loadB() throws SQLException{
        TableColumn colSTT = new TableColumn("Book Code");
        colSTT.setCellValueFactory(new PropertyValueFactory("idB"));
        TableColumn colName = new TableColumn("Name");
        colName.setCellValueFactory(new PropertyValueFactory("nameB"));
        TableColumn colAuthorName = new TableColumn("Author");
        colAuthorName.setCellValueFactory(new PropertyValueFactory("authorName"));          
        View.getColumns().addAll(colSTT, colName,colAuthorName);  
        //View.getColumns().addAll(colSTT);
        View.setItems(FXCollections.observableArrayList(BookServices.getid_Name_AuthorofBook()));
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.loadB();
        } catch (SQLException ex) {
        }
        try {
            FindCX();
        } catch (SQLException ex) {
        }
        
    }   
    
}