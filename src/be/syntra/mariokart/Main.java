package be.syntra.mariokart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {
//HELLO FROM ROCCO

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(new URL("File:resources/fxml/StartMenu.fxml"));
            Scene scene = new Scene(root, 768, 768);
            scene.getStylesheets().add("File:resources/css/Style.css");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


