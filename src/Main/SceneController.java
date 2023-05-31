package Main;

import entities.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import map.Map;

public class SceneController {
    Character character;
    AudioClip AudioSelect = new AudioClip(new File("resources/audio/selectSomething.mp3").toURI().toString());
    AudioClip AudioNextScreen = new AudioClip(new File("resources/audio/nextScreen.mp3").toURI().toString());
    Text velocityTextField;
    Map map;
    private Stage stage;

    private Scene scene;
    @FXML
    private AnchorPane CharacterSelectPane;
    @FXML
    private GridPane GridCharacters;
    @FXML
    private Button ButtonStartRace;
    @FXML
    private Button Button1;
    @FXML
    private Button Button2;
    @FXML
    private Button Button3;
    @FXML
    private Button Button4;
    @FXML
    private Button Button5;
    @FXML
    private Button Button6;

    public Scene getScene() {
        return scene;
    }

    public void SwitchToCharacterSelect(ActionEvent event) throws IOException {
        AudioNextScreen.play();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CharacterSelect.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 768, 768);

        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SelectCharacter1() {
        AudioSelect.play();
        character = new Character("Mario", 1);
    }

    @FXML
    void SelectCharacter2() {
        AudioSelect.play();
        character = new Character("Luigi", 2);
    }

    @FXML
    void SelectCharacter3() {
        AudioSelect.play();
        character = new Character("Toad", 3);
    }

    @FXML
    void SelectCharacter4() {
        AudioSelect.play();
        character = new Character("Yoshi", 4);
    }

    @FXML
    void SelectCharacter5() {
        AudioSelect.play();
        character = new Character("Peach", 5);
    }

    @FXML
    void SelectCharacter6() {
        AudioSelect.play();
        character = new Character("Bowser", 6);
    }

    @FXML
    void switchToGameScene(ActionEvent event){
        AudioNextScreen.play();
        ArrayList<String> keyPressedList = new ArrayList<>();
        map = new Map();
        AudioNextScreen.play();
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

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 768, 768);
        stage.setScene(scene);

        new GameLoop(this, keyPressedList).start();
    }
}
