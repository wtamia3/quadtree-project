package src.test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.main.java.Quadtree; // Import the Quadtree class
import src.main.java.Rectangle; // Import the Rectangle class

public class QuadtreeTest {
    private Quadtree quadtree;

    // Set up a new Quadtree before each test
    @BeforeEach
    public void setUp() {
        quadtree = new Quadtree(-50, 50, -50, 50); // Create a Quadtree with bounds (-50, 50) for both x and y axes
    }

    // Test for inserting a rectangle and finding it
    @Test
    public void testInsertAndFind() {
        Rectangle rect = new Rectangle(10, 10, 5, 5); // Create a rectangle at (10, 10) with width 5 and height 5
        quadtree.insert(rect); // Insert the rectangle into the quadtree
        assertEquals(rect, quadtree.find(10, 10)); // Verify that the rectangle can be found at (10, 10)
    }

    // Test for deleting a rectangle and verifying it's no longer found
    @Test
    public void testDelete() {
        Rectangle rect = new Rectangle(10, 10, 5, 5);
        quadtree.insert(rect); // Insert the rectangle into the quadtree
        quadtree.delete(rect); // Delete the rectangle from the quadtree
        assertNull(quadtree.find(10, 10)); // Verify that the rectangle is no longer found
    }

    // Test for dumping the quadtree structure (just checks if no exceptions occur)
    @Test
    public void testDump() {
        Rectangle rect = new Rectangle(10, 10, 5, 5);
        quadtree.insert(rect); // Insert a rectangle
        quadtree.dump(); // Dump the quadtree structure to the console (for debugging purposes)
    }
}


