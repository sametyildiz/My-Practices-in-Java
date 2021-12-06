package my_practice.Maths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MathsTest {
    Maths math = new Maths();

    @BeforeEach
    void setUp(){
        math = new Maths();
    }



    private static Stream<Arguments> mathArgs() {
        return Stream.of(
            Arguments.of(" 5 + 2     * 10   - 8   " , 17F),
            Arguments.of(" 85 / 5 -2 - 28   " , -13F),
            Arguments.of(" 4 / 2   *  3   - 0   " , 6F),
            Arguments.of("  5 + 8 + 9 + 2   " , 24F),
            Arguments.of("  1 * 2 * 3 * 4 *5 " ,120F),
            Arguments.of("  1 * 2 * 3 * 4 *5 % 12 -5" ,-5F),
            Arguments.of(" 8 * -2 + 5 + 3 - 8 / 10" ,-8.8F),
            Arguments.of(" 8 * -2 + 5 + 3 - 8 % 10" ,-6F),
            Arguments.of("   -8 % 10" , 2F),
            Arguments.of(" 1000 / 2 / 2 * 3 + 50 ", 800F),
            Arguments.of(" 0  " , 0F),
            Arguments.of("", Float.NaN),
            Arguments.of("    " , Float.NaN),
            Arguments.of( null , Float.NaN)
        );
    }


    @ParameterizedTest
    @MethodSource("mathArgs")
    void mathematicalEquation(String input ,  float result) {
        assertEquals(result , math.MathematicalEquation(input));


    }

    private static Stream<Arguments> factArgs(){
        return Stream.of(
          Arguments.of(5 , 120),
          Arguments.of(6 , 720),
          Arguments.of(1 , 1),
          Arguments.of(0 , 1)

        );
    }

    @ParameterizedTest
    @MethodSource("factArgs")
    void factorial(int input , int result) {
        assertEquals( result , math.factorial(input));
    }

    private static Stream<Arguments> fiboArgs(){
        return Stream.of(
          Arguments.of(0 , 0 ),
          Arguments.of(1 , 1 ),
          Arguments.of(2 , 1 ),
          Arguments.of(3 , 2 ),
          Arguments.of(4 , 3 ),
          Arguments.of(5 , 5 ),
          Arguments.of(6 , 8 ),
          Arguments.of(7 , 13 ),
          Arguments.of(8 , 21 ),
          Arguments.of(9 , 34 ),
          Arguments.of(10 , 55)
        );
    }


    @ParameterizedTest
    @MethodSource("fiboArgs")
    void fibonnaci_1stSolve(int input , int result) {
        assertEquals( result , math.fibonnaci_1stSolve(input));
    }

    @ParameterizedTest
    @MethodSource("fiboArgs")
    void fibonnaci_2ndSolve(int input , int result) {
        assertEquals( result , math.fibonnaci_2ndSolve(input));

    }

    @ParameterizedTest
    @MethodSource("fiboArgs")
    void fibonnaci_3ndSolve(int input , int result) {
        assertEquals( result , math.fibonnaci_3rdSolve(input));

    }

    @ParameterizedTest
    @MethodSource("fiboArgs")
    void fibonnaci_4thSolve(int input , int result) {
        assertEquals( result , math.fibonnaci_4thSolve(input));

    }
}