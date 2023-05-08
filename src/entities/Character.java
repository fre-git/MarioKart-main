package entities;

import Main.RaceGamePane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class Character {

    private String name;

    private int speed = 10;

    private float xDelta = 100;
    private float yDelta = 100;
    private Image image;

    private ImageView imageView;

    public Character(String name, int image, RaceGamePane raceGamePane) {
        this.name = name;
        if (image == 1) {
            this.image = new Image("File:resources/Mario.png", 128,128,false,false);
        } else {
            this.image = new Image("File:resources/Luigi.png", 128,128,false,false);
        }
        imageView = new ImageView(this.image);
        this.draw();
        raceGamePane.getChildren().add(imageView);
    }

    public void draw() {
        imageView.relocate(xDelta, yDelta);
    }

    public void keyPressed(KeyEvent keyEvent){
        switch (keyEvent.getCode()) {
            case DOWN:
                imageView.setRotate(90);
                yDelta+= speed;
                break;
            case UP:
                imageView.setRotate(-90);
                yDelta-= speed;
                break;
            case LEFT:
                imageView.setRotate(-180);
                xDelta -= speed;
                break;
            case RIGHT:
                imageView.setRotate(0);
                xDelta+= speed;
                break;
        }
    }
}
