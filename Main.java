package JavaPolygon;

public class Main {
    public static void main(String[] args) {
        Polygon polygon = new Polygon();
        polygon.addPoint(1, 2);
        polygon.addPoint(4, 4);
        polygon.addPoint(-2, 3);
        polygon.addPoint(-3, 1);

        polygon = polygon.normalize();


        System.out.println(polygon.toString());
        System.out.println(polygon.getPerimeter());
        
        int[] gridSize = polygon.getBoundingBoxInt();

        Grid grid = new Grid();
        grid.setSize(gridSize[0]+1, gridSize[1]+1);
        grid.init();
        grid.plot(polygon);
        System.out.println(grid.toString());

    }

}