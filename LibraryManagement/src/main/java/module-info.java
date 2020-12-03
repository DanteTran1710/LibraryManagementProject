module com.mycompany.librarymanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.base;
    requires javafx.graphics;
    requires java.sql;
    
    opens com.mycompany.librarymanagement to javafx.fxml;
    exports com.mycompany.librarymanagement;
    exports com.mycompany.librarymanagement.pojo;
}
