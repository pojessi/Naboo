package org.naboo.javaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.naboo.piattaforma.amministratore;

import java.io.IOException;
import java.util.ArrayList;

public class PannelloAmministratoreController {

    private amministratore amministratore;

    public void initialize() {
        amministratore = new amministratore();
    }

    private Stage stage;
    private Scene scene;

    public void switchToWelcomePanel(ActionEvent event) throws IOException  {
        Parent root = FXMLLoader.load(getClass().getResource("PannelloWelcome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void aggiungiFonte(ActionEvent event){
        Stage secondStage = new Stage();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        //Defining the Name text field
        final TextField urlFonte = new TextField();
        urlFonte.setPromptText("Url fonti: ");
        urlFonte.setPrefColumnCount(10);
        urlFonte.getText();
        GridPane.setConstraints(urlFonte, 0, 0);
        grid.getChildren().add(urlFonte);

        //Defining the Last Name text field
        final TextField nomeFonte = new TextField();
        nomeFonte.setPromptText("Nome fonte: ");
        GridPane.setConstraints(nomeFonte, 0, 1);
        grid.getChildren().add(nomeFonte);

        //Defining the Submit button
        Button submit = new Button("Conferma");
        GridPane.setConstraints(submit, 1, 0);
        grid.getChildren().add(submit);

        //Defining the Clear button
        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 1);
        grid.getChildren().add(clear);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(urlFonte.getText() != null && nomeFonte.getText() != null) {
                    System.out.println("[DEBUG] SUBMIT Aggiungi fonte da GUI con successo ");
                    amministratore.aggiungiFonte(urlFonte.getText(), nomeFonte.getText());
                    secondStage.close();
                }
            }
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("[DEBUG] CLEAR aggiungi fonte da GUI con successo ");
                urlFonte.clear();
                nomeFonte.clear();
            }
        });

        Scene sc = new Scene(grid, 300, 200);
        secondStage.setScene(sc);
        secondStage.show();
    }

    public void aggiungiNotizia(ActionEvent event){
        Stage secondStage = new Stage();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        //Defining the Name text field
        final TextField urlFonte = new TextField();
        urlFonte.setPromptText("Url notizia: ");
        urlFonte.setPrefColumnCount(10);
        urlFonte.getText();
        GridPane.setConstraints(urlFonte, 0, 0);
        grid.getChildren().add(urlFonte);

        //Defining the Last Name text field
        final TextField nomeFonte = new TextField();
        nomeFonte.setPromptText("Nome fonte: ");
        GridPane.setConstraints(nomeFonte, 0, 1);
        grid.getChildren().add(nomeFonte);

        //Defining the Submit button
        Button submit = new Button("Conferma");
        GridPane.setConstraints(submit, 1, 0);
        grid.getChildren().add(submit);

        //Defining the Clear button
        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 1);
        grid.getChildren().add(clear);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(urlFonte.getText() != null && nomeFonte.getText() != null) {
                    System.out.println("[DEBUG] SUBMIT Aggiungi notizia da GUI con successo ");
                    amministratore.aggiungiNotizia(urlFonte.getText(), nomeFonte.getText());
                    secondStage.close();
                }
            }
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("[DEBUG] CLEAR aggiungi notizia da GUI con successo ");
                urlFonte.clear();
                nomeFonte.clear();
            }
        });

        Scene sc = new Scene(grid, 300, 200);
        secondStage.setScene(sc);
        secondStage.show();
    }

    public void rimuoviFonte(){
        Stage secondStage = new Stage();
        ListView listView = new ListView();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        ObservableList<String> observableArrayList =
                FXCollections.observableArrayList(amministratore.getAllFonti());
        listView.setItems(observableArrayList);

        Button submit = new Button("Conferma");
        GridPane.setConstraints(submit, 1, 0);

        grid.getChildren().add(listView);
        grid.getChildren().add(submit);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ObservableList<String> selection = listView.getSelectionModel().getSelectedItems();
                String selectedItem = selection.get(0); //There is only one item, but observablelist is not easy to handle!
                try {
                    amministratore.rimuoviFonte(selectedItem);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Scene sc = new Scene(grid, 300, 200);
        secondStage.setScene(sc);
        secondStage.show();
    }

}
