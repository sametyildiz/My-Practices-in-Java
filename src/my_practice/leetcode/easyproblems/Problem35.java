package my_practice.leetcode.easyproblems;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 */
public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        int first = 0, last = nums.length - 1, index = -1;
        while (first <= last){
            index = (first + last) / 2;
            if(target > nums[index])
                first = index + 1;
            else if( target < nums[index])
                last  = index - 1;
            else
                return index;
        }

    return (last + first + 1) / 2 ;
    }



}
