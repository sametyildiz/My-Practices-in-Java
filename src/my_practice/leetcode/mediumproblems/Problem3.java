package my_practice.leetcode.mediumproblems;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *  */
public class Problem3 {

    public int lengthOfLongestSubstring(String s) {
        String str = "";int max = 0 , i = 0;
        while (i < s.length() ){
            char c = s.charAt(i);
            if(!str.contains(String.valueOf(c))) {
                str += c;
                max = Math.max(str.length(), max);
                i++;
            }else {
                str = str.substring(1);
            }

        }
        return max;
    }


}
