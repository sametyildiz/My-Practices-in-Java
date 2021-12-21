package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem58Test {
    Problem58 solution;
    @BeforeEach
    void setUp() {
        solution = new Problem58();
    }

    static Stream<Arguments> stringArgs(){
        return Stream.of(
                Arguments.of("Hello World" , 5),
                Arguments.of("   fly me   to   the moon  " , 4),
                Arguments.of("luffy is still joyboy" , 6)
        );
    }

    @ParameterizedTest
    @MethodSource("stringArgs")
    void lengthOfLastWord(String s, int lenght) {
        Assertions.assertEquals(solution.lengthOfLastWord(s) , lenght);
    }
}