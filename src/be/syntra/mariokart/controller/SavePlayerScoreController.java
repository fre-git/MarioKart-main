package be.syntra.mariokart.controller;

import be.syntra.mariokart.Main;
import be.syntra.mariokart.model.PlayerCharacter;
import be.syntra.mariokart.controller.storage.DataStorage;
import be.syntra.mariokart.model.PlayerScore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SavePlayerScoreController {
    PlayerCharacter character;
    String name;
    double elapsedTime;
    static DataStorage topScores = Main.getTopScores();

    @FXML
    private TextField txtName;

    @FXML
    void saveRecord(ActionEvent event) throws IOException {
        name = txtName.getText();

        //print results in console
        System.out.println("mijn naam: " + name);
        System.out.println(character.getName());
        System.out.println(elapsedTime);

        // creates new playerScore and adds it to topscores list
        PlayerScore playerScore = new PlayerScore(name, character.getName(), elapsedTime);
        topScores.saveRecord(playerScore);
        System.out.println(topScores.readAllRecords().toString());


        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/StartMenu.fxml")));
        Scene scene = new Scene(root, 768, 768);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/Style.css")).toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    public void setCharacter(PlayerCharacter character) {
        this.character = character;
    }

    public void setElapsedTime(double elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
}
