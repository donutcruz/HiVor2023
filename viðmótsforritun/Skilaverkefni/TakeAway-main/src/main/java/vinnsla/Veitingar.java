package vinnsla;
/**
 * @Author Donna Cruz
 * @Email: Deb5@hi.is
 */
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Vörur í Menu - nafn og verð
 * Gefur 0kkur getter og setter fyrir nöfn og verð
 */
public class Veitingar {
    private final StringProperty matur = new SimpleStringProperty();
    private final IntegerProperty verd = new SimpleIntegerProperty();

    /**
     * Býr til nýja vöru
     *
     */
    public Veitingar(){
        matur.set("Havaían");
        verd.set(2390);
    }

    /**
     * Skilar strengjatákni af matarhlut, í sniðinu "nafn : verðkr".
     *
     * @return strengjatákn af matarhlut
     */

    public String toString(){
        return matur.get() + " : " + verd.get() + "kr";
    }

    /**
     * Setter fyrir nafn á vöru
     *
     * @param matur nafn á vöru
     */
    public void setMatur(StringProperty matur){
        this.matur.bind(matur);
    }

    /**
     * Setter fyrir verð á vöru
     *
     * @param verd verð á vöru
     */
    public void setVerd(IntegerProperty verd) {
        this.verd.bind(verd);
    }

    /**
     * Returns fyrir nafn á vöru
     *
     * @return fyrir nafn á vöru
     */
    public String getMatur() {
        return matur.get();
    }

    /**
     * Returns fyrir verð á vöru
     *
     * @return fyrir verð á vöru
     */
    public int getVerd() {
        return verd.get();
    }

}
