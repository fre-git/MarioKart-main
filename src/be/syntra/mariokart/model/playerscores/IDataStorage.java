package be.syntra.mariokart.model.playerscores;

import java.util.List;

public interface IDataStorage {
    void saveRecord(PlayerScore playerScore);
    List<PlayerScore> readAllRecords();
}
