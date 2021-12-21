package my_practice.leetcode.easyproblems;

/**
 * Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
 *
 * A word is a maximal substring consisting of non-space characters only.
 */
public class Problem58 {
    public int lengthOfLastWord(String s) {
        if(s == null || s.isBlank() || s.isEmpty() )
            return 0;
        s = s.trim();
        return s.substring(s.lastIndexOf(" ") + 1).length();
    }

}
