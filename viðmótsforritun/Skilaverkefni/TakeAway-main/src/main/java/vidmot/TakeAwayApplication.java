package vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



/**Klasinn TakeAwayApplication er ábyrgur fyrir að kveikja á forritinu og stilla upp
 * aðalglugganum fyrir take-away pöntunar kerfið.
 *  Hann extendar Application flokknum í JavaFX safninu.
 *  Þessi flokkur hleður inn aðal FXML skránni og stillir umhverfi fyrir hana.
 *  Hann stillir einnig titilinn á glugganum og frumstillir ViewSwitcher sem er notaður
 *  til að skipta um milli mismunandi útsýnismóta forritsins.
 *  Til að kveikja á forritinu, nægir að kalla á main aðferðina sem síðan kallar á launch aðferðina
 *  frá Application flokknum.**/
public class TakeAwayApplication extends Application {

    /**
     * Byrjar á JavaFX forritinu með því að stilla upp aðalglugganum og sýna hann.
     *
     * @param stage aðalglugginn fyrir JavaFX forritið
     * @throws IOException ef FXML skráin getur ekki verið hlaðin inn
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TakeAwayApplication.class.getResource("pontun-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setTitle("Donnu Búð - hér finnuru allt ");
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.PONTUN);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Aðal aðferðin sem kveikir á JavaFX forritinu.
     *
     * @param args skipanalínuaðgerðirnar
     */
    public static void main(String[] args) {
        launch();
    }
}