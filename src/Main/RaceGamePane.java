package Main;


import entities.Character;
import javafx.scene.layout.Pane;
import map.Map;

import java.util.Objects;

public class RaceGamePane extends Pane {
    private final int MS_PER_FRAME = 1000 / 60;
    private Thread thread;
    private Character character;
    private GameLoop gameLoop;
    //private KeyboardInput keyboardInput;
    private Map map;


    // private final ArrayList<String> keyPressedList = gameLoop.getKeyPressedList();

    public RaceGamePane() {
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        setWidth(768);
        setHeight(768);
        //setOnKeyPressed(new KeyboardInput(this));
        //thread = new Thread(this);
        //thread.start();
    }

    public void setCharacter(Character character) {
        this.character = character;
        getChildren().add(character.getImageView());
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setGameLoop(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    public GameLoop getGameLoop() {
        return gameLoop;
    }

}