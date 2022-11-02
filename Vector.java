package JavaPolygon;

public class Vector {
    double directionX;
    double directionY;

    public Vector() {
        directionX = 0;
        directionY = 0;
    }

    public Vector(double x, double y) {
        directionX = x;
        directionY = y;
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(directionX, 2) + Math.pow(directionY, 2));
    }

    public Vector normalize() {
        double magnitude = this.magnitude();
        return new Vector(directionX / magnitude, directionY / magnitude);
    }

    public double[] get() {
        return new double[] {directionX, directionY};
    }

    public double getX() {
        return directionX;
    }

    public double getY() {
        return directionY;
    }

    public void set(double x, double y) {
        directionX = x;
        directionY = y;
    }

    public Vector add(Vector vector) {
        return new Vector(directionX + vector.getX(), directionY + vector.getY());
    }

    public Vector add(double amount) {
        return new Vector(directionX + amount, directionY + amount);
    }

    public Vector subtract(Vector vector) {
        return new Vector(directionX - vector.getX(), directionY - vector.getY());
    }

    public Vector subtract(double amount) {
        return new Vector(directionX - amount, directionY - amount);
    }

    public String toString() {
        return "< " + directionX + ", " + directionY + " >";
    }
}
