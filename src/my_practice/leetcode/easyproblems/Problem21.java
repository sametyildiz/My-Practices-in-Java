package my_practice.leetcode.easyproblems;

import java.util.List;

public class Problem21 {
    /**
     * You are given the heads of two sorted linked lists list1 and list2.
     *
     * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
     *
     * Return the head of the merged linked list.
     *
     *  */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;
        if( list2 == null )
            return new ListNode( list1.val, mergeTwoLists(list1.next, list2));
        else if(list1 == null)
            return new ListNode( list2.val, mergeTwoLists(list1, list2.next));
        else if(list1.val < list2.val)
            return new ListNode( list1.val, mergeTwoLists(list1.next, list2));
        else
            return new ListNode( list2.val, mergeTwoLists(list1, list2.next));

    }


    public ListNode addToListNode(int[] array, int index){
        if(array == null || index == array.length)
            return null;
        return new ListNode(array[index], addToListNode(array, index + 1 ));


    }
    public ListNode addToListNode(ListNode inputNode){
        if(inputNode == null)
            return null;
        return new ListNode(inputNode.val , addToListNode(inputNode.next));

    }

    public void printListNode(ListNode node){
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
