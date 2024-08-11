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
import javafx.scene.text.Font;
import org.w3c.dom.Text;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

import static javafx.geometry.Pos.CENTER;

public class Quiz {

    private static double returnSolution(double n1, double n2, int op){

        double solution = 0.0;
        final DecimalFormat decimalFormat = new DecimalFormat("0.0");

        switch (op) {
            case 0:
                solution = n1 + n2;
                break;
            case 1:
                solution = n1 - n2;
                break;
            case 2:
                solution = n1 * n2;
                break;
            case 3:
                solution = Double.parseDouble(decimalFormat.format(n1 / n2)); //MUST TRUNCATE to 0.0
                break;
        }
        return solution;
    }

    public static void makeEquation(){
        Random rand = new Random();
        char[] charOps = {'+', '-', 'x', '/'};
        int n1;
        int n2;
        int op; // op is short for operator (where 0 is +, 1 is -, 2 is *, and 3 is /)
        char charOp;
        double solution; //typed the full name "solution" to stand out
        int score = 0;

        int questionNo = 0;
        short numQuestions = MainMenu.getNumQuestions();
        short rangeA = MainMenu.getRangeA();
        short rangeB = MainMenu.getRangeB();

        while(questionNo < numQuestions) {
            //INITIALIZE THE OPERANDS AND THE OPERATOR
            //I thought the operands n1 and n2 are better names than x and y (or a and b).
            n1 = rand.nextInt(rangeB);    //Numbers from [0..100]
            n2 = rand.nextInt(rangeB) + 1;  //Numbers from [1..100] (from 1 to disallow n1/0)
            op = rand.nextInt(4);      //[0..3]
            charOp = charOps[op]; //Initialize the character for the equation operator
            //Debugging purposes
            // n1 = 3;
            //n2 = 6;
            //op = 1;
            solution = returnSolution(n1, n2, op);

            String operation = "";
            switch (charOp) {
                case '+':
                    operation = "plus";
                    break;
                case '-':
                    operation = "minus";
                    break;
                case 'x':
                    operation = "times";
                    break;
                case '/':
                    operation = "divided by";
                    break;
            }
            String question = String.format("%d %s %d", n1, operation, n2);
        }
    }

    public static BorderPane getQuiz() {
        TextField tf = new TextField();
        BorderPane root = new BorderPane();
        GridPane gp = new GridPane();



        //Set up BorderPane
        tf.setPrefHeight(300);
        tf.setFont(Font.font(100));
        tf.setEditable(false);
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
