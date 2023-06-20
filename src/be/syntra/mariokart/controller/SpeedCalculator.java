package be.syntra.mariokart.controller;

import be.syntra.mariokart.controller.CollisionDetector;
import be.syntra.mariokart.model.Character;
import be.syntra.mariokart.model.Map;
import be.syntra.mariokart.model.Vector;

public class SpeedCalculator {
    public static double calculateCharacterSpeed(Character character, Map map, int defaultSpeed) {
        int grassCounter = 0;
        int sandCounter = 0;
        double speed;

        for (Vector gridPosition : character.getGridPositions()) {
            int tileNumber = CollisionDetector.isTileGrass((int) gridPosition.getX() / map.getSpriteWidth(),
                    (int) gridPosition.getY() / map.getSpriteWidth(), map.getMapLayout());

            if (tileNumber == 0) {
                grassCounter++;
            } else if (tileNumber == 2) {
                sandCounter++;
            }
        }
        if (defaultSpeed == character.getForwardSpeed()) {
            double speedPenaltySand = 14;
            double speedPenaltyGrass = 11;
            speed = defaultSpeed - sandCounter * speedPenaltySand - grassCounter * speedPenaltyGrass;
        } else if (defaultSpeed == character.getBackwardSpeed()){
            double backwardsSpeedPenaltySand = 9.5;
            double backwardsSpeedPenaltyGrass = 7;
            speed = defaultSpeed - sandCounter * backwardsSpeedPenaltySand - grassCounter * backwardsSpeedPenaltyGrass;
        } else {
            speed = 0;
        }
        return speed;
    }
}
