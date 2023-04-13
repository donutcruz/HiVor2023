package vidmot;
/**
 * @Author Donna Cruz
 * @Email: Deb5@hi.is
 */
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vinnsla.Karfa;
import vinnsla.Vidskiptavinur;

/** GreidslaController flokkurinn er ábyrgur fyrir að sér um greiðslu- og
staðfestingarferli pöntunar í take-away pöntunar kerfinu.
Hann inniheldur hnappa fyrir staðfestingu á pöntuninni og greiðsluaðgerðir,
ásamt merkingu sem sýnir samheildarkostnað pöntunarinnar og væntanlegt afhendingartíma.
Þessi flokkur sækir upplýsingar um viðskiptavin og pöntun þeirra frá Vidskiptavinur
og Karfa flokkunum tilsvarandi. Hann uppfærir einnig körfuna og skiptir aftur yfir á aðalpöntunarskjáinn
eftir að greiðslan hefur verið staðfest **/


public class GreidslaController{
    @FXML
    private Button fxStadfestaButton;
    @FXML
    private Button fxGreidaButton;

    /**
     * Initilizar GreidslaController með því að ná í gögn í Viðskiptavinir og körfu, sýnir það og staðfesting
     * á greiðslu dialog
     */
    public void initialize(){
        PontunController pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        Vidskiptavinur vidskiptavinur = new Vidskiptavinur();
        fxLabel.setText(vidskiptavinur.getNafn() + " karfan þín kostar " +
                pontunController.getKarfaVerd() + " kr. Þetta verður afhent á " +
                vidskiptavinur.getHeimilisfang() + " eftir 45 mínútur");
    }
    @FXML
    private Label fxLabel;

    /**
     * Event handler fyrir "Cancel" hnapp. Fer aftur í pöntunar skjá ef hætt er við
     */
    @FXML
    private void fxHaettaVidButton() {
        ViewSwitcher.switchTo(View.PONTUN);
    }

    /**
     * Event handler fyrir "Staðfesta Greiðslu" hnapp. Gerir Enable hnappinn virkan.
     */
    @FXML
    public void fxStadfestaButton() {
        // enable the fxGreidaButton after fxStadfestaButton is clicked
        fxGreidaButton.setDisable(false);
        fxStadfestaButton.setDisable(true);
    }

    /**
     * Event handler fyrir "Greida" hnappan. Uppfærir körfuna og hreinsar, fer svo aftur á pöntunarskjá
     */
    @FXML
    public void fxGreidaButton() {
        fxGreidaButton.setDisable(true);
        fxStadfestaButton.setDisable(false);
        Karfa karfa = new Karfa();
        karfa.setjaGogn();
        karfa.taemaKorfu();
        PontunController pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        pontunController.getKarfa().taemaKorfu(); // empty the cart
        ViewSwitcher.switchTo(View.PONTUN);
    }
}
