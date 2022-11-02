package JavaPolygon;

public class Polygon {
    Point head;
    Point tail;
    int sides;

    /**
     * Initializes a new "empty" Polygon instance 
     */
    public Polygon() {
        head = null;
        tail = null;
        sides = 0;
    }

    /**
     * Initializes a new Polygon instances with given points
     * 
     * @param coordsArr double array containing coordinate tuples
     */
    public Polygon(double[][] coordsArr) {
        head = null;
        tail = null;
        sides = 0;
        for (int i = 0; i < coordsArr.length; i++) {
            this.addPoint(coordsArr[i][0], coordsArr[i][1]);
        }
    }

    /**
     * Adds a new point to Polygon
     * 
     * @param x Desired X coordinate of point
     * @param y Desired Y coordinate of point
     */
    public void addPoint(double x, double y) {
        Point tempPoint = new Point(x, y);
        tempPoint.setNext(head);
        if (head == null) {
            tail = tempPoint;
        }
        head = tempPoint;
        tail.setNext(head);
        sides++;
    }

    /**
     * Adds a new point to Polygon
     * 
     * @param coords double[] tuple containing desired coordinates for Point
     */
    public void addPoint(double[] coords) {
        Point tempPoint = new Point(coords[0], coords[1]);
        tempPoint.setNext(head);
        if (head == null) {
            tail = tempPoint;
        }
        head = tempPoint;
        tail.setNext(head);
        sides++;
    }

    public String toString() {
        String returnString = "[ Sides: " + sides + " | Points: ";
        Point tempPoint = head;
        int i = 0;
        while (i < sides) {
            returnString += tempPoint.toString();
            if (tempPoint != tail) {
                returnString += ", ";
            }
            tempPoint = tempPoint.getNext();
            i++;
        }
        returnString += (" | Head " + head.toString() + " | Tail: " + tail.toString() + " ]");
        return returnString;
    }

    class Point {
        private double positionX;
        private double positionY;
        private Point next;
    
        /**
         * Initializes a new "empty" Point at position (0, 0) 
         */
        public Point() {
            positionX = 0;
            positionY = 0;
            next = null;
        }
    
        /**
         * Initializes a new point at (x, y)
         * 
         * @param x Desired X coordinate of point
         * @param y Desired Y coordinate of point
         */
        public Point(double x, double y) {
            positionX = x;
            positionY = y;
            next = null;
        }
    
        /**
         * Returns next Point that this current point is pointing to
         * 
         * @return 
         */
        public Point getNext() {
            return next;
        }

        /**
         * Links current Point object to newNext
         * 
         * @param newNext New Point to be linked
         */
        public void setNext(Point newNext) {
            next = newNext;
        }

        /**
         * Returns double value containing X coordinate of Point
         * 
         * @return double containing X coordinate of Point
         */
        public double getX() {
            return positionX;
        }
    
        /**
         * Returns double value containing Y coordinate of Point
         * 
         * @return double containing Y coordinate of Point
         */
        public double getY() {
            return positionY;
        }
    
        /**
         * Sets current Point's coordinates to new coordinates
         * 
         * @param x Desired X coordinate to be set
         * @param y Desired Y coordinate to be set
         */
        public void set(double x, double y) {
            positionX = x;
            positionY = y;
        }
    
        public Point add(Point point) {
            return new Point(positionX + point.getX(), positionY + point.getY());
        }
    
        public Point add(double amount) {
            return new Point(positionX + amount, positionY + amount);
        }
    
        public Point subtract(Point point) {
            return new Point(positionX - point.getX(), positionY - point.getY());
        }
    
        public Point subtract(double amount) {
            return new Point(positionX - amount, positionY - amount);
        }
    
        public String toString() {
            return "( " + positionX + ", " + positionY + " )";
        }
    }
}
