package org.gikezian;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import static javafx.geometry.Pos.CENTER;

public class MainMenu {

    private IntegerProperty startA = new SimpleIntegerProperty();
    private IntegerProperty startB = new SimpleIntegerProperty();
    private IntegerProperty QuestionNo = new SimpleIntegerProperty();

    public static GridPane getGridPane() {
        Label numQuestionLabel = new Label("No. of Questions:");
        TextField numQuestionInp = new TextField();

        Label rangeLabel = new Label("Range:");
        TextField rangeInp = new TextField();

        Label userPrompt = new Label("Test");
        userPrompt.setTextFill(Color.web("#ff5050"));

        ButtonBar buttonBar = new ButtonBar();
        Button startButton = new Button("Start");
        Button clearButton = new Button("Clear");
        buttonBar.getButtons().addAll(startButton, clearButton);

        GridPane gp = new GridPane();

        //Set the size for the pane
        gp.setMinSize(800,400);

        //Set the padding for the pane
        gp.setPadding(new Insets(20, 20, 20, 20));

        //Setting the vertical and horizontal gaps between the columns
        gp.setVgap(10);
        gp.setHgap(15);

        //Sett the grid alignment
        gp.setAlignment(CENTER);

        gp.add( numQuestionLabel, 0, 0 );
        gp.add( numQuestionInp, 1, 0 );
        gp.add( rangeLabel, 0, 1 );
        gp.add( rangeInp, 1, 1 );
        gp.add( userPrompt, 1, 2 );
        gp.add(buttonBar, 1,4);

        //Setting an action for the Submit button
//    startButton.setOnAction(new EventHandler<ActionEvent>() {
//
//        @Override
//        public void handle(ActionEvent e) {
//            if ((numQuestionInp.getText() != null && !numQuestionInp.getText().isEmpty())) {
//                label.setText(name.getText() + " " + lastName.getText() + ", "
//                        + "thank you for your comment!");
//            } else {
//                userPrompt.setText("Invalid input");
//            }
//        }
//    });

        //Setting an action for the Clear button
        clearButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                numQuestionInp.clear();
                rangeInp.clear();
                userPrompt.setText(null);
            }
        });

        return gp;
    }

}

