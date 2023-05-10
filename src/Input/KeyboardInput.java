package Input;

import Main.RaceGamePane;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

import java.io.FileNotFoundException;

public class KeyboardInput implements EventHandler<KeyEvent> {
    private final RaceGamePane raceGamePane;

    public KeyboardInput(RaceGamePane raceGamePane) {
        this.raceGamePane = raceGamePane;
    }

    @Override
    public void handle(KeyEvent e) {
        try {
            raceGamePane.keyPressed(e);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }




}

