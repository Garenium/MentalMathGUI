/*
* Author: Garen Ikezian
* File: Main.java
*
* */

package org.gikezian;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.transform.Scale;

import static javafx.geometry.Pos.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //GridPane gp = MainMenu.getMainMenu();
        BorderPane gp = Quiz.getQuiz();

        //Create a scene object
        Scene scene = new Scene(gp);

        //set title to the stage
        primaryStage.setTitle("MentalMathGUI");

        primaryStage.setScene( scene );

        primaryStage.setTitle("MentalMathGUI");
        //primaryStage.setResizable(false);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}