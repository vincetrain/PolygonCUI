package JavaPolygon;

public class Main {
    public static void main(String[] args) {
        Polygon polygon = new Polygon();
        polygon.addPoint(1, 2);
        polygon.addPoint(4, 4);
        polygon.addPoint(-2, 3);
        polygon.addPoint(-3, 1);

        System.out.println(polygon.toString());
    }
}
