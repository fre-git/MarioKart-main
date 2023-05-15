package entities;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.FileNotFoundException;

public class Character {
    private ImageView imageView;
    private String name;

    private int xDelta = 64;
    private int yDelta = 64;

    public Character(String name, int image) {
        this.name = name;

        Image image1 = switch (image) {
            case 1 -> new Image("File:resources/Mario.png", 64, 64, false, false);
            case 2 -> new Image("File:resources/Luigi.png", 64, 64, false, false);
            case 3 -> new Image("File:resources/Toad.png", 64, 64, false, false);
            case 4 -> new Image("File:resources/Yoshi.png", 64, 64, false, false);
            case 5 -> new Image("File:resources/Peach.png", 64, 64, false, false);
            case 6 -> new Image("File:resources/Bowser.png", 64, 64, false, false);
            default -> new Image("File:resources/Mario.png", 64, 64, false, false);
        };
        imageView = new ImageView(image1);
        this.draw();
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    public void draw() {
        imageView.relocate(xDelta, yDelta);

    }

    public void keyPressed(KeyEvent keyEvent, int speed) throws FileNotFoundException {

        if (keyEvent.getCode() == KeyCode.DOWN) {
            imageView.setRotate(90);
            yDelta += speed;
        }
        if (keyEvent.getCode() == KeyCode.UP) {
            imageView.setRotate(-90);
            yDelta -= speed;
        }
        if (keyEvent.getCode() == KeyCode.LEFT) {
            imageView.setRotate(-180);
            xDelta -= speed;
        }
        if (keyEvent.getCode() == KeyCode.RIGHT) {
            imageView.setRotate(0);
            xDelta += speed;
        }
    }

    public int getXDelta() {
        System.out.println(xDelta);

        return xDelta;
    }

    public int getYDelta() {
        return yDelta;
    }
}
