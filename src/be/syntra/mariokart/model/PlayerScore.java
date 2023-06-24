package be.syntra.mariokart.model;

public class PlayerScore {
    private String name;
    private String characterName;
    private double timeToCompleteRace;

    public PlayerScore(String name, String characterName, double timeToCompleteRace){
        this.name = name;
        this.characterName = characterName;
        this.timeToCompleteRace = timeToCompleteRace;
    }

    @Override
    // print out player score
    public String toString(){
        return this.timeToCompleteRace + "  " +  this.name + "  (" +  this.characterName + ")";
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


}
