package my_practice.leetcode.easyproblems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {
    Problem21 problem21;
    @BeforeEach
    void setUp(){
        problem21 = new Problem21();
    }
    @Test
    void adding(){
        ListNode node = problem21.addToListNode(new int[]{1,2,3,4,5} , 0);
        problem21.printListNode(node);
    }

    @Test
    void adding2(){
        ListNode node1 = problem21.addToListNode(new int[]{1,2,3,4,5}, 0);
        problem21.printListNode(node1);
        System.out.println("*************************");

        ListNode node = problem21.addToListNode(node1);

        problem21.printListNode(node);
    }
}