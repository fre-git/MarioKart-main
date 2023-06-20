package be.syntra.mariokart.model;

import javafx.scene.image.*;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private Image mapImage;
    private Image spriteSheet = new Image("File:resources/images/Tilesspritesheet3Colors.png");

    int spriteWidth = 64;
    int spriteHeight = 64;
    int amountOfSprites = 5;

    private Image[] sprites = new Image[amountOfSprites];
    private int[][] mapLayout;
    private List<ImageView> tileMap = new ArrayList<>();

    public Map(String imageResource) {
        mapImage = new Image(imageResource);
        this.mapLayout = new int[(int) mapImage.getHeight()][(int) mapImage.getWidth()];
        generateMap();
    }


    private void generateMap() {
        PixelReader mapReader = mapImage.getPixelReader();
        ImageView tile;
        for (int y = 0; y < mapLayout.length; y++) {
            for (int x = 0; x < mapLayout[y].length; x++) {
                int color = mapReader.getArgb(x, y);

                //?
                int red = (color >> 16) & 0xFF;
                System.out.println(red);
                mapLayout[y][x] = red;
            }
        }

        for (int i = 0; i < sprites.length; i++) {

            int x = spriteWidth * i;
            int y = 0;

            WritableImage sprite = new WritableImage(spriteWidth, spriteHeight);
            PixelReader pixelReader = spriteSheet.getPixelReader();

            for (int j = 0; j < spriteWidth; j++) {
                for (int k = 0; k < spriteHeight; k++) {
                    Color color = pixelReader.getColor(x + j, y + k);
                    sprite.getPixelWriter().setColor(j, k, color);
                    sprites[i] = sprite;
                }
            }
        }

        for (int y = 0; y < mapLayout.length; y++) {
            for (int x = 0; x < mapLayout[y].length; x++) {
                tile = new ImageView(sprites[mapLayout[y][x]]);
                tile.relocate(x * spriteWidth, y * spriteHeight);
                tileMap.add(tile);
            }
        }
    }

    public int getSpriteWidth() {
        return spriteWidth;
    }

    public List<ImageView> getTileMap() {
        return tileMap;
    }

    public int[][] getMapLayout() {
        return mapLayout;
    }
}
