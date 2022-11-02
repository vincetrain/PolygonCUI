package JavaPolygon;

public class Main {
    public static void main(String[] args) {

        Polygon rect = new Polygon();
        rect.addVertex(1, 2);
        rect.addVertex(4, 4);
        rect.addVertex(-2, 3);
        rect.addVertex(-3, 1);

        Vector[] plot = rect.vectorize();
        printCoords(plot);

        String[][] grid = plot(plot);
        printGrid(grid);

    }

    public static String[][] plot(Vector[] plot) {
        String[][] grid = makeGrid(plot);

        // y = mx+b
        // y = plot[i].getY()/plot[i].getX() * k
        // truncate y 
        for (int i = 0; i < plot.length; i++) {
            int slope = (int) (plot[i].getY()/plot[i].getY());
            for (int j = 0; j < grid[0].length; j++) {
                int y = slope * j;
                if (y > grid.length) {
                    break;
                }
                grid[y][j] = " * ";
            }
        }

        return grid;
    }

    public static String[][] makeGrid(Vector[] plot) {
        double[] maxValues = getMax(plot);
        String[][] grid = new String[(int) maxValues[0] + 1][(int) maxValues[1] + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j= 0; j < grid[i].length; j++) {
                grid[i][j] = " _ ";
            }
        }
        return grid;
    }

    public static double[] getMax(Vector[] plot) {
        double maxX = 0;
        double maxY = 0;
        for (int i = 0; i < plot.length; i++) {
            double currentX = plot[i].getX();
            double currentY = plot[i].getY();
            if (currentX > maxX) {
                maxX = currentX;
            }
            if (currentY > maxY) {
                maxY = currentY;
            }
        }
        return new double[] { maxX, maxY }; 
    }

    public static void printGrid(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void printCoords(Vector[] plot) {
        for (int i = 0; i < plot.length; i++) {
            System.out.println(plot[i].toString());
        }
    }
}
