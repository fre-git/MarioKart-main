package be.syntra.mariokart.controller.storage;

import be.syntra.mariokart.model.PlayerScore;

import java.util.List;

public interface IDataStorage {
    void saveRecord(PlayerScore playerScore);
    List<PlayerScore> readAllRecords();
}
