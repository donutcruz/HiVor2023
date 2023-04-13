package vinnsla;
/**
 * @Author Donna Cruz
 * @Email: Deb5@hi.is
 */
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *  innkaupakarfa fyrir veitingar í matseðilinni á veitingastaðnum.
 * Hann víðarar Matsedill flokknum og yfirskrifar umsvifalausan lista af Veitingar til að bæta við virkni körfunnar.
 * Klasinn inniheldur aðferðir til að uppfæra heildarkostnað körfunnar og tæma körfuna.
 * Hann inniheldur einnig aðal aðferð til að prófa virkni hans.
 */
public class Karfa extends Matsedill {
    private final IntegerProperty heildarVerd = new SimpleIntegerProperty(0);

    /**
     * Smíðar tóman innkaupakörfu.
     * Stillir umsvifalausan lista af Veitingum í nýjan, tóman lista og hlustar á breytingar til að uppfæra heildarkostnað
     * körfunnar.
     */
    public Karfa() {
        this.veitingar = FXCollections.observableArrayList(); // Create a new, empty list
        veitingar.addListener((ListChangeListener<Veitingar>) change -> updateVerd());
        updateVerd();
    }

    /**
     * Tekur allt úr körfuna og uppfærir heildarverð .
     */
    public void taemaKorfu() {
        veitingar.clear();
        updateVerd();
    }

    /**
     * Returns IntegerProperty fyrir heildarverð í körfuna
     *
     * @return IntegerProperty fyrir heildarverð í körfuna
     */
    public IntegerProperty getTotalPriceProperty() {
        return heildarVerd;
    }

    /**
     * Returns heildarverð körfuna
     *
     * @return heildarverð körfuna sem integer
     */
    public int getHeildarVerd() {
        return heildarVerd.get();
    }

    /**
     * Uppfærir heildarverð það sem er í körfuna
     */
    private void updateVerd() {
        int total = 0;
        for (Veitingar veiting : veitingar) {
            total += veiting.getVerd();
        }
        heildarVerd.set(total);
    }

    /**
     * Main aðferð
     * Býr til matseðill object og Karfa object, bætir við vörur í körfuna og prentar út heildar verð
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matsedill matsedill = new Matsedill();


        System.out.println("Matsedill:");
        for (Veitingar veiting : matsedill.veitingar) {
            System.out.println(veiting);
        }

        Karfa karfa = new Karfa();
        karfa.setjaGogn();

        System.out.println("Karfa:");
        for (Veitingar veiting : karfa.veitingar) {
            System.out.println(veiting);
        }

        System.out.println("Total price: " + karfa.getHeildarVerd());
    }


}
