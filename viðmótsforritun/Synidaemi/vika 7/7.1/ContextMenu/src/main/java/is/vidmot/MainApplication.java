package is.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("dagur-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        //  Láta vita hver controller er
        scene.setUserData(fxmlLoader.getController());

        stage.setTitle("Sýnidæmi ContextMenu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
