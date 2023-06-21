package be.syntra.mariokart.controller;

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

public class StartMenuController {
    AudioPlayer audio = new AudioPlayer();

    @FXML
    void SwitchToRacetrackSelect(ActionEvent event) throws IOException {
        audio.playAudioNextScreen();

        Parent root = FXMLLoader.load(new URL("File:resources/fxml/RacetrackSelect.fxml"));

        //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/RacetrackSelect.fxml")));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 768, 768);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/Style.css")).toExternalForm());

        stage.setScene(scene);
        stage.show();
    }


}
