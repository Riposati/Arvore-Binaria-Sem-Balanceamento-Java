import br.com.gustavo.riposati.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    private Tree tree = new Tree();

    @Test
    void treeInsertionTest(){
        assertEquals(1, this.tree.insertNode(1, this.tree.getRoot()).getKey());
    }

    @Test
    void treeSearchTest(){
        this.tree.setRoot(this.tree.insertNode(10, this.tree.getRoot()));
        assertEquals( false, this.tree.searchNode(50, this.tree.getRoot()));
        assertEquals( true, this.tree.searchNode(10, this.tree.getRoot()));
    }

    @Test
    void treeDeletionTest(){
        this.insertKeys();
        this.tree.removeNode(10, this.tree.getRoot());

        Tree treeTest = new Tree();
        treeTest.setRoot(treeTest.insertNode(5, treeTest.getRoot()));
        treeTest.setRoot(treeTest.insertNode(3, treeTest.getRoot()));
        treeTest.setRoot(treeTest.insertNode(15, treeTest.getRoot()));

        assertNotNull(this.tree.getRoot());
        assertEquals(treeTest, this.tree);
    }

    @Test
    void treeMaximumTest(){
        this.insertKeys();
        assertNotEquals(10,this.tree.treeMaximum(this.tree.getRoot()));
        assertEquals(15,this.tree.treeMaximum(this.tree.getRoot()));
    }

    private void insertKeys(){
        this.tree.setRoot(this.tree.insertNode(10, this.tree.getRoot()));
        this.tree.setRoot(this.tree.insertNode(5, this.tree.getRoot()));
        this.tree.setRoot(this.tree.insertNode(3, this.tree.getRoot()));
        this.tree.setRoot(this.tree.insertNode(15, this.tree.getRoot()));
    }
}
