package Main;

import Input.KeyboardInput;
import Input.MouseClickInput;
import Input.MouseMoveInput;
import entities.Character;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class RaceGamePane extends Pane implements Runnable {

    private Thread thread;

    private final int FPS_SET = 120;

    private Character character;

    public RaceGamePane() {
        setWidth(700);
        setHeight(700);

        setOnKeyPressed(new KeyboardInput(this));
        setOnMouseClicked(new MouseClickInput(this));
        setOnMouseMoved(new MouseMoveInput(this));

        character = new Character("Mario", 1, this);

        thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        double timePerFrame = 100000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();

        while (true) {
            if (System.nanoTime() - lastFrame >= timePerFrame) {
                paintComponent();
            }
        }
    }

    private void paintComponent() {
        character.draw();
    }

    public void keyPressed(KeyEvent keyEvent){
        character.keyPressed(keyEvent);
    }
}
