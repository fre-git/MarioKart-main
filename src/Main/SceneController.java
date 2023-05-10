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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import javax.sound.sampled.AudioFileFormat;
import java.io.IOException;

public class SceneController {
    //    private Parent root;
    RaceGamePane pane;
    Character character;
    private Stage stage;
    private Scene scene;
    /*
    Media media = new Media("/audio/selectSomething.mp3");
    MediaPlayer player = new MediaPlayer(media);

     */
    //AudioClip selectSomething = new AudioClip(this.getClass().getResource("File://resources/selectSomething.mp3").toExternalForm());
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
        Parent root = FXMLLoader.load(getClass().getResource("CharacterSelect.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 768, 768);

        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToGameScene(ActionEvent event) throws IOException {
        if(character == null){
            character = new Character("Mario", 1);
        }

        //RaceGamePane raceGamePane = new RaceGamePane();
        //Scene scene = new Scene(raceGamePane, 1200, 1200);

        var root = new RaceGamePane(character);

        root.getChildren().add(character.getImageView());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 700, 700);
        stage.setScene(scene);
        stage.show();
        root.requestFocus();
    }

    @FXML
    void SelectCharacter1(ActionEvent event) {
        //player.play();
        character = new Character("Mario", 1);
    }

    @FXML
    void SelectCharacter2(ActionEvent event) {
        character = new Character("Luigi", 2);
    }

    @FXML
    void SelectCharacter3(ActionEvent event) {
        character = new Character("Toad", 3);
    }

    @FXML
    void SelectCharacter4(ActionEvent event) {
        character = new Character("Yoshi", 4);
    }

    @FXML
    void SelectCharacter5(ActionEvent event) {
        character = new Character("Peach", 5);
    }

    @FXML
    void SelectCharacter6(ActionEvent event) {
        character = new Character("Bowser", 6);
    }
}
