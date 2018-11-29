package jp.naist;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    @FXML
    private TextField answerTextField;
    @FXML
    private Text foreText;
    @FXML
    private Text postText;
    @FXML
    private Text resultText;
    @FXML
    private Button nextButton;
    private int questionNumber = -1;
    private ArrayList<String> foreTexts = new ArrayList<>();
    private ArrayList<String> postTexts = new ArrayList<>();
    private ArrayList<String> answers = new ArrayList<>();

    private boolean isAnswerCorrect(int questionNumber, String answer) {
        return answers.get(questionNumber).toLowerCase().equals(answer.toLowerCase());
    }

    @FXML
    private void handleAnswerEntered(KeyEvent event) {
        KeyCode code = event.getCode();
        String name = code.getName();
        if (name.equals("Enter")) {
            if (event.isControlDown()) {
                handleNextButtonPressed();
            } else {
                String answer = answerTextField.getText();
                boolean isCorrect = isAnswerCorrect(questionNumber, answer);
                if (isCorrect) {
                    resultText.setText("Correct!");
                    handleNextButtonPressed();
                } else {
                    resultText.setText("The answer should be: " + answers.get(questionNumber));
                }
            }
        }
    }

    @FXML
    private void handleNextButtonPressed() {
        resultText.setText("");
        answerTextField.setText("");
        questionNumber = (int) (Math.random() * answers.size());
        foreText.setText(foreTexts.get(questionNumber));
        postText.setText(postTexts.get(questionNumber));
    }

    @FXML
    private void initialize() throws FileNotFoundException {
        Scanner in = new Scanner(new File("sentences.txt"));
        while (in.hasNext()) {
            String sentence = in.nextLine();
            String[] split = sentence.split("\\$");
            String partOne;
            String answer;
            String partTwo;
            if (sentence.charAt(sentence.length() - 1) == '$') {
                partOne = split[0];
                answer = split[1];
                partTwo = "";
            } else {
                partOne = split[0];
                answer = split[1];
                partTwo = split[2];
            }
            foreTexts.add(partOne);
            postTexts.add(partTwo);
            answers.add(answer);
        }

        answerTextField.requestFocus();
        foreText.setFont(new Font(20));
        postText.setFont(new Font(20));
        resultText.setFont(new Font(30));
        resultText.setFill(Color.RED);
        nextButton.setFont(new Font(30));
        handleNextButtonPressed();
    }
}
