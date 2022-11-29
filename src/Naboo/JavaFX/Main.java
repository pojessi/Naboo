package Naboo.JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("PannelloWelcome.fxml"));
        primaryStage.setTitle("Naboo");
        primaryStage.setScene(new Scene(root,900,500, Color.DARKBLUE));
        primaryStage.setX(50);
        primaryStage.setY(50);

        Text text = new Text();
        text.setText("Welcome to Naboo");

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
