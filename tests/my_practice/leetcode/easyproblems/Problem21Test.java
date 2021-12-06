package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem21Test {

    private Problem21 problem21;
    private ListNode node1;
    private ListNode node2;
    @BeforeEach
    void setUp() {
        problem21 = new Problem21();
        node1 = new ListNode();
        node2 = new ListNode();
    }

    private static Stream<Arguments> arrayArgs(){
        return Stream.of(
                Arguments.of(new int[]{1,3,5,7,9} , new int[]{2,4,6,8})
        );
    }


    @ParameterizedTest
    @MethodSource("arrayArgs")
    void addtoNode(int[] array1 , int[] array2) {
        node1 = problem21.addToListNode(array1);
        node2 = problem21.addToListNode(array2);
        Assertions.assertDoesNotThrow(()->problem21.printListNode(  problem21.mergeTwoLists(node1 , node2)));
    }

}