package Main.java;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
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
    Rectangle taust;
    Scene lava;
    Stage alus = new Stage();
    Image Rool = new Image("Main/resources/Rool.png");
    ImagePattern rool = new ImagePattern(Rool);



    public LotoFrame(){
        setupScene();
        setupLoto();
        setupWinner();

    }

    private void setupScene() {
        loto = new StackPane();
        taust = new Rectangle(500, 500);
        taust.setFill(rool);
        loto.getChildren().add(taust);

        lava = new Scene(loto,500,500);
        masin = new Label("Käivita loosimine vajutades - \"Start\" nuppu");
        loto.setAlignment(masin,Pos.TOP_CENTER);
        masin.setFont(Font.font(20));
        käivita = new Button("Start");
        loto.setAlignment(käivita, Pos.BOTTOM_CENTER);
        käivita.setFont(Font.font(30));
        loto.getChildren().addAll(masin, käivita);

        alus.setScene(lava);
        alus.show();

    }

    private void setupLoto() {

    }

    private void setupWinner() {
    }

}
