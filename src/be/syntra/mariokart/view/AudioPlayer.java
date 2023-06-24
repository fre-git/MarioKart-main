package be.syntra.mariokart.view;

import javafx.scene.media.AudioClip;

import java.io.File;

// audioPlayer will handle all audio in the game
public class AudioPlayer {
    private final AudioClip applause = new AudioClip(new File("resources/audio/cheerAndApplaus.wav").toURI().toString());

    private final AudioClip audioSelect = new AudioClip(new File("resources/audio/SelectSomething.mp3").toURI().toString());
    private final AudioClip audioNextScreen = new AudioClip(new File("resources/audio/NextScreen.mp3").toURI().toString());
    private final AudioClip drivingAudio = new AudioClip(new File("resources/audio/DrivingShort.wav").toURI().toString());
    private final AudioClip engineAudio = new AudioClip(new File("resources/audio/EngineIdle.wav").toURI().toString());

    public void playAudioSelect() {
        audioSelect.play();
    }

    public void loopEngineAudio(){
        engineAudio.setCycleCount(AudioClip.INDEFINITE);
        engineAudio.play(0.3);
    }

    public void stopEngineAudio(){
        engineAudio.stop();
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

    public void playApplaus(){
        applause.play();
    }

}


