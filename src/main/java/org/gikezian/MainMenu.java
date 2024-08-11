package org.gikezian;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.IOException;

import static javafx.geometry.Pos.CENTER;

public class MainMenu {

    private static short rangeA;
    private static short rangeB;
    private static short numQuestions;

    public static GridPane getMainMenu() {

        GridPane gp = new GridPane();
        gp.setGridLinesVisible(true);

        //Set the size for the pane
        gp.setMinSize(800,400);

        //Set the padding for the pane
        gp.setPadding(new Insets(20, 20, 20, 20));

        //Setting the vertical and horizontal gaps between the columns
        gp.setVgap(10);
        gp.setHgap(30);

        //Set the grid alignment
        gp.setAlignment(CENTER);

        Label numQuestionLabel = new Label("Number of Questions:");
        TextField numQuestionInp = new TextField();

        Label rangeLabel = new Label("Range:");
        rangeLabel.setTooltip(new Tooltip("It is [a, b] inclusive. It can be in any order."));
        TextField rangeInp = new TextField();

        Label userPrompt = new Label("Test user prompt");
        userPrompt.setTextFill(Color.web("#ff5050"));

        ButtonBar buttonBar = new ButtonBar();
        Button startButton = new Button("Start");
        Button clearButton = new Button("Clear");
        buttonBar.getButtons().addAll(startButton, clearButton);

        //Wrap ButtonBar to control ButtonBar padding
        HBox buttonBarContainer = new HBox(buttonBar);
        buttonBarContainer.setPadding(new Insets(0,0,0,-20));

        gp.add( numQuestionLabel, 0, 0 );
        gp.add( numQuestionInp, 1, 0 );
        gp.add( rangeLabel, 0, 1 );
        gp.add( rangeInp, 1, 1 );
        gp.add( userPrompt, 1, 2 );
        gp.add(buttonBarContainer, 0,2);

        //Setting an action for the Submit button
        startButton.setOnAction(e -> {
            String numQuestionInput = numQuestionInp.getText().trim();
            String rangeInput = rangeInp.getText().trim();

            if (!rangeInput.isEmpty() && !numQuestionInput.isEmpty()) {
                try {
                    if (numQuestionInput.length() > 3) {
                        userPrompt.setText("Number of questions is too long.");
                    } else {
                        numQuestions = Short.parseShort(numQuestionInput);

                        if (rangeInput.matches("\\d{1,4}, \\d{1,4}") || rangeInput.matches("\\d{1,4},\\d{1,4}")) {
                            String[] ranges = rangeInput.split(",\\s*");
                            rangeA = Short.parseShort(ranges[0]);
                            rangeB = Short.parseShort(ranges[1]);

                            SceneController.switchToQuiz(e);
                        } else {
                            userPrompt.setText("Range is invalid. (Ex: '1, 100')");
                        }

                    }
                } catch (NumberFormatException ex) {
                    userPrompt.setText("Please ensure all inputs are numbers.");
                } catch (IOException ex) {
                    userPrompt.setText("Error loading the quiz. Please try again.");
                    ex.printStackTrace();
                }
            } else {
                userPrompt.setText("Please fill in all fields.");
            }
        });

        //Setting an action for the Clear button
        clearButton.setOnAction(e -> {
            numQuestionInp.clear();
            rangeInp.clear();
            userPrompt.setText(null);
        });

        return gp;
    }

    public static short getNumQuestions() {
        return numQuestions;
    }

    public static short getRangeA() {
        return rangeA;
    }

    public static short getRangeB() {
        return rangeB;
    }
}

