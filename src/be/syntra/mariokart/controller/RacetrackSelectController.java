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
import be.syntra.mariokart.model.Map;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class RacetrackSelectController implements IController {
    private Map map;
    private final AudioPlayer audio = new AudioPlayer();
    Scene scene;

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public Character getCharacter() {
        return null;
    }

    @FXML
    @Override
    public void switchToNextScene(ActionEvent event) throws IOException {
        audio.playAudioNextScreen();

        //FXMLLoader loader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/CharacterSelect.fxml")));


        FXMLLoader loader = new FXMLLoader(new URL("File:resources/fxml/CharacterSelect.fxml"));
        Parent root = loader.load();

        CharacterSelectController characterController = loader.getController();
        characterController.setMap(this.map);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 768, 768);

        scene.getStylesheets().add("File:resources/css/Style.css");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void selectTrack1() {
        audio.playAudioSelect();
        map = new Map("File:resources/images/Backgroundpixell.png");
    }

    @FXML
    void selectTrack2() {
        audio.playAudioSelect();
        map = new Map("File:resources/images/Backgroundpixell3Colors3.png");
    }
}
