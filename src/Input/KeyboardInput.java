package Input;

import Main.RaceGamePane;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyboardInput implements EventHandler<KeyEvent> {
    private RaceGamePane raceGamePane;

    public KeyboardInput(RaceGamePane raceGamePane) {
        this.raceGamePane = raceGamePane;

    }

    @Override
    public void handle(KeyEvent e) {
        raceGamePane.keyPressed(e);
    }




}

