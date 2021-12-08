package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem27Test {
    private Problem27 problem27;
    @BeforeEach
    void setUp() {
        problem27 = new Problem27();
    }

    static Stream<Arguments> removeArgs(){
        return Stream.of(
                Arguments.of(new int[]{3,2,2,3}, 3 , 2 ),
                Arguments.of(new int[]{0,1,2,2,3,0,4,2}, 2 , 5 ),
                Arguments.of(new int[]{2,2,4,6,4,2,5,7}, 4 , 6 ),
                Arguments.of(null, 4 , 6 )
        );
    }


    @ParameterizedTest
    @MethodSource("removeArgs")
    void removeElement(int[] nums, int val , int expect) {
        Assertions.assertEquals(problem27.removeElement(nums, val), expect);
        System.out.println("");
    }
}