package my_practice.leetcode.easyproblems;

import java.util.Arrays;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 */
public class Problem66 {

    public int[] plusOne(int[] digits) {
        return revisionDigits(digits, digits.length - 1 , 1);
    }

    private int[] revisionDigits(int[] digits, int index, int rest){
        if(rest == 0)
            return digits;
        int num = digits[index];
        num += rest;
        rest = num / 10;
        digits[index] = num - rest * 10;
        if(rest > 0 && index == 0){
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 0;
            for(int i = 1 ; i < newDigits.length ; i++)
                newDigits[i] = digits[i-1];
            index = 1;
            digits = newDigits;
        }
        return revisionDigits(digits, index - 1 , rest);
    }
}
