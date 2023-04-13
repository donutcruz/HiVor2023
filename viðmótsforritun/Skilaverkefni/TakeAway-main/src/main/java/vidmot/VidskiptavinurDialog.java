package vidmot;
/**
 /
 * @Author Donna Cruz
 * @Email: Deb5@hi.is
 */

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import vinnsla.Vidskiptavinur;

/**Klasinn VidskiptavinurDialog er ábyrgur fyrir að birta glugga sem leyfir
 * notandanum að slá inn upplýsingar fyrir nýjan viðskiptavin.
 * Hann extendar Dialog flokknum í JavaFX safninu.
 * Þessi flokkur inniheldur notendanafns- og heimilisfangareit, og tvo hnappa til að senda
 * eða hætta við dialogglugganum. Hann inniheldur einnig atburðaritaraðgerðir fyrir hnappana
 * sem búa til nýjan Vidskiptavinur hlut á grundvelli sleginna upplýsinga og skipta yfir á aðalpöntunarskjáinn**/
public class VidskiptavinurDialog extends Dialog<Vidskiptavinur> {
    @FXML
    private TextField fxUsername;
    @FXML
    private TextField fxHeimilisfang;
    @FXML
    private Button fxSkraInnTakki;

    /**
     * Frumstillir VidskiptavinurDialog með því að tengja óvirkni "Skrá inn" hnappins við textaeiginleika
     * notendanafns- og heimilisfangareits. Þetta tryggir að hnappurinn geti ekki verið smelltur án þess að báðir
     * reitir hafi verið fylltir út.
     */
    public void initialize() {
        fxSkraInnTakki.disableProperty().bind(Bindings.isEmpty(fxUsername.textProperty()).or(Bindings.isEmpty(fxHeimilisfang.textProperty())));
    }

    /**
     * Atburðar aðgerð fyrir "Skrá inn" hnappinn. Býr til nýjan Vidskiptavinur hlut á grundvelli sleginna upplýsinga
     * og skiptir yfir á aðalpöntunarskjáinn.
     */
    @FXML
    private void fxSkraInnTakki() {
        PontunController pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
        pontunController.buttonPusher();
        Vidskiptavinur vidskiptavinur = new Vidskiptavinur();
        vidskiptavinur.setNafn(fxUsername.getText());
        vidskiptavinur.setHeimilisfang(fxHeimilisfang.getText());
        ViewSwitcher.switchTo(View.PONTUN);
    }

    /**
     * Atburðaritaraðgerð fyrir "Hætta við" hnappinn. Lokaðu dialogglugganum án þess að búa til nýjan viðskiptavin
     * hlut eða skipta um útsýni.
     */
    @FXML
    private void fxHaettaVidTakki() {
        ViewSwitcher.switchTo(View.PONTUN);
    }

}
