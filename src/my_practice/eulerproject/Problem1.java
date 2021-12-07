package my_practice.eulerproject;
/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *         */

public class Problem1 {

    public int solution(int limit ,int num1, int num2 ){
        int[] sorted = sortedArray(num1,num2);
        int sum = 0, i = sorted[0], j = sorted[1] ;
        while (i < limit){
            if(i != j){
                if(i < limit && i % sorted[1] != 0)
                    sum += i;
                if(j < limit )
                    sum += j ;
            }else
                sum += i;
            i += sorted[0];
            j += sorted[1];
        }
        return sum;
    }

    private int[] sortedArray(int num1 , int num2){
        return new int[]{Math.min(num1, num2), Math.max(num1,num2) };
    }
}
