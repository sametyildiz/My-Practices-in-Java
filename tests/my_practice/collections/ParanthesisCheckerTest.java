package my_practice.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ParanthesisCheckerTest {
    private ParanthesisChecker checker;

    @BeforeEach
    void setUp() {
        checker = new ParanthesisChecker();
    }
    private static Stream<Arguments> parenthesisArgs(){
        return Stream.of(
                Arguments.of(null, false),

                Arguments.of("" , true),
                Arguments.of("      " , true),
                Arguments.of("      \t",true),
                Arguments.of(" ()()()",true),
                Arguments.of("()" , true),
                Arguments.of("())" , false),
                Arguments.of("(" , false),
                Arguments.of("adasgsgsgagafafqwfwq(/{}[[]]" , false),
                Arguments.of("adasgsgsgagafafqwfwq(/{}[[]])" , true),
                Arguments.of("adas{gsgsgag}( [ ] )afafqwfwq(/{}[[]])" , true),
                Arguments.of("adas({)}( [ } )(/{}[[]])" , false),
                Arguments.of("({)}[{]}" , false),
                Arguments.of("{[]}()({})75e[68]{}" , true),
                Arguments.of("{[]}()({})75e[68]{}]" , false)

        );
    }

    @ParameterizedTest
    @MethodSource("parenthesisArgs")
    void checkParanthesis(String input , boolean answer) {
        Assertions.assertEquals(checker.checkParanthesis(input) , answer);
    }
}