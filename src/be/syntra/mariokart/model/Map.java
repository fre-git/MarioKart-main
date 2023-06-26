package be.syntra.mariokart.model;

import javafx.scene.image.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private Image mapImage;
    private Image spriteSheet = new Image("File:resources/images/Tilesspritesheet3Colors.png");
    private String mapName;

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

        // Read every pixel from the map background image. The background image is designed in such a way
        // that the red color value represents a tile ID
        for (int y = 0; y < mapLayout.length; y++) {
            for (int x = 0; x < mapLayout[y].length; x++) {

                // get the RGB color for the current pixel
                int color = mapReader.getArgb(x, y);

                // get only the red value from the RGB value
                int red = (color >> 16) & 0xFF;

                // Set the value of the red color, which is also a tile ID in the mapLayout array
                mapLayout[y][x] = red;
            }
        }

        //Loop over the amount of tiles we have in the sprite sheet image
        for (int i = 0; i < sprites.length; i++) {

            // all sprites are next to each other in a single row. We therefore need to multiply the width of a single
            // tile with the position it has in the sprite sheet
            // first tile starts at x=0 and ends at x=64
            // second tile starts at x=64 and ends at x=128
            int x = spriteWidth * i;

            // Since all tiles are on a single row, they're al y=0 to y=64
            int y = 0;

            // create a writeable image of 64x64
            WritableImage sprite = new WritableImage(spriteWidth, spriteHeight);

            // read the entire sprite sheet
            PixelReader pixelReader = spriteSheet.getPixelReader();

            // read every pixel of a single sprite which is 64 * 64 = 4096 pixels per tile
            for (int j = 0; j < spriteWidth; j++) {
                for (int k = 0; k < spriteHeight; k++) {
                    // Get the color of the current pixel
                    Color color = pixelReader.getColor(x + j, y + k);

                    // Add the color to the writeable image
                    sprite.getPixelWriter().setColor(j, k, color);

                    // Add the current writeable image to the list of all sprites images
                    sprites[i] = sprite;
                }
            }
        }
        //loop over every tile ID in the map layout
        for (int y = 0; y < mapLayout.length; y++) {
            for (int x = 0; x < mapLayout[y].length; x++) {

                // Get the Sprite image that matches the current value of map layout
                // and create an ImageView for that sprite
                ImageView tile = new ImageView(sprites[mapLayout[y][x]]);

                // set the correct x and y coordinate for the current tile
                // first tile has x = 0 and y = 0. these values need to be multiplied by the width and the height of the tiles
                // so for the first tile it's x = 0 and y = 0
                // for the second tile it's x = 64 and y = 0
                // this goes on for all tiles in the map
                tile.relocate(x * spriteWidth, y * spriteHeight);

                // The tile is now added to the list of tiles that will be drawn later
                tileMap.add(tile);
            }
        }
    }

    public int getSpriteWidth() {
        return spriteWidth;
    }

    public List<ImageView> getTileMap() {
        // Return the list of tiles
        return tileMap;
    }

    public int[][] getMapLayout() {
        return mapLayout;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }
}
