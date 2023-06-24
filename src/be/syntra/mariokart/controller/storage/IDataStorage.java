package be.syntra.mariokart.controller.storage;

import be.syntra.mariokart.model.PlayerScore;

import java.io.IOException;
import java.util.List;

public interface IDataStorage {
    void saveRecord(PlayerScore playerScore) throws IOException;


    List<PlayerScore> getTopScores(int amountOfHighscores);
}
