package be.syntra.mariokart.view;

import javafx.scene.media.AudioClip;

import java.io.File;

public class AudioPlayer {
    private final AudioClip audioSelect = new AudioClip(new File("resources/audio/selectSomething.mp3").toURI().toString());
    private final AudioClip audioNextScreen = new AudioClip(new File("resources/audio/nextScreen.mp3").toURI().toString());
    private final AudioClip drivingAudio = new AudioClip(new File("resources/audio/drivingShort.wav").toURI().toString());
    private final AudioClip engineAudio = new AudioClip(new File("resources/audio/engineIdle.wav").toURI().toString());


    public void playAudioSelect() {
        audioSelect.play();
    }

    public void loopEngineAudio(){
        engineAudio.setCycleCount(AudioClip.INDEFINITE);
        engineAudio.play(0.3);
    }

    public void playAudioNextScreen() {
        audioNextScreen.play();
    }

    public void playDrivingAudio(){
        drivingAudio.play();
    }

    public void stopDrivingAudio(){
        drivingAudio.stop();
    }

    public AudioClip getDrivingAudio() {
        return drivingAudio;
    }

}


