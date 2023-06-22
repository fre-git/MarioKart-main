package be.syntra.mariokart.controller;

import be.syntra.mariokart.model.PlayerCharacter;
import be.syntra.mariokart.model.Map;
import be.syntra.mariokart.view.AudioPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GameOverController implements IController{
    private AudioPlayer audio = new AudioPlayer();
    private PlayerCharacter characterPlayer;
    private Map map;
    private Scene scene;
    private Stage stage;

    @FXML
    @Override
    //go back to startscreen
    public void switchToNextScene(ActionEvent event) throws IOException {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/StartMenu.fxml")));
        scene = new Scene(root, 768, 768);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/Style.css")).toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public Scene getScene() {
        return null;
    }

    @Override
    public PlayerCharacter getCharacter() {
        return characterPlayer;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setCharacter(PlayerCharacter characterPlayer) {
        this.characterPlayer = characterPlayer;
    }
}
