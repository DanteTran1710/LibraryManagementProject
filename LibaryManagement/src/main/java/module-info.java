module com.mycompany.libarymanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.libarymanagement to javafx.fxml;
    exports com.mycompany.libarymanagement;
}
