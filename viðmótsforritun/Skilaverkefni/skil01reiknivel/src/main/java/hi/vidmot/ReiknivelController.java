package hi.vidmot;


import hi.vinnsla.Reiknivel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;

/**
 * ReiknivelController sér um Javafx view og samskipti Reiknivel model. Veitir aðferð í handler notenda eins og
 * inntakTalaActionPerformed, hreinsaHandler, equalsHandler,
 * * virkiHandler, plusMinusHandler, percentageHandler, dotHandler
 *
 * @author Donna Cruz | Donn Eunice deb5@hi.is
 */

public class ReiknivelController {
    /**
     * JavaFX TextField sýnir niðurstöður útreikningana
     */

    @FXML
    private TextField fxUttak;
    /**
     * Reiknivel model gerir útreikningana.
     */
    private Reiknivel reiknivel;

    public ReiknivelController() {
    }

    /**
     * Aðgerð sem kviknar á þegar notandi ýtir á takka. Aðgerðinn setur gildi af takka inn
     * í Reiknivél og uppfærir skjá
     *
     * @param actionEvent event þegar notandi notar viðmótið.
     */

    @FXML
    public void inntakTalaActionPerformed(ActionEvent actionEvent) {
        int tala = Integer.parseInt(((Node) actionEvent.getSource()).getId());
        reiknivel.setTala(tala);
        fxUttak.setText(fxUttak.getText() + tala);

    }

    /**
     * Aðferðin býr til nýtt tilvik af Reiknivél model
     */

    public void initialize() {
        reiknivel = new Reiknivel();
    }

    /**
     * Aðferð þegar notandinn smellir á "Hreinsa" hnappan til að hreinsa skjá og uppfærir
     * Reiknivel model
     *
     * @param ignoredEvent sett afstað af notenda aðgerð.
     */

    @FXML
    private void hreinsaHandler(ActionEvent ignoredEvent) {
        reiknivel.hreinsa();
        fxUttak.setText("");
    }

    /**
     * Aðgerð sem þegar notandinn smellir á "=" hnappan, uppfærir skjá og sýnir niðurstöður útreikningana
     */

    @FXML
    public void equalsHandler() {
        int reval = reiknivel.jafntOg();
        fxUttak.setText(reval + "");
    }

    @FXML
    public void virkiHandler(ActionEvent actionEvent) {
        int numty = Integer.parseInt(((Node) actionEvent.getSource()).getId()) - 10;
        reiknivel.setVirki(numty);
        fxUttak.setText("");
    }


    @FXML
    public void dotHandler(ActionEvent ignoredActionEvent) {
    }

    public void plusMinusHandler(ActionEvent ignoredEvent) {
    }
}
