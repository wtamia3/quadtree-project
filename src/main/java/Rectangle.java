package src.main.java;

public class Rectangle {
    private int x, y, length, width;

    public Rectangle(int x, int y, int length, int width) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getLength() { return length; }
    public int getWidth() { return width; }

    @Override
    public String toString() {
        return "Rectangle(" + "x=" + x + ", y=" + y + ", length=" + length + ", width=" + width + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rectangle rectangle = (Rectangle) obj;
        return x == rectangle.x && y == rectangle.y && length == rectangle.length && width == rectangle.width;
    }

    @Override
    public int hashCode() {
        return 31 * (31 * (31 * Integer.hashCode(x) + Integer.hashCode(y)) + Integer.hashCode(length)) + Integer.hashCode(width);
    }
}


