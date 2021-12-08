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

    public int strStr(String haystack, String needle) {//Time Limit Exceeded
        if(needle.isEmpty())
            return 0;

        int index = 0 , needleIndex = 0;
        while (index <= haystack.length() - needle.length()){
            if(needleIndex == needle.length())
                return index;
            if(haystack.charAt(index + needleIndex) == needle.charAt(needleIndex))
                needleIndex++;
            else {
                needleIndex = 0;
                index++;
            }

        }
        return -1;
     }

}
