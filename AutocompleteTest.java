import student.TestCase;

/**
 * Tests for the {@link Autocomplete} class.
 *
 * @author Chen Zhao
 * @version 2018.12.05
 */
public class AutocompleteTest extends TestCase {

    private Autocomplete a;

    /**
     * Creates a brand new, empty Autocomplete for each test method.
     */
    public void setUp() {
        a = new Autocomplete();

    }

    /**
     * test getSubtrie()
     */
    public void testGetSubTrie() {
        a.addWord("te*st", 50);
        a.addWord("tes}ter", 30);
        a.addWord("testing", 15);
        assertNull(a.getSubTrie(null));
        assertEquals("te*st", a.getSubTrie("test").getTerm().getTerm());
        assertNull(a.getSubTrie("te}st"));
        assertNull(a.getSubTrie("te*st"));
    }

    /**
     * test countPrefixes()
     */
    public void testCountPrefixes() {
        a.addWord("te*st", 50);
        a.addWord("tester", 30);
        a.addWord("testing", 15);
        assertEquals(0, a.countPrefixes("app"));
        assertEquals(0, a.countPrefixes(null));
        assertEquals(3, a.countPrefixes("tes"));
        assertEquals(0, a.countPrefixes(""));

    }

    /**
     * test getSuggestions()
     */
    public void testGetSuggestions() {
        a.addWord("test", 50);
        a.addWord("tester", 30);
        a.addWord("testing", 15);
        a.getSuggestions("");
        a.getSuggestions("app");
        assertEquals(0, a.getSuggestions("app").size());
        assertEquals(3, a.getSuggestions("").size());
        assertEquals(0, a.getSuggestions("****").size());
        a.getSuggestions("test");
        assertNotNull(a.getSuggestions(null));
        assertEquals(3, a.getSuggestions("t").size());
        assertEquals(0, a.getSuggestions("@").size());
        assertEquals(0, a.getSuggestions("t" + null + "e").size());
        a.getSuggestions(null);
        a.getSuggestions("*");

    }
}
