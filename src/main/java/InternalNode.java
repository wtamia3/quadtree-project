import java.util.ArrayList;
import java.util.List;

public class InternalNode extends Node {
    private List<Node> children;

    public InternalNode(double xMin, double yMin, double xMax, double yMax) {
        super(xMin, yMin, xMax, yMax);
        children = new ArrayList<>();
    }

    @Override
    public void insertRectangle(Rectangle rectangle) {
        // Insert rectangle into the appropriate child node
        for (Node child : children) {
            if (child.isWithinBounds(rectangle)) {
                child.insertRectangle(rectangle);
                return;
            }
        }
    }

    @Override
    public void deleteRectangle(double x, double y) {
        // Find and delete rectangle, if exists
        for (Node child : children) {
            child.deleteRectangle(x, y);
        }
    }

    @Override
    public void findRectangle(double x, double y) {
        for (Node child : children) {
            child.findRectangle(x, y);
        }
    }

    @Override
    public void dumpNode(int level) {
        System.out.println("\t".repeat(level) + "Internal Node (" + xMin + ", " + yMin + ") to (" + xMax + ", " + yMax + ")");
        for (Node child : children) {
            child.dumpNode(level + 1);
        }
    }

    public void addChild(Node node) {
        children.add(node);
    }
}
