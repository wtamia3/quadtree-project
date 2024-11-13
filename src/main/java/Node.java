package src.main.java;

public abstract class Node {
    private int xMin, xMax, yMin, yMax;

    public Node(int xMin, int xMax, int yMin, int yMax) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    }

    public abstract void insert(Rectangle rect);
    public abstract void delete(Rectangle rect);
    public abstract Rectangle find(int x, int y);
    public abstract void dump(int level);

    public int getXMin() { return xMin; }
    public int getXMax() { return xMax; }
    public int getYMin() { return yMin; }
    public int getYMax() { return yMax; }
}


