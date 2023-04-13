package hi.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Veitingar {
    private StringProperty nafn = new SimpleStringProperty();
    private IntegerProperty verd = new SimpleIntegerProperty();

    public String getNafn() {
        return this.nafn.get();
    }

    public void setNafn(StringProperty nafn) {
        this.nafn = nafn;
    }

    public int getVerd() {
        return this.verd.get();
    }

    public void setVerd(IntegerProperty verd) {
        this.verd = verd;
    }

    public Veitingar(String nafn, Integer verd){
        this.nafn.set(nafn);
        this.verd.set(verd);
    }
    @Override
    public String toString(){
        return nafn.getValue() + "       " + verd.getValue();
    }
}
