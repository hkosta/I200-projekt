package Main.java;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Helen on 14.12.2015.
 */
public class LotoFrame extends Pane{

    Label masin;
    Label võitja;
    ArrayList<String> tootaja;
    Button käivita;
    StackPane loto;
    Scene lava;
    Stage alus = new Stage();


    public LotoFrame(){
        setupScene();
        setupLoto();
        setupWinner();

    }

    private void setupScene() {
        loto = new StackPane();
        lava = new Scene(loto,300,200);
        masin = new Label("Käivita loosimine vajutades - \"Start\" nuppu");
        loto.setAlignment(masin, Pos.TOP_CENTER);
        käivita = new Button("Start");
        loto.getChildren().addAll(masin, käivita);

        alus.setScene(lava);
        alus.show();

    }

    private void setupLoto() {

    }

    private void setupWinner() {
    }

}
