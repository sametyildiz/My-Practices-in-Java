package my_practice.leetcode.easyproblems;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem9 {
    //Given an integer x, return true if x is palindrome integer.
    //
    // An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

    public boolean isPalindrome(int x) {
        if(x < 0 )
            return false;
        else{
            Deque<Character> numbers = new ArrayDeque<Character>() ;
            for (char c : Integer.toString(x).toCharArray()) {
                numbers.add(c);
            }
            while (numbers.size() != 1 && !numbers.isEmpty() ){
                if(numbers.removeFirst() != numbers.removeLast())
                    return false;
            }
            return true;
        }
    }
}
