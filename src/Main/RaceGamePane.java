package Main;


import java.util.Objects;
import javafx.scene.layout.Pane;

public class RaceGamePane extends Pane {

    public RaceGamePane() {
        //getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        setWidth(768);
        setHeight(768);
    }
}