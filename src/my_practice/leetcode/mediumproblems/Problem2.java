package my_practice.leetcode.mediumproblems;



/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 */

public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sumListNodes(l1 , l2 , 0);
    }
    private ListNode sumListNodes(ListNode l1 , ListNode l2, int rest){
        if( l1 == null && l2 == null && rest == 0)
            return null;
        else {
            int num1 = l1 == null ? 0 : l1.val;
            l1 = l1 == null ? null : l1.next;

            int num2 = l2 == null ? 0 : l2.val;
            l2 = l2 == null ? null : l2.next;

            int sum =  num1 + num2 + rest;
            rest = sum / 10;
            return new ListNode(sum - rest * 10, sumListNodes(l1 , l2 , rest));
        }

    }

    public ListNode add(int[] nums,int i){
        return i == nums.length ? null : new ListNode(nums[i] , add(nums, i + 1));
    }

    public ListNode add(ListNode node){
        return node == null ? null : new ListNode(node.val, add(node.next));
    }

    public void printListNode(ListNode node){
        while (node != null){
            System.out.printf("%d " , node.val);
            node = node.next;
        }
    }
}


class ListNode {
      int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

