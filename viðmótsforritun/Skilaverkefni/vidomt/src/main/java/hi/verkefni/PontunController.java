package hi.verkefni;

import java.io.IOException;
import java.util.Observable;

import hi.vinnsla.Karfa;
import hi.vinnsla.Matsedill;
import hi.vinnsla.Veitingar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class PontunController {
    @FXML
    private static Karfa karfa;
    public static int activeindex=0;

    @FXML
    private MatsedillView foodlist;


    @FXML
    public ListView<Veitingar> fxCart;

    public void fxSetjaKorfuHandler(ActionEvent actionEvent){
        if (activeindex!=-1){
        karfa.getVeitingar().add(foodlist.getVeiting(activeindex));
        }
    }

    public void fxTakaUrKorfuHandler(ActionEvent actionEvent){
        if (activeindex!=-1){
            karfa.getVeitingar().remove(foodlist.getVeiting(activeindex));
            }
    }

    public void fxInnskraningHandler(ActionEvent actionEvent){

    }

    public void initialize(){
        foodlist.getSelectionModel().selectedItemProperty().addListener((observable) ->{
            activeindex=foodlist.getSelectionModel().getSelectedIndex();
        }); 
        karfa = new Karfa();
        fxCart.setItems(karfa.getVeitingar());
    }
}
