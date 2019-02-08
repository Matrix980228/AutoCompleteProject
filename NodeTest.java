import student.TestCase;

/**
 * Tests for the {@link Node} class.
 *
 * @author Chen Zhao
 * @version 2018.12.05
 */
public class NodeTest extends TestCase {

    private Node a;
    private Node b;
    private Node c;
    private Term a1;
    private Term b1;
    private Term c1;
    private Node[] a2;
    private Node[] b2;

    /**
     * Creates a series of nodes for each test method.
     */
    public void setUp() {
        a = new Node("a", 5);
        b = new Node("b", 9);
        c = new Node("c", 11);
        a1 = new Term("a", 5);
        b1 = new Term("b", 7);
        c1 = new Term("c", 13);
        a2 = new Node[3];
        b2 = new Node[6];
    }

    /**
     * test Node()
     */
    public void testNode() {
        Node t = new Node();
        t.setTerm(c1);
        t.setWords(3);
        t.setPrefixes(7);
        assertEquals(c1.getTerm(), t.getTerm().getTerm());
        assertEquals(3, t.getWords());
        assertEquals(7, t.getPrefixes());
    }

    /**
     * test getTerm()
     */
    public void testGetTerm() {
        assertEquals(a1.getTerm(), a.getTerm().getTerm());
        assertEquals(a1.getWeight(), a.getTerm().getWeight());
    }

    /**
     * test setTerm()
     */
    public void testSetTerm() {
        a.setTerm(b1);
        assertEquals(b1.getTerm(), a.getTerm().getTerm());
        assertEquals(b1.getWeight(), a.getTerm().getWeight());
    }

    /**
     * test getWords()
     */
    public void testGetWords() {
        b.setWords(5);
        assertEquals(5, b.getWords());
    }

    /**
     * test setWords()
     */
    public void testSetWords() {
        b.setWords(8);
        assertEquals(8, b.getWords());
        b.setWords(10);
        assertEquals(10, b.getWords());
    }

    /**
     * test getPrefixes()
     */
    public void testGetPrefixes() {
        c.setPrefixes(6);
        assertEquals(6, c.getPrefixes());
    }

    /**
     * test setPrefixes()
     */
    public void testSetPrefixes() {
        c.setPrefixes(9);
        assertEquals(9, c.getPrefixes());
        c.setPrefixes(15);
        assertEquals(15, c.getPrefixes());
    }

    /**
     * test getChildren()
     */
    public void testGetReferences() {
        a.setReferences(a2);
        assertEquals(a2, a.getReferences());
    }

    /**
     * test setChildren()
     */
    public void testSetReferences() {
        b.setReferences(b2);
        assertEquals(b2, b.getReferences());
    }

}
