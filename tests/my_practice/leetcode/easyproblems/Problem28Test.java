package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem28Test {
    private Problem28 problem28;
    @BeforeEach
    void setUp() {
        problem28 = new Problem28();
    }

    static Stream<Arguments> strArgs(){
        return Stream.of(
                Arguments.of("hello","ll",2),
                Arguments.of("aaaaa","ba",-1),
                Arguments.of("","",0),
                Arguments.of("a","a",0)
        );
    }


    @ParameterizedTest
    @MethodSource("strArgs")
    void strStr(String haystack, String needle, int index) {
        Assertions.assertEquals(problem28.strStr(haystack,needle) , index);
    }
}