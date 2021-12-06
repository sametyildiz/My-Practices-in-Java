package my_practice.leetcode.easyproblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class Problem14 {
    /**
     *Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     */
    public String longestCommonPrefix(String[] strs) {
        if (minLength(strs).isPresent())
            return calculatePrefix(strs,"",0 , minLength(strs).get().length());
        return "";
    }

    /*public String longestCommonPrefix(String[] strs) {
        if (strs != null)
            return calculatePrefix(strs,"",0 , minLength2(strs));
        return "";
    }*/

    private String calculatePrefix(String[] stringList, String prefix, int index , int limit) {
        if(stringList[0].isBlank())
            return "";
        if(index == limit)
            return prefix;

        char c =  stringList[0].charAt(index);
        for (String str : stringList) {
            if (str.charAt(index) != c)
                return prefix;
        }
        return calculatePrefix(stringList, prefix.concat(String.valueOf(c)), ++index , limit);
    }

    private Optional<String> minLength(String[] strings){
//        return Arrays.stream(strings).min((str1,str2) -> Integer.compare(str1.length(),str2.length()));
        return Arrays.stream(strings).min(Comparator.comparingInt(String::length));
    }
    /*private int minLength2(String[] strings){
        int min = strings[0].length();
        for(String str : strings)
            min = Math.min(str.length(), min);
        return min;
    }*/
}