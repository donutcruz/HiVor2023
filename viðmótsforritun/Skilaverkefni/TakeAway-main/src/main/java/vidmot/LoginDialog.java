package vidmot;
/**
 *  @Author Donna Cruz
 *  @Email: Deb5@hi.is
 */
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import vinnsla.Vidskiptavinur;

/** Flokkurinn LoginDialog er ábyrgur fyrir að birta glugga sem leyfir notandanum að slá inn lykilorð sitt
 * til að skrá sig inn í take-away pöntunar kerfið.
 * Hann víðarar TextInputDialog flokknum í JavaFX safninu. Þessi flokkur býr til sérsniðinn dialogglugga
 * með textareit fyrir notendanafn og lykilorðareit fyrir lykilorðið. Hann stillir einnig
 * atburðaritaraðgerð fyrir "Skrá inn" hnappinn sem býr til nýtt Vidskiptavinur hlut og skiptir yfir á
 * aðalpöntunarskjáinn ef rétt lykilorð er slegið inn.**/

public class LoginDialog extends TextInputDialog {

    private TextField nameLabel;

    /**
     * Frumstillir LoginDialog með því að setja titil og haus texta, búa til textareit og
     * lykilorðareit og stilla atburðaritaraðgerðina fyrir "Skrá inn" hnappinn.
     */
    public LoginDialog() {
        super();
        init();
    }

    private void init() {
        this.setTitle("Login Dialog");
        this.setHeaderText("Sláðu inn lykilorð.");

        // Create text field for name
        nameLabel = new TextField("Donna Flippin Cruz");

        // Create password field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("ostur");

        // Set custom content for dialog
        GridPane grid = new GridPane();
        grid.add(nameLabel, 0, 0);
        grid.add(passwordField, 0, 1);
        this.getDialogPane().setContent(grid);

        // Remove the default "OK" button
        this.getDialogPane().getButtonTypes().clear();

        // Add custom "Sign In" button and set event handler
        ButtonType okButtonType = new ButtonType("Skrá inn", ButtonBar.ButtonData.OK_DONE);
        this.getDialogPane().getButtonTypes().add(okButtonType);

        // Add custom "Sign In" button and set event handler
        this.setResultConverter(dialogButton -> {
            if (dialogButton == okButtonType) {
                new Vidskiptavinur(String.valueOf(nameLabel.getText()), "Helvíti 666");
                PontunController pontunController = (PontunController) ViewSwitcher.lookup(View.PONTUN);
                pontunController.buttonPusher();

            }
            return null;
        });
    }
}

