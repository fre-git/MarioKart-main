package be.syntra.mariokart.controller;

import be.syntra.mariokart.model.Character;
import javafx.event.ActionEvent;
import javafx.scene.Scene;

import java.io.IOException;

public interface IController {

    Scene getScene();

    Character getCharacter();
    void switchToNextScene(ActionEvent event) throws IOException;
}
