package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem35Test {
    private  Problem35 problem35;
    @BeforeEach
    void setUp() {
        problem35 = new Problem35();
    }

    static Stream<Arguments> intArgs(){
        return Stream.of(
                Arguments.of(new int[]{1,3,5,6}, 5, 2),
                Arguments.of(new int[]{1,3,5,6}, 3, 1),
                Arguments.of(new int[]{1,3,5,6}, 6, 3),
                Arguments.of(new int[]{1,3,5,6}, 7, 4),
                Arguments.of(new int[]{1,3,5,6}, 4, 2),
                Arguments.of(new int[]{1,3,5,6}, 0, 0),
                Arguments.of(new int[]{-1,3,5,6},-2, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("intArgs")
    void searchInsert(int[] array,int target, int position) {
        Assertions.assertEquals(problem35.searchInsert(array, target), position);
    }
}