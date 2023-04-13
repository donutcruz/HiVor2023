package vinnsla;
/**
 * @Author Donna Cruz
 * @Email: Deb5@hi.is
 */
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Matsedill klassinn sýnir vörurnar sem eru í boði
 **/
public class Matsedill {

    /**
     * Vörur í boði
     */
    protected ObservableList<Veitingar> veitingar = FXCollections.observableArrayList();

    /**
     * Býr til new Matsedill object og kallar á setjaGögn aðferð
     */
    public Matsedill() {
        setjaGogn();
    }

    /**
     * Setur upp lista af því sem er hægt að kaupa
     */
    public void setjaGogn() {
        String[] rettir = {"Havaían", "Virðing frá móður þinni", "Pyyylsa", "Flott hár for life", "Lasagna", "Djúpsteiktar Rækjur", "Skilning á JavaFX", "klakar", "Vöfflu Franskar", "Kjúklingaborgari", "sleikjó", "lífsvilji"};
        int[] verd = {2490, 8990, 590, 14990, 2200, 990, 22990, 110, 1390, 3490, 50, 50000000};

        for (int i = 0; i < rettir.length; i++) {
            Veitingar veiting = new Veitingar();
            veiting.setMatur(new SimpleStringProperty(rettir[i]));
            veiting.setVerd(new SimpleIntegerProperty(verd[i]));
            veitingar.add(veiting);
        }
    }

    /**
     * Returns lista af vörum sem hægt er að velja úr
     *
     * @return lista af vörum sem hægt er að velja úr
     */
    public ObservableList<Veitingar> getVeitingar() {
        return veitingar;
    }
}