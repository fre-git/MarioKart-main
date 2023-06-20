package be.syntra.mariokart.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GameOverController {
    Stage stage;



    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void goToStart(ActionEvent event) throws IOException {
//        stage = new Stage();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //controller.getStage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/StartMenu.fxml")));
        Scene scene = new Scene(root, 768, 768);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/Style.css")).toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void tryAgain(ActionEvent event) {

    }

}
