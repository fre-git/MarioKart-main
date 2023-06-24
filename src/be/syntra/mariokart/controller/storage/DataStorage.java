package be.syntra.mariokart.controller.storage;

import be.syntra.mariokart.model.PlayerScore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DataStorage implements IDataStorage {
    private final List<PlayerScore> topScores = new ArrayList<>();

    @Override
    public void saveRecord(PlayerScore playerScore) {
        topScores.add(playerScore);
    }

    @Override
    public List<PlayerScore> readAllRecords() {
        return topScores;
    }

    public List<PlayerScore> getTopScores() {
        return topScores;
    }

  public void sortTopTen(){
      topScores.sort(Comparator.comparing(playerScore -> playerScore.getTimeToCompleteRace()));
  }
}
