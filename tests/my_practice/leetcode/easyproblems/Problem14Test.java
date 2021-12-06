package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem14Test {

    private Problem14 problem14;
    @BeforeEach
    void setUp() {
        problem14 = new Problem14();
    }


    static Stream<Arguments> prefixArgs(){
        return Stream.of(
                Arguments.of(new String[]{"flower","flow","flight"} , "fl"),
                Arguments.of(new String[]{"dog","racecar","car"} , ""),
                Arguments.of(new String[]{"samet","sağlep","sağlam"} , "sa"),
                Arguments.of(new String[]{"","sağlep","sağlam"} , ""),
                Arguments.of(new String[]{"a","a","a"} , "a"),
                Arguments.of(new String[]{"flower","flower","flower","flower"} , "flower")
        );
    }

    @ParameterizedTest
    @MethodSource("prefixArgs")
    void longestCommonPrefix(String[] strs , String prefix) {
        Assertions.assertTrue(problem14.longestCommonPrefix(strs).equals(prefix));
    }
}