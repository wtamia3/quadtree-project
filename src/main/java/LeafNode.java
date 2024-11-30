import java.util.ArrayList;
import java.util.List;

public class LeafNode extends Node {
    private List<Rectangle> rectangles;

    public LeafNode(double xMin, double yMin, double xMax, double yMax) {
        super(xMin, yMin, xMax, yMax);
        rectangles = new ArrayList<>();
    }

    @Override
    public void insertRectangle(Rectangle rectangle) {
        if (rectangles.size() < 5) {
            rectangles.add(rectangle);
        } else {
            // Split node and move rectangles to children
        }
    }

    @Override
    public void deleteRectangle(double x, double y) {
        rectangles.removeIf(r -> r.getX() == x && r.getY() == y);
    }

    @Override
    public void findRectangle(double x, double y) {
        for (Rectangle rect : rectangles) {
            if (rect.getX() == x && rect.getY() == y) {
                System.out.println("Rectangle at (" + x + ", " + y + "): " + rect);
                return;
            }
        }
        System.out.println("Nothing is at (" + x + ", " + y + ").");
    }

    @Override
    public void dumpNode(int level) {
        System.out.println("\t".repeat(level) + "Leaf Node (" + xMin + ", " + yMin + ") to (" + xMax + ", " + yMax + ")");
        for (Rectangle rect : rectangles) {
            System.out.println("\t".repeat(level + 1) + rect);
        }
    }

    public boolean containsRectangle(double x, double y) {
        return rectangles.stream().anyMatch(r -> r.getX() == x && r.getY() == y);
    }
}

