package be.syntra.mariokart.controller;

import be.syntra.mariokart.controller.CollisionDetector;
import be.syntra.mariokart.model.Character;
import be.syntra.mariokart.model.Map;
import be.syntra.mariokart.model.Vector;

public class SpeedCalculator {
    public static double calculateCharacterSpeed(Character character, Map map, int defaultSpeed) {
        int grassCounter = 0;
        int sandCounter = 0;
        int speed;

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
            int speedPenaltySand = 14;
            int speedPenaltyGrass = 11;
            speed = defaultSpeed - sandCounter * speedPenaltySand - grassCounter * speedPenaltyGrass;
        } else {
            int backwardsSpeedPenaltySand = 28;
            int backwardsSpeedPenaltyGrass = 20;
            speed = defaultSpeed - sandCounter * backwardsSpeedPenaltySand - grassCounter * backwardsSpeedPenaltyGrass;
        }
        return speed;
    }
}
