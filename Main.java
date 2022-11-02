package JavaPolygon;

public class Main {
    public static void main(String[] args) {
        Polygon polygon = new Polygon();
        polygon.addPoint(1, 2);
        polygon.addPoint(4, 4);
        polygon.addPoint(-2, 3);
        polygon.addPoint(-3, 1);


        System.out.println(polygon.toString());
        System.out.println(polygon.getPerimeter());
        
        Grid grid = new Grid();
        grid.setSize(4, 4);
        grid.init();
        System.out.println(grid.toString());

    }

    public static String[][] generateGrid(Polygon polygon) {
        int[] boundingbox = polygon.getBoundingBoxInt();
        String[][] grid = new String[boundingbox[0]][boundingbox[1]];

        // Populate grid with Strings
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; i++) {
                grid[i][j] = " _ ";
            }
        }

        return grid;
    }

}