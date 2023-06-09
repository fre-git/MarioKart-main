package be.syntra.mariokart.model;

import be.syntra.mariokart.view.ImageSelector;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerCharacter {
    private final int  turningSpeed;
    private int passedCheckout = 0;
    private int lapsFinished = 0;
    private boolean isSurfacePassed = false;
    // player position (8 points)
    private final Vector[] gridPositions = {new Vector(0, 0), new Vector(0, 0), new Vector(0, 0), new Vector(0, 0), new Vector(0, 0), new Vector(0, 0), new Vector(0, 0), new Vector(0, 0)};
    private final String name;
    private final Vector velocity;
    private final Vector position;
    private final int forwardSpeed;
    private final int backwardSpeed;
    private double rotation;
    private final int characterSize = 40;
    private final Image image;
    private final ImageView imageView;
    private final double height;

    public PlayerCharacter(String name, int characterImage, int forwardSpeed, int backwardSpeed, int turningSpeed) {
        this.name = name;
        this.rotation = 0;
        this.velocity = new Vector();
        this.position = new Vector(200, 90);
        this.image = new Image(ImageSelector.getImageResource(characterImage), characterSize, characterSize, false, false);
        imageView = new ImageView(this.image);
        this.height = image.getHeight();
        this.forwardSpeed = forwardSpeed;
        this.backwardSpeed = backwardSpeed;
        this.turningSpeed = turningSpeed;
    }

    public int getTurningSpeed() {
        return turningSpeed;
    }

    public String getName() {
        return name;
    }

    public boolean getSurfacePassed() {
        return isSurfacePassed;
    }

    public void setSurfacePassed(boolean surfacePassed) {
        isSurfacePassed = surfacePassed;
    }

    public Vector getPosition() {
        return position;
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

    public double getHeight() {
        return height;
    }

    public void update(double deltaTime) {
        //update position acoording to velocity (& update rotation of imageview)
        this.getImageView().setRotate(getRotation());
        this.position.add(this.velocity.getX() * deltaTime, this.velocity.getY() * deltaTime);
    }

    //draw the imageView of the playerCharacter on the updated position
    public void draw() {
        imageView.relocate(this.position.getX(), this.position.getY());
    }

    public int getAmountOfCheckPointsPassed() {
        return passedCheckout;
    }

    public void bumpCheckpointsPassed() {
        this.passedCheckout++;
    }

    public void resetCheckpoints() {
        this.passedCheckout = 0;
    }

    public int getLapsFinished() {
        return lapsFinished;
    }

    public void bumpLapFinished() {
        this.lapsFinished++;
    }

    // get 8 vectors (positions) that represents the position of the playerCharacter
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

