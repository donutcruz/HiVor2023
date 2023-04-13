package hi.verkefni.vidmot;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import hi.verkefni.vinnsla.Pipa;
import hi.verkefni.vinnsla.Pipukista;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


class PipeMania {
    private static final IntegerProperty stig = new SimpleIntegerProperty(0);
    private int stigCount = 0;
    private static final int F = 5;
    private final Pipa[][] pipulogn = new Pipa[F][F];
    private final Pipukista pipukista;
    private boolean first = true;
    private Pipa firstPipe;
    private boolean gameOver = false;

    private final ObjectProperty<Pipa> nuverandiPipa = new SimpleObjectProperty<Pipa>();

    public PipeMania() {
        pipukista = new Pipukista(4);
    }

    /**
     * setur parameter pípuna á 2d fylkið fyrir leikvöllinn á staðsetninguna [i,j].
     * Svo ef þetta var fyrsta pípan þá setur fallið hana í breytuna firstPipe
     * @param i staðsetning í röð á borðið
     * @param j staðsetning í dálk á borðið
     * @param pipa pípa sem á að setja á leikborðið
     */
    public void setNaestaPipa(int i, int j, Pipa pipa) {
            pipa.setIndexOne(i);
            pipa.setIndexTwo(j);
            pipulogn[i][j] = pipa;
            if (first) {
                firstPipe = pipa;
                first = false;
            }
            setNuverandiPipa(pipa);
    }

    /**
     * getter fyrir firstPipe breytu sem segir til hvaða pípa var fyrst
     * @return firstPipe
     */
    public Pipa getFirstPipe() {
        return firstPipe;
    }


    /**
     * setter fyrir breytuna gameOver sem segir til um hvort leikur sé í gangi eða ekki
     * @param gameOver True eða False
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * getter fyrir gameOver breytu
     * @return gameOver true eða false
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Athugar hvort tiltekin reitur í pipulogninni er tómur eða ekki.
     * @param i x-hnit reitsins sem á að athuga.
     * @param j y-hnit reitsins sem á að athuga.
     * @return skilar true ef reiturinn er tómur og ekki er game over, annars skilar false.
     */
    public boolean skodaPipulogn(int i, int j) {
        return (pipulogn[i][j] == null && !gameOver);
    }

    /**
     * Athugar hvort leik lokið er eða ekki og keyrir nýja flokkun frá upphafs-pípu
     * ef leikur er ekki lokið. Athugar hvort upphafs-pípan er opin og stillir stig
     * í samræmi við árangur. Skilar true ef leikur er lokið, annars false.
     * @param p upphafs-pípan
     * @return true ef leikur er lokið, annars false
     */
    public boolean flaedir(Pipa p) {
        if (p == firstPipe) {
            p.setOpin(true);
        }
        Pipa nextPipe = null;
        int indexOne = p.getIndexOne();
        int indexTwo = p.getIndexTwo();
        setNuverandiPipa(p);

        if (p.isOpin() && indexOne == 0 && p.getUt() == Pipa.Att.N) {
            PipeMania.stig.set(stigCount);
            return true;
        }
        if (p.isOpin() && indexOne == 4 && p.getUt() == Pipa.Att.S) {
            PipeMania.stig.set(stigCount);
            return true;
        }
        if (p.isOpin() && indexTwo == 0 && p.getUt() == Pipa.Att.V) {
            PipeMania.stig.set(stigCount);
            return true;
        }
        if (p.isOpin() && indexTwo == 4 && p.getUt() == Pipa.Att.A) {
            PipeMania.stig.set(stigCount);
            return true;
        }


        if (p.getIndexOne() != 0 && pipulogn[indexOne-1][indexTwo] != null && !pipulogn[indexOne-1][indexTwo].isOpin()) {
            Pipa pp = pipulogn[indexOne-1][indexTwo];
            if (p.getUt() == Pipa.Att.N && (pp.getUt() == Pipa.Att.S || pp.getInn() == Pipa.Att.S) && p.flaedir(pp)) {
                pp.setOpin(true);
                stigCount++;
                nextPipe = pp;
            }
        }

        if (p.getIndexOne() != 4 && pipulogn[indexOne+1][indexTwo] != null && !pipulogn[indexOne+1][indexTwo].isOpin()) {
            Pipa pp = pipulogn[indexOne+1][indexTwo];
            if (p.getUt() == Pipa.Att.S && (pp.getUt() == Pipa.Att.N || pp.getInn() == Pipa.Att.N) && p.flaedir(pp)) {
                pp.setOpin(true);
                stigCount++;
                nextPipe = pp;
            }
        }

        if (p.getIndexTwo() != 0 && pipulogn[indexOne][indexTwo-1] != null && !pipulogn[indexOne][indexTwo-1].isOpin()) {
            Pipa pp = pipulogn[indexOne][indexTwo-1];
            if (p.getUt() == Pipa.Att.V && (pp.getUt() == Pipa.Att.A || pp.getInn() == Pipa.Att.A) && p.flaedir(pp)) {
                pp.setOpin(true);
                stigCount++;
                nextPipe = pp;
            }
        }

        if (p.getIndexTwo() != 4 && pipulogn[indexOne][indexTwo+1] != null && !pipulogn[indexOne][indexTwo+1].isOpin()) {
            Pipa pp = pipulogn[indexOne][indexTwo+1];
            if (p.getUt() == Pipa.Att.A && (pp.getUt() == Pipa.Att.V || pp.getInn() == Pipa.Att.V) && p.flaedir(pp)) {
                pp.setOpin(true);
                stigCount++;
                nextPipe = pp;
            }
        }

        if (nextPipe != null) {
            return this.flaedir(nextPipe);
        }
        return false;
    }

    /**
     * Skilar stigafjölda eiganda stigafjölda heildarstigs sem IntegerProperty hlutur.
     *
     * @return IntegerProperty hlutur sem inniheldur heildarstigafjölda
     */
    public static IntegerProperty stigProperty() {
        return stig;
    }

    /**
     * Skilar Pipukista hlut sem inniheldur listan af pípum.
     *
     * @return Pipukista hlut sem inniheldur listan af pípum
     */
    public Pipukista getPipukista() {
        return pipukista;
    }

    /**
     * Skilar Pipa[][] fylki sem inniheldur núverandi stöðu pipulognsins.
     *
     * @return Pipa[][] fylki sem inniheldur núverandi stöðu pipulognsins
     */


    public Pipa[][] getPipulogn() {
        return pipulogn;
    }

    /**
     * Skilar núverandi pipunni sem er valin.
     *
     * @return Núverandi Pipa hlut sem er valin
     */
    public Pipa getNuverandiPipa() {
        return nuverandiPipa.get();
    }

    /**
     * Uppfærir núverandi pipu hlut sem er valin.
     *
     * @param nuverandiPipa Nýja Pipa hlut sem verður núverandi hlutur.
     */
    public void setNuverandiPipa(Pipa nuverandiPipa) {
        this.nuverandiPipa.set(nuverandiPipa);
    }

    /**

     Skilar ObjectProperty hlut sem heldur utan um núverandi pípu.
     @return ObjectProperty hlut sem heldur utan um núverandi pípu
     */
    public ObjectProperty<Pipa> nuverandiPipaProperty() {
        return nuverandiPipa;
    }

}

/**

 Klasinn PipemaniaController er hönnunaraksturinn fyrir

 notendaumsjónarkerfið í PipeMania-forritinu.
 */
public class PipemaniaController  implements Initializable {

    /**
     * VBox hlutur sem geymir reiti sem táknar hverja pípu í kistunni.
     */
    public VBox fxButar;

    /**
     * X-hnit síðasta reitsins sem var smellt á.
     */
    private int last_x;
    /**
     * Y-hnit síðasta reitsins sem var smellt á.
     */
    private int last_y;
    /**
     * GridPane hlutur sem geymir reitina í spilaborðinu.
     */
    public GridPane gridd;
    /**
     PipeMania hlutur sem heldur utan um spilaborðið og stigin.
     */
    private PipeMania mania;

    /**
     * Textareitur sem birtir stigin í viðmótinu.
     */
    @FXML
    private TextField fxStig;

    /**
     * Síðasta pípan sem var smellt á.
     */
    private Pipa mostRecentPipe;

    /**
     *Birtir myndir af pípum í kistunni í viðmótið.
     * @param q Listi af pípum sem á að birta í viðmótið.
     */
    public void birtaMyndir(ObservableList<Pipa> q) {
        int i = 3;

        for (Pipa p : q) {
            fxButar.getChildren().get(i).getStyleClass().clear();
            fxButar.getChildren().get(i--).getStyleClass().add(getStilKlasi(p));
            if (i == -1) {
                break;
            }
        }
    }

    /**
     * Bregst við atburði þegar notandi velur reit á leikborðinu
     * og kallar á viðeigandi aðferðir til að bæta við nýrri pípu ef
     * skilyrði eru uppfyllt.
     * @param actionEvent atburðurinn sem var valinn af notandanum.
     */
    public void fxVeljaReit(ActionEvent actionEvent) {
        if (!mania.isGameOver()) {
            Button nappur = ((Button) actionEvent.getTarget());
            last_x = GridPane.getRowIndex(nappur);
            last_y = GridPane.getColumnIndex(nappur);

            if (mania.skodaPipulogn(last_x, last_y)) {
                Pipa pipa = mania.getPipukista().naestaPipa();
                mania.setNaestaPipa(last_x, last_y, pipa);
                mostRecentPipe = pipa;
            }
        }
    }

    /**
     * Skilar streng sem táknar stíl klasa fyrir gefna pípu.
     * @param p Pípa sem þarf að finna stíl klasa fyrir.
     * @return Strengur sem táknar stíl klasa fyrir pípuna.
     */
    public String getStilKlasi(Pipa p) {
        return ("p" + p.getInn() + p.getUt());
    }

    /**
     * Athugar hvort núverandi pípa sé ekki tóm og kallar á flæði í PipeMania objectinu.
     * Ef leik lýkur setur gameOver sem satt. Annars bætir sprengju klassa við hnappi sem núverandi pípa stendur á
     * og setur gameOver sem satt.
     */
    public void fxAthFlaedir() {
        if (mostRecentPipe != null) {
            if (mania.flaedir(mania.getFirstPipe())) {
                mania.setGameOver(true);
            } else {
                Button hnappur = ((Button) gridd.getChildren().get(mania.getNuverandiPipa().getIndexTwo() * 5 + mania.getNuverandiPipa().getIndexOne()));
                hnappur.getStyleClass().add("explosion");
                mania.setGameOver(true);
            }
        }
    }

    /**
     * initialize til að setja upp tilvik af pipemania leik sem hægt er að spila þegar forritið er keyrt
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mania = new PipeMania();
        fxStig.textProperty().bind(PipeMania.stigProperty().asString());

        Random random = new Random();
        int r = random.nextInt((3) + 1);
        Pipa startPipe = new Pipa(null, Pipa.Att.values()[r]);

        mania.getPipukista().getKista().set(0, startPipe);

        int i = 3;
        for (Pipa p : mania.getPipukista().getKista()) {
            fxButar.getChildren().get(i).getStyleClass().clear();
            fxButar.getChildren().get(i--).getStyleClass().add(getStilKlasi(p));
            if (i == -1) break;
        }

        mania.getPipukista().getKista().addListener((ListChangeListener<Pipa>) change -> {
            if (change.next() && change.wasAdded()) {
                birtaMyndir(mania.getPipukista().getKista());
            }

            mania.nuverandiPipaProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.isOpin()) {
                    int gridPosition = (last_y * 5) + last_x;
                    Button hnappur = ((Button) gridd.getChildren().get(gridPosition));
                    hnappur.getStyleClass().add(getStilKlasi(newValue));
                } else {
                    int nuvPipaPosition = (newValue.getIndexTwo() * 5) + newValue.getIndexOne();
                    Button hnappur = ((Button) gridd.getChildren().get(nuvPipaPosition));
                    hnappur.getStyleClass().add("f" + getStilKlasi(newValue));
                }
            });
        });
    }
}