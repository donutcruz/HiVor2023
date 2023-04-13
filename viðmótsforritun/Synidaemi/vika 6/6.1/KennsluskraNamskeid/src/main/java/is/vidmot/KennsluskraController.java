
package is.vidmot;
import javafx.fxml.FXMLLoader;
import is.vinnsla.Kennsluskra;
import is.vinnsla.Namskeid;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 * Sýnir hvernig notaður er klasinn
 * Námskeið í ListView.
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class KennsluskraController  {

    // Vinnsluhlutinn með gögnunum
    private Kennsluskra kennsluskra;
    private int virkurIndex=0;

    // Viðmótshlutir
    @FXML
    private ListView<Namskeid> listiNamskeid;

    // Controller fyrir Námskeið
    private NamskeidController namskeidController;


    public void initialize() {
        kennsluskra = new Kennsluskra();
        listiNamskeid.setItems(kennsluskra.getOllNamskeid());

        listiNamskeid.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Indexinn í listanum.
            virkurIndex = listiNamskeid.getSelectionModel().getSelectedIndex();
        });

        try {
            namskeidController= hladaGluggi();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private NamskeidController hladaGluggi() throws IOException {
        FXMLLoader dLoader = new FXMLLoader(getClass().getResource("Namskeid.fxml"));
        dLoader.load();
        return dLoader.getController();
    }




    @FXML
    private void eydaNamskeidiHandler(ActionEvent event) {
        if (virkurIndex != -1)
            kennsluskra.eydaNamskeidi(virkurIndex);
    }

    @FXML
    private void skodaNamskeidHandler(ActionEvent event) {
        if (virkurIndex != -1)
            namskeidController.birtaGluggi(
                    kennsluskra.getNamskeid(virkurIndex));
    }
    }

