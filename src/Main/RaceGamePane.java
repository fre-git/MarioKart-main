package Main;

import Input.KeyboardInput;

import entities.Character;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class RaceGamePane extends Pane implements Runnable {

    private Thread thread;

    private final int FPS_SET = 30;

    private Character character;

    public RaceGamePane(Character character) {
        this.character = character;
        setWidth(700);
        setHeight(700);

        setOnKeyPressed(new KeyboardInput(this));

        thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        double timePerFrame = FPS_SET;
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
