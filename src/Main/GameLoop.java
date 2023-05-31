package Main;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import map.CollisionDetector;

import java.util.ArrayList;

class GameLoop extends AnimationTimer {

    private final SceneController sceneController;
    private final ArrayList<String> keyPressedList;

    private long lastTime;

    public GameLoop(SceneController sceneController, ArrayList<String> keyPressedList) {
        this.sceneController = sceneController;
        this.keyPressedList = keyPressedList;
    }

    @Override
    public void handle(long currentTimeNano) {

        long frameDelta = currentTimeNano - lastTime;
        lastTime = currentTimeNano;

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

        double deltaTime = frameDelta / 600_000_000f;

        //process user input
        if (keyPressedList.contains("LEFT")) {
            sceneController.character.setRotation((int) (-3f / (1/60f) * deltaTime));
            sceneController.character.getImageView().setRotate(sceneController.character.getRotation());
            sceneController.character.setVelocity((int) (-3f / (1/60f) * deltaTime));
        }
        if (keyPressedList.contains("RIGHT")) {
            sceneController.character.setRotation((int) (3f / (1/60f) * deltaTime));
            sceneController.character.getImageView().setRotate(sceneController.character.getRotation());
            sceneController.character.setVelocity((int) (-3f / (1/60f) * deltaTime));
        }
        if (keyPressedList.contains("DOWN")) {
            sceneController.character.setVelocity(CollisionDetector.calculateCharacterSpeed(sceneController.character, sceneController.map, sceneController.character.getBackwardSpeed()));
            sceneController.character.getVelocity().setAngle(sceneController.character.getRotation() + 180);
            sceneController.character.getImageView().setRotate(sceneController.character.getRotation());
        }
        if (keyPressedList.contains("UP")) {
            sceneController.character.setVelocity(CollisionDetector.calculateCharacterSpeed(sceneController.character, sceneController.map, sceneController.character.getForwardSpeed()));
            sceneController.character.getVelocity().setAngle(sceneController.character.getRotation());
            sceneController.character.getImageView().setRotate(sceneController.character.getRotation());

        } else if (!keyPressedList.contains("DOWN")) { // not pressing down
            sceneController.character.setVelocity(0);
        }



        sceneController.character.update(deltaTime);
        sceneController.character.draw();

        sceneController.velocityTextField.setText(String.format("SPEED: %.2f", sceneController.character.getVelocity().getLenght()));

    }
}
