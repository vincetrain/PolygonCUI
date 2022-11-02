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
                grid[i][j] = "-  ";
            }
        }
    }

    public void plot(Polygon poly) {
        // "▣"
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
