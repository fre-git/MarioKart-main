package be.syntra.mariokart.view;

public class ImageSelector {

    private ImageSelector() {
    }

    public static String getImageResource(int image) {
        // TODO variable inlining nie nodig
        String imageResource;
        switch (image) {
            case 1 -> imageResource = "File:resources/images/Mario.png";
            case 2 -> imageResource = "File:resources/images/Luigi.png";
            case 3 -> imageResource = "File:resources/images/Toad.png";
            case 4 -> imageResource = "File:resources/images/Yoshi.png";
            case 5 -> imageResource = "File:resources/images/Peach.png";
            case 6 -> imageResource = "File:resources/images/Bowser.png";
            default -> imageResource = "File:resources/images/Mario.png";
        }
        return imageResource;
    }
}
