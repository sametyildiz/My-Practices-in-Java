package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem53Test {
    private  Problem53 solution;
    @BeforeEach
    void setUp() {
        solution = new Problem53();
    }

    static Stream<Arguments> arrayArgs(){
        return Stream.of(
                Arguments.of(new int[]{1,1,-3,3,10,15,-5}, 28),
                Arguments.of(new int[]{1,1,-1,3,10,15,-5}, 29),
                Arguments.of(new int[]{-2,1,-3,4,-1,2,1,-5,4} , 6),
                Arguments.of(new int[]{5,4,-1,7,8} , 23),
                Arguments.of(new int[]{-3,-2,-2,-3} , -2)
        );
    }


    @ParameterizedTest
    @MethodSource("arrayArgs")
    void maxSubArray(int[] nums , int exp) {
        Assertions.assertEquals(solution.maxSubArray(nums) , exp);
    }
}