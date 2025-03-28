import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {
    @Test
    public void testInsertAndSearch() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.insert(10, "Ten");
        bst.insert(5, "Five");
        bst.insert(15, "Fifteen");

        assertEquals("Ten", bst.search(10));
        assertEquals("Five", bst.search(5));
        assertEquals("Fifteen", bst.search(15));
        assertNull(bst.search(20));
    }
}
