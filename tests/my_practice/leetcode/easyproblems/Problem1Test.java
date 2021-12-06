package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {
    private Problem1 problem1;
    @BeforeEach
    void setUp() {
        problem1 = new Problem1();
    }

    static Stream<Arguments> numsArgs(){
        return Stream.of(
                Arguments.of(new int[]{2,7,11,15} , 9 , new int[]{0,1}),
                Arguments.of(new int[]{3,2,4} , 6 , new int[]{1,2}),
                Arguments.of(new int[]{4,6,8,3} , 11 , new int[]{2,3}),
                Arguments.of(new int[]{-1,-2,-3,-4,-5} , -8 , new int[]{2,4}),
                Arguments.of(new int[]{-3,4,3,90} , 0 , new int[]{0,2})
        );
    }

    @ParameterizedTest
    @MethodSource("numsArgs")
    void twoSum(int[] nums, int target, int[] result) {
        int[] ans = problem1.twoSum(nums,target);
        System.out.println(ans[0] + " " +ans[1]);
        Assertions.assertArrayEquals(ans, result);

    }
}