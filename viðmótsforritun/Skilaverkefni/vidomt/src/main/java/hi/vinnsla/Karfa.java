package hi.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Karfa extends Matsedill{
    
    private IntegerProperty total = new SimpleIntegerProperty();

    public IntegerProperty getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total.set(total);
    }

    // public String toString(){
    //     return matur + ", " + verd;
    // }
}
