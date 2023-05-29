package Main;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import map.CollisionDetector;

import java.util.ArrayList;

class GameLoop extends AnimationTimer {

    private final SceneController sceneController;
    private final ArrayList<String> keyPressedList;

    public GameLoop(SceneController sceneController, ArrayList<String> keyPressedList) {
        this.sceneController = sceneController;
        this.keyPressedList = keyPressedList;
    }

    @Override
    public void handle(long l) {

        sceneController.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyPressed) {
                String keyName = keyPressed.getCode().toString();
                // avoid adding duplicates to list
                if (!keyPressedList.contains(keyName)) {
                    keyPressedList.add(keyName);
                    //keyJustPressedList.add(keyName);
                }
            }
        });

        sceneController.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyReleased) {
                String keyName = keyReleased.getCode().toString();
                keyPressedList.remove(keyName);
            }
        });

        double deltaTime = 1 / 60f;
        int normalSpeed = 300;
        int backwardSpeed = 200;
        //process user input
        if (keyPressedList.contains("LEFT")) {
            sceneController.character.setRotation(-4);
            sceneController.character.getImageView().setRotate(sceneController.character.getRotation());
            sceneController.character.setVelocity(4);
        }
        if (keyPressedList.contains("RIGHT")) {
            sceneController.character.setRotation(4);
            sceneController.character.getImageView().setRotate(sceneController.character.getRotation());
            sceneController.character.setVelocity(4);
        }
        if (keyPressedList.contains("DOWN")) {
            sceneController.character.setVelocity(CollisionDetector.calculateCharacterSpeed(sceneController.character, sceneController.map, backwardSpeed));
            sceneController.character.getVelocity().setAngle(sceneController.character.getRotation() + 180);
            sceneController.character.getImageView().setRotate(sceneController.character.getRotation());
        }
        if (keyPressedList.contains("UP")) {
            sceneController.character.setVelocity(CollisionDetector.calculateCharacterSpeed(sceneController.character, sceneController.map, normalSpeed));
            sceneController.character.getVelocity().setAngle(sceneController.character.getRotation());
            sceneController.character.getImageView().setRotate(sceneController.character.getRotation());

        } else if (!keyPressedList.contains("DOWN")) { // not pressing up
            sceneController.character.setVelocity(0);
        }

        sceneController.character.update(deltaTime);
        sceneController.character.draw();

        sceneController.velocityTextField.setText(String.format("Snelheid: %.2f", sceneController.character.getVelocity().getLenght()));

    }



        /*

    @Override
    public void handle(long l) {
        double deltaTime = 1 / 60f;

        int normalSpeed = 300;
        int speedPenaltySand = 70;
        int speedPenaltyGrass = 65;

        int backwardSpeed = 200;
        //process user input
        if (keyPressedList.contains("LEFT")) {
            sceneController.character.rotation -= 4;
            sceneController.character.getImageView().setRotate(sceneController.character.rotation);
            sceneController.character.velocity.setLength(4);
        }
        if (keyPressedList.contains("RIGHT")) {
            sceneController.character.rotation += 4;
            sceneController.character.getImageView().setRotate(sceneController.character.rotation);
            sceneController.character.velocity.setLength(4);
        }
        if (keyPressedList.contains("UP")) {
            int gridPointsSand = sceneController.character.getSurfaceColorGrid(sandColorHashCode);
            int gridPointsGrass = sceneController.character.getSurfaceColorGrid(grassColorHashCode);

            sceneController.character.velocity.setLength(normalSpeed - gridPointsSand * speedPenaltySand - gridPointsGrass * speedPenaltyGrass);

            sceneController.character.velocity.setAngle(sceneController.character.rotation);
            sceneController.character.getImageView().setRotate(sceneController.character.rotation);

        } else { // not pressing up
            sceneController.character.velocity.setLength(0);
        }

        if (keyPressedList.contains("DOWN")) {
            int gridPointsSand = sceneController.character.getSurfaceColorGrid(sandColorHashCode);
            int gridPointsGrass = sceneController.character.getSurfaceColorGrid(grassColorHashCode);

            sceneController.character.velocity.setLength(backwardSpeed - gridPointsSand * 48 - gridPointsGrass * 44);

            sceneController.character.velocity.setAngle(sceneController.character.rotation + 180);
            sceneController.character.getImageView().setRotate(sceneController.character.rotation);
        }
        sceneController.character.update(deltaTime);
        sceneController.character.draw();

        sceneController.velocityTextField.setText(String.format("Snelheid: %.2f", sceneController.character.getVelocity().getLenght()));

    */


}
