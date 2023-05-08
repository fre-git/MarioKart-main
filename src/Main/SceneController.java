package Main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SwitchToCharacterSelect(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CharacterSelect.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 768, 768);


        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();

    }




    public void SwitchToGameScene(ActionEvent event) throws IOException {

        //RaceGamePane raceGamePane = new RaceGamePane();
        //Scene scene = new Scene(raceGamePane, 1200, 1200);

        root = new RaceGamePane();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 700,700);
        stage.setScene(scene);
        stage.show();
        root.requestFocus();

    }


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

    @FXML
    void SelectCharacter1(ActionEvent event) {

    }

    @FXML
    void SelectCharacter2(ActionEvent event) {

    }

    @FXML
    void SelectCharacter3(ActionEvent event) {

    }

    @FXML
    void SelectCharacter4(ActionEvent event) {

    }

    @FXML
    void SelectCharacter5(ActionEvent event) {

    }

    @FXML
    void SelectCharacter6(ActionEvent event) {

    }


}
