package be.syntra.mariokart.controller.gamelogic;

import be.syntra.mariokart.model.PlayerCharacter;
import be.syntra.mariokart.model.Map;
import be.syntra.mariokart.model.Vector;

public class SpeedCalculator {
    public static double calculateCharacterSpeed(PlayerCharacter characterPlayer, Map map, int defaultSpeed) {
        int grassCounter = 0;
        int sandCounter = 0;
        double speed;

        //takes 8 points of character as positions, the more of these points are in grass or sand,
        // the slower the car will drive
        for (Vector gridPosition : characterPlayer.getGridPositions()) {
            int tileNumber = CollisionDetector.checkUnderground((int) gridPosition.getX() / map.getSpriteWidth(),
                    (int) gridPosition.getY() / map.getSpriteWidth(), map.getMapLayout());

            if (tileNumber == 0) {
                grassCounter++;
            } else if (tileNumber == 2) {
                sandCounter++;
            }
        }

        // calculates forward speed
        if (defaultSpeed == characterPlayer.getForwardSpeed()) {
            double speedPenaltySand = 14;
            double speedPenaltyGrass = 11;
            speed = defaultSpeed - sandCounter * speedPenaltySand - grassCounter * speedPenaltyGrass;

        //calculates backward speed
        } else if (defaultSpeed == characterPlayer.getBackwardSpeed()){
            double backwardsSpeedPenaltySand = 9.5;
            double backwardsSpeedPenaltyGrass = 7;
            speed = defaultSpeed - sandCounter * backwardsSpeedPenaltySand - grassCounter * backwardsSpeedPenaltyGrass;
        } else {
            speed = 0;
        }
        return speed;
    }
}
