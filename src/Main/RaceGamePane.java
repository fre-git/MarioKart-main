package Main;

import Input.KeyboardInput;
import entities.Character;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.util.Objects;

public class RaceGamePane extends Pane implements Runnable {

    private final int FPS_SET = 1;
    private Thread thread;
    private Character character;

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
        character.draw();
    }

    public void keyPressed(KeyEvent keyEvent) throws FileNotFoundException {
        character.keyPressed(keyEvent);
    }
}
