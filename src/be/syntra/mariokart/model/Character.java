package be.syntra.mariokart.model;

import be.syntra.mariokart.view.ImageSelector;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Character {

    private Vector[] gridPositions = {new Vector(0, 0), new Vector(0, 0), new Vector(0, 0), new Vector(0, 0), new Vector(0, 0), new Vector(0, 0), new Vector(0, 0), new Vector(0, 0)};
    private String name; // TODO wordt nie gebruikt
    private Vector velocity;
    private Vector position;
    private int forwardSpeed = 120; // TODO mag final, verandert nooit
    private int backwardSpeed = 80;
    private double rotation;
    private int characterSize = 40;
    private Image image;
    private ImageView imageView;

    public Character(String name, int characterImage) {
        this.name = name;
        this.rotation = 0;
        this.velocity = new Vector();
        this.position = new Vector(60, 60);
        this.image = new Image(ImageSelector.getImageResource(characterImage), characterSize, characterSize, false, false);
        imageView = new ImageView(this.image);
    }

    public int getForwardSpeed() {
        return forwardSpeed;
    }

    public int getBackwardSpeed() {
        return backwardSpeed;
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
        //update position acoording to velocity (& update rotation of imageview)
        this.getImageView().setRotate(getRotation());
        this.position.add(this.velocity.getX() * deltaTime, this.velocity.getY() * deltaTime);
    }

    public void draw() {
        imageView.relocate(this.position.getX(), this.position.getY());
    }

    public Vector[] getGridPositions() {
        int offset = 2;
        int bigOffset = 8;
        gridPositions[0].set(position.getX() + offset * 2, position.getY() + offset);
        gridPositions[1].set(position.getX() + characterSize - offset * 2, position.getY() + offset);
        gridPositions[2].set(position.getX(), position.getY() + characterSize - offset);
        gridPositions[3].set(position.getX() + characterSize, position.getY() + characterSize - offset);
        gridPositions[4].set(position.getX() + bigOffset, position.getY() + bigOffset);
        gridPositions[5].set(position.getX() + characterSize - bigOffset, position.getY() + bigOffset);
        gridPositions[6].set(position.getX() + bigOffset, position.getY() + characterSize - bigOffset);
        gridPositions[7].set(position.getX() + characterSize - bigOffset, position.getY() + characterSize - bigOffset);
        return gridPositions;
    }
}

