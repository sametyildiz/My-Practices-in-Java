package my_practice.Maths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringCheckerTest {
    private  StringChecker checker;
    @BeforeEach
    void setUp() {
        checker = new StringChecker();
    }

    static Stream<Arguments> stringArgs(){
        return Stream.of(
                Arguments.of("abca","a"),
                Arguments.of("aa","a"),
                Arguments.of("zz","z"),
                Arguments.of("codility","i"),
                Arguments.of("kazablanca","a")
        );
    }


    @ParameterizedTest
    @MethodSource("stringArgs")
    void solution(String input, String expected) {
        Assertions.assertEquals(checker.solution(input) , expected);
    }
}