package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem66Test {
    Problem66 solution;
    @BeforeEach
    void setUp() {
        solution = new Problem66();
    }

    static Stream<Arguments> arrayArgs(){
        return Stream.of(
                Arguments.of(new int[]{1,2,3} , new int[]{1,2,4}),
                Arguments.of(new int[]{4,3,2,1} , new int[]{4,3,2,2}),
                Arguments.of(new int[]{9} , new int[]{1,0}),
                Arguments.of(new int[]{0} , new int[]{1}),
                Arguments.of(new int[]{1,9,9} , new int[]{2,0,0})


        );
    }


    @ParameterizedTest
    @MethodSource("arrayArgs")
    void plusOne(int[] digits, int[] result) {
        Assertions.assertArrayEquals(solution.plusOne(digits) , result);
    }


}