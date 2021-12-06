package my_practice.leetcode.easyproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem20 {
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     */
    public boolean isValid(String s) {
        Stack<Character> paranthesis = new Stack<>();
        Map<Character,Character> paranthesisMap = new HashMap<>(){{put('}','{'); put(')','(');put(']','[');}};

        if(s == null || s.isBlank()){
            return true;
        }
        for(char c : s.toCharArray()){
            if(paranthesisMap.containsValue(c))
                paranthesis.add(c);
            else if(paranthesisMap.containsKey(c)){
                if(!paranthesis.isEmpty() && paranthesis.peek() == paranthesisMap.get(c))
                    paranthesis.pop();
                else
                    return false;
            }

        }
        return paranthesis.isEmpty();
    }


}
