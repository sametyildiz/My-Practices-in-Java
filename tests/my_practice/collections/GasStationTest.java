package my_practice.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GasStationTest {
    private GasStation station;

    @BeforeEach
    void setUp() {
        station = new GasStation();
    }

    private static Stream<Arguments> stationArgs(){
        return Stream.of(
                Arguments.of( 25 , 100 , new ArrayList<int[]>(){{
                        add(new int[]{15,20});//
                        add(new int[]{25,18});
                        add(new int[]{42,25});//
                        add(new int[]{51,16});//
                        add(new int[]{64,11});
                        add(new int[]{85,21});//
                        add(new int[]{93,30});}
        }, 4),

                Arguments.of( 10, 30, new ArrayList<>(){{
                            add(new int[]{2 , 5});
                            add(new int[]{5 , 18});
                            add(new int[]{8 , 5});
                            add(new int[]{12 , 1});
                        }}
                        ,  2),


                Arguments.of(10 , 35, new ArrayList<>(){{
                            add(new int[]{2 , 5});
                            add(new int[]{5 , 18});
                            add(new int[]{8 , 5});
                            add(new int[]{12 , 1});
                        }}
                        ,   3
                        )

        );
    }


    @ParameterizedTest
    @MethodSource("stationArgs")
    void calculateStops(int depo , int distance, List<int[]> listOfStops , int result) {
        Assertions.assertEquals(station.calculateStops( depo, distance , listOfStops) , result );
    }
}