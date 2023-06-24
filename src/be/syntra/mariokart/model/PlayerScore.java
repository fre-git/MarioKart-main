package be.syntra.mariokart.model;

public class PlayerScore {
    private final String name;
    private final String characterName;
    private final double timeToCompleteRace;
    private final String mapName;

    public PlayerScore(String name, String characterName, double timeToCompleteRace, String mapName){
        this.name = name;
        this.characterName = characterName;
        this.timeToCompleteRace = timeToCompleteRace;
        this.mapName = mapName;
    }

    @Override
    // print out player score
    public String toString(){
        return "[" + this.mapName + "] " + this.timeToCompleteRace + "  "  + "  (" +  this.characterName + ")    " +   this.name;
    }

    public String getName() {
        return name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public double getTimeToCompleteRace() {
        return timeToCompleteRace;
    }

    public String getMapName() {
        return mapName;
    }
}
