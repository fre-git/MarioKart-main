package be.syntra.mariokart.controller.gamelogic;

import be.syntra.mariokart.controller.CharacterSelectController;
import be.syntra.mariokart.controller.IController;
import be.syntra.mariokart.model.PlayerCharacter;
import be.syntra.mariokart.view.AudioPlayer;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;

import java.io.IOException;
import java.util.ArrayList;

//Animates the character and handle most of the game logic
public class GameLoop extends AnimationTimer {

    AudioPlayer audioPlayer = new AudioPlayer();
    private final CharacterSelectController controller;

    //input is added in an arrayList for smoother input calculation
    private final ArrayList<KeyCode> keyPressedList;

    //time at start of the race
    private long startTime = System.currentTimeMillis();
    private long lastTime;
    private final int lapsToFinnish = 3;
    private final int numberOfCheckpoints = 3;
    //public static final float TURNING_SPEED = 2.5f / (1 / 60f);

    public GameLoop(IController controller, ArrayList<KeyCode> keyPressedList) {
        audioPlayer.loopEngineAudio();
        this.controller = (CharacterSelectController) controller;
        this.keyPressedList = keyPressedList;
    }

    @Override
    //handles all the input that is continuously detected
    public void handle(long currentTimeNano) {

        //fix gameSpeed by frame rate
        long frameDelta = currentTimeNano - lastTime;
        lastTime = currentTimeNano;
        long elapsedTime = System.currentTimeMillis() - startTime;
        double deltaTime = frameDelta / 600_000_000f;


        controller.getScene().setOnKeyPressed(keyPressed -> {
            // avoid adding duplicates to list & adds pressed key to the keyPressedList
            if (!keyPressedList.contains(keyPressed.getCode())) {
                keyPressedList.add(keyPressed.getCode());
            }
        });

        //on key release, remove this key from the keyPressedList
        controller.getScene().setOnKeyReleased(keyReleased -> {
            if (keyReleased.getCode().equals(KeyCode.UP) || keyReleased.getCode().equals(KeyCode.DOWN)) {
                audioPlayer.stopDrivingAudio();
            }
            keyPressedList.remove(keyReleased.getCode());
        });

        //when escape is pressed, go to start screen
        if (keyPressedList.contains(KeyCode.ESCAPE)) {
            try {
                controller.escape();
                audioPlayer.stopEngineAudio();
                this.stop();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        PlayerCharacter character = controller.getCharacter();

        if (keyPressedList.contains(KeyCode.LEFT)) {
            character.setRotation((int) (-character.getTurningSpeed() * deltaTime));
            character.setVelocity((int) (-character.getTurningSpeed() * deltaTime));
        }
        if (keyPressedList.contains(KeyCode.RIGHT)) {
            character.setRotation((int) (character.getTurningSpeed() * deltaTime));
            character.setVelocity((int) (-character.getTurningSpeed() * deltaTime));
        }
        if (keyPressedList.contains(KeyCode.DOWN)) {
            if (!audioPlayer.getDrivingAudio().isPlaying()) {
                audioPlayer.playDrivingAudio();
            }
            //set the backward speed of the playerCharacter
            character.setVelocity(SpeedCalculator.calculateCharacterSpeed(character,
                    controller.getMap(), character.getBackwardSpeed()));

            //set the direction of the playerCharacter driving backwards
            character.getVelocity().setAngle(character.getRotation() + 180);
        }
        if (keyPressedList.contains(KeyCode.UP)) {
            if (!audioPlayer.getDrivingAudio().isPlaying()) {
                audioPlayer.playDrivingAudio();
            }

            //set forward speed of playerCharacter
            character.setVelocity(SpeedCalculator.calculateCharacterSpeed(character,
                    controller.getMap(), character.getForwardSpeed()));
            //set direction for playerCharacter
            character.getVelocity().setAngle(character.getRotation());

        } else if (!keyPressedList.contains(KeyCode.DOWN)) { // not pressing down
            character.setVelocity(0);
        }

        //update position & velocity of character & then redraws it
        character.update(deltaTime);
        character.draw();

        //set texts for gameScreen
        controller.getLapsText().setText("LAPS: " + character.getLapsFinished() + "/" + lapsToFinnish);
        controller.getCheckpointsText().setText("checkpoints: " + character.getAmountOfCheckPointsPassed() + "/" + numberOfCheckpoints);
        controller.getElapsedTimeTextField().setText(String.valueOf((double) elapsedTime / 1000));

        checkCheckpoints();
    }

    public void checkCheckpoints() {
        PlayerCharacter character = controller.getCharacter();

        // checks on what tile the playerCharacter is
        int tileNumber = CollisionDetector.checkUnderground(
                (int) (character.getPosition().getX() + character.getHeight() / 2)
                        / controller.getMap().getSpriteWidth(),
                (int) (character.getPosition().getY() + character.getHeight()/2)
                        / controller.getMap().getSpriteWidth(),
                controller.getMap().getMapLayout());

        //if tileNumber = 4 -> bump checkpoint
        if (tileNumber == 4) {
            if (!character.getSurfacePassed()) {
                character.bumpCheckpointsPassed();
                character.setSurfacePassed(true);
            }
        //if tilenumber = 3 -> bump lap
        } else if (tileNumber == 3) {
            if (character.getAmountOfCheckPointsPassed() >= 3) {
                if (!character.getSurfacePassed()) {
                    character.bumpLapFinished();
                    character.setSurfacePassed(true);
                    character.resetCheckpoints();
                }
            }
        } else {
            character.setSurfacePassed(false);
        }
        // all laps finnished
        if(character.getLapsFinished() >= lapsToFinnish){
            audioPlayer.stopEngineAudio();
            try {
                controller.escape();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
