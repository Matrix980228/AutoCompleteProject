import java.util.ArrayList;
import java.util.List;

/**
 * Implement a data type that provides autocomplete functionality for a given
 * set of string and weights, using Term and Node.
 * 
 * @author Matthew Drabick
 * @author Kevin Wayne
 * @author Eric Fouh
 * @author Chen Zhao
 * @version 2018.12.05
 */
public class Autocomplete {

    // ~ Instance/static variables .............................................
    private Node root;

    /**
     * Initializes the data structure, created the root of the Trie.
     */
    public Autocomplete() {
        root = new Node();
    }

    /**
     * Adds a new word and its associated weight to the Trie - O(n).
     * 
     * @param word
     *            to use
     * @param weight
     *            to use
     */
    public void addWord(String word, long weight) {
        Node n = root;
        for (int i = 0; i < word.length(); i++) {
            Node[] m = n.getReferences();
            char l = word.charAt(i);
            int k = l - 'a';
            if (k < 0 || k > 26) {
                continue;
            }
            if (m[k] != null) {
                n = m[k];
                n.setPrefixes(n.getPrefixes() + 1);
            }
            else {
                if (i == word.length() - 1) {
                    Node t = new Node(word, weight);
                    m[k] = t;
                    m[k].setPrefixes(m[k].getPrefixes() + 1);
                    m[k].setWords(m[k].getWords() + 1);
                }
                else {
                    Node t = new Node();
                    m[k] = t;
                    m[k].setPrefixes(m[k].getPrefixes() + 1);
                    n = t;
                }
            }
        }
    }

    /**
     * Returns the root of the subTrie corresponding to the last character of
     * the prefix - provide O(n).
     * 
     * @param prefix
     *            to use
     * @return the node
     */

    public Node getSubTrie(String prefix) {
        if (prefix == null) {
            return null;
        }
        return getSubTrieH(root, prefix);
    }

    /**
     * The Helper method of getSubTrie() - provide O(n).
     * 
     * @param n
     *            to use
     * @param prefix
     *            to use
     * @return the List
     */
    private Node getSubTrieH(Node n, String prefix) {
        if (n == null) {
            return null;
        }
        else {
            if (prefix.isEmpty()) {
                return n;
            }
            else {
                Node[] m = n.getReferences();
                String s = prefix.substring(1);
                char l = prefix.charAt(0);
                int k = l - 'a';
                if (k < 0 || k > 26) {
                    return null;
                }
                return getSubTrieH(m[k], s);
            }
        }
    }

    /**
     * The method returns the number of words that start with prefix - provide
     * o(n).
     * 
     * @param prefix
     *            to use
     * @return the number
     */
    public int countPrefixes(String prefix) {
        if ((prefix == null) || (getSubTrie(prefix) == null)) {
            return 0;
        }
        return getSubTrie(prefix).getPrefixes();
    }

    /**
     * The method returns a List containing all the Terms objects with query
     * starting with prefix - O(a^n).
     * 
     * @param prefix
     *            to use
     * @return the List
     */
    public List<Term> getSuggestions(String prefix) {
        List<Term> list = new ArrayList<Term>();
        if (prefix == null) {
            return list;
        }
        else {
            list = getSuggestionsH(getSubTrie(prefix));
        }
        return list;
    }

    /**
     * The Helper method of getSuggestions() - provide O(a^n).
     * 
     * @param n
     *            to use
     * @return the List
     */
    private List<Term> getSuggestionsH(Node n) {
        List<Term> result = new ArrayList<Term>();
        if (n == null) {
            return result;
        }
        if (n.getWords() > 0) {
            result.add(n.getTerm());

        }
        for (int i = 25; i >= 0; i--) {
            List<Term> tmp = getSuggestionsH(n.getReferences()[i]);
            if (tmp.size() == 0) {
                continue;
            }
            for (int k = 0; k < tmp.size(); k++) {
                result.add(tmp.get(k));
            }
        }
        return result;
    }

}
