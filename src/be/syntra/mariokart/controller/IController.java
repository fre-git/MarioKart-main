package be.syntra.mariokart.controller;

import be.syntra.mariokart.model.PlayerCharacter;
import javafx.event.ActionEvent;
import javafx.scene.Scene;

import java.io.IOException;

public interface IController {

    Scene getScene();

    PlayerCharacter getCharacter();
    void switchToNextScene(ActionEvent event) throws IOException;
}
