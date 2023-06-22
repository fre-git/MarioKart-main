package be.syntra.mariokart.controller.gamelogic;

public class CollisionDetector {

    public static int checkUnderground(int x, int y, int[][] mapLayout) {
        return mapLayout[y][x];
    }
}
