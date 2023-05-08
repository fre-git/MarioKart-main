package Input;

import Main.RaceGamePane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class MouseMoveInput implements EventHandler<MouseEvent> {

    private RaceGamePane raceGamePane;

    public MouseMoveInput(RaceGamePane raceGamePane) {
        this.raceGamePane = raceGamePane;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
    }
}
