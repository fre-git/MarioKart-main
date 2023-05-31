package Main;

import Input.KeyboardInput;
import entities.Character;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import map.Map;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.logging.Level;

import static map.CollisionDetector.isTileGrass;

public class RaceGamePane extends Pane implements Runnable {

    private final int FPS_SET = 1;
    private Thread thread;
    private Character character;
    private Map map;

    public RaceGamePane() {
        getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        setWidth(768);
        setHeight(768);
        setOnKeyPressed(new KeyboardInput(this));
        thread = new Thread(this);
        thread.start();
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public void run() {
        long lastFrame = System.nanoTime();


        while (true) {
            if (System.nanoTime() - lastFrame >= FPS_SET) {
                paintComponent();
            }
        }
    }

    private void paintComponent() {
        if (character != null) {
            character.draw();
        }
    }

    public void keyPressed(KeyEvent keyEvent) throws FileNotFoundException {
        int speed = 10;

        double x = character.getXDelta();
        double y = character.getYDelta();


        if (keyEvent.getCode() == KeyCode.DOWN) {
            y = Math.ceil(++y / 64);
            x = x / 64;
        }
        if (keyEvent.getCode() == KeyCode.UP) {
            y = Math.floor(--y / 64);
            x = x / 64;
        }
        if (keyEvent.getCode() == KeyCode.LEFT) {
            x = Math.floor(--x / 64);
            y = y / 64;
        }
        if (keyEvent.getCode() == KeyCode.RIGHT) {
            x = Math.ceil(++x / 64);
            y = y / 64;
        }

        if (isTileGrass((int) x, (int) y, map.getMapLayout())) {
            character.keyPressed(keyEvent, speed / 2);
        } else {
            character.keyPressed(keyEvent, speed);
        }
    }
}
