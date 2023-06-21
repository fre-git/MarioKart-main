package be.syntra.mariokart.model.playerscores;

import java.util.ArrayList;
import java.util.List;

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
