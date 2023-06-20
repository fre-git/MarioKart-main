package be.syntra.mariokart.controller;

import be.syntra.mariokart.model.Character;
import be.syntra.mariokart.model.Map;
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

public class CharacterSelectController {
    private final AudioPlayer audio = new AudioPlayer();
    private Stage stage;
    private Scene scene;
    private Character character;
    private Map map;
    private Text velocityTextField;
    private Text elapsedTimeTextField;
    private GameLoop gameLoop;

    GameOverController controller = new GameOverController();

    public Scene getScene() {
        return scene;
    }

    public Character getCharacter() {
        return character;
    }

    public Map getMap() {
        return map;
    }

    public Stage getStage() {
        return stage;
    }

    public void setMap(Map map) {
        if (map == null) {
            this.map = new Map("File:resources/images/Backgroundpixell.png");
        } else {
            this.map = map;
        }
    }

    public Text getVelocityTextField() {
        return velocityTextField;
    }

    public Text getElapsedTimeTextField() {
        return elapsedTimeTextField;
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
    void switchToGameScene(ActionEvent event) throws Exception {
        audio.playAudioNextScreen();
        ArrayList<KeyCode> keyPressedList = new ArrayList<>();

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

        elapsedTimeTextField = new Text("");
        elapsedTimeTextField.setX(370);
        elapsedTimeTextField.setY(50);

        elapsedTimeTextField.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        elapsedTimeTextField.setFill(Color.BROWN);
        elapsedTimeTextField.setStrokeWidth(2);
        elapsedTimeTextField.setStroke(Color.BLUE);
        root.getChildren().add(elapsedTimeTextField);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 768, 768);
        stage.setScene(scene);


        gameLoop = new GameLoop(this, keyPressedList);
        gameLoop.start();


        //new GameLoop(this, keyPressedList).start();
    }

    @FXML
    public void escape() throws IOException {
        System.out.println("time: " + elapsedTimeTextField.getText());
        if(Double.valueOf(elapsedTimeTextField.getText()) < 4){
            System.out.println("lower as 10");
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/StartMenu.fxml")));
            Scene scene = new Scene(root, 768, 768);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/Style.css")).toExternalForm());
            gameLoop.stop();

            stage.setScene(scene);
            stage.show();

        } else{
            System.out.println("higher as 10");
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/GameOver.fxml")));
            Scene scene = new Scene(root, 768, 768);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/Style.css")).toExternalForm());

            gameLoop.stop();

            stage.setScene(scene);
            stage.show();
        }
        /*
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/StartMenu.fxml")));
        Scene scene = new Scene(root, 768, 768);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/Style.css")).toExternalForm());

        stage.setScene(scene);
        stage.show();

         */
    }
}
