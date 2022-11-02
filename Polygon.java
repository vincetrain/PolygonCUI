package JavaPolygon;

public class Polygon {
    Vertex head;
    Vertex tail;
    int sides;

    public Polygon() {
        head = null;
        tail = null;
        sides = 0;
    }

    public void addVertex(double x, double y) {
        Vertex tempVertex = new Vertex(x, y);
        tempVertex.setNext(head);
        if (head == null) {
            tail = tempVertex;
        }
        head = tempVertex;

        tail.setNext(head);
        sides++;
    }

    public Vector[] vectorize() throws NullPointerException {
        Vector[] transformations = 
    }

    private Vector[] getVertexTransformations () throws NullPointerException {
        Vector[] vectorArr = new Vector[sides];
        
        Vertex tempVertex = head;
        if (tempVertex == null) {
            throw new NullPointerException();
        }

        for (int i = 0; i < vectorArr.length; i++) {
            Vector v1 = tempVertex.get();
            Vector v2 = tempVertex.next.get();
            v2 = v2.subtract(v1);
            vectorArr[i] = v2;
            tempVertex = tempVertex.next();
        }

        return vectorArr;
    }

    

    public Vector[] normalize() {
        Vector[] vectorArr = new Vector[sides];
        
        Vertex tempVertex = head;
        if (tempVertex == null) {
            throw new NullPointerException();
        }

        for (int i = 0; i < vectorArr.length; i++) {
            Vector tempVector = tempVertex.get();
            vectorArr[i] = tempVector.normalize();
            tempVertex = tempVertex.next();
        }

        return vectorArr;
    }

    class Vertex {
        private double coordX;
        private double coordY;

        private Vertex next;
    
        public Vertex(double x, double y) {
            coordX = x;
            coordY = y;
            next = null;
        }

        public Vertex next() {
            return next;
        }
    
        public void setNext(Vertex nextVertex) {
            next = nextVertex;
        }

        public Vector get() {
            return new Vector(coordX, coordY);
        }
    }
}
