package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem13Test {
    private Problem13 problem13;
    @BeforeEach
    void setUp() {
        problem13 = new Problem13();
    }

    static Stream<Arguments> romanSymbolArgs(){
        return Stream.of(
                Arguments.of("I",1),
                Arguments.of("II",2),
                Arguments.of("III",3),
                Arguments.of("IV",4),
                Arguments.of("V",5),
                Arguments.of("VI",6),
                Arguments.of("VII",7),
                Arguments.of("VIII",8),
                Arguments.of("IX",9),
                Arguments.of("X",10),
                Arguments.of("MCMXCIV",1994),
                Arguments.of("LVIII",58)
        );
    }

    @ParameterizedTest
    @MethodSource("romanSymbolArgs")
    void romanToInt(String s , int toInt) {
        Assertions.assertEquals(problem13.romanToInt(s), toInt);

    }

    @ParameterizedTest
    @MethodSource("romanSymbolArgs")
    void alfernativeSolution(String s, int toInt) {
        Assertions.assertEquals(problem13.alfernativeSolution(s),toInt);
    }
}