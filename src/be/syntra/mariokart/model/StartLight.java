package be.syntra.mariokart.model;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Date;

public class StartLight{

    private Vector position;
    private Vector velocity;
    Image image;
    ImageView imageView;

    public StartLight(){
        image = new Image("File:resources/images/StartLight1.png", 45, 45, false, false);
        imageView = new ImageView(image);
        this.position = new Vector(360, 50);
        this.velocity = new Vector();
    }

    public void counter()  {
        long startTime = System.currentTimeMillis();
        long elapsedTime;

        for (elapsedTime = 0; elapsedTime < 6000; elapsedTime++) {


        //while (elapsedTime < 6 * 1000) {


            elapsedTime = (new Date()).getTime() - startTime;
            if(elapsedTime > 1000){
                //System.out.println(elapsedTime);
                this.position.set(360, 50);
                this.imageView.relocate(position.getX(), position.getY());
                this.draw();
            }

            if(elapsedTime > 3000){
                //System.out.println(elapsedTime);
                imageView.setImage(new Image("File:resources/images/StartLight2.png"));
                this.draw();

            }
            if(elapsedTime > 4000){
                //System.out.println(elapsedTime);
                imageView.setImage(new Image("File:resources/images/StartLight3.png"));
                this.draw();
            }
            if(elapsedTime > 5000){
                //System.out.println("end image + " + elapsedTime);
                imageView.setImage(new Image("File:resources/images/StartLight4.png"));
                this.draw();
            }
            if(elapsedTime > 5900){
                //System.out.println("hide");
                hide();
            }
        }
    }

    public ImageView getImageview() {
        return imageView;
    }

    public void update(double deltaTime){
        this.position.add(this.velocity.getX() * deltaTime, this.velocity.getY() * deltaTime);
    }

    public void draw() {
        imageView.relocate(this.position.getX(), this.position.getY());
    }

    public Vector getPosition() {
        return position;
    }

    public void showInScreen(){
        position.set(360, 50);
    }

    public void hide(){
        position.set(360, -360);
        this.draw();
    }
}
