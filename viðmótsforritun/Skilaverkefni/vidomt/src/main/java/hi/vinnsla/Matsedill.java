package hi.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Matsedill {

    protected ObservableList<Veitingar> veitingar = FXCollections.observableArrayList();

    public ObservableList<Veitingar> getVeitingar() {
        return veitingar;
    }

    public void setjaGogn(Veitingar matur){
        veitingar.add(matur);
    }
}

