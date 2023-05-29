package entities;

import Main.Vector;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Character {

    private String name;
    private Vector velocity;
    private Vector position;
    Vector[] gridPositions = {new Vector(0, 0), new Vector(0, 0), new Vector(0, 0), new Vector(0, 0), new Vector(0, 0)};
    private Vector startPosition = new Vector(70, 70);
    private double rotation;
    private int characterSize = 32;
    private Image image;
    private ImageView imageView;


    public Character(String name, int characterImage) {
        this.name = name;
        this.rotation = 0;
        this.velocity = new Vector();
        this.position = startPosition;
        this.image = new Image(getImageResource(characterImage), characterSize, characterSize, false, false);
        imageView = new ImageView(this.image);
    }

    public String getImageResource(int characterImage) {
        String characterImageResource;
        switch (characterImage) {
            case 1 -> characterImageResource = "File:resources/Mario.png";
            case 2 -> characterImageResource = "File:resources/Luigi.png";
            case 3 -> characterImageResource = "File:resources/Toad.png";
            case 4 -> characterImageResource = "File:resources/Yoshi.png";
            case 5 -> characterImageResource = "File:resources/Peach.png";
            case 6 -> characterImageResource = "File:resources/Bowser.png";
            default -> characterImageResource = "File:resources/Mario.png";
        }
        return characterImageResource;
    }

    //calculates points of contact from car with surface
    public Vector[] getGridPositions() {
        int offset = 2;
        gridPositions[0].set(position.getX() + offset * 2, position.getY() + offset);
        gridPositions[1].set(position.getX() + characterSize - offset * 2, position.getY() + offset);
        gridPositions[2].set(position.getX() + characterSize / 2, position.getY() + characterSize / 2);

        gridPositions[3].set(position.getX(), position.getY() + characterSize - offset);
        gridPositions[4].set(position.getX() + characterSize, position.getY() + characterSize - offset);
        return gridPositions;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(double speed) {
        this.velocity.setLength(speed);
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation += rotation;
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    public void update(double deltaTime) {
        //update position acoording to velocity
        this.position.add(this.velocity.getX() * deltaTime, this.velocity.getY() * deltaTime);
    }

    public void draw() {
        imageView.relocate(this.position.getX(), this.position.getY());
    }
}

