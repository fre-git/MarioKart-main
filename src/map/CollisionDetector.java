package map;

public class CollisionDetector {

    private static int tileSize = 64;

    public static boolean isTileGrass(int x, int y, int[][] mapLayout) {
        return mapLayout[y][x] == 0;
    }
}
