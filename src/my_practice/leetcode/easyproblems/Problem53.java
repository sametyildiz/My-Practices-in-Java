package my_practice.leetcode.easyproblems;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 *
 */
public class Problem53 {

    public int maxSubArray(int[] nums) {//too slow
        int sum  = 0, maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length  ; i++){
            sum += nums[i];
            if( sum > maxSum){
                maxSum = sum;
            }
            if(sum < 0)
                sum = 0;
        }
        return maxSum;
    }

}
