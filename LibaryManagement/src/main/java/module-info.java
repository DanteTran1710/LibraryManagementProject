module com.mycompany.libarymanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.base;
    requires javafx.graphics;

    opens com.mycompany.libarymanagement to javafx.fxml;
    exports com.mycompany.libarymanagement;
}
