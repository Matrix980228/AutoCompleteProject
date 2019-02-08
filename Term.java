import java.util.Comparator;

/**
 * A data type Term that represents an autocomplete term: a string and an
 * associated integer weight. Note that all "matching" is based on the
 * compareTo() method.
 * 
 * @author Matthew Drabick
 * @author Kevin Wayne
 * @author Eric Fouh
 * @author Chen Zhao
 * @version 2018.12.05
 */
public class Term implements Comparable<Term> {
    // ~ Instance/static variables .............................................

    private String query;
    private long weight;

    /**
     * Initializes a term with the given query string and weight.
     * 
     * @param query
     *            to use
     * @param weight
     *            to use
     */
    public Term(String query, long weight) {
        if (query == null) {
            throw new IllegalArgumentException();
        }
        if (weight < 0) {
            throw new IllegalArgumentException();
        }
        this.query = query;
        this.weight = weight;
    }

    /**
     * Get the query of the term
     * 
     * @return the query
     */
    public String getTerm() {
        return query;
    }

    /**
     * Set the query in the term
     * 
     * @param value
     *            to use
     */
    public void setTerm(String value) {
        query = value;
    }

    /**
     * Get the weight of the term
     * 
     * @return the weight
     */
    public long getWeight() {
        return weight;
    }

    /**
     * Set the weight in the term
     * 
     * @param value
     *            to use
     */
    public void setWeight(long value) {
        weight = value;
    }

    /**
     * Compares the two terms in descending order by weight.
     * 
     * @return the Comparator
     */
    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                double result = o2.weight - o1.weight;
                if (result < 0) {
                    return -1;
                }
                else if (result > 0) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        };

    }

    /**
     * Compares the two terms in lexicographic order but using only the first r
     * characters of each query.
     * 
     * @param r
     *            the number of characters to use
     * @return the Comparator
     */
    public static Comparator<Term> byPrefixOrder(int r) {
        if (r < 0) {
            throw new IllegalArgumentException();
        }
        return new Comparator<Term>() {
            @Override
            public int compare(Term o1, Term o2) {
                String s1 = findRLetters(r, o1.query);
                String s2 = findRLetters(r, o2.query);
                if (s1.compareTo(s2) > 0) {
                    return 1;
                }
                else if (s1.compareTo(s2) < 0) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        };
    }

    /**
     * The helper method to find the string contains first r letters
     * 
     * @param r
     *            the number of characters to use
     * @param result
     *            to use
     * @return result
     */
    public static String findRLetters(int r, String result) {
        if (r <= result.length()) {
            return result.substring(0, r);
        }
        return result;
    }

    /**
     * Compares the two terms in lexicographic order by query.
     * 
     * @param that
     *            to use
     * @return the result
     */
    public int compareTo(Term that) {
        return this.query.compareTo(that.query);
    }

    /**
     * Returns a string representation of this term in the following format: the
     * weight, followed by a tab character, followed by the query (no space).
     * 
     * @return the result
     */
    public String toString() {
        return this.weight + "\t" + this.query;
    }

}
