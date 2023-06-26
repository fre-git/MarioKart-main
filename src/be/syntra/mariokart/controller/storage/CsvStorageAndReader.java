package be.syntra.mariokart.controller.storage;

import be.syntra.mariokart.model.PlayerScore;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CsvStorageAndReader implements IDataStorage {
    private final List<PlayerScore> topScores = new ArrayList<>();
    private FileWriter csvFileWriter;
    private final BufferedWriter bufferedWriter;

    private final File csvFile = new File("resources/csv/topscores.csv");

    public CsvStorageAndReader(){
        try {
            csvFileWriter = new FileWriter("resources/csv/topscores.csv", true);
            bufferedWriter = new BufferedWriter(csvFileWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveRecord(PlayerScore playerScore) throws IOException {
        topScores.add(playerScore);
        bufferedWriter.write(playerScore.getName() + ";" + playerScore.getCharacterName() + ";" + playerScore.getTimeToCompleteRace() + ";" + playerScore.getMapName());
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }


    public List<PlayerScore> readAllRecords() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))) {
            String Line = bufferedReader.readLine();
            List<PlayerScore> playerScores = new ArrayList<>();
            while (Line != null) {
                String[] colum = Line.split(";");
                PlayerScore playerScore = new PlayerScore(colum[0], colum[1], Double.valueOf(colum[2]), colum[3]);
                playerScores.add(playerScore);
                Line = bufferedReader.readLine();
            }
            return playerScores;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PlayerScore> getTopScores(int amountOfHighscores, String mapName) {
        return readAllRecords().stream()
                .filter(playerScore -> playerScore.getMapName().equals(mapName))
                .sorted(Comparator.comparing(PlayerScore::getTimeToCompleteRace))
                .limit(amountOfHighscores)
                .toList();
    }
}
