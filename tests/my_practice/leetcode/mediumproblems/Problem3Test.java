package my_practice.leetcode.mediumproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {
    private Problem3 solution;
    @BeforeEach
    void setUp() {
        solution = new Problem3();
    }

    static Stream<Arguments> stringArgs(){
        return Stream.of(
                Arguments.of("bbbbbbbb" , 1),
                Arguments.of("" , 0),
                Arguments.of("abbcabc" , 3),
                Arguments.of("abcabcbb" , 3),
                Arguments.of("pwwkew" , 3),
                Arguments.of("pwwkewabcd" , 7),
                Arguments.of("dvdf" , 3)
        );
    }


    @ParameterizedTest
    @MethodSource("stringArgs")
    void lengthOfLongestSubstring(String s, int maxSubLength) {
        Assertions.assertEquals(solution.lengthOfLongestSubstring(s) , maxSubLength );
    }
}