package be.syntra.mariokart.controller;

import be.syntra.mariokart.Main;
import be.syntra.mariokart.controller.storage.DataStorage;
import be.syntra.mariokart.model.Map;
import be.syntra.mariokart.model.PlayerScore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class TopscoresController implements Initializable {
    static DataStorage topScoresTrack1 = Main.getTopScoresTrack1();
    private Map map;

    @FXML
    private ListView<PlayerScore> topscoresList;

    @FXML
    public void goToStartScreen(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/StartMenu.fxml")));
        Scene scene = new Scene(root, 768, 768);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/Style.css")).toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        topscoresList.getItems().addAll(topScoresTrack1.getTopScores());
    }


}
