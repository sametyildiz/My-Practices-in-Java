package my_practice.leetcode.easyproblems;

import java.lang.module.FindException;

public class Problem28 {
    /**
     * Implement strStr().
     *
     * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *
     * Clarification:
     *
     * What should we return when needle is an empty string? This is a great question to ask during an interview.
     *
     * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
     */

    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())
            return 0;

        int index = 0 , hL = haystack.length() , nL = needle.length();
        while (index <= hL - nL){
            if(haystack.substring(index , index + nL).equals(needle))
                return index;
            else
                index++;
        }
        return -1;
     }
}
