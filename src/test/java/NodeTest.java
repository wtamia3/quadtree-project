import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NodeTest {

    @Test
    public void testNodeCreation() {
        Node node = new Node(0, 0, 100, 100); // Example Node setup
        assertNotNull(node);
    
    }

    @Test
    public void testLeafNodeCreation() {
        LeafNode leafNode = new LeafNode(0, 0, 50, 50); // Example LeafNode setup
        assertNotNull(leafNode);
    }

    @Test
    public void testLeafNodeInsertRectangle() {
        LeafNode leafNode = new LeafNode(0, 0, 50, 50);
        Rectangle rectangle = new Rectangle(10, 10, 5, 5);
        assertTrue(leafNode.insertRectangle(rectangle));
    }

    @Test
    public void testLeafNodeSplit() {
        LeafNode leafNode = new LeafNode(0, 0, 50, 50);
        for (int i = 0; i < 6; i++) {
            leafNode.insertRectangle(new Rectangle(i * 10, i * 10, 5, 5)); // Add 6 rectangles
        }
        assertTrue(leafNode.isSplit());
        
    }

    @Test
    public void testNodeFindRectangle() {
        Node node = new Node(0, 0, 100, 100);
        Rectangle rectangle = new Rectangle(10, 10, 5, 5);
        node.insertRectangle(rectangle);
        assertNotNull(node.findRectangle(10, 10));
    }

}
