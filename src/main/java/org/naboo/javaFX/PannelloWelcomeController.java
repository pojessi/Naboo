package org.naboo.javaFX;

import java.io.IOException;

//import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PannelloWelcomeController {

    @FXML
    private Label label;

    @FXML
    private Button button;

    @FXML
    private ImageView myImageView;

    @FXML
    private MenuBar menuBar;


    public void printGilda(){
        System.out.println("Gildina");
    }

    public void initialize() {
        //String javaVersion = System.getProperty("java.version");
        //String javafxVersion = System.getProperty("javafx.version");
        //label.setText("Hello, JavaFX " + javafxVersion + "\nRunning on Java " + javaVersion + ".");
        /*button.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                label.setText("Gilda");
            }
        });
        */
    }

    private Stage stage;
    private Scene scene;

    public void switchToPannelloAmm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PannelloAmministratore.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
