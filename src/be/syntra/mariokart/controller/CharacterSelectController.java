package be.syntra.mariokart.controller;

import be.syntra.mariokart.view.AudioPlayer;
import be.syntra.mariokart.view.RaceGamePane;
import be.syntra.mariokart.model.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import be.syntra.mariokart.model.Map;

import java.util.ArrayList;

public class CharacterSelectController {
    private Scene scene;
    private Character character;
    private Map map;
    private Text velocityTextField;
    private final AudioPlayer audio = new AudioPlayer();

    public Scene getScene() {
        return scene;
    }

    public Character getCharacter() {
        return character;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map){
        this.map = map;
    }

    public Text getVelocityTextField() {
        return velocityTextField;
    }

    @FXML
    void SelectCharacter1() {
        audio.playAudioSelect();

        character = new Character("Mario", 1);
    }

    @FXML
    void SelectCharacter2() {
        audio.playAudioSelect();
        character = new Character("Luigi", 2);
    }

    @FXML
    void SelectCharacter3() {
        audio.playAudioSelect();
        character = new Character("Toad", 3);
    }

    @FXML
    void SelectCharacter4() {
        audio.playAudioSelect();
        character = new Character("Yoshi", 4);
    }

    @FXML
    void SelectCharacter5() {
        audio.playAudioSelect();
        character = new Character("Peach", 5);
    }

    @FXML
    void SelectCharacter6() {
        audio.playAudioSelect();
        character = new Character("Bowser", 6);
    }

    @FXML
    void switchToGameScene(ActionEvent event) {
        audio.playAudioNextScreen();
        ArrayList<KeyCode> keyPressedList = new ArrayList<>();
        System.out.println("map = " + map);

        if (character == null) {
            character = new Character("Mario", 1);
        }

        var root = new RaceGamePane();

        root.getChildren().addAll(map.getTileMap()); // view
        root.getChildren().add(character.getImageView()); // view

        velocityTextField = new Text("");
        velocityTextField.setX(50);
        velocityTextField.setY(50);
        root.getChildren().add(velocityTextField);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 768, 768);
        stage.setScene(scene);

        new GameLoop(this, keyPressedList).start();
    }
}
