package hi.verkefni;

import hi.vinnsla.Matsedill;
import hi.vinnsla.Veitingar;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;

public class MatsedillView extends ListView<Veitingar>{

    Matsedill matsedill;

    public MatsedillView(){

        FXMLLoader fxmlLoader = new FXMLLoader(TakeAwayApplication.class.getResource("matsedill-view.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        matsedill = new Matsedill();
        matsedill.setjaGogn(new Veitingar("Pizza con pepperoni", 3500));
        matsedill.setjaGogn(new Veitingar("Banana",150));
        matsedill.setjaGogn(new Veitingar("Hamburger",2990));
        matsedill.setjaGogn(new Veitingar("Spicy Chicken",3490));

        setItems(matsedill.getVeitingar());
    }

    public Veitingar getVeiting(int index){
        return (Veitingar) matsedill.getVeitingar().get(index);
    }


}
