package map;

import Main.Vector;
import entities.Character;

public class CollisionDetector {
    private static int tileSize = 64;


    public static int isTileGrass(int x, int y, int[][] mapLayout) {
        return mapLayout[y][x];
    }

    public static double calculateCharacterSpeed(Character character, Map map, int defaultSpeed) {
        int grassCounter = 0;
        int sandCounter = 0;
        int speedPenaltySand = 55;
        int speedPenaltyGrass = 45;
        int speed;

        for(Vector gridPositon: character.getGridPositions()){
            int tileNumber = isTileGrass((int)gridPositon.getX()/map.getSpriteWidth(),
                    (int)gridPositon.getY()/map.getSpriteWidth(), map.getMapLayout());

            if(tileNumber == 0){
                grassCounter++;
            } else if(tileNumber == 2){
                sandCounter++;
            }
        }
        if(defaultSpeed == 300){
            speed = defaultSpeed - sandCounter * speedPenaltySand - grassCounter * speedPenaltyGrass;
        } else{
            int backwardsSpeedPenaltySand = 38;
            int backwardsSpeedPenaltyGrass = 30;
            speed = defaultSpeed - sandCounter * backwardsSpeedPenaltySand - grassCounter * backwardsSpeedPenaltyGrass;
        }
        return speed;
    }


}
