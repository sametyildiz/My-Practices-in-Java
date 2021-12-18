package my_practice.leetcode.mediumproblems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {
    private Problem2 problem2;
    @BeforeEach
    void setUp() {
        problem2 = new Problem2();
    }

    static Stream<Arguments> ListNodeArgs(){
        return Stream.of(
                Arguments.of(new int[]{2,4,3}),
                Arguments.of(new int[]{5,6,4})
        );
    }

    @ParameterizedTest
    @MethodSource("ListNodeArgs")
    void add(int[] nums) {
        ListNode node = problem2.add(nums, 0);
        problem2.printListNode(node);
        System.out.println();

        node = problem2.add(node);
        problem2.printListNode(node);
        System.out.println();
    }

    static Stream<Arguments> ListNodeArgs2(){
        return Stream.of(
                Arguments.of(new int[]{2,4,3}, new int[]{5,6,4}),
                Arguments.of(new int[]{9,9}, new int[]{9}),
                Arguments.of(new int[]{9,9,9,9,9,9,9}, new int[]{9,9,9,9})
        );
    }
    @ParameterizedTest
    @MethodSource("ListNodeArgs2")
    void addTwoNumbers(int[] nums1,int[] nums2) {
        ListNode l1 = problem2.add(nums1, 0);
        ListNode l2 = problem2.add(nums2, 0);

        ListNode solution = problem2.addTwoNumbers(l1, l2);
        problem2.printListNode(solution);
        System.out.println();
    }
}