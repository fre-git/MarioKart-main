package be.syntra.mariokart.controller;

import be.syntra.mariokart.controller.storage.CsvStorageAndReader;
import be.syntra.mariokart.controller.storage.IDataStorage;
import be.syntra.mariokart.model.Map;
import be.syntra.mariokart.model.PlayerScore;
import javafx.application.Platform;
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
    private final IDataStorage topScores = new CsvStorageAndReader();

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

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> topscoresList.getItems().addAll(topScores.getTopScores(10, map.getMapName())));
    }
}
