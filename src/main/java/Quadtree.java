package src.main.java;

public class Quadtree {
    private Node root;

    public Quadtree(int xMin, int xMax, int yMin, int yMax) {
        this.root = new LeafNode(xMin, xMax, yMin, yMax); // Ensure LeafNode is available
    }

    public void insert(Rectangle rect) {
        root.insert(rect);
    }

    public void delete(Rectangle rect) {
        root.delete(rect);
    }

    public Rectangle find(int x, int y) {
        return root.find(x, y);
    }

    public void dump() {
        root.dump(0); // Start dumping from root level
    }
}

