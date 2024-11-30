import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuadtreeTest {

    private Quadtree quadtree;

    @BeforeEach
    public void setUp() {
        quadtree = new Quadtree(); // Initialize the quadtree before each test
    }

    @Test
    public void testInsertRectangle() {
        // Insert a rectangle and check if it can be found
        quadtree.insertRectangle(10, 10, 5, 5);
        quadtree.findRectangle(10, 10); // Should print the rectangle with the right coordinates
    }

    @Test
    public void testFindRectangle() {
        // Insert a rectangle and try to find it
        quadtree.insertRectangle(10, 10, 5, 5);
        quadtree.findRectangle(10, 10); // Should print the rectangle at (10, 10)
        
        // Try to find a non-existing rectangle
        quadtree.findRectangle(20, 20); // Should print "Nothing is at (20, 20)."
    }

    @Test
    public void testDeleteRectangle() {
        // Insert a rectangle, then delete it and ensure it is removed
        quadtree.insertRectangle(10, 10, 5, 5);
        quadtree.deleteRectangle(10, 10);
        quadtree.findRectangle(10, 10); // Should print "Nothing is at (10, 10)."
    }

    @Test
    public void testUpdateRectangle() {
        // Insert a rectangle and then update its dimensions
        quadtree.insertRectangle(10, 10, 5, 5);
        quadtree.updateRectangle(10, 10, 8, 8); // Update the rectangle
        quadtree.findRectangle(10, 10); // Should print updated rectangle with new dimensions
    }

    @Test
    public void testDumpTree() {
        // Insert several rectangles and dump the quadtree structure
        quadtree.insertRectangle(10, 10, 5, 5);
        quadtree.insertRectangle(20, 20, 3, 3);
        quadtree.insertRectangle(-10, -10, 6, 6);
        
        // The dump function should print the structure with all inserted rectangles
        quadtree.dumpTree(); // Will print tree structure with rectangles
    }

    @Test
    public void testInsertOverLimit() {
        // Test the quadtree split behavior when inserting more than 5 rectangles into a leaf node
        for (int i = 0; i < 6; i++) {
            quadtree.insertRectangle(i * 10, i * 10, 5, 5); // Insert rectangles in different positions
        }
        
        // After inserting 6 rectangles, the leaf node should split into internal nodes
        quadtree.dumpTree(); // Dump the tree structure to see the split
    }
}

