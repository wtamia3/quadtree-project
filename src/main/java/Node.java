public abstract class Node {
    protected double xMin, yMin, xMax, yMax;

    public Node(double xMin, double yMin, double xMax, double yMax) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public abstract void insertRectangle(Rectangle rectangle);

    public abstract void deleteRectangle(double x, double y);

    public abstract void findRectangle(double x, double y);

    public abstract void dumpNode(int level);
}


