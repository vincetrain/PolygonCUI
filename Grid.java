package JavaPolygon;

public class Grid {
    String[][] grid;
    int width;
    int height;

    public Grid() {
        width = 0;
        height = 0;
        grid = null;
    }

    public Grid(int x, int y) {
        width = x;
        height = y;
    }

    public void setSize(int x, int y) {
        width = x;
        height = y;
    }

    public void init() throws IllegalStateException {
        grid = new String[height][width];

        // Populate grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " - ";
            }
        }
    }

    public void plot(Polygon poly) {
        double[][] points = poly.getPoints();
        for (int i = 1; i < points.length+1; i++) {
            double[] nextPoint = points[i%points.length];
            double[] currentPoint = cloneDoubleArray(points[i%points.length-1]);
            double slope = (nextPoint[1] - currentPoint[1])/(nextPoint[0]-currentPoint[0]);
            double yint = currentPoint[1];
            System.out.println("slope: " + slope);
            System.out.println("x: " + currentPoint[0] + " y: " + currentPoint[1]);

            while ((currentPoint[0] < nextPoint[0]) && (currentPoint[1] != nextPoint[1])) {

                grid[(int) currentPoint[1] + 1][(int) currentPoint[0]] = " * ";                
                currentPoint[0]+=1;
                currentPoint[1] = currentPoint[0] * slope + yint;
                System.out.println(currentPoint[0] * slope + yint);
                System.out.println(toString());
            }
            
        }
    }

    private double[] cloneDoubleArray(double[] array) {
        double[] newArray = new double[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }

        return newArray;
    }

    public String toString() {
        String returnString = "";
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                returnString += grid[i][j];
            }
            returnString += "\n";
        }

        return returnString;
    }

}
