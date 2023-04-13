package hi.verkefni.vinnsla;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Pipa {

    private int indexOne;
    private int indexTwo;
    public enum Att {V, N, A, S}
    private Att inn;
    private Att ut;

    private final BooleanProperty opin = new SimpleBooleanProperty(false);

    /**
     * Býr til pípu með inn og út áttir sem segir til hvernig formið á henni er
     * @param x Att fyrir inn áttina
     * @param y Att fyrir ut áttina
     */
    public Pipa(Att x, Att y){
        this.inn = x;
        this.ut = y;
    }

    /**
     * Athugar hvort að hægt sé að flæða vatni í gegnum pípu þegar búið er að tengja við annað pípueind í mismunandi átt.
     * @param s Pipa sem er tengd
     * @return true ef það er hægt að tengjast, false annars
     */
    public boolean flaedir(Pipa s){

        if ((ut.ordinal() +2)%4 == s.getInn().ordinal()) {
            return true;
        }
        else if ((ut.ordinal() +2)%4 == s.getUt().ordinal()){
            Att tmp = s.ut;
            s.ut = s.inn;
            s.inn = tmp;
            return true;
        }
        return false;
    }


    public boolean isOpin() {
        return opin.get();
    }

    /**
     * Skilar boolean gildi sem táknar hvort Pípan sé opin eða ekki.
     * @return boolean gildi sem táknar hvort Pípan sé opin eða ekki
     */
    public void setOpin(boolean opin) {
        this.opin.set(true);
    }

    /**
     * skilar fyrir inn áttina á pípunni
     * @return inn
     */
    public Att getInn() {
        return this.inn;
    }

    /**
     * skilar fyrir út áttina á pípunni
     * @return ut
     */
    public Att getUt() {
        return this.ut;
    }

    /**
     * skilar fyrir staðsetningu í röð á leikvelli fyrir núverandi pípu
     * @return int tölugildi fyrir röð
     */
    public int getIndexOne() {
        return indexOne;
    }

    /**
     * setter fyrir staðsetningu í röð á leikvelli fyrir núverandi pípu
     * @param index int gildi fyrir röð
     */
    public void setIndexOne(int index) {
        this.indexOne = index;
    }

    /**
     * skilar fyrir staðsetningu í dálki á leikvelli fyrir núverandi pípu
     * @return int gildi fyrir dálk
     */
    public int getIndexTwo() {
        return indexTwo;
    }

    /**
     * setter fyrir staðsetningu í dálki á leikvelli fyrir núverandi pípu
     * @param indexTwo int gildi fyrir dálk
     */
    public void setIndexTwo(int indexTwo) {
        this.indexTwo = indexTwo;
    }
}
