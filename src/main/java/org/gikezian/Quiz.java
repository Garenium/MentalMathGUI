package org.gikezian;

import com.sun.javafx.application.PlatformImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.application.Platform;
import org.w3c.dom.Text;

import java.io.IOException;

import static javafx.geometry.Pos.CENTER;

public class Quiz {

    public static BorderPane getQuiz() {
        TextField tf = new TextField("1 + 1 = 2");
        BorderPane root = new BorderPane();
        GridPane gp = new GridPane();

        //Set up BorderPane
        tf.setPrefHeight(300);
        VBox topContainer = new VBox(tf);  // Create a VBox to contain the TextField to control its layout
        topContainer.setAlignment(Pos.CENTER);
        topContainer.setPadding(new Insets(10));

        root.setTop(topContainer);
        root.setCenter(gp);


        // Set up GridPane
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(0.0);
        gp.setVgap(0.0);
        gp.setMinSize(800, 200);

        Button cancelButton = new Button("Cancel");
        TextField equationInput = new TextField();


        gp.add(equationInput, 0,0);
        gp.add(cancelButton, 0, 1);

        Platform.runLater(() -> equationInput.requestFocus());

        cancelButton.setOnAction(e -> {
            try {
                SceneController.switchToMainMenu(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        return root;
    }
}
