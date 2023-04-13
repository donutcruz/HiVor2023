package hi.verkefni.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Hero - einfaldur leikur þar sem þú setur inn nýjar pípur á borðleik - til að ná besta mögulega stigin
 * Höfundur: Donn Eunice
 * Netfang: deb5@hi.is
 */

public class PipemaniaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PipemaniaApplication.class.getResource("pipemania-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Pipemania");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}