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
import java.util.Objects;

public class SceneController {
    //    private Parent root;
    //RaceGamePane pane;
    Character character;
    private Stage stage;
    private Scene scene;

    AudioClip selectAudio = new AudioClip(new File("resources/audio/selectSomething.mp3").toURI().toString());
    AudioClip nextScreenAudio = new AudioClip(new File("resources/audio/nextScreen.mp3").toURI().toString());

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

    public void SwitchToCharacterSelect(ActionEvent event) throws IOException {
        nextScreenAudio.play();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CharacterSelect.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 768, 768);

        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToGameScene(ActionEvent event) {
        nextScreenAudio.play();
        if(character == null){
            character = new Character("Mario", 1);
        }

        var root = new RaceGamePane();
        root.setCharacter(character);
        root.getChildren().add(character.getImageView());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 768, 768);

        stage.setScene(scene);
        stage.show();
        root.requestFocus();
    }

    @FXML
    void SelectCharacter1(ActionEvent event){
        selectAudio.play();
        character = new Character("Mario", 1);
    }

    @FXML
    void SelectCharacter2(ActionEvent event){
        selectAudio.play();
        character = new Character("Luigi", 2);
    }

    @FXML
    void SelectCharacter3(ActionEvent event) {
        selectAudio.play();
        character = new Character("Toad", 3);
    }

    @FXML
    void SelectCharacter4(ActionEvent event){
        selectAudio.play();
        character = new Character("Yoshi", 4);
    }

    @FXML
    void SelectCharacter5(ActionEvent event){
        selectAudio.play();
        character = new Character("Peach", 5);
    }

    @FXML
    void SelectCharacter6(ActionEvent event){
        selectAudio.play();
        character = new Character("Bowser", 6);
    }
}
