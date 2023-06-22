package be.syntra.mariokart.model;

//A vector is a quantity or phenomenon that has two independent properties: magnitude and direction.
public class Vector {
    private double x;
    private double y;

    public Vector() {
        this.set(0, 0);
    }

    public Vector(double x, double y) {
        this.set(x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //changes the position of the playerCharacter in this application
    public void add(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    //scale vector
    public void multiply(double m) {
        this.x *= m;
        this.y *= m;
    }

    //returns the length of the vector, for example: speed in this application
    public double getLength() {
        return  Math.sqrt(this.x * this.x + this.y * this.y);
    }

    //used to set the velocity (speed) of the playerCharacter
    public void setLength(double L) {
        double currentLength = this.getLength();

        if (currentLength == 0) {
            this.set(L, 0);
        } else {
            this.multiply(1 / currentLength);
            this.multiply(L);
        }
    }

    // used to set direction where playerCharacter is going
    public void setAngle(double angleDegrees) {
        double length = this.getLength();
        double angleRadians = Math.toRadians(angleDegrees);
        this.x = (length * Math.cos(angleRadians));
        this.y = (length * Math.sin(angleRadians));
    }
}


