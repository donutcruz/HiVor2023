package vidmot;

/**
 * @Author Donna Cruz
 * @Email: Deb5@hi.is
 */
import javafx.fxml.FXML;
import javafx.scene.control.*;
import vinnsla.*;

/**
 * PontunController er controller fyrir pöntunar skjá - Fær User input, sýnir menu og körfu. Uppfærir samtals verð
 */
public class PontunController {
    @FXML
    private ListView matsedill;
    @FXML
    private ListView fxKarfa;
    @FXML
    private Button borgaButton;
    @FXML
    private Button innskraningButton;
    @FXML
    private Button nyrNotandiButton;
    @FXML
    private Label verdIKorfuLabel;
    private Karfa karfa;

    /**
     *
     * Initialize-ar PontunarController með matseðill og körfu, sett upp með event listener og
     * binding fyrir samtals verð í körfuna.
     */
    @FXML
    public void initialize() {
        Matsedill matsedillModel = new Matsedill();

        matsedill.setItems(matsedillModel.getVeitingar());

        matsedill.setCellFactory(param -> new VeitingarCell());

        this.karfa = new Karfa();

        matsedill.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                verdIKorfuLabel.setText("Bæta í körfu? " + ((Veitingar) newValue).getVerd() + " kr.");
            }
        });

        borgaButton.textProperty().bind(karfa.getTotalPriceProperty().asString("Borga (%d kr)"));

        fxKarfa.setItems(karfa.getVeitingar());

        fxKarfa.setCellFactory(param -> new VeitingarCell());

        fxKarfa.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                verdIKorfuLabel.setText("Taka úr körfu? " + ((Veitingar) newValue).getVerd() + " kr.");
            }
        });
    }

    /**
     * Handler fyrir "setja í körfu" hnapp, event sér um að bæta í körfu frá veitingum
     */
    @FXML
    private void fxSetjaKorfuHandler(){
        Veitingar selected = (Veitingar) matsedill.getSelectionModel().getSelectedItem();
        if (selected != null) {
            fxKarfa.getItems().add(selected);
        }
    }

    /**
     * Sér um  "Taka úr körfu" hnappan, tekur vörur úr körfuna
     */
    @FXML
    private void fxTakaUrKorfuHandler() {
        Veitingar selected = (Veitingar) fxKarfa.getSelectionModel().getSelectedItem();
        if (selected != null) {
            fxKarfa.getItems().remove(selected);
        }
    }

    /**
     * Sér um  "Innskráning" hnapp sýnir Innskráning Dialog
     */
    @FXML
    private void fxInnskraningHandler(){
        LoginDialog dialog = new LoginDialog();
        dialog.showAndWait();
    }

    /**
     * Sér um  "Nýr notandi" hnappan, skiptir yfir í Viðskiptavinur view
     */
    @FXML
    private void fxNyrNotandihandler() {
        ViewSwitcher.switchTo(View.VIDSKIPTAVINUR);
    }

    /**
     * Sér um "Borga" hnappan. Skiptir yfir í greiðslu view
     */
    @FXML
    private void fxBorgaHandler() {
        ViewSwitcher.switchTo(View.GREIDSLA);
    }

    /**
     *
     * Returns samtals verð á körfu
     * @return samtals verð á körfu sem integer
     */
    public int getKarfaVerd() {
        return karfa.getHeildarVerd();
    }

    /**
     * Returns körfu
     * @return körfu
     */
    public Karfa getKarfa() {
        return karfa;
    }

    /**
     * Sér um "Borga,"innskráning" og "nýr notandi" hnappana þegar User loggar sig inn
     */
    public void buttonPusher(){
        borgaButton.setDisable(false);
        innskraningButton.setDisable(true);
        nyrNotandiButton.setDisable(true);
    }

    /**
     *
     * Sérsniðið  ListCell notað til að sýna menu og körfu
     * @param <Veitingar> vörur sem eru í boði
     */
    private class VeitingarCell extends ListCell<Veitingar> {
        @Override
        protected void updateItem(Veitingar item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setText(null);
            } else {
                setText(item.getMatur() + " - " + item.getVerd() + " kr");
            }
        }
    }


}