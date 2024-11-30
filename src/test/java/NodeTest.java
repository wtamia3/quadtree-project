import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NodeTest {

    @Test
    public void testInsertRectangle() {
        Quadtree quadtree = new Quadtree();
        quadtree.insertRectangle(10, 10, 5, 5);
        quadtree.findRectangle(10, 10); // Should print the rectangle
    }

    @Test
    public void testFindRectangle() {
        Quadtree quadtree = new Quadtree();
        quadtree.insertRectangle(10, 10, 5, 5);
        quadtree.findRectangle(10, 10); // Should find the rectangle
    }

}
