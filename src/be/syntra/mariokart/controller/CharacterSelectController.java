package be.syntra.mariokart.controller;

import be.syntra.mariokart.controller.gamelogic.GameLoop;
import be.syntra.mariokart.model.Map;
import be.syntra.mariokart.model.PlayerCharacter;
import be.syntra.mariokart.model.characters.*;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class CharacterSelectController implements IController {
    private final AudioPlayer audio = new AudioPlayer();
    private Stage stage;
    private Scene scene;
    private PlayerCharacter playerCharacter;
    private Map map;
    private Text lapsText;
    private Text elapsedTimeTextField;
    private Text checkpointsText;
    private GameLoop gameLoop;

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public PlayerCharacter getCharacter() {
        return playerCharacter;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = Objects.requireNonNullElseGet(map, () -> new Map("File:resources/images/Backgroundpixell.png"));
    }

    public Text getLapsText() {
        return lapsText;
    }

    public Text getCheckpointsText() {
        return checkpointsText;
    }

    public Text getElapsedTimeTextField() {
        return elapsedTimeTextField;
    }

    @FXML
    void SelectCharacter1() {
        audio.playAudioSelect();
        playerCharacter = new Mario();
        //playerCharacter = new PlayerCharacter("Mario", 1);
    }

    @FXML
    void SelectCharacter2() {
        audio.playAudioSelect();
        playerCharacter = new Luigi();
                //PlayerCharacter("Luigi", 2);
    }

    @FXML
    void SelectCharacter3() {
        audio.playAudioSelect();
        playerCharacter = new Toad();
    }

    @FXML
    void SelectCharacter4() {
        audio.playAudioSelect();
        playerCharacter = new Yoshi();
    }

    @FXML
    void SelectCharacter5() {
        audio.playAudioSelect();
        playerCharacter = new Peach();
    }

    @FXML
    void SelectCharacter6() {
        audio.playAudioSelect();
        playerCharacter = new Bowser();
    }

    //starts racegamePane and the actual racegame
    @FXML
    @Override
    public void switchToNextScene(ActionEvent event) {
        audio.playAudioNextScreen();
        ArrayList<KeyCode> keyPressedList = new ArrayList<>();

        if (playerCharacter == null) {
            playerCharacter = new Mario();
        }
        var root = new RaceGamePane();
        root.getChildren().addAll(map.getTileMap());
        root.getChildren().add(playerCharacter.getImageView());

        //amount of laps completed text
        lapsText = new Text("");
        lapsText.setX(500);
        lapsText.setY(50);
        lapsText.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 40));
        lapsText.setFill(Color.BROWN);
        lapsText.setStrokeWidth(2);
        lapsText.setStroke(Color.BLUE);
        root.getChildren().add(lapsText);

        //amount of checkpoints completed text
        checkpointsText = new Text("");
        checkpointsText.setX(500);
        checkpointsText.setY(70);
        checkpointsText.setFont(Font.font("Verdana", FontPosture.REGULAR, 18));
        checkpointsText.setStrokeWidth(2);
        checkpointsText.setStroke(Color.BLUE);
        root.getChildren().add(checkpointsText);

        //time elapsed from start of the race
        elapsedTimeTextField = new Text("");
        elapsedTimeTextField.setX(50);
        elapsedTimeTextField.setY(50);
        elapsedTimeTextField.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        elapsedTimeTextField.setFill(Color.BROWN);
        elapsedTimeTextField.setStrokeWidth(2);
        elapsedTimeTextField.setStroke(Color.BLUE);
        root.getChildren().add(elapsedTimeTextField);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 768, 768);
        stage.setScene(scene);

        //starts the gameloop: race & animations
        gameLoop = new GameLoop(this, keyPressedList);
        gameLoop.start();
    }

    @FXML
    // stops gameloop & either goes to gameover screen or to SaveplayerScore screen if a new topscore is reached
    public void escape() throws IOException {
        gameLoop.stop();
        audio.stopDrivingAudio();
        Scene scene;
        //TODO fix correct conditions
        if (Double.parseDouble(elapsedTimeTextField.getText()) > 4) {
            FXMLLoader loader = new FXMLLoader(new URL("File:resources/fxml/SavePlayerScore.fxml"));
            Parent root = loader.load();

            //pass variables to SavePlayerController
            SavePlayerScoreController savePlayerScoreController = loader.getController();
            savePlayerScoreController.setElapsedTime(Double.parseDouble(elapsedTimeTextField.getText()));
            savePlayerScoreController.setCharacter(playerCharacter);
            savePlayerScoreController.setMap(map);

            scene = new Scene(root, 768, 768);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/Style.css")).toExternalForm());

            stage.setScene(scene);
            stage.show();

        } else {
            FXMLLoader loader = new FXMLLoader(new URL("File:resources/fxml/GameOver.fxml"));
            Parent root = loader.load();

            //pass variables to next controller
            GameOverController gameOverController = loader.getController();
            gameOverController.setMap(map);
            gameOverController.setCharacter(playerCharacter);

            scene = new Scene(root, 768, 768);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/Style.css")).toExternalForm());

            //gameLoop.stop();
            stage.setScene(scene);
            stage.show();
        }
    }
}
