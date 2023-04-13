package vidmot;
/**
 * @Author Donna Cruz
 * @Email: Deb5@hi.is
 */
import javafx.fxml.FXMLLoader;
import vinnsla.*;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.io.IOException;

/**
 * MatsedillView class er sérsniðið JavaFX ListView sem sýnir hvaða vörur eru í boði á matseðlinum.
 */
public class MatsedillView extends ListView {
    @FXML
    private ListView<Veitingar> veitingarList;

    @FXML
    private final Matsedill matsedill;

    /**
     * Initializes  MatsedillView með því að loada  FXML file and set-  rót og  controller,
     *
     */
    public MatsedillView() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/matsedill-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exeption) {
            throw new RuntimeException(exeption);
        }

        matsedill = new Matsedill();
        matsedill.setjaGogn();
        veitingarList.setItems(matsedill.getVeitingar());
    }
}
