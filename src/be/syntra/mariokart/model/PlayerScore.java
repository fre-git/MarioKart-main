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
        String playerScore = this.timeToCompleteRace + "  " +  this.name + "  (" +  this.characterName + ")" ;
        return playerScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public double getTimeToCompleteRace() {
        return timeToCompleteRace;
    }

    public void setTimeToCompleteRace(double timeToCompleteRace) {
        this.timeToCompleteRace = timeToCompleteRace;
    }

}
