package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem26Test {
    Problem26 problem26 ;
    @BeforeEach
    void setUp() {
        problem26 = new Problem26();
    }

    static Stream<Arguments> arrayArg(){
        return Stream.of(
                Arguments.of(new int[]{0,0,1,1,1,2,2,3,3,4}, 5 ),
                Arguments.of(new int[]{1,1,2}, 2 )
        );
    }


    @ParameterizedTest
    @MethodSource("arrayArg")
    void removeDuplicates(int[] nums, int removed) {
        Assertions.assertEquals(problem26.removeDuplicates(nums) , removed);
        System.out.println();
    }


}