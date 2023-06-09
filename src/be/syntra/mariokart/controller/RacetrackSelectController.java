package be.syntra.mariokart.controller;

import be.syntra.mariokart.model.PlayerCharacter;
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
import java.net.URL;

public class RacetrackSelectController implements IController {
    private Map map;
    private final AudioPlayer audio = new AudioPlayer();
    Scene scene;

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public PlayerCharacter getCharacter() {
        return null;
    }

    @FXML
    @Override
    //switch to character select screen
    public void switchToNextScene(ActionEvent event) throws IOException {
        audio.playAudioNextScreen();

        FXMLLoader loader = new FXMLLoader(new URL("File:resources/fxml/CharacterSelect.fxml"));
        Parent root = loader.load();

        //pass map variable to next controller
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
        map.setMapName("track1");
    }

    @FXML
    void selectTrack2() {
        audio.playAudioSelect();
        map = new Map("File:resources/images/Backgroundpixell3Colors.png");
        map.setMapName("track2");
    }
}
