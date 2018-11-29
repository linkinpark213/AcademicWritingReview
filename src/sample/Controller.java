package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.regex.Pattern;

public class Controller {

    @FXML
    private TextField blank;
    @FXML
    private Text foreText;
    @FXML
    private Text postText;
    @FXML
    private Text result;
    @FXML
    private Button nextButton;
    private int questionNumber = -1;
    private String[] texts = {
            "The aim of Research Writing is to prepare students with the knowledge, language and skills needed to $ in research writing",
            "Science is the systematic $ classification of experience",
            "The whole of $ is nothing more than a refinement of everyday thinking",
            "The $ section looks at what others have observed",
            "The Method section explains how you made your own $",
            "The Results section shows $ you observed",
            "The Discussion section tries to $ your observations",
            "A good introduction is a clear $ of the problem or project and the reasons for studying it",
            "The introduction flows from general to $ information",
            "The purposes of an introduction is to introduce the research topic and its $",
            "In the Introduction section, it is important to identify the $ in previous research",
            "You must also list the $ of your research in the introduction",
            "The method section is a $ of what the researchers did to obtain the results that are presented and discussed in succeeding sections",
            "$ details is another name for the method section",
            "'We prepared the substrate' is an example of $ voice",
            "'The substrate was prepared' is an example of $ voice",
            "The key to a successful method is to provide just the right amount of $",
            "The method section should follow a logical order corresponding with the $ section",
            "$ can help readers find information in the method section",
            "The method section should provide enough detail for $",
            "In the results section we $ what we observed",
            "In the discussion section, we try to $ what we observed",
            "Results can be presented in figures, tables and $",
            "The results section should answer your $",
            "The order of the results presented should follow the order of the $",
            "When you want to present exact numbers, use a $",
            "When you want the reader to see trends and relationships, you should use a $",
            "The discussion section is the place to interpret your results, $ what's new and why is matters",
            "The title is the single most important $ in a scientific document",
            "The title attracts readers' attention, describes the $ and facilitates information retrieval",
            "Using $ letters in a heading depends on the level of heading",
            "In the title, use keywords, cut verbs and articles, and avoid specialized $",
            "The first purpose of a conclusion is to $ the main areas covered in the paper",
            "The comment in a conclusion may include suggestions for improvement and $ work",
            "An abstract is a $ of an academic paper",
            "The main purpose of an abstract is to $ the research done",
            "Organizations use abstracts as a $ to selecting research for publication",
            "An abstract is a $ report of the study you did",
            "$ use abstracts to decide whether or not to read the paper"
    };

    private String[] answers = {
            "get started",
            "classification",
            "science",
            "Introduction",
            "observations",
            "what",
            "understand",
            "statement",
            "specific",
            "importance",
            "gap",
            "aim",
            "description",
            "Experimental",
            "active",
            "passive",
            "details",
            "results",
            "Subheadings",
            "replication",
            "describe",
            "understand",
            "text",
            "research questions",
            "method section",
            "table",
            "figure",
            "explain",
            "phrase",
            "content",
            "capital",
            "abbreviations",
            "summarize",
            "future",
            "summary",
            "represent",
            "guide",
            "complete",
            "Readers"
    };

    private boolean isAnswerCorrect(int questionNumber, String answer) {
        return answers[questionNumber].toLowerCase().equals(answer.toLowerCase());
    }

    @FXML
    private void handleAnswerEntered(KeyEvent event) {
        KeyCode code = event.getCode();
        String name = code.getName();
        if (name.equals("Enter")) {
            if (event.isControlDown()) {
                handleNextButtonPressed();
            } else {
                String answer = blank.getText();
                boolean isCorrect = isAnswerCorrect(questionNumber, answer);
                if (isCorrect) {
                    result.setText("Correct!");
                    handleNextButtonPressed();
                } else {
                    result.setText("The answer should be: " + answers[questionNumber]);
                }
            }
        }
    }

    @FXML
    private void handleNextButtonPressed() {
        result.setText("");
        blank.setText("");
        questionNumber = (int) (Math.random() * texts.length);
        String str = texts[questionNumber];
        System.out.println(str);
        String[] split = str.split("\\$");
        String partOne;
        String partTwo;
        if (str.charAt(0) == '$') {
            partOne = "";
            partTwo = split[0];
        } else if (str.charAt(str.length() - 1) == '$') {
            partOne = split[0];
            System.out.println("partOne:\t" + partOne);
            partTwo = "";
            System.out.println("partTwo:\t" + partTwo);
        } else {
            partOne = split[0];
            partTwo = split[1];
        }
        foreText.setText(partOne);
        postText.setText(partTwo);
    }

    @FXML
    private void initialize() {
        handleNextButtonPressed();
        blank.requestFocus();
        foreText.setFont(new Font(20));
        postText.setFont(new Font(20));
        result.setFont(new Font(30));
        result.setFill(Color.RED);
        nextButton.setFont(new Font(30));
    }
}
