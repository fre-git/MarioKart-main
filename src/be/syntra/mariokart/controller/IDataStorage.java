package be.syntra.mariokart.controller;

import be.syntra.mariokart.model.PlayerScore;

import java.util.ArrayList;
import java.util.List;

public interface IDataStorage {
    void saveRecord(PlayerScore playerScore);
    List<PlayerScore> readAllRecords();

    class DataStorage implements IDataStorage {
        private List<PlayerScore> topScores = new ArrayList<>();

        @Override
        public void saveRecord(PlayerScore playerScore) {
            topScores.add(playerScore);
        }

        @Override
        public List<PlayerScore> readAllRecords() {
            return topScores;
        }
    }
}
