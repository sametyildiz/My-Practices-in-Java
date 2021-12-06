package my_practice.iterator_exercise;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CityTravellerTest {
    private static CityTraveller traveller ;
    private final static Cities startPoint = Cities.ISTANBUL;

    @BeforeAll
    static void setUp() {
        traveller = new CityTraveller(startPoint);
    }


    private static Stream<Arguments> directions(){
        return Stream.of(
                Arguments.of(false,startPoint,Cities.ISTANBUL),
                Arguments.of(true , startPoint  , Cities.ANKARA),
                Arguments.of(false , Cities.ANKARA, Cities.ISTANBUL),

                Arguments.of(false , Cities.ISTANBUL, Cities.ISTANBUL),

                Arguments.of(true , Cities.ISTANBUL, Cities.ANKARA),
                Arguments.of(true , Cities.ANKARA, Cities.ESKISEHIR),
                Arguments.of(true , Cities.ESKISEHIR, Cities.IZMIR),
                Arguments.of(false , Cities.IZMIR, Cities.ESKISEHIR),
                Arguments.of(true , Cities.ESKISEHIR, Cities.IZMIR),
                Arguments.of(true , Cities.IZMIR, Cities.BODRUM),

                Arguments.of(true , Cities.BODRUM, Cities.BODRUM)

        );
    }



    @ParameterizedTest
    @MethodSource("directions")
    void testTravel(Boolean direction , Cities locationNow , Cities expected) {
        CityTraveller.printMap();
        Assertions.assertEquals(traveller.travel(direction , locationNow), expected);


    }

    @Nested
    class iteratorLimitTest{
        private static CityTraveller traveller ;
        private final static  Cities startPoint = Cities.BODRUM;
        private

        @BeforeEach
        void setUp() {
            traveller = new CityTraveller(startPoint);
        }

        @Test
        void limitTest(){
            traveller.limitTest();
        }



    }

}