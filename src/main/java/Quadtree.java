public class Quadtree {
    private Node root;

    public Quadtree() {
        root = new LeafNode(-50, -50, 50, 50);
    }

    public void insertRectangle(double x, double y, double l, double w) {
        Rectangle rectangle = new Rectangle(x, y, l, w);
        root.insertRectangle(rectangle);
    }

    public void deleteRectangle(double x, double y) {
        root.deleteRectangle(x, y);
    }

    public void findRectangle(double x, double y) {
        root.findRectangle(x, y);
    }

    public void updateRectangle(double x, double y, double l, double w) {
        Rectangle rectangle = new Rectangle(x, y, l, w);
        // Logic to update the rectangle (change length and width)
    }

    public void dumpTree() {
        root.dumpNode(0);
    }
}
