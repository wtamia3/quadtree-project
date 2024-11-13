package src.main.java;

public class InternalNode extends Node {
    private Node[] children = new Node[4]; // 4 quadrants

    public InternalNode(int xMin, int xMax, int yMin, int yMax) {
        super(xMin, xMax, yMin, yMax);
        // Initialize child nodes with appropriate boundaries for each quadrant
        int xMid = (xMin + xMax) / 2;
        int yMid = (yMin + yMax) / 2;
        
        children[0] = new LeafNode(xMin, xMid, yMin, yMid); // Top-left quadrant
        children[1] = new LeafNode(xMid, xMax, yMin, yMid); // Top-right quadrant
        children[2] = new LeafNode(xMin, xMid, yMid, yMax); // Bottom-left quadrant
        children[3] = new LeafNode(xMid, xMax, yMid, yMax); // Bottom-right quadrant
    }

    @Override
    public void insert(Rectangle rect) {
        // Find which child node should contain the rectangle
        int index = findQuadrant(rect);
        if (index != -1) {
            children[index].insert(rect);
        } else {
            // Handle cases where the rectangle overlaps multiple quadrants
            for (Node child : children) {
                if (child.contains(rect)) {
                    child.insert(rect);
                }
            }
        }
    }

    @Override
    public void delete(Rectangle rect) {
        int index = findQuadrant(rect);
        if (index != -1) {
            children[index].delete(rect);
        } else {
            for (Node child : children) {
                if (child.contains(rect)) {
                    child.delete(rect);
                }
            }
        }
    }

    @Override
    public Rectangle find(int x, int y) {
        int index = findQuadrant(x, y);
        if (index != -1) {
            return children[index].find(x, y);
        }
        return null;
    }

    @Override
    public void dump(int level) {
        // Print this node and its children with indentation based on level
        System.out.println("  ".repeat(level) + "InternalNode: " + this);
        for (Node child : children) {
            child.dump(level + 1);
        }
    }

    private int findQuadrant(Rectangle rect) {
        // Determine which quadrant the rectangle belongs to
        int xMid = (xMin + xMax) / 2;
        int yMid = (yMin + yMax) / 2;
        
        boolean left = rect.getXMax() <= xMid;
        boolean right = rect.getXMin() >= xMid;
        boolean top = rect.getYMax() <= yMid;
        boolean bottom = rect.getYMin() >= yMid;
        
        if (top && left) return 0;
        if (top && right) return 1;
        if (bottom && left) return 2;
        if (bottom && right) return 3;

        return -1; // Rectangle overlaps multiple quadrants
    }

    private int findQuadrant(int x, int y) {
        // Determine which quadrant a point belongs to
        int xMid = (xMin + xMax) / 2;
        int yMid = (yMin + yMax) / 2;

        if (y <= yMid && x <= xMid) return 0;
        if (y <= yMid && x > xMid) return 1;
        if (y > yMid && x <= xMid) return 2;
        if (y > yMid && x > xMid) return 3;

        return -1; // Out of bounds
    }
}

