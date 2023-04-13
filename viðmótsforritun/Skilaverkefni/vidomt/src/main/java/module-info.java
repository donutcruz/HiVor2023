module hi.verkefni {
    requires javafx.controls;
    requires javafx.fxml;

    opens hi.verkefni to javafx.fxml;
    exports hi.verkefni;
}
