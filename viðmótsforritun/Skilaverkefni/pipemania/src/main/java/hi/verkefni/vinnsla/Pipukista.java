package hi.verkefni.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Random;



public class Pipukista {
    private final ObservableList<Pipa> kista = FXCollections.observableArrayList();

    /**
     * Smíðar nýja Pipukista hlut með i Pipa hlutum.
     * Kistinni er bætt við i nýjar pipur, sem eru búnar til með að nota nyPipa() fallið.
     * @param i tala sem segir til um stærð pípukistu
     */
    public Pipukista(int i) {
        for (int k = 0; k < i; k++) {
            kista.add(nyPipa());
        }
    }

    /**
     * Býr til nýja pípu object frá klasanum Pipa með slembna lögun af 6 möguleikum (0 - 5)
     * @return ný pípa
     */
    public Pipa nyPipa(){
        int a=0, b=0;
        Random random= new Random();
        a = random.nextInt((3) + 1);
        b = random.nextInt((3) + 1);
        while(a==b){
            b = random.nextInt((3) + 1);
        }
        Pipa.Att c = Pipa.Att.values()[a];
        Pipa.Att d = Pipa.Att.values()[b];
        return new Pipa(c, d);
    }

    /**
     * Skilar næstu pípu úr pípukistunni og bætir við nýju pípu í kistuna.
     * @return næstu pípu í pípukistunni.
     */
    public Pipa naestaPipa() {
        Pipa naesti = kista.get(0);
        Pipa nyr = nyPipa();
        kista.remove(0,1);
        kista.add(nyr);
        return naesti;
    }

    /**
     * skilar fyrir observable array list kista
     * @return kista pípukistan sem geymir pípur
     */
    public ObservableList<Pipa> getKista() {
        return kista;
    }
}
