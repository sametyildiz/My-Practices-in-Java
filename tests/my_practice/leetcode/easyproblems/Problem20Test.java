package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem20Test {
    private Problem20 problem20;
    @BeforeEach
    void setUp() {
        problem20 = new Problem20();
    }

    private static Stream<Arguments> parenthesisArgs(){
        return Stream.of(
                Arguments.of(null, true),

                Arguments.of("" , true),
                Arguments.of("      " , true),
                Arguments.of("      \t",true),
                Arguments.of(" ()()()",true),
                Arguments.of("()" , true),
                Arguments.of("())" , false),
                Arguments.of("(" , false),
                Arguments.of("]" , false),
                Arguments.of("adasgsgsgagafafqwfwq(/{}[[]]" , false),
                Arguments.of("adasgsgsgagafafqwfwq(/{}[[]])" , true),
                Arguments.of("adas{gsgsgag}( [ ] )afafqwfwq(/{}[[]])" , true),
                Arguments.of("adas({)}( [ } )(/{}[[]])" , false),
                Arguments.of("({)}[{]}" , false),
                Arguments.of("{[]}()[]{}" , true),
                Arguments.of("{[]}()({})75e[68]{}]" , false)

        );
    }
    @ParameterizedTest
    @MethodSource("parenthesisArgs")
    void isValid(String s, boolean expect) {
        Assertions.assertEquals(problem20.isValid(s) , expect);
    }
}