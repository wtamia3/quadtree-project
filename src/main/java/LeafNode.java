package src.main.java;

import java.util.ArrayList;
import java.util.List;

public class LeafNode extends Node {
    private List<Rectangle> rectangles = new ArrayList<>();

    public LeafNode(int xMin, int xMax, int yMin, int yMax) {
        super(xMin, xMax, yMin, yMax);
    }

    @Override
    public void insert(Rectangle rect) {
        if (rectangles.size() >= 5) {
            // Convert this LeafNode into an InternalNode if capacity is exceeded
        } else {
            rectangles.add(rect);
        }
    }

    @Override
    public void delete(Rectangle rect) {
        rectangles.remove(rect);
    }

    @Override
    public Rectangle find(int x, int y) {
        for (Rectangle rect : rectangles) {
            if (rect.getX() == x && rect.getY() == y) {
                return rect;
            }
        }
        return null;
    }

    @Override
    public void dump(int level) {
        for (Rectangle rect : rectangles) {
            System.out.println("Level " + level + ": Rectangle at (" + rect.getX() + ", " + rect.getY() + ")");
        }
    }
}
