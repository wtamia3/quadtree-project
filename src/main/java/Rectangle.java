public class Rectangle {
    private double x, y, length, width;

    public Rectangle(double x, double y, double length, double width) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Rectangle at (" + x + ", " + y + "): " + length + "x" + width;
    }
}
