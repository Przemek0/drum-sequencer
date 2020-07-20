module pl.sdacademy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens pl.sdacademy to javafx.fxml;
    exports pl.sdacademy;
}