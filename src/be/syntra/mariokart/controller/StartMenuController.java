package be.syntra.mariokart.controller;

import be.syntra.mariokart.model.Character;
import be.syntra.mariokart.view.AudioPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class StartMenuController implements IController {
    AudioPlayer audio = new AudioPlayer();
    Scene scene;

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public Character getCharacter() {
        return null;
    }

    //switch to racetrack select
    @FXML
    @Override
    public void switchToNextScene(ActionEvent event) {
        audio.playAudioNextScreen();

        Parent root = null;
        try {
            root = FXMLLoader.load(new URL("File:resources/fxml/RacetrackSelect.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/RacetrackSelect.fxml")));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 768, 768);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/Style.css")).toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

}
