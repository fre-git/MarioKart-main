package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
            Scene scene = new Scene(root, 768, 768);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    /*

    @Override
    public void start(Stage stage) throws Exception {
        RaceGamePane raceGamePane = new RaceGamePane();
        Scene scene = new Scene(raceGamePane, 1200, 1200);
        stage.setScene(scene);
        stage.show();
        raceGamePane.requestFocus();
    }

     */
}
