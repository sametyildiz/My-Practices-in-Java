package my_practice.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ParanthesisChecker {
    private Stack<Character> paranthesisStack;
    private final ArrayList<Character> firstParanthesis;
    private final ArrayList<Character> lastParanthesis;

    public ParanthesisChecker(){
        paranthesisStack = new Stack<>();
        this.firstParanthesis = new ArrayList<>(Arrays.asList(new Character[]{'(','{','['}));
        this.lastParanthesis = new ArrayList<>(Arrays.asList(new Character[]{')','}',']'}));
    }

    /**
     * Verifies that given input has matching '(' ')', '{' '}', '[' ']'
     * @param input A string input
     * @return  true if inout has matching brackets, false otherwise.
     */
    public boolean checkParanthesis(String input){
        if(input == null)
            return false;
        for(Character c : input.toCharArray()){
            if(lastParanthesis.contains(c) && paranthesisStack.isEmpty())
                return false;
            else if(firstParanthesis.contains(c))
                paranthesisStack.push(c);
            else if(lastParanthesis.contains(c)){
                if( paranthesisStack.peek() == switch (c){
                    case ')' -> firstParanthesis.get(0);
                    case '}' -> firstParanthesis.get(1);
                    case ']' -> firstParanthesis.get(2);
                    default -> null;
                })
                    paranthesisStack.pop();
                else
                    return false;
            }
            else
                continue;
        }
        return paranthesisStack.isEmpty();


    }
}
