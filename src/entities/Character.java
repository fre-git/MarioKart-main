package entities;

import Main.Vector;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Character {

    private Vector velocity;
    private Vector position;
    private double rotation;
    private String name;
    private ImageView imageView;

    public Character(String name, int image) {
        this.name = name;
        this.rotation = 0;
        this.velocity = new Vector();
        this.position = new Vector(50, 50);

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


            /*
        if (image == 1) {
            this.image = new Image("File:resources/Mario.png", 128,128,false,false);
        } else {
            this.image = new Image("File:resources/Luigi.png", 128,128,false,false);
        }
        imageView = new ImageView(this.image);
        this.draw();
             */
        //raceGamePane.getChildren().add(imageView);
    }


    public int getSurface() throws FileNotFoundException {
        int halfWidth = 32;
        FileInputStream inputstream = new FileInputStream("resources/raceColors1.png");
        Image image = new Image(inputstream);
        PixelReader pixelReader = image.getPixelReader();
        return pixelReader.getColor((int) position.getX() + halfWidth, (int) position.getY() + halfWidth).hashCode();
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    public void update(double deltaTime) {
        //update position acoording to velocity
        this.position.add(this.velocity.getX() * deltaTime, this.velocity.getY() * deltaTime);
    }

    public void draw() {
        //imageView.relocate(getxDelta(),getyDelta());
        imageView.relocate(this.position.getX(), this.position.getY());
    }

    public void keyPressed(KeyEvent keyEvent) throws FileNotFoundException {

        switch (keyEvent.getCode()) {
            case DOWN -> {
                if (this.getSurface() == -546232577) {
                    this.velocity.setLength(-30);
                    this.update(1 / 120.0);
                } else if (this.getSurface() == 1790849279) {
                    this.velocity.setLength(-60);
                    this.update(1 / 120.0);
                } else if (this.getSurface() == 255) {
                    this.velocity.setLength(-250);
                    this.update(1 / 120.0);
                } else {
                    this.velocity.setLength(-250);
                    this.update(1 / 120.0);
                }
                this.velocity.setAngle(this.rotation);
            }
            case UP -> {
                if (this.getSurface() == -546232577) {
                    this.update(1 / 120.0);
                    this.velocity.setLength(60);
                } else if (this.getSurface() == 1790849279) {
                    this.update(1 / 120.0);
                    this.velocity.setLength(200);
                } else if (this.getSurface() == 255) {
                    this.update(1 / 120.0);
                    this.velocity.setLength(500);
                }
                this.velocity.setAngle(this.rotation);
            }
            case LEFT -> {
                this.velocity.setLength(5);
                this.rotation -= 10;
                imageView.setRotate(this.rotation);
                this.update(1 / 120.0);
            }
            case RIGHT -> {
                this.velocity.setLength(5);
                this.rotation += 10;
                imageView.setRotate(this.rotation);
                this.update(1 / 120.0);
            }
        }
    }

 /*
    public void keyPressed(KeyEvent keyEvent) throws FileNotFoundException {

        switch (keyEvent.getCode()) {
            case DOWN:
                imageView.setRotate(90);
                yDelta += speed;
                break;
            case UP:
                imageView.setRotate(-90);
                yDelta -= speed;
                break;
            case LEFT:
                imageView.setRotate(-180);
                xDelta -= speed;
                break;
            case RIGHT:
                imageView.setRotate(0);
                xDelta += speed;
                break;
        }
             */

    /*
    public int getxDelta() {
        return xDelta;
    }

    public int getyDelta() {
        return yDelta;
    }



    /*public void setSpeed(int speed) {
        this.speed = speed;
    }

     */
}
