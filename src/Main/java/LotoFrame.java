package Main.java;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Helen on 14.12.2015.
 */
public class LotoFrame extends Pane{

    Label masin;
    List<Isik> isikud = ReadIsikDB.getIsikud();
    Button kaivita;
    StackPane loto;
    Rectangle taust;
    Scene lava;
    Stage alus = new Stage();
    Image Rool = new Image("Main/resources/Rool.png");
    ImagePattern rool = new ImagePattern(Rool);



    public LotoFrame(){
        setupScene();

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
        kaivita = new Button("Start");
        loto.setAlignment(kaivita, Pos.BOTTOM_CENTER);
        kaivita.setFont(Font.font(30));
        loto.getChildren().addAll(masin, kaivita);

        kaivita.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                Random rand = new Random();
                int n = rand.nextInt(isikud.size());
                masin.setText("Võitja on: " + isikud.get(n).getNimi());
                SendMail.sendWinner(isikud.get(n));
            }
        });

        alus.setScene(lava);
        alus.show();

    }


}
