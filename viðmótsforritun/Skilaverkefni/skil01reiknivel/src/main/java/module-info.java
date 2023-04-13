module hi.verkefni {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.github.spotbugs.annotations;

    opens hi.vidmot to javafx.fxml;
    exports hi.vidmot;
}
