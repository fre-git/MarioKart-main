package be.syntra.mariokart.controller;

public class CollisionDetector {

    // TODO unused
    private static int tileSize = 64;

    public static int isTileGrass(int x, int y, int[][] mapLayout) {
        return mapLayout[y][x];
    }
}
