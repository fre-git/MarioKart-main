package be.syntra.mariokart.controller;

import be.syntra.mariokart.controller.gamelogic.GameLoop;
import be.syntra.mariokart.model.Character;
import be.syntra.mariokart.model.Map;
import be.syntra.mariokart.model.Vector;
import be.syntra.mariokart.view.AudioPlayer;
import be.syntra.mariokart.view.RaceGamePane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class GameOverController implements IController{
    private AudioPlayer audio = new AudioPlayer();
    private Map map;
    private Character character;
    private Text velocityTextField;
    private Text elapsedTimeTextField;
    private Scene scene;
    private Stage stage;
    private GameLoop gameLoop;




    public void setMap(Map map) {
        this.map = map;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    @FXML
    @Override
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
    public Character getCharacter() {
        return character;
    }
}
