package src.test.java;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NodeTest {
    private LeafNode leafNode;
    private InternalNode internalNode;

    @BeforeEach
    public void setUp() {
        leafNode = new LeafNode(-50, 50, -50, 50);
        internalNode = new InternalNode(-50, 50, -50, 50);
    }

    @Test
    public void testLeafNodeInsert() {
        Rectangle rect = new Rectangle(10, 10, 5, 5);
        leafNode.insert(rect);
        assertEquals(rect, leafNode.find(10, 10), "Rectangle should be found in LeafNode after insertion");
    }

    @Test
    public void testInternalNodeInsert() {
        Rectangle rect = new Rectangle(25, 25, 5, 5);
        internalNode.insert(rect);
        assertEquals(rect, internalNode.find(25, 25), "Rectangle should be found in InternalNode after insertion");
    }

    @Test
    public void testLeafNodeDelete() {
        Rectangle rect = new Rectangle(10, 10, 5, 5);
        leafNode.insert(rect);
        leafNode.delete(rect);
        assertNull(leafNode.find(10, 10), "Rectangle should be null in LeafNode after deletion");
    }

    @Test
    public void testInternalNodeDelete() {
        Rectangle rect = new Rectangle(30, 30, 5, 5);
        internalNode.insert(rect);
        internalNode.delete(rect);
        assertNull(internalNode.find(30, 30), "Rectangle should be null in InternalNode after deletion");
    }

    @Test
    public void testInternalNodeInsertMultipleRectangles() {
        Rectangle rect1 = new Rectangle(10, 10, 5, 5);
        Rectangle rect2 = new Rectangle(-20, -20, 5, 5);
        internalNode.insert(rect1);
        internalNode.insert(rect2);
        
        assertEquals(rect1, internalNode.find(10, 10), "First rectangle should be found in InternalNode");
        assertEquals(rect2, internalNode.find(-20, -20), "Second rectangle should be found in InternalNode");
    }

    @Test
    public void testInternalNodeFindOutsideBounds() {
        assertNull(internalNode.find(100, 100), "Find should return null if point is outside node bounds");
    }

    @Test
    public void testInternalNodeStructureAfterInsert() {
        // Check that internal node children structure is preserved after inserts
        Rectangle rect1 = new Rectangle(-40, -40, 5, 5);
        Rectangle rect2 = new Rectangle(40, 40, 5, 5);
        
        internalNode.insert(rect1);
        internalNode.insert(rect2);
        
        // We assume there is a `dump` method to help us verify structure visually
        internalNode.dump(0);
        
        assertEquals(rect1, internalNode.find(-40, -40), "First rectangle should be correctly located");
        assertEquals(rect2, internalNode.find(40, 40), "Second rectangle should be correctly located");
    }
}

