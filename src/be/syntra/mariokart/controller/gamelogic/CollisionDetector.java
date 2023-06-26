package be.syntra.mariokart.controller.gamelogic;

public class CollisionDetector {


    //Returns the tile ID the player is currently one for the given X and Y coordinate on the provided map
    public static int checkUnderground(int x, int y, int[][] mapLayout) {
        return mapLayout[y][x];
    }
}
