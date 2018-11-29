package jp.naist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WritingReview extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("review.fxml"));
        primaryStage.setScene(new Scene(root, 800, 275));
        primaryStage.setTitle("Research Writing WritingReview");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
