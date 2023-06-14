package be.syntra.mariokart.controller;

import be.syntra.mariokart.view.AudioPlayer;
import javafx.animation.AnimationTimer; // TODO ideaal zou zijn hier geen javafx
import javafx.scene.input.KeyCode;
import java.util.ArrayList;

public class GameLoop extends AnimationTimer {

    public static final float TURNING_SPEED = 3f / (1 / 60f);

    private final be.syntra.mariokart.controller.CharacterSelectController controller;

    private final ArrayList<KeyCode> keyPressedList;
    AudioPlayer audioPlayer = new AudioPlayer();

    private long lastTime;

    public GameLoop(be.syntra.mariokart.controller.CharacterSelectController controller, ArrayList<KeyCode> keyPressedList) {
        audioPlayer.loopEngineAudio();
        this.controller = controller;
        this.keyPressedList = keyPressedList;
    }

    @Override
    public void handle(long currentTimeNano) {
        long frameDelta = currentTimeNano - lastTime;
        lastTime = currentTimeNano;

        controller.getScene().setOnKeyPressed(keyPressed -> {
            // avoid adding duplicates to list
            if (!keyPressedList.contains(keyPressed.getCode())) {
                keyPressedList.add(keyPressed.getCode());
            }
        });

        controller.getScene().setOnKeyReleased(keyReleased -> {
            if (keyReleased.getCode().equals(KeyCode.UP)) {
                audioPlayer.stopDrivingAudio();
            }
            keyPressedList.remove(keyReleased.getCode());
        });

        double deltaTime = frameDelta / 600_000_000f;

        if (keyPressedList.contains(KeyCode.LEFT)) {
            controller.getCharacter().setRotation((int) (-TURNING_SPEED * deltaTime));
            controller.getCharacter().setVelocity((int) (-TURNING_SPEED * deltaTime));
        }
        if (keyPressedList.contains(KeyCode.RIGHT)) {
            controller.getCharacter().setRotation((int) (TURNING_SPEED * deltaTime));
            controller.getCharacter().setVelocity((int) (-TURNING_SPEED * deltaTime));
        }
        if (keyPressedList.contains(KeyCode.DOWN)) {
            controller.getCharacter().setVelocity(SpeedCalculator.calculateCharacterSpeed(controller.getCharacter(), controller.getMap(), controller.getCharacter().getBackwardSpeed()));
            controller.getCharacter().getVelocity().setAngle(controller.getCharacter().getRotation() + 180);
        }
        if (keyPressedList.contains(KeyCode.UP)) {
            if(!audioPlayer.getDrivingAudio().isPlaying()){
                audioPlayer.playDrivingAudio();
            }

            controller.getCharacter().setVelocity(SpeedCalculator.calculateCharacterSpeed(controller.getCharacter(), controller.getMap(), controller.getCharacter().getForwardSpeed()));
            controller.getCharacter().getVelocity().setAngle(controller.getCharacter().getRotation());

        } else if (!keyPressedList.contains(KeyCode.DOWN)) { // not pressing down
            controller.getCharacter().setVelocity(0);
        }

        controller.getCharacter().update(deltaTime);
        controller.getCharacter().draw();

        controller.getVelocityTextField().setText(String.format("SPEED: %.2f", controller.getCharacter().getVelocity().getLength()));
    }
}
