package be.syntra.mariokart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Main extends Application {

    //HELLO FROM ROCCO

    @Override
    public void start(Stage stage) {
        try {
            //"File:resources/images/backgroundpixell.png"
//            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/be/syntra/mariokart/fxml/StartMenu.fxml")));
            Parent root = FXMLLoader.load(new URL("File:resources/fxml/StartMenu.fxml"));
            Scene scene = new Scene(root, 768, 768);
            scene.getStylesheets().add("File:resources/css/style.css");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
