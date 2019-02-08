import java.util.Arrays;
import student.TestCase;

/**
 * Tests for the {@link Term} class.
 *
 * @author Chen Zhao
 * @version 2018.12.05
 */
public class TermTest extends TestCase {

    private Term c;
    private Term d;
    private Term e;
    private Term f;
    private Term g;
    private Term h;

    /**
     * Creates a series of terms for each test method.
     */
    public void setUp() {
        c = new Term("c", 5);
        d = new Term("d", 7);
        e = new Term("e", 9);
        f = new Term("f", 11);
        g = new Term("g", 13);
        h = new Term("h", 15);
    }

    /**
     * test Term()
     */
    public void testTerm() {
        Exception thrown = null;
        try {
            g = new Term(null, 3);
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        thrown = null;
        try {
            g = new Term("b", -1);
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        assertEquals("c", c.getTerm());
        assertEquals(5, (int) c.getWeight());
    }

    /**
     * test setWeight()
     */
    public void testSetWeight() {
        c.setWeight(10);
        assertEquals(10, (int) c.getWeight());
    }

    /**
     * test setTerm()
     */
    public void testSetTerm() {
        d.setTerm("k");
        assertEquals("k", d.getTerm());
    }

    /**
     * test byReverseWeightOrder()
     */
    public void testByReverseWeightOrder() {
        Term[] r1 = { f, g, d, c, e, h, d };
        Arrays.sort(r1, Term.byReverseWeightOrder());
        assertEquals(h, r1[0]);
        assertEquals(g, r1[1]);
        assertEquals(f, r1[2]);
        assertEquals(e, r1[3]);
        assertEquals(d, r1[4]);
        assertEquals(d, r1[5]);
        assertEquals(c, r1[6]);
    }

    /**
     * test byPrefixOrder()
     */
    public void testByPrefixOrder() {
        Term[] r2 = { f, g, d, c, e, h, d };
        Term[] r3 = { f, g, d, c, e, h };
        Term[] r4 = { f, g, d, c, e, h, d };
        Exception thrown = null;
        try {
            Arrays.sort(r3, Term.byPrefixOrder(-3));
        } 
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        Arrays.sort(r2, Term.byPrefixOrder(1));
        assertEquals(c, r2[0]);
        assertEquals(d, r2[1]);
        assertEquals(d, r2[2]);
        assertEquals(e, r2[3]);
        assertEquals(f, r2[4]);
        assertEquals(g, r2[5]);
        assertEquals(h, r2[6]);
        Arrays.sort(r4, Term.byPrefixOrder(3));
        assertEquals(c, r2[0]);
        assertEquals(d, r2[1]);
        assertEquals(d, r2[2]);
        assertEquals(e, r2[3]);
        assertEquals(f, r2[4]);
        assertEquals(g, r2[5]);
        assertEquals(h, r2[6]);
    }

    /**
     * test compareTo()
     */
    public void testCompareTo() {
        assertEquals(0, c.compareTo(c));
        assertTrue(d.compareTo(e) < 0);
        assertTrue(h.compareTo(g) > 0);
    }

    /**
     * test toString()
     */
    public void testToString() {
        assertEquals("15\th", h.toString());
    }
}
