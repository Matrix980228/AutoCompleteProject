/**
 * A data type Node that represents a node in the Trie which encapsulates a Term
 * data field.
 * 
 * @author Chen Zhao
 * @version 2018.12.05
 */
public class Node {
    // ~ Instance/static variables .............................................
    private Term t;
    private int words;
    private int prefixes;
    private Node[] references;

    /**
     * Initializes a empty node
     */
    public Node() {
        t = new Term("", 0);
        words = 0;
        prefixes = 0;
        references = new Node[26];
        for (int i = 0; i < 26; i++) {
            references[i] = null;
        }
    }

    /**
     * Initializes a node with a string and an associated integer weight.
     * 
     * @param query
     *            to use
     * @param weight
     *            to use
     */
    public Node(String query, long weight) {
        t = new Term(query, weight);
        words = 0;
        prefixes = 0;
        references = new Node[26];
        for (int i = 0; i < 26; i++) {
            references[i] = null;
        }
    }

    /**
     * Get the term in the node
     * 
     * @return the term
     */
    public Term getTerm() {
        return t;
    }

    /**
     * Set the term in the node
     * 
     * @param value
     *            to use
     */
    public void setTerm(Term value) {
        t = value;
    }

    /**
     * Get the words in the node
     * 
     * @return the words
     */
    public int getWords() {
        return words;
    }

    /**
     * Set the words in the node
     * 
     * @param value
     *            to use
     */
    public void setWords(int value) {
        words = value;
    }

    /**
     * Get the prefixes in the node
     * 
     * @return the prefixes
     */
    public int getPrefixes() {
        return prefixes;
    }

    /**
     * Set the prefixes in the node
     * 
     * @param value
     *            to use
     */
    public void setPrefixes(int value) {
        prefixes = value;
    }

    /**
     * Get the children of the node
     * 
     * @return the children
     */
    public Node[] getReferences() {
        return references;
    }

    /**
     * Set the children of the node
     * 
     * @param value
     *            to use
     */
    public void setReferences(Node[] value) {
        references = value;
    }

}
